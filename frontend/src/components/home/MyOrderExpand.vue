<template>
  <div>
    <Row class="expand-row">
      <Col>
        <span class="expand-key">订单号: </span>
        <span class="expand-value">{{ row.order_id }}</span>
      </Col>
    </Row>
    <Row class="expand-row">
      <Col>
        <span class="expand-key">购买时间: </span>
        <span class="expand-value">{{ row.order_time }}</span>
      </Col>
    </Row>
    <Row>
      <Col>
        <span class="expand-key">收货人: </span>
        <span class="expand-value">{{ row.receiverName }}</span>
      </Col>
    </Row>
    <Row>
      <Col>
        <span class="expand-key">联系电话: </span>
        <span class="expand-value">{{ row.receiverPhone }}</span>
      </Col>
    </Row>
    <Row>
      <Col>
        <span class="expand-key">收货地址: </span>
        <span class="expand-value">{{ row.receiverAddress }}</span>
      </Col>
    </Row>
      <!--<Col span="8">-->
        <!--<span class="expand-key"> </span>-->
        <!--<span class="expand-value">{{ row.birthday }}</span>-->
      <!--</Col>-->
    <!--<Row>-->
      <!--<Col span="8">-->
        <!--<span class="expand-key">Favorite book: </span>-->
        <!--<span class="expand-value">《{{ row.book }}》</span>-->
      <!--</Col>-->
      <!--<Col span="8">-->
        <!--<span class="expand-key">Favorite movie: </span>-->
        <!--<span class="expand-value">{{ row.movie }}</span>-->
      <!--</Col>-->
      <!--<Col span="8">-->
        <!--<span class="expand-key">Favorite music: </span>-->
        <!--<span class="expand-value">{{ row.music }}</span>-->
      <!--</Col>-->
    <!--</Row>-->
  </div>
</template>

<script>
    export default {
        name: "MyOrderExpand",
      props: {
        row: Object
      }
    }
</script>

<style scoped>
  .expand-row{
    margin-bottom: 16px;
  }
</style>
