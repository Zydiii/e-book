<template>
  <div id="app">
    <Header v-bind:msg="msg" v-on:logout="logout"></Header>
    <router-view v-on:logged="logged" />
  </div>
</template>

<script>
  import Header from '@/components/header/Header';
  export default {
    name: 'App',
    data () {
      return {
        msg: "1"
      };
    },
    components: {
      Header
    },
    created() {
      sessionStorage.setItem("isLog","");
      sessionStorage.setItem("userInfo","");
    },
    methods: {
      logged:function() {
      this.msg +="1";
      console.log("log5");
      },
      logout:function() {
        this.msg = "1";
        console.log("log000");
      }
    }
  };
</script>
