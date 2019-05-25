<template>
    <div>
      <div>
        <Row>
          <Col span="8">
            开始时间：
            <DatePicker type="date" v-model="date1"  format="yyyy-MM-dd HH:mm" placeholder="Select date" style="width: 200px"></DatePicker>
          </Col>
          <Col span="8">
            结束时间：
            <DatePicker type="date" v-model="date2" format="yyyy-MM-dd HH:mm" placeholder="Select date" style="width: 200px"></DatePicker>
          </Col>
          <Col>
            <Button type="primary" @click="search">查询</Button>
          </Col>
        </Row>
      </div>
      <div>
        <Table border :columns="columns" :data="bookShow" no-data-text="请您添加书籍~"></Table>
      </div>


    </div>
</template>

<script>
  import axios from 'axios'
  import dateUtil from 'iview/src/utils/date'
    export default {
        name: "SeeOrder",
      methods: {
          search(){
            this.date1 = dateUtil.format(this.date1, 'yyyy-MM-dd'),
              this.date2 = dateUtil.format(this.date2, 'yyyy-MM-dd'),
            axios.get("http://localhost:8088/manager/SeeOrder?date1=" + this.date1 + "&date2=" + this.date2)
              .then((response) => {
                console.log(response);
                this.bookShow = response.data;
              })
          }
      },
      data() {
          return {
            bookShow: [],
            date1: '',
            date2: '',
            columns: [
              {
                title: '图片',
                key: 'img',
                width: 100,
                render: (h, params) => {
                  return h('div', [
                    h('img', {
                      attrs: {
                        src: params.row.cover,
                        width: "80px"
                      }
                    })
                  ]);
                },
                align: 'center'
              },
              {
                title: '标题',
                key: 'title',
                align: 'center'
              },
              {
                title: '作者',
                key: 'writer',
                align: 'center'
              },
              {
                title: '出版商',
                key: 'shopname',
                align: 'center'
              },
              {
                title: 'ISBN',
                width: 150,
                key: 'isbn',
                align: 'center'
              },
              {
                title: '价格',
                width: 68,
                key: 'price',
                align: 'center'
              },
              {
                title: '销量',
                key: 'sales',
                width: 68,
                align: 'center'
              },
              {
                title: '评论数',
                width: 150,
                key: 'remarknum',
                align: 'center'
              }
            ]
          }
      }
    }
</script>

<style scoped>

</style>
