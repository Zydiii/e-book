<template>
    <div>
      <div>
        <i-input v-model="searchData" class="search" placeholder="输入你想查找的订单" >
          <Button slot="append" icon="md-search" @click="handleSearch" ></Button>
        </i-input>
      </div>
      <Table border :columns="columns" :data="orderShow" no-data-text="您还没有已经完成的订单~"></Table>
    </div>
</template>

<script>
    export default {
        name: "ManageOrder",
      data() {
        return {
          order: [],
          orderShow: [],
          id: 0,
          columns: [
            {
              title: '订单号',
              key: 'order_id',
              width: 180,
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
              title: '购买时间',
              width: 120,
              key: 'order_time',
              align: 'center'
            }
          ]
        }
      },
      created()
      {
        var str = sessionStorage.getItem("userInfo");
        var s = JSON.parse(str);
        this.id = s.id;
        axios.get('http://localhost:8088/home/order?ID=' + this.id.toString()).then((response) => {
          this.order = response.data;
          this.orderShow = this.order;
          console.log(response);
        }).catch((error) => {
          console.log(error);
        });
      },
      methods: {
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
      }
    }

</script>

<style scoped>

</style>
