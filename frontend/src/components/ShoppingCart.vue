<template>
  <div>
    <div class="add-info-box-container">
      <div class="add-info-box">
        <div class="add-info-detail">
          <div class="add-info-title">
            <p>
              <i class="fa fa-check-circle"></i> 书籍已成功加入购物车！</p>
          </div>
          <div class="add-info-box-row">
            <div class="add-info-img">
              <img :src="newShoppingCart.package" alt="">
            </div>
            <div class="add-info-intro">
              <p>{{newShoppingCart.title}}...</p>
              <p class="add-info-intro-detail">数量：{{newShoppingCart.count}}</p>
            </div>
          </div>
        </div>
        <div class="car-btn-group">
          <div></div>
          <div class="car-btn-row">

            <button class="btn-car btn-car-to-detail" @click="back(newShoppingCart.to)">查看商品详情</button>

            <router-link to="/order">
              <button class="btn-car btn-car-to-pay">去购物车结算 > </button>
            </router-link>
          </div>
        </div>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import GoodsListNav from '@/components/nav/GoodsListNav';
  import Footer from '@/components/footer/Footer';
  import store from '@/vuex/store';
  import { mapState, mapActions } from 'vuex';
  export default {
    name: 'ShoppingCart',
    beforeRouteEnter (to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    computed: {
      ...mapState(['newShoppingCart']),

    },
    methods: {
      back(to){
        const path = '/goodsDetail'+ to;
        this.$router.push(path);
  }
    },
    components: {
      Search,
      GoodsListNav,
      Footer
    },
    store
  };
</script>

<style scoped>
@import "../assets/shoppingcart.css";
</style>
