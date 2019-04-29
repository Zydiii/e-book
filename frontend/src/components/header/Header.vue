<template>
  <div class="box">
    <div class="nav">
      <ul class="menu">
        <li><Icon type="ios-book" color="white"/></li>
        <li><router-link to="/">首页</router-link></li>
      </ul>
      <ul class="detail">
        <li class="first" v-show=!isIn>
          <router-link to="/login">登录 <Icon type="md-person" /> </router-link>
        </li>
        <li v-show=!isIn> <span class="text-color-red"><router-link to="/SignUp">注册 <Icon type="md-person-add" /></router-link></span></li>
        <li v-show=isIn>
          <Dropdown>
            <p class="username-p">
              <Avatar class="person-icon" icon="md-person" size="small" /> <span class="username">{{logState.logid}} </span>
            </p>
            <DropdownMenu slot="list">
              <div class="my-page">
                <div class="my-info" @click="myInfo">
                  <Icon type="md-home" color="#25b7c4"></Icon>
                  <p>我的主页</p>
                </div>
                <div class="sign-out" @click="signOutFun">
                  <Icon type="md-log-out" color="#25b7c4"></Icon>
                  <p>退出登陆</p>
                </div>
              </div>
            </DropdownMenu>
          </Dropdown>
        </li>
        <li v-show=1>
          <router-link to="/order"><Icon type="md-cart" /> 购物车 </router-link>
        </li>
        <li><router-link to="/feedback"> <Icon type="ios-send" />反馈 </router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
  import store from '@/vuex/store';
  import { mapState, mapActions } from 'vuex';

  export default {
    name: 'M-Header',
    props:['msg'],
    watch: {
      msg:
        function(val) {
          var str = sessionStorage.getItem("userInfo");
          console.log("123123");
          console.log(str);
          console.log(sessionStorage.getItem("userInfo"));
          if (str != "") {
            this.logState = JSON.parse(str);
            console.log("Header");
            console.log(this.logState);
            console.log(this.logState.id);
          }
          if (sessionStorage.getItem("isLog") != "")
            this.isIn = "true";
        }
    },
    // updated: function (){
    //   var str = sessionStorage.getItem("userInfo");
    //   console.log("Header");
    //   console.log(
    //     (str));
    //   if(str != ""){
    //     this.logState = JSON.parse(str);
    //     console.log("Header");
    //     console.log(this.logState);
    //     console.log(this.logState.id);
    //   }
    //   if(sessionStorage.getItem("isLog") != "")
    //     this.isIn = "true";
    //  },
    data () {
      return {
        logState: [],
        isIn: ""
      };
    },
    methods: {
      myInfo () {
        this.$router.push('/home');
      },
      signOutFun () {
        this.isIn = "";
        this.logState = "";
        this.$emit("logout","logout");
        sessionStorage.setItem("userInfo","");
        sessionStorage.setItem("isLog","");
        //this.signOut();
        this.$router.push('/');
      }
    }
  };
</script>

<style scoped>
  @import "../../assets/header.css";
</style>
