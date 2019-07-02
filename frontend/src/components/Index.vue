<template>
  <div>
    <Search></Search>
    <HomeNav></HomeNav>
    <Footer></Footer>
  </div>
</template>

<script>
  import Search from '@/components/Search';
  import HomeNav from '@/components/nav/HomeNav';
  import Footer from '@/components/footer/Footer';
  import store from '@/vuex/store';
  import { mapState, mapActions, mapGetters, mapMutations } from 'vuex';
  export default {
    name: 'Index',
    data () {
      return {
      };
    },
    components: {
      Search,
      HomeNav,
      Footer
    },
    store
  };
</script>

<style scoped>
  .container {
    background-color: #ffffff;
  }
</style>
