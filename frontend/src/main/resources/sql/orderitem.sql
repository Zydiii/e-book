use ebook;

CREATE TABLE orderitem (
  order_id int,
  book_id int,
  num int,
  primary key(order_id, book_id),
  foreign key(order_id) references orders(id),
  foreign key(book_id) references books(id)
);

