# ADRIA Bank Platform

## 1. Présentation du projet

ADRIA Bank Platform est une application bancaire basée sur une architecture microservices. Elle permet la gestion des comptes, la création des transactions et l'intégration de plusieurs technologies distribuées.

## 2. Architecture du projet

Les principaux composants du projet sont :

- Discovery Service : découverte des microservices avec Eureka.
- Config Service : centralisation de la configuration.
- Account Service : gestion des comptes bancaires.
- Transaction Service : gestion des transactions.
- API Gateway : point d'entrée unique.
- Kafka : communication événementielle.
- Fraud Detection : détection des transactions frauduleuses avec Python.
- Frontend : interface utilisateur.
- Chatbot IA : assistant bancaire intelligent.

**Capture d'écran – Structure globale du projet :**

![Structure du projet](docs/screenshots/01-project-structure.png)

## 3. Technologies utilisées

- Java 21
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Spring Cloud Gateway
- Eureka Discovery
- Spring Cloud Config
- OpenFeign
- Resilience4J
- Apache Kafka
- H2 Database
- Python
- Machine Learning
- Docker
- GitHub Actions
- React ou Angular

## 4. Services techniques

### 4.1 Discovery Service – Eureka

Port : `8761`

Capture d'écran :

![Eureka Dashboard](docs/screenshots/02-eureka-dashboard.png)

### 4.2 Config Service

Port : `8888`

Configuration centralisée :

- `bank.transaction.max-amount=1000`

Capture d'écran :

![Config Service](docs/screenshots/03-config-service.png)

### 4.3 API Gateway

Port : `8080`

Capture d'écran :

![API Gateway](docs/screenshots/04-api-gateway.png)

## 5. Account Service

Port : `8081`

Fonctionnalités :
- Création d'un compte.
- Consultation de tous les comptes.
- Consultation d'un compte par ID.
- Débit d'un compte.
- Vérification du solde et du statut.

### Test de création d'un compte
<img width="1900" height="991" alt="image" src="https://github.com/user-attachments/assets/22a58aeb-6a4f-4b26-8f2e-7735e208e38c" />


### Liste des comptes

![Get Accounts](docs/screenshots/06-get-accounts.png)

## 6. Transaction Service

Port : `8082`

Fonctionnalités :
- Création d'une transaction.
- Vérification du compte.
- Vérification du statut ACTIVE.
- Vérification de la devise.
- Vérification du solde.
- Débit du compte.
- Publication d'un événement Kafka.

### Création d'une transaction

![Create Transaction](docs/screenshots/07-create-transaction.png)

### Liste des transactions

![Get Transactions](docs/screenshots/08-get-transactions.png)

### Gestion des erreurs

![Transaction Validation](docs/screenshots/09-transaction-validation.png)

## 7. Kafka – Event-Driven Architecture

Topic : `bank.transactions.created`

L'événement est publié après la création d'une transaction. La clé Kafka utilisée est l'identifiant du compte (`accountId`).

### Producteur Kafka

![Kafka Producer](docs/screenshots/10-kafka-producer.png)

### Consommateur Kafka

![Kafka Consumer](docs/screenshots/11-kafka-consumer.png)

## 8. Fraud Detection – Python

Cette partie utilise Machine Learning pour détecter les transactions frauduleuses à partir du dataset `bank_transactions.csv`.

Éléments à présenter :
- Préparation des données.
- Prétraitement.
- Séparation Train/Test stratifiée.
- Entraînement du modèle.
- Évaluation : Precision, Recall, F1-score, Confusion Matrix et Average Precision.

![Fraud Detection](docs/screenshots/12-fraud-detection.png)

## 9. Frontend

Interface utilisateur de la plateforme bancaire.

![Frontend](docs/screenshots/13-frontend.png)

## 10. Chatbot IA et MCP

Assistant bancaire intelligent connecté aux outils et services MCP.

![Chatbot IA](docs/screenshots/14-chatbot.png)

## 11. Docker et CI/CD

Cette partie présente la conteneurisation des services et l'automatisation du pipeline CI/CD.

### Docker Compose

![Docker Compose](docs/screenshots/15-docker-compose.png)

### GitHub Actions

![GitHub Actions](docs/screenshots/16-github-actions.png)

## 12. Conclusion

Ce projet met en œuvre une architecture bancaire distribuée intégrant des microservices, une communication événementielle, des mécanismes de configuration centralisée et des composants d'intelligence artificielle.

## 13. Organisation des captures d'écran

Toutes les captures d'écran sont regroupées dans :

`docs/screenshots/`

Les noms des fichiers doivent correspondre aux références utilisées dans ce README.
