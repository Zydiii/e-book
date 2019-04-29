<template>
  <div>
    <Search></Search>
    <ShowGoods></ShowGoods>
    <ShowGoodsDetail></ShowGoodsDetail>
    <Footer></Footer>
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import Footer from '@/components/footer/Footer';
  import ShowGoods from '@/components/goodsDetail/ShowGoods';
  import ShowGoodsDetail from '@/components/goodsDetail/ShowGoodsDetail';
  import store from '@/vuex/store';
  import { mapState, mapActions } from 'vuex';
  import axios from 'axios'
  export default {
    name: 'GoodsDetail',
    beforeRouteEnter (to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    // created () {
    //   this.loadGoodsInfo();
    // },
    data () {
      return {
        tagsColor: [ 'blue', 'green', 'red', 'yellow' ],
        goodsInfo: []
      };
    },
    // methods: {
    //   ...mapActions(['loadGoodsInfo'])
    // },
    computed: {
      //...mapState(['isLoading'])
    },
    mounted: function () {
      this.id = this.$route.params.id;
      axios.get('http://localhost:8088/book/detail?ID='+this.id.toString())
        .then((response) => {
          this.goodsInfo = response.data;
          // console.log("goodsdetail1");
          // console.log(this.goodsInfo);
          // console.log("goodsdetail2");
          // console.log(response);
        }).catch((error) => {
        console.log(error);
      });

    },
    updated: function(){

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
