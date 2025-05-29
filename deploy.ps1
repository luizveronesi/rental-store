$ErrorActionPreference = "Stop"

$projectImages = @(
    @{ Name = "rental-configserver"; Path = ".\ConfigServer" },
    @{ Name = "rental-eurekaserver"; Path = ".\EurekaServer" },
    @{ Name = "rental-gateway"; Path = ".\CloudGateway" },
#     @{ Name = "rental-db"; Path = ".\database" },
    @{ Name = "rental-customer"; Path = ".\customer" }
)

# 1. Stop e rimozione container
Write-Host ">> Fermando ed eliminando i container Docker..." -ForegroundColor Yellow
docker compose down

# 2. Rimozione immagini
Write-Host "`n>> Rimuovendo immagini Docker esistenti..." -ForegroundColor Yellow
foreach ($image in $projectImages) {
    try {
        docker rmi $($image.Name) -f
        Write-Host "[V] Immagine '$($image.Name)' rimossa." -ForegroundColor DarkGray
    } catch {
        Write-Host "!! Immagine '$($image.Name)' non trovata o già rimossa." -ForegroundColor Gray
    }
}

function Send-Notification {
    param (
        [string]$title,
        [string]$message
    )

    $app = New-Object -ComObject WScript.Shell
    $app.Popup($message, 5, $title, 0x1)
}

Write-Host ">> Building Maven projects..." -ForegroundColor Cyan
mvn clean install -DskipTests

Write-Host "`n>> Building Docker images..." -ForegroundColor Cyan
# $projects = @("configserver", "eurekaserver", "gateway", "customer")
# foreach ($project in $projects) {
#     $projectPath = ".\$project"
#     if (Test-Path $projectPath) {
#         Write-Host "`n>> Building $project..."
#         Push-Location $projectPath
#         docker build -t rental-$project:latest .
#         Pop-Location
#     }
#     else {
#         Write-Host "!! Directory $project non trovata, salto..." -ForegroundColor Yellow
#     }
# }
# docker build -t rental-configserver:latest .\ConfigServer
# docker build -t rental-eurekaserver:latest .\EurekaServer
# docker build -t rental-gateway:latest .\CloudGateway
# docker build -t rental-customer:latest .\customer
foreach ($image in $projectImages) {
    docker build -t "$($image.Name):latest" $image.Path
}

Write-Host ">> Avvio contenitore database Docker..." -ForegroundColor Cyan
docker compose up -d rental-db

function Wait-For-Container {
    param (
        [string]$name,
        [string]$url,
        [int]$timeout = 60
    )

    Write-Host "`n[...] Aspettando che '$name' risponda su $url..."

    $elapsed = 0
    while ($true) {
        try {
            $response = Invoke-WebRequest -Uri $url -UseBasicParsing -TimeoutSec 5
            if ($response.StatusCode -eq 200) {
                Write-Host "V '$name' pronto!" -ForegroundColor Green
                break
            }
        }
        catch {
            Start-Sleep -Seconds 2
            $elapsed += 2
            if ($elapsed -ge $timeout) {
                Write-Host "!! Timeout in attesa di '$name'." -ForegroundColor Red
                Send-Notification -title "Errore avvio" -message "Timeout in attesa di '$name'."
                exit 1
            }
        }
    }
}

Write-Host "`n>> Avvio Config Server..." -ForegroundColor Cyan
docker compose up -d config-server
Wait-For-Container -name "Config Server" -url "http://localhost:8888/actuator/health"

Write-Host "`n>> Avvio Eureka Server..." -ForegroundColor Cyan
docker compose up -d eureka-server
Wait-For-Container -name "Eureka Server" -url "http://localhost:8761/actuator/health"

Write-Host "`n>> Avvio Gateway..." -ForegroundColor Cyan
docker compose up -d gateway

Write-Host "`n>> Avvio Customer..." -ForegroundColor Cyan
docker compose up -d customer

Write-Host "`n[V] Tutti i servizi sono avviati correttamente!" -ForegroundColor Green
Send-Notification -title "Deploy completato" -message "Tutti i servizi sono stati avviati con successo!"
