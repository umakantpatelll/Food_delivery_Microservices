# Food Delivery Microservices

## Overview
A scalable, microservices-based food delivery app on AWS EKS.

## Architecture
![Application Architecture Diagram](docs/architecture.png)

## Services
| Service                | Description                        |
|------------------------|------------------------------------|
| restaurant-service     | Manages restaurants                |
| food-catalogue-service | Handles food menus                 |
| order-service          | Processes orders                   |
| user-service           | Manages users/auth                 |
| eureka-server          | Service discovery                  |
| frontend-angular       | User interface                     |

## Quickstart

### Prerequisites
- Docker, Node.js, Java 17, AWS CLI, kubectl

### Clone & Run (Local)
```bash
git clone https://github.com/umakantpatelll/Food_delivery_Microservices.git
cd Food_delivery_Microservices
cp .env.sample .env
docker-compose up --build
```

### Deploy to AWS EKS
See [docs/DEPLOYMENT.md](docs/DEPLOYMENT.md)

## API Docs
See [docs/API.md](docs/API.md)

## Contribution
See [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)

---
