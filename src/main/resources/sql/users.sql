use book;

CREATE TABLE users (
  user_id varchar(255) not null,
  address varchar(255),
  use_password varchar(20) not null,
  identity int,
  valid int,
  primary key(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

