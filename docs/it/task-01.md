# 📖 Attività 1: Implementazione dei servizi per il modulo Cliente

## Panoramica del Compito

Il tuo primo compito è implementare la struttura del database **Customer Data** basata sul diagramma seguente con alcuni
endpoint.

## 📌 Diagramma del Database

C'è un file PDF nella cartella del database che contiene il modello completo del database, incluse le tabelle per *
*Customer Data**. Puoi anche utilizzare MySQL Workbench per visualizzare tutti i dettagli aprendo il file
rental-store.mwb.

## Passaggi:

1. **Crea un nuovo database** in PostgreSQL chiamato `customer` e modifica la configurazione nel file
   `application.yml` all'interno della cartella `customer/resources`.
2. Mappa le entità JPA per:
    - `country` (già mappato)
    - `city`
    - `address`
    - `customer`
3. Assicurati che:
    - I rapporti di chiave esterna siano implementati correttamente.
    - I tipi di dati corrispondano a quelli nel diagramma.
    - Le chiavi primarie siano impostate correttamente.
4. Quando l'applicazione viene eseguita, Spring dovrebbe creare tutte le tabelle nel database.
5. Crea tutta la logica necessaria per implementare i seguenti endpoint per ciascuna entità:
    - Trova Tutti
    - Trova Uno
    - Inserisci
    - Aggiorna
    - Elimina
6. Crea un endpoint per filtrare i dati dall'entità `customer` dove:
    - I risultati devono essere paginati, visualizzando 10 elementi per pagina.
    - Deve filtrare per `first_name` o `last_name` in base all'input fornito.
    - L'input deve essere di almeno due caratteri di lunghezza.
    - La query generata per JPA deve essere simile a:
      `select * from customer where first_name like '%str%' or last_name like '%str%'`
7. **Esegui il commit delle modifiche** e spingile nel tuo repository biforcato.