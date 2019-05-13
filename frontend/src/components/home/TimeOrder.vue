<template>
    <div>
      <div>
        <div>
          <i-input v-model="value1" class="search" placeholder="开始时间"> </i-input> 年
          <i-input v-model="value2" class="search" placeholder="开始时间" > </i-input> 月
          <i-input v-model="value3" class="search" placeholder="开始时间" > </i-input> 日
        </div>
        <div>
          <i-input v-model="value4" class="search" placeholder="结束时间" > </i-input> 年
          <i-input v-model="value5" class="search" placeholder="结束时间" > </i-input> 月
          <i-input v-model="value6" class="search" placeholder="结束时间" > </i-input> 日
        </div>
        <Button @click="time" type="primary" calss="search">搜索</Button>
      <Table border :columns="columns" :data="orderShow" no-data-text="您还没有已经完成的订单~"></Table>
      </div>
    </div>
</template>

<script>
  import axios from 'axios'
  import MyOrderExpand from './MyOrderExpand.vue';
    export default {
        name: "ManageOrder",
      components: {MyOrderExpand},
      data() {
        return {
          order: [],
          orderShow: [],
          id: 0,
          value1: '2018',
          value2: '9',
          value3: '13',
          value4: '2020',
          value5: '9',
          value6: '13',
          columns: [
            {
              type: 'expand',
              width: 50,
              render: (h, params) => {
                return h(MyOrderExpand, {
                  props: {
                    row: params.row
                  }
                })
              }
            },
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
            },
            {
              title: 'ISBN',
              width: 150,
              key: 'isbn',
              align: 'center'
            }
            // {
            //   title: '操作',
            //   key: 'action',
            //   width: 150,
            //   align: 'center',
            //   render: (h, params) => {
            //     return h('div', [
            //       // h('Button', {
            //       //   props: {
            //       //     type: 'primary',
            //       //     size: 'small'
            //       //   },
            //       //   style: {
            //       //     marginRight: '5px'
            //       //   },
            //       //   on: {
            //       //     click: () => {
            //       //       this.show(params.index)
            //       //     }
            //       //   }
            //       // }, 'View'),
            //       // h('Button', {
            //       //   props: {
            //       //     type: 'error',
            //       //     size: 'small'
            //       //   },
            //       //   on: {
            //       //     click: () => {
            //       //       this.remove(params.index,params.row.order_id, params.row.book_id);
            //       //     }
            //       //   }
            //       // }, 'Delete')
            //     ]);
              //}
            //}
          ]
          // columns: [
          //   {
          //     title: '订单号',
          //     key: 'order_id',
          //     width: 180,
          //     align: 'center'
          //   },
          //   {
          //     title: '标题',
          //     key: 'title',
          //     align: 'center'
          //   },
          //   {
          //     title: '数量',
          //     key: 'num',
          //     width: 68,
          //     align: 'center'
          //   },
          //   {
          //     title: '价格',
          //     width: 68,
          //     key: 'price',
          //     align: 'center'
          //   },
          //   {
          //     title: '购买时间',
          //     width: 120,
          //     key: 'order_time',
          //     align: 'center'
          //   }
          // ]
        }
      },
      created()
      {
        var str = sessionStorage.getItem("userInfo");
        var s = JSON.parse(str);
        this.id = s.id;
        // axios.get('http://localhost:8088/home/order?ID=' + this.id.toString()).then((response) => {
        //   this.order = response.data;
        //   this.orderShow = this.order;
        //   console.log(response);
        // }).catch((error) => {
        //   console.log(error);
        // });
      },
      methods: {
        // search(data, argumentObj) {
        //   let res = data;
        //   let dataClone = data;
        //   for (let argu in argumentObj) {
        //     if (argumentObj[argu].length > 0) {
        //       res = dataClone.filter(d => {
        //         return d[argu].indexOf(argumentObj[argu]) > -1;
        //       });
        //       dataClone = res;
        //     }
        //   }
        //   return res;
        // },
        // handleSearch() {
        //   this.orderShow = this.order;
        //   this.orderShow = this.search(this.order, {title: this.title});
        // },
        time() {
          var t1 = this.value1 + '-' + this.value2 + '-' + this.value3;
          var t2 = this.value4 + '-' + this.value5 + '-' + this.value6;
          console.log(t1);
          console.log(t2);
          console.log(this.id);
          axios.post('http://localhost:8088/home/gettime', {
            'id': this.id,
            'time1': t1,
            'time2': t2
          }).then((response) => {
            this.order = response.data;
            this.orderShow = this.order;
            console.log(response);
          }).catch((error) => {
            console.log(error);
          })
        }
      }
    }

</script>

<style scoped>
 .search {
   width: 30%;
   padding-bottom: 5px;
 }
</style>
