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
            <div class="item-as-img" @click="link()">
              <img :src="item.img" alt="" width="150px" height="150px">
            </div>
            <div class="item-as-price">
              <span>
                <Icon type="social-yen text-danger"></Icon>
                <span class="seckill-price title">￥{{item.price}}</span>
              </span>
            </div>
            <div class="item-as-intro">
              <span>{{item.intro}}</span>
            </div>
            <div class="item-as-selled">
              已有<span>{{item.num}}</span>人评价
            </div>
          </div>
        </div>
        <div class="goods-list-box">
          <div class="goods-list-tool">
            <ul>
              <li v-for="(item,index) in goodsTool" :key="index" @click="orderBy(item.en, index)"><span :class="{ 'goods-list-tool-active': isAction[index]}">{{item.title}} <Icon :type="icon[index]"></Icon></span></li>
            </ul>
          </div>
          <div class="goods-list">
            <div class="goods-show-info" v-for="(item, index) in orderGoodsList" :key="index" v-show="search(item.intro)">
              <div class="goods-show-img" @click="link()">
                <img :src="item.img"/>
              </div>
              <div class="goods-show-price">
                <span>
                  <Icon type="social-yen text-danger"></Icon>
                  <span class="seckill-price text-danger">￥{{item.price}}</span>
                </span>
              </div>
              <div class="goods-show-detail" @click="selectStyle (item) " :class="{'active':item.active,'unactive':!item.active}" >
                <span>{{item.intro}}</span>
              </div>
              <div class="goods-show-num">
                已有<span>{{item.remarks}}</span>人评价
              </div>
              <div class="goods-show-seller">
                <span>{{item.shopName}}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="goods-page">
        <Page :total="100" show-sizer></Page>
      </div>
    </div>
    <Footer></Footer>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import GoodsListNav from '@/components/nav/GoodsListNav';
  import GoodsClassNav from '@/components/nav/GoodsClassNav';
  import Footer from '@/components/footer/Footer';
  import store from '@/vuex/store';
  import Vue from 'vue';
  import { mapState, mapActions, mapGetters, mapMutations } from 'vuex';
  export default {
    name: 'GoodsList',
    beforeRouteEnter (to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    data () {
      return {
        isAction: [ true, false, false ],
        icon: [ 'md-arrow-dropup', 'md-arrow-dropdown', 'md-arrow-dropdown' ],
        goodsTool: [
          {title: '综合', en: 'sale'},
          {title: '评论数', en: 'remarks'},
          {title: '价格', en: 'price'}
        ]
      };
    },
    computed: {
      ...mapState(['asItems', 'isLoading']),
      ...mapGetters(['orderGoodsList'])
    },
    methods: {
      ...mapActions(['loadGoodsList']),
      ...mapMutations(['SET_GOODS_ORDER_BY']),
      orderBy (data, index) {
        this.icon = [ 'md-arrow-dropdown', 'md-arrow-dropdown', 'md-arrow-dropdown' ];
        this.isAction = [ false, false, false ];
        this.isAction[index] = true;
        this.icon[index] = 'md-arrow-dropup';
        this.SET_GOODS_ORDER_BY(data);
      },
      link (){
        this.$router.push('/goodsDetail');
      },
      search(title){
        if(this.$route.query.searchData === undefined){
          return true;
        }
        if (title === this.$route.query.searchData){
          return true;
        }
        else
          return false;
      },
      selectStyle (item) {
          this.$nextTick(function () {
            if(item.color === 0) {
              item.color = 1;
              Vue.set(item,'active',true);
            }
            else{
              item.color = 0;
              Vue.set(item,'active',false);
            }
          });
        }
    },
    created () {
      this.loadGoodsList();
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
