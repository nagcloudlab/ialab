
create table users(
                      id int primary key auto_increment,
                      username varchar(255) not null unique,
                      password varchar(255) not null,
                      name varchar(255) not null,
                      email varchar(255) not null unique
);
select * from users;
insert into users(username, password, name, email) values ('tom','secret','Tom','tom@gmail.com');
insert into users(username, password, name, email) values ('jerry','secret','Jerry','jerry@gmail.com');


create table todos(
                      id int primary key auto_increment,
                      title varchar(255) not null,
                      completed boolean,
                      type varchar(255) not null default 'HOME',
                      user_id int not null references users(id)
);

insert into todos(title, completed, type, user_id) values ('todo-1',false,'OFFICE',1);
insert into todos(title, completed, type, user_id) values ('todo-2',false,'OFFICE',1);
insert into todos(title, completed, type, user_id) values ('todo-3',false,'OFFICE',2);


select t.title,u.name
from todos t inner join users u on u.id = t.user_id
where username = 'tom' && t.completed=false;
