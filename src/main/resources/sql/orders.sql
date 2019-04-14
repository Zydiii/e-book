use book;

CREATE TABLE orders (
  id varchar(255) not null,
  money double default 0,
  receiverAddress varchar(255) not null,
  receiverName varchar(20) not null,
  receiverPhone varchar(20) not null,
  paystate int,
  odertime timestamp,
  user_id varchar(255) not null,
  primary key(id),
  foreign key(user_id) references users(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;