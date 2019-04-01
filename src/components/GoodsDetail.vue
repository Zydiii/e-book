<template>
  <div>
    <Search></Search>
    <ShowGoods></ShowGoods>
    <ShowGoodsDetail></ShowGoodsDetail>
    <Footer></Footer>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import Footer from '@/components/footer/Footer';
  import ShowGoods from '@/components/goodsDetail/ShowGoods';
  import ShowGoodsDetail from '@/components/goodsDetail/ShowGoodsDetail';
  import store from '@/vuex/store';
  import { mapState, mapActions } from 'vuex';
  export default {
    name: 'GoodsDetail',
    beforeRouteEnter (to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    created () {
      this.loadGoodsInfo();
    },
    data () {
      return {
        tagsColor: [ 'blue', 'green', 'red', 'yellow' ]
      };
    },
    methods: {
      ...mapActions(['loadGoodsInfo'])
    },
    computed: {
      ...mapState(['goodsInfo', 'isLoading'])
    },
    components: {
      Search,
      ShowGoods,
      ShowGoodsDetail,
      Footer
    },
    store
  };
</script>

<style scoped>
  @import "../assets/goodsdetail.css";
</style>
