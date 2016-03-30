# osgi-amdatu-modular
The modular application (build with OSGi and Amdatu) that was used in the comparison from [this article](http://wp.me/p5qBJ9-e7)
This application is build according to the instructions from [here](http://www.amdatu.org/tutorial/step1.html)

## Prerequisites

1. Eclipse with bndtools setup as expalined in [Setting up the toolchain](http://www.amdatu.org/tutorial/step1.html)
2. mongoDB

## Running the application

1. From the _org.amdatu.tutorial.todo.rest_ project, open the tutorial.bndrun
2. Click the Run OSGi button in the upper right corner

The application exposes 2 rest resources on http://localhost:8080/todo:

GET /todo/{userId} -> curl http://localhost:8080/todo/test

POST /todo -> curl -H "Content-Type: application/json" -d '{"user":"test", "description": "Finish the tutorial"}' http://localhost:8080/todo)