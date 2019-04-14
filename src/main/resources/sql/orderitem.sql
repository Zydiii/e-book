use book;

CREATE TABLE orderitem (
  order_id varchar(255) not null,
  good_id varchar(255) not null,
  buynum int,
  primary key(order_id, good_id),
  foreign key(order_id) references orders(id),
  foreign key(good_id) references booklist(ISBN)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

