use ebook;

CREATE TABLE users (
  id int not null AUTO_INCREMENT,
  logid varchar(20),
  name varchar(20),
  address varchar(255),
  password varchar(20),
  phone varchar(20),
  identity int,
  valid int,
  primary key(id)
)AUTO_INCREMENT=1;

insert into userinfo (id, logid, name, address, password, phone, identity, valid)
value
(1, 'didi', '小王', '上海市闵行区东川路800号上海交通大学学生宿舍西23', '123456', '15826138027', 0, 1);
insert into userinfo (id, logid, name, address, password, phone, identity, valid)
value
(2, 'zyd', '小红', '上海市闵行区东川路800号上海交通大学学生宿舍东23', 'aaaaaa', '15986138027', 0, 0);
insert into userinfo (id, logid, name, address, password, phone, identity, valid)
value
(3, 'user', '小明', '上海市闵行区东川路800号上海交通大学学生宿舍东12', 'password', '15026138027', 1, 1);

