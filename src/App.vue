<template>
  <div>
    <ul>
      <li v-for="item in links"><a @click="$goRoute(item.route)">{{item.text}}</a></li>
      <li>
        <el-button @click="startHacking">Log In</el-button>
      </li>
      <li>
        <el-button @click="startHacking">Sign Up</el-button>
      </li>
    </ul>

    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data () {
      return {
        links: [
          {
            text: 'Home',
            route: '/home'
          },
          {
            text: 'Shop',
            route: '/page01'
          },
          {
            text: 'Search',
            route: '/page02'
          },
          {
            text: 'Detail',
            route: '/page02'
          },
          {
            text: 'Favorite',
            route: '/page02'
          },
          {
            text: 'Cart',
            route: '/page02'
          }
        ]
      }
    },
    methods: {
      startHacking () {
        this.$notify({
          title: 'It works!',
          type: 'success',
          message: 'We\'ve laid the ground work for you. It\'s time for you to build something epic!',
          duration: 5000
        })
      }
    }
  }
</script>

<style>
  #app {
    font-family: Helvetica, sans-serif;
    text-align: center;
  }

  .text-center {
    text-align: center;
  }
  .spacing {
    margin-top: 30px;
  }
  .red {
    color: darkred;
  }
  ul li {
    display: inline-block;
    margin-right: 10px;
  }
  ul li a{
    display: inherit;
    padding: 5px 10px;
    border: 1px solid #ccc;
  }
  ul li a:hover{
    cursor: pointer;
    color: #fff;
    background-color: #138bec;
    border: 1px solid #138bec;
  }

  a {
    display: block;
    width: 100px;
  }
</style>
