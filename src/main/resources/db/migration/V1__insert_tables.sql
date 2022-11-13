CREATE TABLE "course_class" (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
name VARCHAR(100)
);

CREATE TABLE "project_group" (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
name VARCHAR(100),
project_score NUMERIC(10,2),
course_class_id INTEGER,
CONSTRAINT fk_course_class
 FOREIGN KEY(course_class_id)
     REFERENCES course_class(id)
);

CREATE TABLE "student" (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
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
  id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  test_score NUMERIC(10,2),
  student_id INTEGER,
  CONSTRAINT fk_student
      FOREIGN KEY(student_id)
          REFERENCES student(id)
);




