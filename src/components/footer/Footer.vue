<template>
  <div>
    <footer class="footer">
      <div class="icon-row">
        <div class="footer-icon">
          <span class="footer-icon-text">正规渠道，正品保障</span>
        </div>
        <div class="footer-icon">
          <span class="footer-icon-text">放心购物，货到货款</span>
        </div>
        <div class="footer-icon">
          <span class="footer-icon-text">625城市，次日达到</span>
        </div>
        <div class="footer-icon">
          <span class="footer-icon-text">上门退换，购物无忧</span>
        </div>
      </div>
      <div class="service-intro">
        <div class="servece-type">
          <div class="servece-type-info" v-for="(guide, index) in guideArr" :key="index">
            <ul>
              <li v-for="(item, index) in guide" :key="index">{{item}}</li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
  export default {
    name: 'Footer',
    data () {
      return {
        linkItemClass: 'link-item',
        guideArr: [
          [ '购物指南','购物流程','发票制度','账户管理', '会员优惠'],
          [ '支付方式', '货到付款', '网上支付', '礼品卡支付', '银行转帐'],
          [ '订单服务', '配送服务查询', '订单状态说明', '自助取消订单', '自助修改订单'],
          [ '配送方式', '当日递', '次日达', '订单自提', '验货与签收'],
          [ '退换货', '退换货服务查询', '自助申请退换货', '退换货进度查询', '退款方式和时间'],
          [ '商家服务', '商家中心', '运营服务', '加入尾品汇']
        ]
      };
    }
  };
</script>

<style scoped>
  .footer {
    width: 100%;
    height: 250px;
    margin-top: 30px;
    background-color: #25b7c4;
  }
  .icon-row {
    margin: 15px auto;
    padding-top: 8px;
    width: 1000px;
    height: 64px;
  }
  .footer-icon {
    margin-left: 17px;
    margin-right: 17px;
    float: left;
  }
  .footer-icon-text {
    margin-left: 45px;
    color: #ffffff;
    font-size: 18px;
    font-weight: bold;
    line-height: 64px;
  }
  .service-intro {
    width: 100%;
    border-top: 1px solid #b2dfdb;
  }
  .servece-type {
    margin: 15px auto;
    height: 100px;
    width: 800px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .servece-type-info {
    color: #ffffff;
  }
  .servece-type-info ul {
    list-style: none;
  }
  .servece-type-info li {
    font-size: 14px;
    cursor: pointer;
    line-height: 26px;
  }
  .servece-type-info li:first-child {
    font-size: 16px;
    line-height: 28px;
    font-weight: bold;
  }
  /*****************************底 部 结 束*****************************/
</style>
