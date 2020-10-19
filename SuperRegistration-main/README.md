# Super Registration App
An Angularjs spring-boot application that deals with a user registration and viewing of users all backed by a dockerized postgres database ie this is a CRUD exercise using angular and spring boot

#project pre-requisites

You need JAVA 8, Maven, Docker, Node&NPM and Angular Cli to be able to successfully run this application

## starting the app

step1:

bring up the docker container using the yaml file provide in the route directory of this project
> docker-compose up -d

make sure the docker postgres container is up
>docker container ls

you are looking for a container named super_registration_db

step2:

start your backend application

>cd backend
>
>mvn clean install
>
>mvn spring-boot:run

step3:

start up the angular front end

in another terminal

>cd frontend
>
>npm install
>
>ng serve

step4:

The App is available here: http://localhost:4200

The API is available here: http://localhost:8080

The postgres docker internal port is 5432. I have chosen to expose it externally on port 5452
just in case the user has a default postgres running on their machine.

To start interacting with the app go to http://localhost:4200 

## Other commands

To bring down the docker container run from the project route

>docker-compose down

To run the backend tests:

> cd backend
> .\mvnw test

building artifacts for the front end (/dist):

>ng build

Running frontend tests via Karma:

>ng test

Running end to end tests via Protractor

>ng e2e
