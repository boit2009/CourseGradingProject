CREATE TABLE "course_class" (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE "project_group" (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR(100),
project_score NUMERIC(10,2),
course_class_id INTEGER,
CONSTRAINT fk_course_class
 FOREIGN KEY(course_class_id)
 REFERENCES course_class(id)
);

CREATE TABLE "student" (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR(100),
course_class_id INTEGER,
CONSTRAINT fk_course_class
   FOREIGN KEY(course_class_id)
   REFERENCES course_class(id),
project_group_id INTEGER,
CONSTRAINT fk_project_group_id
   FOREIGN KEY(project_group_id)
       REFERENCES project_group(id)
);

CREATE TABLE "test_score" (
id INTEGER NOT NULL PRIMARY KEY,
test_score NUMERIC(10,2),
student_id INTEGER,
CONSTRAINT fk_student
  FOREIGN KEY(student_id)
  REFERENCES student(id)
);
insert into course_class(name,id) values ('2022_A',1);
insert into course_class(name,id) values ('2022_B',2);
insert into project_group(name,id, course_class_id, project_score) values ('ProjectGroup1',1, 1,0);
insert into student(name,id,project_group_id, course_class_id) select 'student1',1,1, id from course_class where name = '2022_A';
insert into student(name,id,project_group_id, course_class_id) select 'student2',2,1, id from course_class where name = '2022_A';
insert into student(name,id, course_class_id) select 'student3',3, id from course_class where name = '2022_A';
insert into student(name,id, course_class_id)select 'student4',4, id from course_class where name = '2022_A';
insert into student(name,id, course_class_id) select 'student5',5, id from course_class where name = '2022_A';
insert into student(name,id, course_class_id) select 'student6',6, id from course_class where name = '2022_B';
insert into student(name,id, course_class_id) select 'student7',7, id from course_class where name = '2022_B';
insert into student(name,id, course_class_id) select 'student8',8, id from course_class where name = '2022_B';
