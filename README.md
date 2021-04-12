# Quiz3.0
Description:

Amazing application which can measure your intelligence.

Update 0.0.5

This version of application have a few endponts for crud user 
operations such as create, delete, update, get. All operations 
are test coverage. 


# Start appliaction

run command: docker-compose up

This command creates containers for postgredb and pgadmin.
After this you can go to localhost:5050 and try to connect
using login and password which are inside 
docker-compose.yml and database.env. 

You need to generate userdto file.  You can run command 
mvn clean install or do it with these steps.
1. View -> Tool Windows -> Maven. 
2. Opens your projects in a sub-window.
3. Click on the arrow next to your project.
4. Click on Lifecycle.
5. Click on clean.
6. Click on the green (play) button.
7. Click on install.
8. Click on the green (play) button.

# Technology Stack

Data: 
PostgreSQL, H2DatabaseEnginge

BackEnd: java 11, Spring Boot, meaven

Others: git, docker, dockerfile meaven

# To-Do

next version features 

- update user json
- add question table
- add user log in and registration 

check technologies

- Flyway
- JSONWebToken
- SpringSecurity
- Logger
- Frontend
- Swagger
- More Unit tests and integration tests