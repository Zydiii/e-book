<template>
  <div>
    <div>
      <i-input v-model="searchData" class="search" placeholder="输入你想查找的订单" >
        <Button slot="append" icon="md-search" @click="handleSearch" ></Button>
      </i-input>
    </div>
    <Table border :columns="columns" :data="orderShow" no-data-text="还没有用户下单~"></Table>
  </div>
</template>

<script>
  import axios from 'axios'
  import MyOrderExpand from './MyOrderExpand.vue';

  export default {
    components: {MyOrderExpand},
    name: 'ManageOrder',
    created() {
      var str = sessionStorage.getItem("userInfo");
      var s = JSON.parse(str);
      this.id = s.id;
      axios.get('http://localhost:8088/home/orderAll').then((response) => {
        this.order = response.data;
        this.orderShow = this.order;
        console.log(typeof(response.data[0].order_time));
      }).catch((error) => {
        console.log(error);
      });
    },
    methods: {
      start(order_id, book_id){
        axios.get("http://localhost:8088/manager/sendOrder?order_id=" + order_id + "&book_id=" + book_id )
          .then((response) => {
            console.log(response);
             if(response.data == "1"){
               this.$Message.success("您已成功发货，等待卖家收货");
               axios.get('http://localhost:8088/home/orderAll').then((response) => {
                 this.order = response.data;
                 this.orderShow = this.order;
                 console.log(typeof(response.data[0].order_time));
               }).catch((error) => {
                 console.log(error);
               });
             }
             else if(response.data === "0"){
               this.$Message.error("连接出错，请重试");
             }
             else{
               this.$Message.error("库存不足");
             }
          })
      },
      search(data, argumentObj) {
        let res = data;
        let dataClone = data;
        for (let argu in argumentObj) {
          if (argumentObj[argu].length > 0) {
            res = dataClone.filter(d => {
              return d[argu].indexOf(argumentObj[argu]) > -1;
            });
            dataClone = res;
          }
        }
        return res;
      },
      handleSearch() {
        this.orderShow = this.order;
        this.orderShow = this.search(this.order, {title: this.searchData});
      },
      // show (index) {
      //   this.$Modal.info({
      //     title: 'User Info',
      //     content: `Name：${this.order[index].name}<br>Age：${this.order[index].age}<br>Address：${this.data6[index].address}`
      //   })
      // },
      remove(index, orderid, bookid) {
        this.order.splice(index, 1);
        axios.get('http://localhost:8088/home/deleteOrder?order_id=' + orderid.toString() + '&book_id=' + bookid.toString())
          .then((response) => {
            var status = response.data;
            console.log(response);
          }).catch((error) => {
          console.log(error);
        })
      }
    },
    data() {
      return {
        order: [],
        orderShow: [],
        id: 0,
        searchData: "",
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
                    src: 'http://localhost:8088/image/' + params.row.cover,
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
          },
          {
            title: '状态',
            width: 68,
            key: 'state',
            align: 'center'
          },
          {
            title: '操作',
            key: 'action',
            width: 150,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.start(params.row.order_id, params.row.book_id, params.row.num)
                    }
                  }
                 }, '发货'),
                // h('Button', {
                //   props: {
                //     type: 'error',
                //     size: 'small'
                //   },
                //   on: {
                //     click: () => {
                //       this.remove(params.index,params.row.order_id, params.row.book_id);
                //     }
                //   }
                // }, 'Delete')
              ]);
            }
          }
        ]
      };
    }
  };
</script>

<style scoped>
  .page-size {
    margin: 15px 0px;
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
</style>
