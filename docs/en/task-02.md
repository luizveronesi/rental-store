# 📖 Activity 2: Implementation of services for the Inventory module

## Task Overview

Your first task is to implement the **Inventory** database structure based on the following diagram with some endpoints.

## 📌 Database Diagram

There’s a PDF file in the database folder containing the complete database model, including the tables for
**Inventory**. You can also use MySQL Workbench to view all details by opening the file `rental-store.mwb`.

## Steps:

1. **Create a new database** in PostgreSQL named `inventory` and create the configuration in the `application.yml` file
   inside the `inventory/resources` folder.
2. **Create a new module** in the `Rental Store` project, update the parent `pom` and configure the `gateway`.
3. Map the JPA entities for:
    - `category`
    - `film_category`
    - `language`
    - `actor`
    - `film_actor`
    - `film_text`
    - `inventory`
    - `film`
4. Make sure that:
    - Foreign key relationships are correctly implemented.
    - Data types match those in the diagram.
    - Primary keys are properly set.
5. When the application runs, Spring should create all tables in the database.
6. Create all necessary logic to implement the following endpoints for each entity:
    - Find All
    - Find One
    - Insert
    - Update
    - Delete
7. Create services for managing movie images:
    - Research different methods for storing images (file server vs. database), choose one and explain to me why you
      chose it before proceeding.
    - Create a new entity related to movie images.
    - The entity must have an attribute responsible for the display order.
    - Create the endpoint for file upload.
    - Create endpoints to retrieve all images from a movie and delete one.
    - Create an endpoint to modify their order. The endpoint must change the order of one image and update the order of the others.
8. **Commit the changes** and push them to your forked repository.
