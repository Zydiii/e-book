<template>
  <div>
    <div class="nav-body">
      <div class="nav-side" ref="navSide">
        <ul>
          <li @mouseenter="showDetail(1)" @mouseleave="hideDetail(1)">
            <span class="nav-side-item">特色书单</span>
          </li>
          <li @mouseenter="showDetail(2)" @mouseleave="hideDetail(2)">
            <span class="nav-side-item">电子书</span>
            <span class="nav-side-item">网络文学</span>
            <span class="nav-side-item">阅读器</span>
          </li>
          <li @mouseenter="showDetail(3)" @mouseleave="hideDetail(3)">
            <span class="nav-side-item">教育</span>
          </li>
          <li @mouseenter="showDetail(4)" @mouseleave="hideDetail(4)">
            <span class="nav-side-item">小说</span>
          </li>
          <li @mouseenter="showDetail(5)" @mouseleave="hideDetail(5)">
            <span class="nav-side-item">文艺</span>
          </li>
          <li @mouseenter="showDetail(6)" @mouseleave="hideDetail(6)">
            <span class="nav-side-item">青春文学</span>
            <span class="nav-side-item">动漫</span>
            <span class="nav-side-item">幽默</span>
          </li>
          <li @mouseenter="showDetail(7)" @mouseleave="hideDetail(7)">
            <span class="nav-side-item">童书</span>
          </li>
          <li @mouseenter="showDetail(8)" @mouseleave="hideDetail(8)">
            <span class="nav-side-item">人文社科</span>
          </li>
          <li @mouseenter="showDetail(9)" @mouseleave="hideDetail(9)">
            <span class="nav-side-item">经管</span>
          </li>
          <li @mouseenter="showDetail(10)" @mouseleave="hideDetail(10)">
            <span class="nav-side-item">成功</span>
            <span class="nav-side-item">励志</span>
          </li>
          <li @mouseenter="showDetail(11)" @mouseleave="hideDetail(11)">
            <span class="nav-side-item">生活</span>
          </li>
          <li @mouseenter="showDetail(12)" @mouseleave="hideDetail(12)">
            <span class="nav-side-item">科技</span>
          </li>
          <li @mouseenter="showDetail(13)" @mouseleave="hideDetail(13)">
            <span class="nav-side-item">英文原版书</span>
            <span class="nav-side-item">港台图书</span>
          </li>
          <li @mouseenter="showDetail(14)" @mouseleave="hideDetail(14)">
            <span class="nav-side-item">期刊</span>
            <span class="nav-side-item">音像</span>
          </li>
        </ul>
      </div>
      <div class="nav-content">
        <div>
          <router-link to="/goodsList">
            <img src="../../../static/img/nav/1.jpg">
          </router-link>
        </div>
        <div class="nav-show">
          <router-link to="/goodsList">
            <img src="../../../static/img/nav/2.jpg">
          </router-link>
          <router-link to="/goodsList">
            <img src="../../../static/img/nav/3.jpg">
          </router-link>
        </div>
      </div>
    </div>
    <transition name="fade">
      <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel1" @mouseenter="showDetail(1)" ref="itemPanel1" @mouseleave="hideDetail(1)">
        <ul>
          <li v-for="(items, index) in panelData1.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-2" :duration="{ enter: 100, leave: 100 }" v-show="panel2" @mouseenter="showDetail(2)" ref="itemPanel2" @mouseleave="hideDetail(2)">
        <ul>
          <li v-for="(items, index) in panelData2.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-3" :duration="{ enter: 100, leave: 100 }" v-show="panel3" @mouseenter="showDetail(3)" ref="itemPanel3" @mouseleave="hideDetail(3)">
        <ul>
          <li v-for="(items, index) in panelData3.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-4" :duration="{ enter: 100, leave: 100 }" v-show="panel4" @mouseenter="showDetail(4)" ref="itemPanel4" @mouseleave="hideDetail(4)">
        <ul>
          <li v-for="(items, index) in panelData4.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-5" :duration="{ enter: 100, leave: 100 }" v-show="panel5" @mouseenter="showDetail(5)" ref="itemPanel5" @mouseleave="hideDetail(5)">
        <ul>
          <li v-for="(items, index) in panelData5.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-6" :duration="{ enter: 100, leave: 100 }" v-show="panel6" @mouseenter="showDetail(6)" ref="itemPanel6" @mouseleave="hideDetail(6)">
        <ul>
          <li v-for="(items, index) in panelData6.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-7" :duration="{ enter: 100, leave: 100 }" v-show="panel7" @mouseenter="showDetail(7)" ref="itemPanel7" @mouseleave="hideDetail(7)">
        <ul>
          <li v-for="(items, index) in panelData7.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-8" :duration="{ enter: 100, leave: 100 }" v-show="panel8" @mouseenter="showDetail(8)" ref="itemPanel8" @mouseleave="hideDetail(8)">
        <ul>
          <li v-for="(items, index) in panelData8.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-9" :duration="{ enter: 100, leave: 100 }" v-show="panel9" @mouseenter="showDetail(9)" ref="itemPanel9" @mouseleave="hideDetail(9)">
        <ul>
          <li v-for="(items, index) in panelData9.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-10" :duration="{ enter: 100, leave: 100 }" v-show="panel10" @mouseenter="showDetail(10)" ref="itemPanel10" @mouseleave="hideDetail(10)">
        <ul>
          <li v-for="(items, index) in panelData10.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-11" :duration="{ enter: 100, leave: 100 }" v-show="panel11" @mouseenter="showDetail(11)" ref="itemPanel2" @mouseleave="hideDetail(11)">
        <ul>
          <li v-for="(items, index) in panelData11.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-12" :duration="{ enter: 100, leave: 100 }" v-show="panel12" @mouseenter="showDetail(12)" ref="itemPanel12" @mouseleave="hideDetail(12)">
        <ul>
          <li v-for="(items, index) in panelData12.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-13" :duration="{ enter: 100, leave: 100 }" v-show="panel13" @mouseenter="showDetail(13)" ref="itemPanel2" @mouseleave="hideDetail(13)">
        <ul>
          <li v-for="(items, index) in panelData13.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
    <transition name="fade">
      <div class="detail-item-panel panel-14" :duration="{ enter: 100, leave: 100 }" v-show="panel14" @mouseenter="showDetail(14)" ref="itemPanel2" @mouseleave="hideDetail(14)">
        <ul>
          <li v-for="(items, index) in panelData14.classNav" :key="index" class="detail-item-row">
            <span class="detail-item-title">{{items.title}}
              <span class="glyphicon glyphicon-menu-right"></span>
            </span>
            <router-link to="/goodsList" v-for="(item, subIndex) in items.tags" :key="subIndex">
              <span class="detail-item">{{item}}</span>
            </router-link>
          </li>
        </ul>
      </div>
    </transition>
  </div>
</template>

<script>
  import store from '@/vuex/store';
  import { mapState } from 'vuex';
  export default {
    name: 'HomeNav',
    data () {
      return {
        panel1: false,
        panel2: false,
        panel3: false,
        panel4: false,
        panel5: false,
        panel6: false,
        panel7: false,
        panel8: false,
        panel9: false,
        panel10: false,
        panel11: false,
        panel12: false,
        panel13: false,
        panel14: false,
        nav: [
        ],
        panelData1: {
          classNav: [
            {
              title: '童书',
              tags: [ '清华附小推荐书单','一年级课外阅读书单','二年级课外阅读书单','凯迪克奖获奖作品','致敬大师-林明子温暖绘本',
                '给新手爸妈的入门图画书','纽伯瑞奖获奖作品','图画书之后读什么？--桥梁书','二胎时代孩子们需要的书']
            },
            {
              title: '文艺',
              tags: ['央视《朗读者》第二季书单','抖音点赞30W+精选书单','七年级至高中必读书目','2017-2018年播出的影视剧原著',
                '场景书单：总有本小说在案头','美国推理作家协会百部最佳推理']
            },
            {
              title: '社科',
              tags: ['历史类人气品牌 “甲骨文丛书”书单','历史类精品“汗青堂丛书”书单','译文纪实系列书单','中信“新思文库”品牌书单','中信见识丛书书单']
            },
            {
              title: '经管励志',
              tags: ['终身学习者推崇的20本书','10本必读心灵成长经典瞬间','提高个人修养的10部经典','管理者进阶书单','职场精进书单：你离高手还差几个段位']
            },
            {
              title: '生活',
              tags: ['充满爱的家，总有灯光为你点亮','Lonely Planet 2018亚洲十佳旅行目的地榜单','玩出来的专注力','美食MOOK野路子','孩子越大越难管，父母越当越烦躁']
            },
            {
              title: '科技',
              tags: ['EXCEL数据分析就像一本故事书','人民日报推荐过的科普读物','学习计算机系统必看的5本书']
            },
            {
              title: '教育',
              tags: ['教育部推荐初中必读书目','《手捧智库》丛书','特级教师倾力推荐：亲近母语系列']
            }
          ]
        },
        panelData2: {
          classNav: [
            {
              title: '特价',
              tags: ['当读VIP','免费书','特价书','限时抢','阅读器']
            },
            {
              title: '网络文学',
              tags: ['男频','女频','玄幻奇幻','现代都市','武侠仙侠','现代言情','穿越重生','古装言情']
            },
            {
              title: '小说',
              tags: ['侦探/悬疑/推理','玄幻/惊悚','影视/娱乐','爱情/情感','武侠小说','外国小说']
            },
            {
              title: '文艺',
              tags: ['传记','随笔','文学作品集','纪实文学','艺术','摄影','文学评论与鉴赏' ]
            },
            {
              title: '社科',
              tags: ['历史','心理学','哲学','政治/军事','社会科学','古籍法律']
            },
            {
              title: '生活',
              tags: ['亲子/家教','育儿/早教','两性关系','孕产/胎教','保健/养生','旅游/地图','烹饪/美食','时尚/美妆','手工/DIY','家庭/家居']
            },
            {
              title: '教育/科技',
              tags: ['考试','外语','中小学教辅','工具书','科普读物','计算机/网络','自然科学']
            },
            {
              title: '童书/进口书',
              tags: ['儿童文学','启蒙读物','成长/益智','动漫/图画书','外文原版书','港台图书']
            }
          ]
        },
        panelData3: {
        classNav: [
          {
            title: '教材',
            tags: ['研究生/本科/专科教材','高职高专教材','中职教材','成人教育教材','职业技术培训教材','公共课','经济管理类',
              '工学类','文法类','医学类','理学类','农学','更多']
          },
          {
            title: '外语',
            tags: ['英语综合教程','英语专项训练','英语读物','英语考试','英语工具书','小语种','新概念','口语','听力',
              '英文版读物','IELTS','TOEFL','GRE','GMAT','SAT','TOEIC','BEC','翻译资格','职称英语','CET-4','CET-6','专四/八',
              '日语','法语','韩语','对外汉语','更多']
          },
          {
            title: '考试',
            tags: ['学历考试','公职','财税外贸保险','建筑工程','计算机','医药卫生','艺术/体育','考研','MBA/MPA/MPAcc',
              '公务员','事业单位','注册会计师','会计职称','会计从业','一级建造师','二级建造师','卫生职称','医师资格',
              '人力资源管理师','更多']
          },
          {
            title: '中小学教辅',
            tags: ['幼小衔接','一年级','二年级','三年级','四年级','五年级','六年级','小学升初中','小学通用','七年级',
              '八年级','九年级','中考','初中通用','高一','高二','高三','高考','高中通用','中小学阅读','英语专项','语文作文',
              '工具书','写字/字帖','学习方法','教育理论/教师用书','更多']
          },
          {
            title: '工具书',
            tags: ['汉语工具书','英语工具书','其他语种工具书','百科全书/年鉴','文学鉴赏辞典','牛津系列','朗文系列','民族语工具书',
              '英文原版书-工具书']
          }
        ]
      },
        panelData4: {
          classNav: [
            {
              title: '小说',
              tags: ['中国当代小说','中国近现代小说','中国古典小说','四大名著','港澳台小说','外国小说','侦探/悬疑/推理',
                '惊悚/恐怖','魔幻','科幻','武侠','军事','情感','社会','都市','乡土','职场','财经','官场','历史','影视小说','作品集','世界名著']
            }
          ]
        },
        panelData5: {
          classNav: [
            {
              title: '文学',
              tags: ['文集','纪实文学','文学理论','中国古诗词','中国现当代诗歌','外国诗歌','中国古代随笔','中国现当代随笔',
                '外国随笔','戏剧','民间文学','文学类考试','英文原版书-文学','名家作品','文学评论与鉴赏']
            },
            {
              title: '传记',
              tags: ['财经人物','历代帝王','领袖首脑','军事人物','政治人物','历史人物','女性人物','法律人物','宗教人物',
                '哲学家','人文/社会学家','教育家','语言文字学家','文学家','艺术家','科学家','国学大师','影视明星','体育明星',
                '人物合集','传记的研究与编写','家族研究/谱系','年谱','自传','画传','学者','其他','英文原版书-传记','建筑设计师']
            },
            {
              title: '艺术',
              tags: ['艺术理论','世界各国艺术概况','绘画','书法/篆刻','影视/媒体艺术','戏剧艺术/舞台艺术','音乐','舞蹈',
                '雕塑','设计','人体艺术','工艺美术','民间艺术','建筑艺术','艺术类考试','收藏/鉴赏','小人书/连环画','英文原版书-艺术']
            },
            {
              title: '摄影',
              tags: ['摄影理论','摄影入门','分类摄影','摄影进阶','摄影器材','技法/教程','后期处理','作品集/作品赏析','英文原版书-摄影']
            }
          ]
        },
        panelData6: {
          classNav: [
            {
              title: '青春文学',
              tags: ['校园','爱情/情感','叛逆/成长','悬疑/惊悚','娱乐/偶像','爆笑/无厘头','玄幻/新武侠/魔幻/科幻','大陆原创',
                '港台青春文学','韩国青春文学','穿越/重生/架空','其他国外青春文学','影视写真','古代言情']
            },
            {
              title: '动漫/幽默',
              tags: ['大陆漫画','港台漫画','日韩漫画','欧美漫画','其他国外漫画','世界经典漫画集','小说/名著漫画版','动漫学堂',
                '幽默/笑话集','轻小说','游戏同人作品','画集','动漫同人作品']
            }
          ]
        },
        panelData7: {
          classNav: [
            {
              title: '人气作家',
              tags: ['曹文轩','沈石溪','郑渊洁','杨红樱']
            },
            {
              title: '按年龄段选书 ',
              tags: ['0-2岁','3-6岁','7-10岁','11-14岁']
            },
            {
              title: '按内容选书',
              tags: ['中国儿童文学','外国儿童文学','绘本','科普/百科','婴儿读物','幼儿启蒙','益智游戏','玩具书','动漫/卡通',
                '少儿英语','励志/成长','进口儿童书','少儿期刊','阅读工具书','更多']
            }
          ]
        },
        panelData8: {
          classNav: [
            {
              title: '历史',
              tags: ['历史普及读物','中国史','世界史','史家名著','文物考古','史学理论','历史随笔','史料典籍','地方史志',
                '历史地理','民族史','口述史','逸闻野史','更多']
            },
            {
              title: '文化',
              tags: ['传统文化','文化评述','文化随笔','各国文化','神秘文化','地域文化','更多']
            },
            {
              title: '古籍',
              tags: ['经部','史类','子部','集部','古籍工具书','古籍整理','善本影印本','更多']
            },
            {
              title: '心理学',
              tags: ['心理百科','心理学著作','心理咨询治疗','心理学理论','心理学入门','色彩心理学','积极心理学','社会心理学',
                '人格心理学','儿童心理学','心灵疗愈','更多']
            },
            {
              title: '哲学/宗教',
              tags: ['古代哲学','哲学知识读物','世界哲学','周易','伦理学','哲学与人生','美学','哲学史','近现代哲学','宗教知识读物',
                '佛教','基督教','道教','术数/命理','更多']
            },
            {
              title: '政治/军事',
              tags: ['中国政治','党政读物','政治理论','世界政治','公共管理','领袖著作','时事政治','外交/国际关系','中国共产党',
                '领袖首脑','军事理论','中外战争纪实','兵器','世界各国军事','军事史','军事技术','更多']
            },
            {
              title: '社会科学',
              tags: ['社会科学总论','社会学','文化人类学','新闻传播','语言文字','名家作品集','更多']
            },
            {
              title: '法律',
              tags: ['民法','经济法','法律法规','法律实务','理论法学','刑法','法律随笔','更多']
            }
          ]
        },
        panelData9: {
          classNav: [
            {
              title: '管理',
              tags: ['一般管理学','会计','市场/营销','战略管理','生产与运作管理','管理信息系统','金融/投资','创业企业与企业家',
                '商业史传','WTO','电子商务','工具书','MBA','商务沟通','管理类职称考试','外文原版/影印版','经管音像','英文原版书-管理']
            },
            {
              title: '投资理财',
              tags: ['证券/股票','基金','期货','外汇','保险','彩票','购房置业','纳税','投资指南','女性理财','黄金投资','理财技巧','英文原版书-投资理财']
            },
            {
              title: '经济',
              tags: ['经济学理论','各流派经济学说','经济数学','区域经济','财政税收','统计 审计','贸易政策','通货膨胀','中国经济',
                '国际经济','各部门经济','经济法','保险','经济史','工具书','经济通俗读物','财税外贸保险类考试','英文原版书-经济']
            }
          ]
        },
        panelData10: {
          classNav: [
            {
              title: '成功/励志',
              tags: ['人生哲学','成功/激励','心灵与修养','性格与习惯','智商/智谋','情商/情绪管理','财商/财富智慧','人在职场',
                '人际交往','处世学','礼仪','口才/演讲/辩论','青少年励志','出国/留学','名言/格言','励志小品','男性励志','女性励志',
                '名人励志','励志经典著作','英文原版书-成功励志']
            }
          ]
        },
        panelData11: {
          classNav: [
            {
              title: '亲子/家教',
              tags: ['家教理论','家教方法','成功案例','素质教育','品格养成','亲子关系','培育男孩','培育女孩','心理疏导','0-6岁','7-12岁','13-18岁']
            },
            {
              title: '育儿/早教',
              tags: ['育儿百科','早教/亲子互动','婴幼儿饮食营养','婴幼儿护理健康']
            },
            {
              title: '孕产/胎教',
              tags: ['孕前准备','胎教','孕期','孕产妇健康','孕期饮食指导','产后管理']
            },
            {
              title: '保健/养生',
              tags: ['中医养生','饮食健康','药膳食疗','运动健康','中老年养生','男性养生','女性/儿童','性保健','健康百科','心理健康']
            },
            {
              title: '烹饪/美食',
              tags: ['家常菜谱','烘焙甜品','药膳食疗','西餐料理','茶酒饮料','饮食文化','地方美食']
            },
            {
              title: '旅游/地图',
              tags: ['国内自助游','国外自助游','城市自助游','户外探险旅','游随笔','旅游攻略','地图']
            },
            {
              title: '两性关系',
              tags: ['两性关系','恋爱','婚姻','性']
            },
            {
              title: '家庭/家居',
              tags: ['家庭园艺','家装效果实例','家装方法指导','家装策略秘籍','家事窍门','英文原版书-家居']
            },
            {
              title: '休闲/爱好',
              tags: ['游戏','宠物','杂事','车载户外','日历']
            },
            {
              title: '体育/运动',
              tags: ['奥林匹克','田径/体操','篮球','足球','高尔夫球','网球','羽毛球']
            },
            {
              title: '时尚/美妆',
              tags: ['瑜珈','时尚','奢侈品','瘦身美体']
            },
            {
              title: '手工/DIY',
              tags: ['纸艺','布艺/不织布','刺绣/十字绣','其他','手工材料']
            },
            {
              title: '风水/占卜',
              tags: [ '运程/风水','星座/血型/塔','占卜/手相/算','英文原版书-']
            }
          ]
        },
        panelData12: {
          classNav: [
            {
              title: '科普读物',
              tags: ['宇宙知识','人类故事','生物世界','科学世界','生态环境','百科知识','英文原版书-科普']
            },
            {
              title: '建筑',
              tags: ['建筑史与建筑文化','建筑科学','建筑外观设计','室内设计/装潢装修','建筑施工与监理','工程经济与管理',
                '城乡规划/市政工程','园林景观/环境艺术','标准/规范','建筑教材/教辅','执业资格考试用书','英文原版书-建筑']
            },
            {
              title: '医学',
              tags: ['预防医学/卫生学','临床医学理论','内科学','外科学','妇产科学','儿科学','其他临床医学','护理学','医技学',
                '中医药学','医学/药学考试','医学/药学教材','医学工具书','医院管理','医疗器械及使用','其他','英文原版书-医学']
            },
            {
              title: '计算机/网络',
              tags: ['计算机理论','硬件 外部设备 维修','操作系统/系统开发','数据库','程序设计','网络与数据通信','图形图像 多媒体',
                'CAD CAM CAE','软件工程/开发项目管理','行业软件及应用','人工智能','家庭与办公室用书','计算机考试 认证',
                '管理信息系统(MIS)','地理信息管理系统（GIS)','企业软件开发与实施','信息安全','项目管理 IT人文','电脑杂志——合订本',
                '计算机体系结构','数码全攻略','影印版','计算机教材','英文原版书-计算机']
            },
            {
              title: '农业/林业',
              tags: ['农业基础科学','农业工程','农学(农艺学)','植物保护','农作物','园艺','林业','畜牧/狩猎/蚕/蜂','水产/渔业','动物医学','农林音像']
            },
            {
              title: '自然科学',
              tags: ['总论','数学','力学','物理学','化学','天文学','地球科学','生物科学','科技史','自然科学类考试','英文原版书-自然科学']
            }
          ]
        },
        panelData13: {
          classNav: [
            {
              title: '英文原版书',
              tags: ['学习 考试','小说 Fiction','传记 Biographies & Memoirs','艺术 Art','摄影 Photography','旅游与地理 Travel Guide',
                '其他原版书','经管类 Business','人文社科 Non Fiction','儿童书 Children\'s book','语言学习 ELT','计算机 Computers & Internet',
                '科学与技术 Science & Techology','建筑 Architechture','医学 Medicine','工具书 Reference','家居 Home & Garden',
                '美食 Cooking, Food & Wine','健康与心理 Health, Mind & Body','家庭与育儿 Parenting & Families']
            },
            {
              title: '港台圖書',
              tags: ['文学','经济管理','生活','童书','漫画','艺术','人文社科','心理/励志','学习/考试','科技']
            }
          ]
        },
        panelData14: {
          classNav: [
            {
              title: '期刊',
              tags: ['娱乐时尚','男士','旅游/人文','家居/装饰','文化/艺术','家庭/美食','健康/运动','汽车','新闻/经管','IT/科技',
                '文摘 文学','特价','母婴/育儿']
            },
            {
              title: '影视',
              tags: ['电影','电视剧','卡通','戏剧/综艺','专题片/专栏节目','生活','教育']
            },
            {
              title: '音乐',
              tags: ['华语流行','欧美流行','日韩流行','摇滚','世界音乐','乡村/民谣','爵士/蓝调','新世纪音乐','民歌','民乐',
                '进口CD','发烧碟','轻音乐','古典音乐','中国交响乐','影视音乐','音乐DVD/VCD','歌舞剧','电子音乐','DJ/舞曲',
                '功能音乐','宗教/庆典音乐','相声/曲艺','戏曲','自然音乐','儿童音乐','音乐教育','有声读物','音乐周边']
            },
            {
              title: '教育音像',
              tags: ['英语学习','英语考试/考级','非英语语种','少儿英语','少儿益智启蒙','教材教辅','管理培训','医学教材',
                '计算机学习/考试/考级','文学 其他']
            }
          ]
        }
      };
    },
    computed: {
      ...mapState(['marketing'])
    },
    methods: {
      showDetail (index) {
        if(index === 1)
          this.panel1 = true;
        else if(index === 2)
          this.panel2 = true;
        else if(index === 3)
          this.panel3 = true;
        else if(index === 4)
          this.panel4 = true;
        else if(index === 5)
          this.panel5 = true;
        else if(index === 6)
          this.panel6 = true;
        else if(index === 7)
          this.panel7 = true;
        else if(index === 8)
          this.panel8 = true;
        else if(index === 9)
          this.panel9 = true;
        else if(index === 10)
          this.panel10 = true;
        else if(index === 11)
          this.panel11 = true;
        else if(index === 12)
          this.panel12 = true;
        else if(index === 13)
          this.panel13 = true;
        else if(index === 14)
          this.panel14 = true;
      },
      hideDetail (index) {
        if(index === 1)
          this.panel1 = false;
        else if(index === 2)
          this.panel2 = false;
        else if(index === 3)
          this.panel3 = false;
        else if(index === 4)
          this.panel4 = false;
        else if(index === 5)
          this.panel5 = false;
        else if(index === 6)
          this.panel6 = false;
        else if(index === 7)
          this.panel7 = false;
        else if(index === 8)
          this.panel8 = false;
        else if(index === 9)
          this.panel9 = false;
        else if(index === 10)
          this.panel10 = false;
        else if(index === 11)
          this.panel11 = false;
        else if(index === 12)
          this.panel12 = false;
        else if(index === 13)
          this.panel13 = false;
        else if(index === 14)
          this.panel14 = false;
      }
    },
    mounted () {
      this.$refs.itemPanel1.style.left =
        this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
      this.$refs.itemPanel2.style.left =
        this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
      this.$refs.itemPanel1.style.top = this.$refs.navSide.offsetTop + 'px';
      this.$refs.itemPanel2.style.top = this.$refs.navSide.offsetTop + 'px';
    },
    updated () {
      this.$refs.itemPanel1.style.left =
        this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
      this.$refs.itemPanel2.style.left =
        this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
      this.$refs.itemPanel1.style.top = this.$refs.navSide.offsetTop + 'px';
      this.$refs.itemPanel2.style.top = this.$refs.navSide.offsetTop + 'px';
    },
    store
  };
</script>

<style scoped>
  @import "../../assets/homenav.css";
</style>
