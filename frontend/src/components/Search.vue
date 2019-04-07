<template>
  <div>
    <div class="container">
      <i-input v-model="searchData" class="search" placeholder="输入你想查找的书籍" >
        <Button slot="append" icon="md-search" @click="search" ></Button>
      </i-input>
      <Tag color="cyan" v-for="(item, index) in promotionTags" :key="index"><span @click="selectTags(index)">{{item}}</span></Tag>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Search',
    data () {
      return {
        searchData: '',
        promotionTags: ['白夜行', '穆斯林的葬礼', '苏菲的世界','看见','白鹿原']
      };
    },
    methods: {
      selectTags (index) {
        this.searchData = this.promotionTags[index];
      },
      search () {
        this.$router.push({path: '/goodsList', query: { searchData: this.searchData }});
      }
    }
  };
</script>

<style scoped>
  @import "../assets/Search.css";
</style>
