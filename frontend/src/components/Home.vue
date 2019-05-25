<template>
  <div class="container">
    <Layout class="layout">
      <Sider class="side-bar" :style="{height: 'calc(100vh - 35px)', background: '#fff', overflow: 'auto'}" ref="side" :collapsed-width="78">
        <Menu active-name="1-2" theme="light" width="auto" @on-select="onSelect">
          <div class="user-icon">
            <div class="user-img">
              <img src="../../static/img/head.png">
            </div>
          </div>
          <Submenu name="1" v-show=!this.isManager>
            <template slot="title">
              <Icon type="md-navigate"></Icon>
              <span>收货地址</span>
            </template>
            <MenuItem name="myAddress">我的收货地址</MenuItem>
            <MenuItem name="addAddress">添加收货地址</MenuItem>
          </Submenu>
          <Submenu name="2" v-show=!this.isManager>
            <template slot="title">
              <Icon type="md-clipboard"></Icon>
              <span>购物订单</span>
            </template>
            <MenuItem name="myOrder">我的订单</MenuItem>
            <MenuItem name="timeOrder">统计订单</MenuItem>
            <MenuItem name="evalOrder">评价订单</MenuItem>
          </Submenu>
          <!--<Submenu name="3" v-show=!this.isManager>-->
            <!--<template slot="title">-->
              <!--<Icon type="ios-cart"></Icon>-->
              <!--<span>购物车</span>-->
            <!--</template>-->
            <!--<MenuItem name="myShoppingCart">我的购物车</MenuItem>-->
          <!--</Submenu>-->
          <Submenu name="4" v-show=this.isManager>
            <template slot="title">
              <Icon type="ios-people-outline" />
              <span>用户管理</span>
            </template>
            <MenuItem name="manageUser">用户清单</MenuItem>
          </Submenu>
          <Submenu name="5" v-show=this.isManager>
            <template slot="title">
              <Icon type="md-clipboard"></Icon>
              <span>订单管理</span>
            </template>
            <MenuItem name="manageOrder">所有订单</MenuItem>
            <MenuItem name="seeOrder">统计订单</MenuItem>
            <MenuItem name="seeUser">用户消费</MenuItem>
          </Submenu>
          <Submenu name="6" v-show=this.isManager>
            <template slot="title">
              <Icon type="md-clipboard"></Icon>
              <span>书籍管理</span>
            </template>
            <MenuItem name="manageBook">书籍清单</MenuItem>
          </Submenu>
        </Menu>
      </Sider>
      <Layout class="layout">
        <Header :style="{background: '#fff'}">
          <h2>{{activeTitle}}</h2>
        </Header>
        <Content class="content">
          <transition mode="out-in">
            <router-view></router-view>
          </transition>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
  export default {
    name: 'Home',
    created() {
      var str = sessionStorage.getItem("userInfo");
      var s = JSON.parse(str);
      this.isManager = s.identity;
    },
    data () {
      return {
        activeTitle: '欢迎登陆',
        isManager: 0,
        bar: {
          'myAddress': '我的收货地址',
          'addAddress': '添加收货地址',
          'myOrder': '我的订单',
          //'myShoppingCart': '我的购物车',
          'timeOrder': '管理订单',
          'manageUser': '用户清单',
          'default': '欢迎登陆',
          'manageOrder': '订单管理',
          'manageBook': '书籍清单',
          'evalOrder': '评价订单',
          'seeOrder': '统计订单',
          'seeUser':'用户消费'
        }
      };
    },
    methods: {
      onSelect (name) {
        this.activeTitle = this.bar[name];
        this.$router.push(`/home/${name}`);
      }
    }
  };
</script>

<style scoped>
  .side-bar a{
    color: #232323;
  }
  .user-icon {
    height: 200px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .user-icon span {
    font-size: 96px;
  }
  .user-img {
    margin-bottom: 15px;
    width: 96px;
    height: 96px;
    border-radius: 48px;
    overflow: hidden;
  }
  .user-img img{
    width: 100%;
  }
  .content {
    margin: 15px;
    background-color: #fff;
    padding: 15px;
  }
  .layout-footer-center {
    padding: 0px 15px;
    padding-bottom: 15px;
    text-align: center;
  }
</style>
