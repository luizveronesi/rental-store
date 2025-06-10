# 📖 Attività 2: Implementazione dei servizi per il modulo Inventory

## Panoramica del Compito

Il tuo primo compito è implementare la struttura del database **Inventory** basata sul diagramma seguente con alcuni
endpoint.

## 📌 Diagramma del Database

C'è un file PDF nella cartella del database che contiene il modello completo del database, incluse le tabelle per
**Inventory**. Puoi anche utilizzare MySQL Workbench per visualizzare tutti i dettagli aprendo il file
rental-store.mwb.

## Passaggi:

1. **Crea un nuovo database** in PostgreSQL chiamato `inventory` e crea la configurazione nel file
   `application.yml` all'interno della cartella `inventory/resources`.
2. **Crea un nuovo modulo** nel progetto `Rental Store`, aggiorna il pom padre e la configurazione del `gateway`.
3. Mappa le entità JPA per:
    - `category`
    - `film_category`
    - `language`
    - `actor`
    - `film_actor`
    - `inventory`
    - `film`
4. Assicurati che:
    - I rapporti di chiave esterna siano implementati correttamente.
    - I tipi di dati corrispondano a quelli nel diagramma.
    - Le chiavi primarie siano impostate correttamente.
5. Quando l'applicazione viene eseguita, Spring dovrebbe creare tutte le tabelle nel database.
6. Crea tutta la logica necessaria per implementare i seguenti endpoint per ciascuna entità:
    - Trova Tutti
    - Trova Uno
    - Inserisci
    - Aggiorna
    - Elimina
7. Creazione di servizi per la gestione delle immagini di un film:
    - Fai una ricerca sulle diverse modalità di archiviazione delle immagini (file server vs. database), scegli un
      metodo e spiegami perché lo hai scelto prima di procedere.
    - Crea una nuova entità relativa alle immagini di un film.
    - L'entità deve avere un attributo responsabile dell'ordine di visualizzazione.
    - Crea l'endpoint per il caricamento del file.
    - Crea gli endpoint per recuperare tutte le immagini, eliminarle e modificare il loro ordine
8. **Esegui il commit delle modifiche** e spingile nel tuo repository biforcato.