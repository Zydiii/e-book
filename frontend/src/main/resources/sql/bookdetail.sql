use ebook;

CREATE TABLE BookDetail (
  id int not null AUTO_INCREMENT,
  intro varchar(300),
  
  
  
  cover varchar(255),
  price float,
  title varchar(100),
  color int default 0,
  shopName varchar(100),
  writer varchar(100),
  remains int,
  remarkNum int,
  saleNum int,
  ISBN varchar(255),
  detail_id int,
  PRIMARY KEY (id),
  foreign key(detail_id) references bookdetail(id)
)AUTO_INCREMENT=1;
