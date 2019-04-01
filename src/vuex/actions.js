// 获取秒杀数据
export const loadSeckillsInfo = ({ commit }) => {
  return new Promise((resolve, reject) => {
    const data = [
      {
        intro: '我有预感明天也会喜欢你',
        img: 'static/img/index/sale/sale-item1.jpg',
        price: 27.4,
        realPrice: 39.8,
      },
      {
        intro: '都挺好（套装共两册）',
        img: 'static/img/index/sale/sale-item2.jpg',
        price: 48.9,
        realPrice: 99.6
      },
      {
        intro: '林徽因传：人生从来都靠自己成全',
        img: 'static/img/index/sale/sale-item3.jpg',
        price: 28.4,
        realPrice: 58
      },
      {
        intro: '2020 MBA\\MPA\\MPAcc管理类联考 陈剑数学高分指南',
        img: 'static/img/index/sale/sale-item4.jpg',
        price: 46.4,
        realPrice: 59
      },
      {
        intro: '习近平在正定',
        img: 'static/img/index/sale/sale-item5.jpg',
        price: 52.8,
        realPrice: 66
      }
    ];
    const date = new Date();
    const hours = date.getHours();
    const minute = date.getMinutes();
    const seconds = date.getSeconds();
    console.log([hours, minute, seconds]);
    // 距离开始秒杀时间
    const deadline = {
      hours: 1,
      minute: 38,
      seconds: 36
    };
    commit('SET_SECKILLS_INFO', [data, deadline]);
  });
};

// 获取轮播(营销)图片
export const loadCarouselItems = ({ commit }) => {
  return new Promise((resolve, reject) => {
    const data = {
      carouselItems: [
        'static/img/nav/1.jpg',
        'static/img/nav/2.jpg',
        'static/img/nav/3.jpg',
        'static/img/nav/4.jpg',
        'static/img/nav/5.jpg'
      ],
      activity: [
        'static/img/nav/nav_showimg1.jpg',
        'static/img/nav/nav_showimg2.jpg'
      ]
    };
    commit('SET_CAROUSELITEMS_INFO', data);
  });
};

// 请求获得商品详细信息
export const loadGoodsInfo = ({ commit }) => {
  commit('SET_LOAD_STATUS', true);
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const data = {
        goodsImg: [
          'static/img/goodsDetail/goodsDetail-item1.jpg',
          'static/img/goodsDetail/goodsDetail-item2.jpg',
        ],
        title: '【白鹿原】一部渭河平原的雄奇史诗，一幅中国农村的斑斓画卷。主人公白嘉轩六娶六丧，奇异的命运序曲预示着不祥。',
        discount: ['满148减10', '满218减20', '满288减30'],
        promotion: ['跨店满减', '多买优惠'],
        index: '',
        remarksNum: 6000,
        price: 18.6,
        hot: [
          {
            img: 'static/img/goodsDetail/hot/goodsList-item21.jpg',
            price: 28,
            title: '穆斯林的葬礼',
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item22.jpg',
            price: 24,
            title: '丰乳肥臀'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item23.jpg',
            price: 18.8,
            title: '人生'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item20.jpg',
            price: 19.1,
            title: '我不'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item25.jpg',
            price: 19.6,
            title: '俗世奇人'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item15.jpg',
            price: 21,
            title: '裂'
          }
        ],
        goodsDetail: [
          {
            title: '编辑推荐',
            content: '本书集家庭史民族史于一体，以厚重的历史感和复杂的人物形象而在同类作品中脱颖而出，成为当代文学中不可多得的杰作之一。一部渭河平原的雄奇史诗，一幅中国农村的斑斓画卷。主人公白嘉轩六娶六丧，奇异的命运序曲预示着不祥。一个家庭两代子孙，为争夺白鹿原的统治代代争斗不已，上演了一幕幕惊心动魄的活剧：巧取风水地，恶施美人计，孝子为匪，亲翁杀媳，兄弟相煎，情人反目……大革命，日寇入侵，三年内战，白鹿原翻云覆雨，王旗变幻，家仇国恨，交错缠结，冤冤相报代代不已，古老的土地在新生的阵痛中颤栗。'
          },
          {
            title: '作者简介',
            content: '陈忠实，男，中国当代著名作家，曾任中国作家协会副主席。《白鹿原》是其成名著作，其他代表作有短篇小说集《乡村》、《到老白杨树背后去》，以及文论集《创作感受谈》。 中篇小说集《初夏》、《四妹子》，《陈忠实小说自选集》，《陈忠实文集》，散文集《接通地脉》等。 1997年获茅盾文学奖，其中《白鹿原》被教育部列入“大学生必读”系列，已发行逾160万册，被改编成秦腔、话剧、舞剧、电影等多种艺术形式。 2016年4月29日7:40左右，因病在西安西京医院去世。'
          }
          ],
        param: [
          {
            title: '开本',
            content: '16开'
          },
          {
            title: '纸张',
            content: '轻型纸'
          },
          {
            title: '包装',
            content: '平装-胶订'
          },
          {
            title: '是否套装',
            content: '否'
          },
          {
            title: '国际标准书号ISBN',
            content: '9787506394314'
          },
          {
            title: '所属分类',
            content: '图书>小说>社会'
          }
        ],
        remarks: {
          goodAnalyse: 99.9,
          remarksTags: [ '经典必读', '装帧精美', '引人入胜', '情节曲折', '温情感人'],
          remarksNumDetail: [ 81110, 81021, 51, 26 ],
          detail: [
            {
              username: 'p****1',
              values: 5,
              content: '表示是被电视剧吸引过来的。 之前看平凡的世界的时候，就对黄土高原有些向往。勤劳朴实，勇敢聪慧。他们身上有魅力，像黄土高山的魅力一样，粗犷强烈。 看他们的生活，就像看了一场狂风暴雨。热烈的同时，有冲刷污浊的舒爽。',
              create_at: '2018-05-15 09:20'
            },
            {
              username: '13****1',
              values: 5,
              content: '正直好在都被认为是正直了。自私也被认为是自私了。书里是的坎坷后来成了不是什么，而现实中的坎坷却是某些人的实实在在的坎坷。书，存在理想的成分，摆脱了生活！',
              create_at: '2018-05-13 15:23'
            },
            {
              username: '3****z',
              values: 4.5,
              content: '怎么说呢，这本书应该算是经典必读书目了吧？我文学史的老师也给我讲过这本书的内容，后来当新的翻拍的电视剧再次出来的时候，这又让我想起了这本书。所以这次当当做活动的时候我就入手了，这本书有时间一定会抽空把它看完的等我看完了再来说说，我看完之后的感受吧。',
              create_at: '2018-05-05 12:25'
            },
            {
              username: 'gd****c',
              values: 4.5,
              content: '一部好的小说，不仅仅是故事情节的离奇动人，也不仅仅在于语言的华丽，也不仅仅在于对历史的感悟，对人生的思考。好的小说应当是以上因素的集合。它能让人爱不释手，一气和呵成地读下来。陈忠实的《白鹿原》正是这样一部作品。 小说中的人物性格鲜明，个性独特，一开篇便牢牢地抓住了人的精神。围绕着主人公白嘉轩，展开了一幅近代传统农民的生活、农民的故事，纯朴的人生观所展现出的关中风情画卷。',
              create_at: '2018-04-06 16:23'
            }
          ]
        }
      };
      commit('SET_GOODS_INFO', data);
      commit('SET_LOAD_STATUS', false);
    }, 300);
  });
};

// 请求获得商品详细信息
export const loadGoodsInfo1 = ({ commit }) => {
  commit('SET_LOAD_STATUS', true);
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const data = {
        goodsImg: [
          'static/img/goodsDetail/goodsDetail-item3.jpg',
          'static/img/goodsDetail/goodsDetail-item4.jpg',
          'static/img/goodsDetail/goodsDetail-item5.jpg'
        ],
        title: '【房思琪的初恋乐园】张爱玲以后ZUI好的中文写作者，李银河、戴锦华、张悦然、蒋方舟、冯唐等郑重推荐！打动万千读者的现象级纯文学小说。豆瓣读书9.2超高评分。',
        discount: ['满148减10', '满218减20', '满288减30'],
        promotion: ['跨店满减', '多买优惠'],
        remarksNum: 6000,
        price: 31.1,
        index: '1',
        hot: [
          {
            img: 'static/img/goodsDetail/hot/goodsList-item21.jpg',
            price: 28,
            title: '穆斯林的葬礼',
            toLink:'1'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item22.jpg',
            price: 24,
            title: '丰乳肥臀'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item23.jpg',
            price: 18.8,
            title: '人生'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item20.jpg',
            price: 19.1,
            title: '我不'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item25.jpg',
            price: 19.6,
            title: '俗世奇人'
          },
          {
            img: 'static/img/goodsDetail/hot/goodsList-item15.jpg',
            price: 21,
            title: '裂'
          }
        ],
        goodsDetail: [
          {
            title: '内容简介',
            content: '痛苦的际遇是如此难以分享，好险这个世界还有文学。我下楼拿作文给李老师改。他掏出来，我被逼到涂在墙上。老师说了九个字：“不行的话，嘴巴可以吧。”我说了五个字：“不行，我不会。”他就塞进来。那感觉像溺水。可以说话之后，我对老师说：“对不起。”有一种功课做不好的感觉。小小的房思琪住在金碧辉煌的人生里，她的脸和她可以想象的将来一样漂亮。补习班语文名师李国华是同一栋高级住宅的邻居。崇拜文学的小房思琪同样崇拜饱读诗书的李老师。有一天李老师说，你的程度这么好，不如每个礼拜交一篇作文给我吧，不收你周点费。思琪听话地下楼了。老师在家里等她，桌上没有纸笔。思琪的初恋是李老师。因为李老师把她翻面，把他的东西塞进去。那年的教师节思琪才十三岁，这个世界和她原本认识的不一样。'
          },
          {
            title: '作者简介',
            content: '林奕含（1991——2017） 台湾作家。出生于台南，曾居台北。梦想是一面写小说，一面像大江健三郎所说的：从书呆子变成读书人，再从读书人变成知识分子。'
          },
          {
            title: '媒体评论',
            content: '从社会学角度看，这部小说涉及了儿童性侵和家庭暴力这两大社会问题。从纯文学角度看，林奕含令人肃然起敬，她是一位杰出的小说家，属于“老天赏饭”的类型。 ——李银河（著名学者 社会学家）如果把社会的阅读与回应考虑进来，说《房思琪的初恋乐园》是 2017 年的年度之书，恐怕也并不为过。《房》书其实是一部优美、准确而深刻的文学作品。它值得我们抛开一切杂音予以肯定。作者也是值得期待的新作家，只可惜这个期待是永远无法验证的了。（2017Openbook好书奖评审推荐语）——詹宏志（作家 出版人）'
          }
        ],
        param: [
          {
            title: '开本',
            content: '32开'
          },
          {
            title: '纸张',
            content: '胶版纸'
          },
          {
            title: '包装',
            content: '平装-胶订'
          },
          {
            title: '是否套装',
            content: '否'
          },
          {
            title: '国际标准书号ISBN',
            content: '9787559614636'
          },
          {
            title: '所属分类',
            content: '图书>小说>情感>言情'
          }
        ],
        remarks: {
          goodAnalyse: 99.9,
          remarksTags: [ '装帧精美','经典必读','温情感人', '情节曲折','引人入胜' ],
          remarksNumDetail: [ 100520, 100398, 83, 39 ],
          detail: [
            {
              username: 'p****1',
              values: 5,
              content: '先在新闻知道了这个作者 读之前心里已经有了预设或准备 但没想到读起来还是很震撼 小小的身体 小小的年纪 承载着无与伦比的沉重 这种社会现象真是荼毒摧毁一切 只是惋惜了作者的年轻与才华 希望那里一切安好 值得推荐!',
              create_at: '2018-05-15 09:20'
            },
            {
              username: '13****1',
              values: 5,
              content: '“房思琪的初恋乐园”。 写得优雅，看得惊心。冷静清醒，又痛彻心扉。 李银河说：“从纯文学角度看，她令人肃然起敬，是一位杰出的小说家，属于老天赏饭的类型，” 张伟说：“这本书是一个年轻女孩身上最后的生机，她把力量放进了书里，而没有留给自己。” 再也无需说更多。',
              create_at: '2018-05-13 15:23'
            },
            {
              username: '3****z',
              values: 4.5,
              content: '感觉真的好可惜，明明是一个这么有才华的女子，小时候却遇到那种事，觉得父母都应该读一读，悲剧的发生不仅是社会的问题，父母也有问题，如果父母可以及时发现苗头，或者她对她的伤害会少一些吧。希望天堂没有恶魔。',
              create_at: '2018-05-05 12:25'
            },
            {
              username: 'gd****c',
              values: 4.5,
              content: '我是在挤出来的时间里看完了它，在看的过程中，我有过愤怒、颤抖、恶心、寒冷、哭泣，这些思绪交织，我觉得我不能想很多社会性，文学性，单单作为读者，我感到无比的悲戚，我不能去运用我的想象力，不敢想象，难以置信。',
              create_at: '2018-04-06 16:23'
            },
            {
              username: 'mg****c',
              values: 4,
              content: '看完。真实，真实到心疼，关于噩梦，关于自我催眠自我压抑。看得我咬牙切齿，恨死里面的那个人，玩文字游戏禽兽不如。关于性与思想精神，永远不要信口开河，永远要多关注多关心，敏感的小孩啊～三思才行，任何时候的思想变化都有可能。',
              create_at: '2018-04-06 16:23'
            }
          ]
        }
      };
      commit('SET_GOODS_INFO', data);
      commit('SET_LOAD_STATUS', false);
    }, 300);
  });
};

// 获取商品列表
export const loadGoodsList = ({ commit }) => {
  commit('SET_LOAD_STATUS', true);
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const data = {
        asItems: [
          {
            img: 'static/img/goodsList/goodsList-item1.jpg',
            price: 35.1,
            intro: '巧巧兔幼儿经典故事',
            num: 3140,
            sale: 9000
          },
          {
            img: 'static/img/goodsList/goodsList-item2.jpg',
            price: 138,
            intro: '《7天学会家常主食》',
            num: 6160,
            sale: 8900
          },
          {
            img: 'static/img/goodsList/goodsList-item3.jpg',
            price: 26.3,
            intro: '流浪地球',
            num: 9160,
            sale: 8800
          },
          {
            img: 'static/img/goodsList/goodsList-item4.jpg',
            price: 225.9,
            intro: '动物小说',
            num: 6160,
            sale: 7990
          },
          {
            img: 'static/img/goodsList/goodsList-item5.jpg',
            price: 96,
            intro: '萧红文集',
            num: 9160,
            sale: 7600
          },
          {
            img: 'static/img/goodsList/goodsList-item6.jpg',
            price: 95,
            intro: '四世同堂',
            num: 6160,
            sale: 6900
          }
        ],
        goodsList: [
          {
            img: 'static/img/goodsList/goodsList-item8.jpg',
            price: 14,
            intro: '活着',
            remarks: 3000,
            color: 0,
            shopName: '余华 /2012-08-01 /作家出版社',
            sale: 9600
          },
          {
            img: 'static/img/goodsList/goodsList-item9.jpg',
            price: 15.00,
            intro: '房思琪的初恋乐园',
            remarks: 2800,
            color: 0,
            shopName: '林奕含 著，磨铁图书 出品 /2018-02-01 /北京联合出版有限公司',
            sale: 8900
          },
          {
            img: 'static/img/goodsList/goodsList-item12.jpg',
            price: 74.5,
            intro: '平凡的世界',
            remarks: 9006,
            color: 0,
            shopName: '路遥 著，新经典 出品 /2017-06-01 /北京十月文艺出版社',
            sale: 8530
          },
          {
            img: 'static/img/goodsList/goodsList-item24.jpg',
            price: 18.6,
            intro: '白鹿原',
            remarks: 8666,
            color: 0,
            shopName: '陈忠实 /2017-04-13 /作家出版社',
            sale: 8360
          },
          {
            img: 'static/img/goodsList/goodsList-item25.jpg',
            price: 19.6,
            intro: '俗世奇人',
            remarks: 3000,
            color: 0,
            shopName: '冯骥才 /2016-02-29 /作家出版社',
            sale: 6960
          },
          {
            img: 'static/img/goodsList/goodsList-item15.jpg',
            price: 21,
            intro: '裂',
            remarks: 2800,
            color: 0,
            shopName: '孙频 著 联合读创 出品 /2019-01-01 /北京联合出版有限公司',
            sale: 6560
          },
          {
            img: 'static/img/goodsList/goodsList-item16.jpg',
            price: 12.6,
            intro: '呼兰河传',
            remarks: 9000,
            color: 0,
            shopName: '萧红 著 /2014-12-01 /北京联合出版公司',
            sale: 6360
          },
          {
            img: 'static/img/goodsList/goodsList-item18.jpg',
            price: 14.4,
            intro: '一九八四',
            remarks: 9006,
            color: 0,
            shopName: '[英]乔治·奥威尔 著,傅霞 译 /2018-02-05 /时代文艺出版社',
            sale: 5560
          },
          {
            img: 'static/img/goodsList/goodsList-item23.jpg',
            price: 18.8,
            intro: '人生',
            remarks: 8666,
            color: 0,
            shopName: '路遥 著，新经典 出品 /2012-03-01 /北京十月文艺出版社',
            sale: 5260
          },
          {
            img: 'static/img/goodsList/goodsList-item20.jpg',
            price: 19.1,
            intro: '我不',
            remarks: 6080,
            color: 0,
            shopName: '大冰 著，博集天卷 出品 /2017-09-01 /湖南文艺出版社',
            sale: 3560
          },
          {
            img: 'static/img/goodsList/goodsList-item21.jpg',
            price: 37.4,
            intro: '穆斯林的葬礼',
            remarks: 6080,
            color: 0,
            shopName: '霍达 著，新经典 出品 /2015-09-01 /北京十月文艺出版社',
            sale: 3560
          },
          {
            img: 'static/img/goodsList/goodsList-item22.jpg',
            price: 24,
            intro: '丰乳肥臀',
            remarks: 6080,
            color: 0,
            shopName: '莫言 /2017-01-01 /浙江文艺出版社',
            sale: 3560
          },
          {
            img: 'static/img/goodsList/goodsList-item19.jpg',
            price: 32.1,
            intro: '寻找时间的人',
            remarks: 6080,
            color: 0,
            shopName: '作者 凯特·汤普森、译者 闫雪莲；酷威文化 出品 /2017-03-01 /江苏文艺出版社',
            sale: 3560
          }
        ]
      };
      commit('SET_GOODS_LIST', data);
      commit('SET_LOAD_STATUS', false);
    });
  });
};

// 添加购物车
export const addShoppingCart = ({ commit }, data) => {
  return new Promise((resolve, reject) => {
    commit('ADD_SHOPPING_CART', data);
  });
};

// 获取用户推荐
export const loadRecommend = ({ commit }) => {
  return new Promise((resolve, reject) => {
    const data = [
    ];
    commit('SET_RECOMMEND_INFO', data);
  });
};

export const loadAddress = ({ commit }) => {
  return new Promise((resolve, reject) => {
    const address = [
      {
        addressId: '1',
        name: '王明',
        province: '上海市',
        city: '',
        area: '闵行区',
        address: '上海交通大学',
        phone: '152********',
        postalcode: '200240'
      }
    ];
    commit('SET_USER_ADDRESS', address);
  });
};

export const loadShoppingCart = ({ commit }) => {
  return new Promise((resolve, reject) => {
    const data = [];
    commit('SET_SHOPPING_CART', data);
  });
};

// 添加注册用户
export const addSignUpUser = ({ commit }, data) => {
  return new Promise((resolve, reject) => {
    const userArr = localStorage.getItem('users');
    let users = [];
    if (userArr) {
      users = JSON.parse(userArr);
    }
    users.push(data);
    localStorage.setItem('users', JSON.stringify(users));
  });
};

// 用户登录
export const login = ({ commit }, data) => {
  return new Promise((resolve, reject) => {
    if (data.username === 'Gavin' && data.password === '123456') {
      localStorage.setItem('loginInfo', JSON.stringify(data));
      commit('SET_USER_LOGIN_INFO', data);
      resolve(true);
      return true;
    }
    const userArr = localStorage.getItem('users');
    console.log(userArr);
    if (userArr) {
      const users = JSON.parse(userArr);
      for (const item of users) {
        if (item.username === data.username) {
          localStorage.setItem('loginInfo', JSON.stringify(item));
          commit('SET_USER_LOGIN_INFO', item);
          resolve(true);
          break;
        }
      }
    } else {
      resolve(false);
    }
  });
};

// 退出登陆
export const signOut = ({ commit }) => {
  localStorage.removeItem('loginInfo');
  commit('SET_USER_LOGIN_INFO', {});
};

// 判断是否登陆
export const isLogin = ({ commit }) => {
  const user = localStorage.getItem('loginInfo');
  if (user) {
    commit('SET_USER_LOGIN_INFO', JSON.parse(user));
  }
};
