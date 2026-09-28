# RentTech — Electronics Rental Platform

A beginner-friendly full-stack electronics rental platform built with Spring Boot, PostgreSQL, HTML, CSS and JavaScript.

## Features

- Electronics catalog
- Search and category filtering
- Product availability
- Rental date selection
- Automatic rental total calculation
- Security deposit calculation
- Rental request API
- Recent rental view
- PostgreSQL persistence
- Render deployment configuration
- Responsive frontend

## Requirements

- Java 17+
- Maven 3.9+
- PostgreSQL 14+
- Git

## Run locally

Create a PostgreSQL database:

```sql
CREATE DATABASE rentaldb;
```

Set environment variables if your PostgreSQL credentials differ:

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/rentaldb
export DB_USERNAME=postgres
export DB_PASSWORD=postgres
```

Run:

```bash
mvn spring-boot:run
```

Open:

http://localhost:8080

## GitHub

```bash
git init
git add .
git commit -m "Initial electronics rental platform"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/electronics-rental-platform.git
git push -u origin main
```

## Render

1. Push the project to GitHub.
2. Create a new Render Blueprint and select the repository.
3. Render will read `render.yaml`.
4. It creates the web service and PostgreSQL database.
5. Open the generated Render URL.

## Important production upgrades

This starter is intentionally focused on getting a working rental application online. Before accepting real payments or sensitive user data, add:

- Spring Security + JWT
- User registration/login
- Role-based admin authorization
- Payment gateway
- Cloud image storage
- Rental date conflict checking
- Email/SMS notifications
- Rate limiting
- HTTPS-only cookies where applicable
- Input validation and audit logging
- Proper secrets management

## API endpoints

GET `/api/products`

GET `/api/products/{id}`

GET `/api/products?search=iPhone`

GET `/api/products?category=Laptop`

POST `/api/products`

GET `/api/rentals`

POST `/api/rentals`

Example rental request:

```json
{
  "productId": 1,
  "customerName": "Karthik",
  "customerEmail": "karthik@example.com",
  "startDate": "2026-10-01",
  "endDate": "2026-10-03"
}
```
