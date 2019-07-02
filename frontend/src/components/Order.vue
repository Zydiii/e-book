<template>
  <div>
    <div class="goods-list-container">
      <Alert show-icon class="tips-box">请点击商品前的选择框，选择购物车中的商品，点击付款即可。</Alert>
      <Table border ref="selection" :columns="columns" :data="shoppingCart" size="large" @on-selection-change="select" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买"></Table>
      <div class="address-container">
        <h3>收货人信息</h3>
        <div class="address-box">
          <div class="address-check">
            <div class="address-check-name">
              <span> {{checkAddress.receiverName}}</span>
            </div>
            <div class="address-detail">
              <p>{{checkAddress.receiverAddress}}</p>
            </div>
            <div class="address-detail">
              <p>{{checkAddress.receiverPhone}}</p>
            </div>
          </div>
          <Collapse>
            <Panel>
              选择地址
              <p slot="content">
                <RadioGroup vertical size="large" @on-change="changeAddress">
                  <Radio :label="item.id" v-for="(item, index) in address" :key="index">
                    <span>{{item.name}} {{item.province}} {{item.city}} {{item.address}} {{item.phone}}</span>
                  </Radio>
                </RadioGroup>
              </p>
            </Panel>
          </Collapse>
        </div>
      </div>
      <div class="pay-container">
        <div class="pay-box">
          <p><span>提交订单应付总额：</span> <span class="money"><Icon type="social-yen"></Icon> {{totalPrice.toFixed(2)}}</span></p>
          <div class="pay-btn">
            <router-link to="/payDone"><Button type="error" size="large" @click="pay()">支付订单</Button></router-link>
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
  import axios from 'axios'
  export default {
    name: 'Order',
    beforeRouteEnter (to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    data () {
      return {
        goodsCheckList: [],
        shoppingCart: [],
        address: [],
        columns: [
          {
            type: 'selection',
            width: 58,
            align: 'center'
          },
          {
            title: '图片',
            key: 'img',
            render: (h, params) => {
              return h('div', [
                h('img', {
                  attrs: {
                    src: 'http://localhost:8088/image/' + params.row.cover,
                    width: '100px'
                  }
                })
              ]);
            },
            align: 'center'
          },
          {
            title: '标题',
            key: 'title',
            width: 180,
            align: 'center'
          },
          {
            title: '作者',
            key: 'writer',
            width: 250,
            align: 'center'
          },
          {
            title: 'ISBN',
            key: 'isbn',
            width: 200,
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
        ],
        checkAddress: {
          receiverAddress: '',
          receiverName: '',
          receiverPhone: ''
        },
        remarks: ''
      };
    },
    created(){
      console.log("order");
      var str = sessionStorage.getItem("userInfo");
      var s = JSON.parse(str).id;
      axios.get('http://localhost:8088/carts/getCart?userID='+s.toString())
        .then((response) => {
          this.shoppingCart = response.data;
          console.log(response);
        }).catch((error) => {
        console.log(error);
      });

      axios.get('http://localhost:8088/user/getAddress?ID=' + s)
        .then((response) => {
          console.log("Address");
          this.address = response.data;
          console.log(response);
        }).catch((error) => {
        console.log(error);
      })
    },
    computed: {
      //...mapState(['address']),
      totalPrice () {
        let price = 0;
        this.goodsCheckList.forEach(item => {
          price += item.price * item.num;
        });
        return price;
      }
    },
    methods: {
      pay(){
        axios.post('http://localhost:8088/carts/doneSubmit?address=' +
          this.checkAddress.receiverAddress.toString() + '&name=' + this.checkAddress.receiverName.toString()
          + '&phone=' + this.checkAddress.receiverPhone.toString(), this.goodsCheckList
        ).then((response)=> {
          var status = response.data;
          console.log(status);
          }
        ).catch((error) => {
          console.log(response);
        });
      },
      //...mapActions(['loadAddress']),
      select (selection, row) {
        this.goodsCheckList = selection;
        console.log("check");
        console.log(this.goodsCheckList);
      },
      changeAddress (data) {
        const father = this;
        this.address.forEach(item => {
          if (item.id === data) {
            father.checkAddress.receiverName = item.name;
            father.checkAddress.receiverAddress = `${item.province} ${item.city} ${item.address}`;
            father.checkAddress.receiverPhone = item.phone;
          }
        });
      }
    },
    mounted () {
      setTimeout(() => {
        this.$refs.selection.selectAll(true);
      }, 500);
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
  .goods-list-container {
    margin: 15px auto;
    width: 80%;
  }
  .tips-box {
    margin-bottom: 15px;
  }
  .address-container {
    margin-top: 15px;
  }
  .address-box {
    margin-top: 15px;
    padding: 15px;
    border: 1px #ccc dotted;
  }
  .address-check {
    margin: 15px 0px;
    height: 36px;
    display: flex;
    align-items: center;
  }
  .address-check-name {
    width: 120px;
    display: flex;
    justify-content: center;
    align-content: center;
    background-color: #ccc;
  }
  .address-check-name span {
    width: 120px;
    height: 36px;
    font-size: 14px;
    line-height: 36px;
    text-align: center;
    color: #fff;
    background-color: #25b7c4;
  }
  .address-detail {
    padding-left: 15px;
    font-size: 14px;
    color: #999999;
  }
  .remarks-container {
    margin: 15px 0px;
  }
  .remarks-input {
    margin-top: 15px;
  }
  .invoices-container p{
    font-size: 12px;
    line-height: 30px;
    color: #999;
  }
  .pay-container {
    margin: 15px;
    display: flex;
    justify-content: flex-end;
  }
  .pay-box {
    font-size: 18px;
    font-weight: bolder;
    color: #495060;
  }
  .money {
    font-size: 26px;
    color: #f90013;
  }
  .pay-btn {
    margin: 15px 0px;
    display: flex;
    justify-content: flex-end;
  }
</style>
