<template>
  <div>
    <Row class="expand-row">
      <Col>
        <span class="expand-key">销量: </span>
        <span class="expand-value">{{ row.salenum }}</span>
      </Col>
    </Row>
    <Row class="expand-row">
      <Col>
        <span class="expand-key">评论数: </span>
        <span class="expand-value">{{ row.remarknum }}</span>
      </Col>
    </Row>
    <Row>
      <Col>
        <span class="expand-key">平均评分: </span>
        <span class="expand-value">{{  }}</span>
      </Col>
    </Row>
  </div>
</template>

<script>
    export default {
        name: "ManageBookExpand",
      props: {
        row: Object
      }
    }
</script>

<style scoped>

</style>
