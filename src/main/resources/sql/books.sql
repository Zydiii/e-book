use ebook;

CREATE TABLE Books (
  id int not null AUTO_INCREMENT,
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
  intro varchar(300),
  time timestamp,
  PRIMARY KEY (id)
)AUTO_INCREMENT=1;

insert into Books (id,cover,price,title,remarkNum,color,shopName,writer,time,saleNum,ISBN,remains,intro)
value
(1, "static/img/goodsList/goodsList-item9.jpg",35,"房思琪的初恋乐园",3000,0,"磨铁图书社","林奕含",'20180201',9600,9787559614636,100, 
'与房思琪情同双胞的刘怡婷，到警局通知，去带回神志不清，被判定疯了的房思琪。透过思琪的日记，怡婷得知思琪五年中的所见所思……嫁钱家的许伊纹，是两位少女的忘年交，二十余岁的她，是两位少女的文学启蒙者同时也是丈夫家暴的沉默受害者……升大学后的郭晓奇仍旧爱着高中时的补习教师李国华，而这位文质彬彬的补习教师并不只有平时人们眼中受人尊敬的老师形象的一面…… ');

insert into Books (cover,price,title,remarkNum,color,shopName,writer,time,saleNum,ISBN,remains,intro)
value
("static/img/goodsList/goodsList-item24.jpg",18.6,"白鹿原",5000,0,"作家出版社","陈忠实",'20170413',9900,9787506394314,450,
"本书集家庭史民族史于一体，以厚重的历史感和复杂的人物形象而在同类作品中脱颖而出，成为当代文学中不可多得的杰作之一。一部渭河平原的雄奇史诗，一幅中国农村的斑斓画卷。主人公白嘉轩六娶六丧，奇异的命运序曲预示着不祥。一个家庭两代子孙，为争夺白鹿原的统治代代争斗不已，上演了一幕幕惊心动魄的活剧：巧取风水地，恶施美人计，孝子为匪，亲翁杀媳，兄弟相煎，情人反目……大革命，日寇入侵，三年内战，白鹿原翻云覆雨，王旗变幻，家仇国恨，交错缠结，冤冤相报代代不已，古老的土地在新生的阵痛中颤栗。");