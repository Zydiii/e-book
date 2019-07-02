<template>
  <div>
    <div>
      <i-input v-model="searchData" class="search" placeholder="输入你想查找的订单" >
        <Button slot="append" icon="md-search" @click="handleSearch" ></Button>
      </i-input>
    </div>
    <Table border :columns="columns" :data="orderShow" no-data-text="您还没有需要评价的订单~"></Table>

    <Modal v-model="model" width="530" @on-ok="commentBook" :rules="ruleInline">
      <p slot="header">
        <Icon type="edit"></Icon>
        <span>书籍评价</span>
      </p>
      <div>
        <Form :model="formData" label-position="left" :label-width="100" >
          <FormItem lable="评分" prop="star">
            <Rate allow-half :value.sync="valueHalf"></Rate>
          </FormItem>
          <FormItem label="评价" prop="comment">
            <Input v-model="formData.comment" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
          </FormItem>
        </Form>
      </div>
    </Modal>
  </div>
</template>

<script>
  import axios from 'axios'
  import MyOrderExpand from './MyOrderExpand.vue';

  export default {
    components: {MyOrderExpand},
    name: 'EvalOrder',
    created() {
      this.getOrder();
    },
    methods: {
      getOrder(){
        var str = sessionStorage.getItem("userInfo");
        var s = JSON.parse(str);
        this.id = s.id;
        axios.get('http://localhost:8088/home/orderEval?ID=' + this.id.toString()).then((response) => {
          this.order = response.data;
          this.orderShow = this.order;
          console.log(typeof(response.data[0].order_time));
        }).catch((error) => {
          console.log(error);
        });
      },
      commentBook() {
        this.formData.order_id = this.msg;
        this.formData.book_id = this.msg1;
        this.formData.star = this.valueHalf;

        var str = sessionStorage.getItem("userInfo");
        this.formData.logid = JSON.parse(str).logid;
        console.log(this.formData);
        axios.post("http://localhost:8088/comment/commentBook", this.formData)
          .then((response) => {
            console.log(this.formData);
            console.log(response);
            this.$Message.success("您已成功评价！");
            this.getOrder();
          }).catch((error) => {
          console.log(this.formData);

          this.$Message.error("连接失败，请稍候再试！");
            console.log(error);
        });
      },
      recorder(order_id, book_id){
        axios.get("http://localhost:8088/home/recOrder?order_id=" + order_id + "&book_id=" + book_id)
          .then((response) => {
            console.log(response);
            if(response.data == "1"){
              this.$Message.success("您已成功收货，请及时评价");
              var str = sessionStorage.getItem("userInfo");
              var s = JSON.parse(str);
              this.id = s.id;
              axios.get('http://localhost:8088/home/order?ID=' + this.id.toString()).then((response) => {
                this.order = response.data;
                this.orderShow = this.order;
                console.log(typeof(response.data[0].order_time));
              }).catch((error) => {
                console.log(error);
              })
            }
            else{
              this.$Message.error("连接出错，请重试");
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
        msg:'',
        msg1:'',
        model: false,
        id: 0,
        searchData: "",
        valueHalf: 5,
        formData: {
          star: '',
          comment: '',
          order_id: '',
          book_id: '',
          logid: ''
        },
        ruleInline: {
          comment: [
            {required: true, message: '评价不能为空', trigger: 'blur'}
          ]
        },
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
            title: '操作',
            key: 'action',
            width: 86,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.model = 1;
                      this.msg = params.row.order_id;
                      this.msg1 = params.row.book_id;
                    }
                  }
                }, '评价')
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
