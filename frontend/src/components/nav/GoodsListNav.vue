<template>
  <div>
    <div class="search-nav">
      <div class="search-nav-container">
        <ul>
          <li>全部书籍分类</li>
          <li><router-link to="/">图书排行榜</router-link></li>
          <li><router-link to="/">童书</router-link></li>
          <li><router-link to="/">教辅</router-link></li>
          <li><router-link to="/">小说</router-link></li>
          <li><router-link to="/">文学</router-link></li>
          <li><router-link to="/">青春文学</router-link></li>
          <li><router-link to="/">传记</router-link></li>
          <li><router-link to="/">成功励志</router-link></li>
          <li><router-link to="/">管理</router-link></li>
          <li><router-link to="/">历史</router-link></li>
          <li><router-link to="/">哲学</router-link></li>
          <li><router-link to="/">宗教</router-link></li>
          <li><router-link to="/">亲子家教</router-link></li>
          <li><router-link to="/">保健养生</router-link></li>
          <li><router-link to="/">考试</router-link></li>
          <li><router-link to="/">科技</router-link></li>
          <li><router-link to="/">进口原版</router-link></li>
          <li><router-link to="/">电子书</router-link></li>
          <li><router-link to="/">网络文学</router-link></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'GoodsListNav'
  };
</script>

<style scoped>
  .search-nav{
    width: 100%;
    height: 44px;
    border-bottom: 2px solid #25b7c4;
  }
  .search-nav-container{
    width: 80%;
    height: 44px;
    margin: 0px auto;
  }
  .search-nav-container ul{
    margin: 0px;
    padding-left: 0px;
    list-style: none;
  }
  .search-nav-container li{
    cursor: pointer;
    margin-left: 10px;
    line-height: 44px;
    color: #25b7c4;
    font-size: 13px;
    float: left;
  }
  .search-nav-container a{
    color: #25b7c4;
    text-decoration: none;
  }
  .search-nav-container li:first-child{
    padding: 0px 8px;
    background:#25b7c4;
    margin: 0px;
    color: #fff;
  }
</style>
