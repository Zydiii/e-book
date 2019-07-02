<template>
  <div>
    <Search></Search>
    <div class="container">
      <div class="goods-box">
        <div class="as-box">
          <div class="item-as-title">
            <span>推广商品</span>
            <span>广告</span>
          </div>
          <div class="item-as" v-for="(item,index) in asItems" :key="index">
            <div class="item-as-img" @click="link(asItems.id)">
              <img :src="'http://localhost:8088/image/' + item.cover" alt="" width="150px" height="150px">
            </div>
            <div class="item-as-price">
              <span>
                <Icon type="social-yen text-danger"></Icon>
                <span class="seckill-price title">￥{{item.price}}</span>
              </span>
            </div>
            <div class="item-as-intro">
              <span>{{item.title}}</span>
            </div>
            <div class="item-as-selled">
              已有<span>{{item.salenum}}</span>人购买
            </div>
          </div>
        </div>
        <div class="goods-list-box">
          <div class="goods-list-tool">
            <ul>
              <li v-for="(item,index) in goodsTool" :key="index" @click="orderBy(item.en, index)"><span
                :class="{ 'goods-list-tool-active': isAction[index]}">{{item.title}} <Icon
                :type="icon[index]"></Icon></span></li>
            </ul>
          </div>
          <div class="goods-list">
            <div class="goods-show-info" v-for="(item, index) in GoodsList" :key="index"
                 v-show="search(item.title, item.writer)">
              <div class="goods-show-img" @click="link(item.id)">
                <img :src="'http://localhost:8088/image/' + item.cover" width="100%"/>
              </div>
              <div class="goods-show-price">
                <span>
                  <Icon type="social-yen text-danger"></Icon>
                  <span class="seckill-price text-danger">￥{{item.price}}</span>
                </span>
              </div>
              <div class="goods-show-detail" @click="selectStyle (item) "
                   :class="{'active':item.active,'unactive':!item.active}">
                <span>{{item.title}}</span>
              </div>
              <div class="goods-show-seller">
                <span>{{item.writer}}</span>
              </div>
              <div class="goods-show-seller">
              ISBN：<span>{{item.isbn}}</span>
            </div>
              <div class="goods-show-seller">
                库存：<span>{{item.remains}}</span>
              </div>
              <div class="goods-show-num">
                已有<span>{{item.salenum}}</span>人购买
              </div>
              <div class="goods-show-seller">
                <span>{{item.shopname}}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer></Footer>
    <!--<Spin size="large" fix v-if="isLoading"></Spin>-->
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import GoodsListNav from '@/components/nav/GoodsListNav';
  import GoodsClassNav from '@/components/nav/GoodsClassNav';
  import Footer from '@/components/footer/Footer';
  import store from '@/vuex/store';
  import Vue from 'vue';
  import {mapState, mapActions, mapGetters, mapMutations} from 'vuex';
  import axios from 'axios'

  export default {
    name: 'GoodsList',
    beforeRouteEnter(to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    data() {
      return {
        isAction: [true, false, false],
        icon: ['md-arrow-dropup', 'md-arrow-dropdown', 'md-arrow-dropdown'],
        goodsTool: [
          {title: '综合', en: 'sale'},
          {title: '评论数', en: 'remarks'},
          {title: '价格', en: 'price'}
        ],
        GoodsList: [
        ],
        asItems: [
        ],
        detailBook: ''
      };
    },
    computed: {
     // ...mapState(['isLoading']),
     // ...mapGetters(['orderGoodsList'])
    },
    methods: {
      //...mapActions(['loadGoodsList']),
     // ...mapMutations(['SET_GOODS_ORDER_BY']),
     //  orderBy(data, index) {
     //    this.icon = ['md-arrow-dropdown', 'md-arrow-dropdown', 'md-arrow-dropdown'];
     //    this.isAction = [false, false, false];
     //    this.isAction[index] = true;
     //    this.icon[index] = 'md-arrow-dropup';
     //    this.SET_GOODS_ORDER_BY(data);
     //  },
      link(id) {
        this.detailBook = id.toString();
        sessionStorage.bookDetail = "";
        this.$router.push('/goodsDetail/'+this.detailBook);
      },
      search(title, writer) {
        if (this.$route.query.searchData === undefined) {
          return true;
        }
        if (title.indexOf(this.$route.query.searchData) > -1 ) {
          return true;
        }
        if (writer.indexOf(this.$route.query.searchData) > -1) {
          return true;
        }
          return false;
      },
      selectStyle(item) {
        this.$nextTick(function () {
          if (item.color === 0) {
            item.color = 1;
            Vue.set(item, 'active', true);
          } else {
            item.color = 0;
            Vue.set(item, 'active', false);
          }
        });
      }
    },
    //created() {
      //this.loadGoodsList();
   // },
    mounted: function () {
      axios.get('http://localhost:8088/book/all1')
        .then((response) => {
          this.GoodsList = response.data;
          console.log(response);
        }).catch((error) => {
        console.log(error);
      });

      axios.get('http://localhost:8088/book/all1')
        .then((response) => {
          this.asItems = response.data;
          console.log(response);
        }).catch((error) => {
        console.log(error);
      });
    },
    components: {
      Search,
      GoodsListNav,
      GoodsClassNav,
      Footer
    },
    store
  };
</script>

<style scoped>
  @import "../assets/goodslist.css";
</style>
