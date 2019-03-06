<template>
  <div id="menu">
    <ul id="menus">
      <li v-for="item in links"><a @click="$goRoute(item.route)">{{item.text}}</a></li>
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
          },
          {
            text: 'Log In',
            route: '/page02'
          }
        ]
      }
    }
  }
</script>

<style>
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

  li {
    border-right: 1px solid #bbb;
  }

  li:last-child {
    border-right: none;
  }

  ul li a:hover{

    color: #fff;
    background-color: #138bec;

  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
  }

  li {
    float: left;
  }

  li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  #menu{
    width: 960px;
    margin: 0 auto;
    padding: 0 10px;
    background: url(assets/templatemo_bg.jpg);
  }

  #templatemo_menu {
    clear: both;
    width: 960px;
    height: 45px;
    background: url(assets/templatemo_menu_bg.jpg) no-repeat;
  }

</style>
