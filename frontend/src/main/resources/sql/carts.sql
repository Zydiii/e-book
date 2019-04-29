use ebook;

CREATE TABLE Carts (
  id int not null AUTO_INCREMENT,
  book_id int,
  num int,
  addtime timestamp,
  user_id int,
  primary key(id),
  foreign key(user_id) references userinfo(id),
  foreign key(book_id) references books(id)
)AUTO_INCREMENT=1;