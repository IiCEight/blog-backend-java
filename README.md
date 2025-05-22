# Blog Platform (Spring Boot, MyBatis, MySQL)

A modular Java-based blog platform built with Spring Boot, MyBatis, and MySQL. This project provides a backend RESTful API for managing articles, categories, tags, and image uploads, supporting both admin and user operations.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Build & Run](#build--run)
- [API Overview](#api-overview)
- [Database Schema](#database-schema)
- [Contribution](#contribution)
- [License](#license)

## Features
- Modular Maven multi-module structure
- RESTful API for articles, categories, tags, and image upload
- Admin and user endpoints
- MyBatis for ORM and custom SQL mapping
- Aliyun OSS integration for image uploads
- JWT-based authentication (configurable)
- Swagger/Knife4j API documentation
- Redis support (configurable)

## Project Structure
```
blog/           # Parent Maven project
├── blog-common  # Common utilities, constants, result wrappers
├── blog-pojo    # Entity, DTO, and VO classes
└── blog-server  # Spring Boot application, controllers, services, mappers
```

## Tech Stack
- Java 21
- Spring Boot 3.4.4
- MyBatis & PageHelper
- MySQL
- Lombok
- Aliyun OSS SDK
- Swagger/Knife4j
- Redis (optional)

## Getting Started
### Prerequisites
- JDK 21+
- Maven 3.9+
- MySQL 8+
- (Optional) Redis
- Aliyun OSS account (for image upload)


## Configuration
Edit `blog-server/src/main/resources/application.yml` and `application-dev.yml` for your environment:
- **Database**: Set `spring.datasource.url`, `username`, `password`.
- **Redis**: Set under `blog.redis` (optional).
- **Aliyun OSS**: Set `aliyun.oss.endpoint`, `bucketName`, `region` and provide credentials via environment variables (`OSS_ACCESS_KEY_ID`, `OSS_ACCESS_KEY_SECRET`).

## Build & Run
From the `blog-server` directory:
```sh
# On Windows (PowerShell)
./mvnw spring-boot:run
```
Or build a jar and run:
```sh
mvn clean package
java -jar target/blog-server-0.0.1-SNAPSHOT.jar
```

## API Overview
- **Admin Endpoints**: `/admin/article`, `/admin/category`, `/admin/tag`, `/admin/upload`
- **User Endpoints**: `/article`, `/category`, `/tag`


## Database Schema
SQL files for tables are in `blog-pojo/src/main/java/altria/blog_pojo/entity/`:
- `Article.sql`, `Category.sql`, `Tag.sql`, `ArticleTag.sql`

## Contribution
1. Fork the repo and create your branch
2. Commit your changes
3. Push to your fork and submit a pull request
