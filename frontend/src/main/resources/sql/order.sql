use ebook;

CREATE TABLE Orders (
  id int not null AUTO_INCREMENT,
  money float,
  receiverAddress varchar(255),
  receiverName varchar(20),
  receiverPhone varchar(20),
  state int,
  odertime timestamp,
  donetime timestamp,
  user_id int,
  see int,
  primary key(id),
  foreign key(user_id) references userinfo(id)
)AUTO_INCREMENT=1;