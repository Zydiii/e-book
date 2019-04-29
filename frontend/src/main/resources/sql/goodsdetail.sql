use book;

CREATE TABLE GoodsDetail (
  goodsImg varchar(255) default null,
  goodsDetail varchar(255) default null,
  discount varchar(255) default null,
  param varchar(255) default null,
  promotion varchar(255) default null,
  remarks varchar(255) default null,
  index1 varchar(255) default null,
  price float not null,
  title varchar(255) default null,
  remarksNum double default 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into GoodsDetail(goodsImg,title,discount,promotion,index1,remarksNum,price,goodsDetail,param,remarks)
value
('static/img/goodsDetail/goodsDetail-item1.jpg',
'【白鹿原】一部渭河平原的雄奇史诗，一幅中国农村的斑斓画卷。主人公白嘉轩六娶六丧，奇异的命运序曲预示着不祥。',
'满148减10','跨店满减','',
6000,18.6,'本书集家庭史民族史于一体，以厚重的历史感和复杂的人物形象而在同类作品中脱颖而出，成为当代文学中不可多得的杰作之一。一部渭河平原的雄奇史诗，一幅中国农村的斑斓画卷。主人公白嘉轩六娶六丧，奇异的命运序曲预示着不祥。一个家庭两代子孙，为争夺白鹿原的统治代代争斗不已，上演了一幕幕惊心动魄的活剧：巧取风水地，恶施美人计，孝子为匪，亲翁杀媳，兄弟相煎，情人反目……大革命，日寇入侵，三年内战，白鹿原翻云覆雨，王旗变幻，家仇国恨，交错缠结，冤冤相报代代不已，古老的土地在新生的阵痛中颤栗。','16开','表示是被电视剧吸引过来的。 之前看平凡的世界的时候，就对黄土高原有些向往。勤劳朴实，勇敢聪慧。他们身上有魅力，像黄土高山的魅力一样，粗犷强烈。 看他们的生活，就像看了一场狂风暴雨。热烈的同时，有冲刷污浊的舒爽。');