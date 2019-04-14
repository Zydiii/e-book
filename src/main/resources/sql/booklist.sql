use book;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE BookList (
  img varchar(255) default null,
  price float not null,
  intro varchar(255) default null,
  remarks double default 0,
  color int default 0,
  shopName varchar(255) default null,
  sale double default 0,
  ISBN varchar(255) not null,
  remain double default 0,
  PRIMARY KEY (ISBN)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into BookList (img, price, intro, remarks, color, shopName, sale, ISBN, remain)
value
("static/img/goodsList/goodsList-item8.jpg",14,"活着",3000,0,"余华 /2012-08-01 /作家出版社",9600,9787506365437,100);

insert into BookList (img, price, intro, remarks, color, shopName, sale, ISBN, remain)
value
("static/img/goodsList/goodsList-item9.jpg",15,"房思琪的初恋乐园",2800,0,"林奕含 著，磨铁图书 出品 /2018-02-01 /北京联合出版有限公司",8900,9787559614636,200);

insert into BookList (img, price, intro, remarks, color, shopName, sale, ISBN, remain)
value
("static/img/goodsList/goodsList-item12.jpg",74.5,"平凡的世界",300,0,"路遥 著，新经典 出品 /2017-06-01 /北京十月文艺出版社",2900,9787530216781,50);

insert into BookList (img, price, intro, remarks, color, shopName, sale, ISBN, remain)
value
("static/img/goodsList/goodsList-item24.jpg",18.6,"白鹿原",10008,0,"陈忠实 /2017-04-13 /作家出版社",9900,9787506394314,450);