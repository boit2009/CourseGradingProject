# Course Grading Project

## Description
In my project I will develop a program which can be used as a grading system for a university course. It can be used for multiple classes (for example. on Analysis 1 we had that case, that we had the same course, the same teacher, in the same semester, but we were divided into different class groups). My project will be capable of handling the student’s scores during the semester.  In the semester students must write a little test in the beginning of every lab. The students in every class must form projectGroups from 2-3 people. During the semester they have to create a project and every project will have one final score (every student got the same amount of score for it). During the semester, Students will be able to list their scores by they unique ID. There will be another kind of user, the Teacher. He/she will be able to add/modify new Classes, new Students. Based on the feedback of the projectGroup demands of the students, he/she will be able to create/modify the projectGroups.

## Github repository
The project is available at [Github repository]https://github.com/boit2009/CourseGradingProject
## Specification
The specification is available here: [Github repository]https://github.com/boit2009/CourseGradingProject/src/main/resources/static/Specification_X0MD3J.pdf



### Entity Relationship Diagram

![ERD](images/diagram.jpg?raw=true "ERD")




#### Run and setup:
```console
$ mvn clean
$ mvn install
$ docker-compose up
$ mvn spring-boot:run
```

#### Reaching endpoints
http://localhost:8089/swagger-ui/index.html

#### Used Roles
TEACHER, username: teacher, password: teacher
STUDENT, username: student, password: student