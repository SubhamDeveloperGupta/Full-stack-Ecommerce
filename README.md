# E-commerce Website

## Table of Contents

1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Functional Requirements](#functional-requirements)
4. [High-Level Design](#high-level-design)
5. [Technology Stack](#technology-stack)
6. [Installation](#installation)
7. [Usage](#usage)
8. [API Endpoints](#api-endpoints)
9. [Contributing](#contributing)
10. [License](#license)
11. [Contact](#contact)

## Project Overview

This project is an e-commerce website that provides a platform for users to browse, search, and purchase products online. The application features user management, product catalog, cart and checkout, order management, and secure payment options.

## Architecture

The architecture is based on a microservices model, leveraging various tools and technologies to ensure scalability, reliability, and performance. The key components include:

- Load Balancers (Amazon Elastic Load Balancing)
- API Gateway (Kong)
- Microservices
- Databases (MySQL, MongoDB)
- Message Broker (Kafka)
- Caching (Redis)
- Search and Analytics (Elasticsearch)

## Functional Requirements

### 1. User Management

- Registration
- Login
- Profile Management
- Password Reset

### 2. Product Catalog

- Browsing
- Product Details
- Search

### 3. Cart & Checkout

- Add to Cart
- Cart Review
- Checkout

### 4. Order Management

- Order Confirmation
- Order History
- Order Tracking

### 5. Payment

- Multiple Payment Options
- Secure Transactions
- Payment Receipt

### 6. Authentication

- Secure Authentication
- Session Management

## High-Level Design

### Architecture Components

- **Load Balancers (LB):** Distribute incoming user requests.
- **API Gateway:** Routes requests, handles rate limiting, and manages authentication.
- **Microservices:**
  - User Management Service
  - Product Catalog Service
  - Cart Service
  - Order Management Service
  - Payment Service
  - Notification Service
- **Databases:**
  - MySQL
  - MongoDB
- **Kafka:** Central message broker.
- **Redis:** Caching for fast response times.
- **Elasticsearch:** Fast product searches.

### Typical Flow with Kafka & Elasticsearch Integration

1. User logs in and searches for a product.
2. User adds a product to the cart.
3. User checks out, triggering the Order Management Service and Payment Service.

## Technology Stack

- **Frontend:** React.js
- **Backend:** Spring Boot
- **Database:** MySQL, MongoDB
- **Messaging:** Kafka
- **Cache:** Redis
- **Search:** Elasticsearch
- **Load Balancing:** Amazon ELB
- **API Gateway:** Kong
- **Authentication:** JWT

## Installation

### Prerequisites

-
- MySQL
- MongoDB
- Kafka
- Redis
- Elasticsearch

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/SubhamKrGuptaDev/Full-stack-Ecommerce

   cd Full-stack-Ecommerce
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Set up environment variables:
   Create a `.env` file in the root directory and add the necessary environment variables.

4. Run the application:
   ```bash
   npm run dev
   ```

## Usage

Instructions on how to use the application once it is up and running.

## API Endpoints

### User Management

- `POST /api/register`: Register a new user.
- `POST /api/login`: Login a user.
- `GET /api/profile`: Get user profile.
- `PUT /api/profile`: Update user profile.
- `POST /api/password-reset`: Reset password.

### Product Catalog

- `GET /api/products`: Browse products.
- `GET /api/products/:id`: Get product details.
- `GET /api/search`: Search products.

### Cart & Checkout

- `POST /api/cart`: Add to cart.
- `GET /api/cart`: View cart.
- `POST /api/checkout`: Checkout.

### Order Management

- `POST /api/orders`: Place an order.
- `GET /api/orders`: View order history.
- `GET /api/orders/:id`: Track order.

### Payment

- `POST /api/payment`: Process payment.

## Contributing

If you want to contribute to this project, please follow the [CONTRIBUTING.md](CONTRIBUTING.md) guidelines.

## Contact

For any queries or issues, please contact [your email](subham7031979@gmail.com).
