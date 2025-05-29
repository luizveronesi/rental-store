# 📖 Attività 3: Configurazione dei Microservizi Spring Cloud e Dockerizzazione

In questa attività, svilupperai e configurerai i servizi fondamentali di Spring Cloud per un'architettura a microservizi
e dockerizzerai l'intero ambiente.

---

## 📌 Obiettivi

Dovrai:

- Creare e configurare i seguenti servizi Spring Cloud:
    - 📦 **Spring Cloud Config Server**
    - 📦 **Eureka Service Discovery**
    - 📦 **Spring Cloud Gateway**
- Configurare il modulo **Customer** esistente per utilizzare il Gateway come proxy di accesso.
- Dockerizzare tutti i servizi (inclusi Customer Module, Config Server, Eureka Server e Gateway).
- Fornire istruzioni dettagliate per installare **Docker Desktop su Windows**.

---

## 📌 Dettaglio delle Attività

### 1️⃣ Creare Eureka Service Discovery

- Crea un nuovo progetto Spring Boot con la dipendenza **Eureka Server**.
- Configuralo su una porta dedicata (es. `8761`).
- Registra tutti gli altri servizi (Gateway e Customer Module) come client Eureka.

---

### 2️⃣ Creare Spring Cloud Config Server

- Crea un nuovo progetto Spring Boot con la dipendenza **Spring Cloud Config Server**.
- Configura il server per leggere le configurazioni da una directory `config-repo` locale o da un repository Git.
- Esponi il Config Server su una porta dedicata (es. `8888`).
- Definisci i file `application.yml` per server e client.

---

### 3️⃣ Creare Spring Cloud Gateway

- Crea un progetto Spring Boot con la dipendenza **Spring Cloud Gateway**.
- Esponi il Cloud Gateway su una porta dedicata (es. `9090`).
- Configura il routing per inoltrare le richieste verso il **Customer Module** e altri futuri servizi.

---

### 4️⃣ Configurare il Customer Module per Usare il Gateway

- Modifica la configurazione del modulo Customer per:
    - Registrarsi su Eureka.
    - Recuperare le proprietà dal Config Server.
    - Essere accessibile solo tramite il Gateway.

---

### 5️⃣ Dockerizzare Tutto

- Crea un `Dockerfile` per ogni servizio.
- Assicurati che i servizi comunichino tra loro tramite i nomi dei container usando Docker network.
- Esponi le porte necessarie verso la macchina host.

---

## 📌 Installazione di Docker Desktop (Windows)

Se Docker non è installato, segui questi passaggi:

1. Scarica Docker Desktop per Windows dal sito ufficiale:
   👉 [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/)

2. Avvia l’installer e segui le istruzioni a schermo.

3. Dopo l’installazione:
    - Avvia **Docker Desktop**.
    - Verifica il corretto funzionamento eseguendo:
      ```bash
      docker --version
      ```

4. (Facoltativo) Installazione con Docker Compose:
    - Crea un file `docker-compose.yml` per orchestrare insieme i servizi.
