<template>
  <div>
    <div class="item-detail-show">
      <div class="item-detail-left">
        <div class="item-detail-big-img">
          <img :src="goodsInfo.goodsImg" alt="">
        </div>
        <div class="item-detail-img-row">
          <div class="item-detail-img-small" v-for="(item, index) in goodsInfo.goodsImg" :key="index" @mouseover="showBigImg(index)">
            <img :src="item" alt="">
          </div>
        </div>
      </div>
      <div class="item-detail-right">
        <div class="item-detail-title">
          <p>
            <span class="item-detail-express">自营</span> {{goodsInfo.title}}</p>
        </div>
        <div class="item-detail-price-row">
          <div class="item-price-left">
            <div class="item-price-row">
              <p>
                <span class="item-price-title">抢购价</span>
                <span class="item-price">￥{{goodsInfo.price}}</span>
              </p>
            </div>
          </div>
          <div class="item-price-right">
            <div class="item-remarks-sum">
              <p>累计评价</p>
              <p>
                <span class="item-remarks-num">{{goodsInfo.remarksNum}} 条</span>
              </p>
            </div>
          </div>
        </div>
        <br>
        <div class="add-buy-car-box">
          <div class="add-buy-car">
            <InputNumber :min="1" v-model="count" size="large"></InputNumber>
            <Button type="error" size="large" @click="addShoppingCartBtn()" ><Icon type="ios-cart-outline" /> 加入购物车</Button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import store from '@/vuex/store';
  import { mapState, mapActions } from 'vuex';
  import axios from 'axios'
  export default {
    name: 'ShowGoods',
    data () {
      return {
        price: 0,
        count: 1,
        selectBoxIndex: 0,
        imgIndex: 0,
        goodsInfo: []
      };
    },
    computed: {
      hirePurchase () {
        const three = this.price * this.count / 3;
        const sex = this.price * this.count / 6;
        const twelve = this.price * this.count / 12 * 1.0025;
        const twentyFour = this.price * this.count / 24 * 1.005;
        return [
        ];
      }
    },
    methods: {
      ...mapActions(['addShoppingCart']),
      showBigImg (index) {
        this.imgIndex = index;
      },
      addShoppingCartBtn () {
        const index1 = parseInt(this.selectBoxIndex / 3);
        const index2 = this.selectBoxIndex % 3;
        const date = new Date();
        const goodsId = date.getTime();
        const img = this.goodsInfo.goodsImg[0];
        const data = {
          goods_id: goodsId,
          title: this.goodsInfo.title,
          count: this.count,
          package: this.goodsInfo.goodsImg[0],
          to: this.goodsInfo.index,
          price: this.goodsInfo.price,
          img: img
        };
        this.addShoppingCart(data);
        this.$router.push({path: '/shoppingCart'});
      }
    },
    mounted () {
      const father = this;
      setTimeout(() => {
        father.price = father.goodsInfo.setMeal[0][0].price || 0;
      }, 300);
    },
    mounted: function () {
      axios.get('http://localhost:8088/book/detail')
        .then((response) => {
          this.goodsInfo = response.data;
          console.log(response);
        }).catch((error) => {
        console.log(error);
      });

    },
    store
  };
</script>

<style scoped>
  /******************商品图片及购买详情开始******************/
  .item-detail-show {
    width: 80%;
    margin: 15px auto;
    display: flex;
    flex-direction: row;
    background-color: #fff;
  }
  .item-detail-left {
    width: 350px;
    margin-right: 30px;
  }
  .item-detail-big-img {
    width: 350px;
    height: 350px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }
  .item-detail-big-img img {
    width: 100%;
  }
  .item-detail-img-row {
    margin-top: 15px;
    display: inline-flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .item-detail-img-small {
    width: 68px;
    height: 68px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }
  .item-detail-img-small img {
    width: 100%;
  }
  /*商品选购详情*/
  .item-detail-right {
    display: flex;
    flex-direction: column;
  }
  .item-detail-title p {
    color: #666;
    font-size: 20px;
  }
  .item-detail-express {
    font-size: 14px;
    padding: 2px 3px;
    border-radius: 3px;
    background-color: #e4393c;
    color: #fff;
  }
  /*商品标签*/
  .item-detail-tag {
    font-size: 12px;
    color: #e4393c;
  }
  /*价格详情等*/
  .item-detail-price-row {
    margin-top: 10px;
    padding: 5px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: #f3f3f3;
  }
  .item-price-left {
    display: flex;
    flex-direction: column;
  }
  .item-price-title {
    color: #999999;
    font-size: 14px;
    margin-right: 15px;
  }
  .item-price-row {
    margin: 5px 0px;
  }
  .item-price {
    color: #e4393c;
    font-size: 23px;
    cursor: pointer;
  }
  .item-price-full-cut {
    margin-right: 5px;
    padding: 3px;
    color: #e4393c;
    font-size: 12px;
    background-color: #ffdedf;
    border: 1px dotted #e4393c;
    cursor: pointer;
  }
  .item-remarks-sum {
    padding-left: 8px;
    border-left: 1px solid #ccc;
  }
  .item-remarks-sum p {
    color: #999999;
    font-size: 12px;
    line-height: 10px;
    text-align: center;
  }
  .item-remarks-num {
    line-height: 18px;
    color: #005eb7;
  }
  .item-select {
    display: flex;
    flex-direction: row;
    margin-top: 15px;
  }
  .item-select-title {
    color: #999999;
    font-size: 14px;
    margin-right: 15px;
  }
  .item-select-column {
    display: flex;
    flex-direction: column;
  }
  .item-select-row {
    display: flex;
    flex-direction: row;
    margin-bottom: 8px;
  }
  .item-select-box {
    display: flex;
    flex-direction: row;
    align-items: center;
  }
  .item-select-img {
    width: 36px;
  }
  .item-select-box {
    padding: 5px;
    margin-right: 8px;
    background-color: #f7f7f7;
    border: 0.5px solid #ccc;
    cursor: pointer;
  }
  .item-select-box:hover {
    border: 0.5px solid #e3393c;
  }
  .item-select-box-active {
    border: 0.5px solid #e3393c;
  }
  .item-select-img img {
    width: 100%;
  }
  .item-select-intro p {
    margin: 0px;
    padding: 5px;
  }
  .item-select-class {
    padding: 5px;
    margin-right: 8px;
    background-color: #f7f7f7;
    border: 0.5px solid #ccc;
    cursor: pointer;
  }
  .item-select-class:hover {
    border: 0.5px solid #e3393c;
  }
  .add-buy-car-box {
    width: 100%;
    margin-top: 150px;
    border-top: 1px dotted #ccc;
  }
  .add-buy-car {
    margin-top: 15px;
  }
  /******************商品图片及购买详情结束******************/
</style>
