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

![at ma.adria.bank.account.service.AccountService.create(AccountService.java:27) ~[classes/:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359) ~[spring-aop-7.0.10.jar:7.0.10]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190) ~[spring-aop-7.0.10.jar:7.0.10]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:158) ~[spring-aop-7.0.10.jar:7.0.10]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:133) ~[spring-tx-7.0.10.jar:7.0.10]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:371) ~[spring-tx-7.0.10.jar:7.0.10]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:130) ~[spring-tx-7.0.10.jar:7.0.10]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179) ~[spring-aop-7.0.10.jar:7.0.10]
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:714) ~[spring-aop-7.0.10.jar:7.0.10]
	at ma.adria.bank.account.service.AccountService$$SpringCGLIB$$0.create(<generated>) ~[classes/:na]
	at ma.adria.bank.account.controller.AccountController.create(AccountController.java:24) ~[classes/:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:252) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:184) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:934) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:853) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:86) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:866) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1000) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:903) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:649) ~[tomcat-embed-core-11.0.27.jar:6.1]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:874) ~[spring-webmvc-7.0.10.jar:7.0.10]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:710) ~[tomcat-embed-core-11.0.27.jar:6.1]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:132) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:59) ~[tomcat-embed-websocket-11.0.27.jar:11.0.27]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:111) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-7.0.10.jar:7.0.10]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:111) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-7.0.10.jar:7.0.10]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:111) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:110) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-7.0.10.jar:7.0.10]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:111) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:199) ~[spring-web-7.0.10.jar:7.0.10]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-7.0.10.jar:7.0.10]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:111) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:164) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:77) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:540) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:86) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:71) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:347) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:411) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:71) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:1308) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:2202) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:74) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:947) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:481) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:74) ~[tomcat-embed-core-11.0.27.jar:11.0.27]
	at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]

Hibernate: insert into accounts (balance,currency,customer_reference,status,id) values (?,?,?,?,?)
Hibernate: select a1_0.id,a1_0.balance,a1_0.currency,a1_0.customer_reference,a1_0.status from accounts a1_0
2026-10-30T11:05:59.971Z  INFO 31336 --- [account-service] [rap-executor-%d] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
Hibernate: select a1_0.id,a1_0.balance,a1_0.currency,a1_0.customer_reference,a1_0.status from accounts a1_0
2026-10-30T11:10:59.975Z  INFO 31336 --- [account-service] [rap-executor-%d] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
2026-10-30T11:15:59.981Z  INFO 31336 --- [account-service] [rap-executor-%d] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
2026-10-30T11:20:59.989Z  INFO 31336 --- [account-service] [rap-executor-%d] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
Hibernate: insert into accounts (balance,currency,customer_reference,status,id) values (?,?,?,?,?)


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

<img width="1900" height="991" alt="image" src="https://github.com/user-attachments/assets/6127150f-b33e-470e-bb3f-f307f2938d89" />

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
