# 📖 Activity 4: Batch Insertion of Customers

## Task Overview

Develop an implementation for the **batch insertion of customers** into the `customer` database.

## Requirements

1. The batch insertion must include both **customers** and their **addresses**.
2. The input file must be a **single CSV file**, where each line contains both the customer and their address data.
3. The developer must generate a sample CSV file with **at least 100 records** (can use AI tools for data generation).
4. The implementation must use **Spring Batch** to read and process the file.
5. **RabbitMQ** must be used to insert the records asynchronously.
