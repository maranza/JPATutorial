create table students(

  id serial not null primary key,
  first_name varchar not null,
  last_name varchar not null
);

create table modules(

 id serial primary key,
 name varchar not null
);

create table student_modules(
  student_id integer references students(id) not null,
  module_id integer references modules(id) not null
);