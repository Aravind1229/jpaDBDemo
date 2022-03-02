insert into course(id,name)values(10001,'JPA');
insert into course(id,name)values(10002,'SPRING');
insert into course(id,name)values(10003,'SPRING BOOT');

/**************/
insert into passport(id,number)values(40001,'E123456');
insert into passport(id,number)values(40002,'N123457');
insert into passport(id,number)values(40003,'L123458');
/**************/

insert into student(id,name,passport_id)values(20001,'john',40001);
insert into student(id,name,passport_id)values(20002,'adam',40002);
insert into student(id,name,passport_id)values(20003,'jane',40003);
/***************/
insert into review(id,rating,description,course_id)values(50001,'5','Great course',10001);
insert into review(id,rating,description,course_id)values(50002,'4','Wonderful course',10001);
insert into review(id,rating,description,course_id)values(50003,'5','Awesome course',10002);
/***************/
insert into student_course(student_id,course_id)values(20001,10001);
insert into student_course(student_id,course_id)values(20002,10001);
insert into student_course(student_id,course_id)values(20003,10001);
insert into student_course(student_id,course_id)values(20001,10003);