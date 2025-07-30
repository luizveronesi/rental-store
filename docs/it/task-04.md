# 📖 Attività 4: Inserimento Batch dei Clienti

## Panoramica del Compito

Sviluppa un'implementazione per l’**inserimento batch dei clienti** nel database `customer`.

## Requisiti

1. L'inserimento batch deve includere sia i **clienti** che i relativi **indirizzi**.
2. Il file di input deve essere un **unico file CSV**, dove ogni riga contiene sia i dati del cliente che dell’indirizzo.
3. Il sviluppatore deve generare un file CSV di esempio con **almeno 100 record** (può usare strumenti di AI per la generazione dei dati).
4. L’implementazione deve usare **Spring Batch** per leggere e processare il file.
5. **RabbitMQ** deve essere utilizzato per inserire i record in modo asincrono.
