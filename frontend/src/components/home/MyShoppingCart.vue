<template>
  <div>
    <Table border ref="selection" :columns="columns" :data="shoppingCart" size="large" no-data-text="您还没有添加商品，快去选购吧~"></Table>
    <div class="go-to">
      <Button @click="goTo" type="primary">去付款</Button>
    </div>
  </div>
</template>

<script>
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
import axios from 'axios'
export default {
  name: 'MyShoppingCart',
  data () {
    return {
      shoppingCart: [],
      columns: [
        {
          type: 'selection',
          width: 58,
          align: 'center'
        },
        {
          title: '标题',
          key: 'title',
          align: 'center'
        },
        {
          title: 'ISBN',
          key: 'isbn',
          align: 'center'
        },
        {
          title: '数量',
          key: 'num',
          width: 68,
          align: 'center'
        },
        {
          title: '价格',
          width: 68,
          key: 'price',
          align: 'center'
        }
      ]
    };
  },
  created () {
    //this.loadShoppingCart();
    var str = sessionStorage.getItem("userInfo");
    var s = JSON.parse(str).id;
    axios.get('http://localhost:8088/carts/getCart?userID='+s.toString())
      .then((response) => {
        this.shoppingCart = response.data;
        console.log(response);
      }).catch((error) => {
      console.log(error);
    });
  },
  computed: {
    //...mapState(['shoppingCart'])
  },
  methods: {
    //...mapActions(['loadShoppingCart']),
    goTo () {
      this.$router.push('/order');
    }
  },
  store
};
</script>

<style scoped>
.go-to {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
</style>
