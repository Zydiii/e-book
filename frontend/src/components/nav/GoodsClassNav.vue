<template>
  <div class="item-class-show">
    <Row class="item-class-group" v-for="(items, index) in tagsInfo" :key="index">
      <i-col class="item-class-name" span="2">{{ items.tagName }} : </i-col>
      <i-col class="item-class-select" span="21">
        <span v-for="(item, subIndex) in items.tags" :key="subIndex">{{ item }}</span>
      </i-col>
    </Row>
  </div>
</template>

<script>
  export default {
    name: 'GoodsClassNav',
    data () {
      return {
        tagsInfo: [
          {
            tagName: '分类',
            tags: ['作品集','科幻小说', '侦探/悬疑/推理','情感', '魔幻小说','社会', '武侠', '惊悚/恐怖', '历史', '影视小说',
              '官场小说', '职场小说', '中国近现代小说', '财经','军事']
          },
          {
            tagName: '作者',
            tags: ['严歌苓','老舍','刘慈欣','莫言','余华','苏童','亦舒','王小波','唐浩明','天下霸唱','王安忆','陈忠实','麦家','冯骥才']
          },
          {
            tagName: '价格',
            tags: ['0-9','9-19','19-29','29-39','39以上']
          },
          {
            tagName: '客户评分',
            tags: ['5星','4星以上','3星以上','2星以上','1星以上']
          }
        ]
      };
    }
  };
</script>

<style scoped>
  .item-class-show {
    margin: 15px auto;
    width: 100%;
  }
  .item-class-group {
    margin-top: 1px;
    height: 45px;
    border-bottom: 1px solid #ccc;
  }
  .item-class-group:first-child {
    border-top: 1px solid #ccc;
  }
  .item-class-name {
    padding-left: 15px;
    line-height: 44px;
    color: #666;
    font-weight: bold;
    background-color: #f3f3f3;
  }
  .item-class-name:first-child {
    line-height: 43px;
  }
  .item-class-select span {
    margin-left: 15px;
    width: 160px;
    color: #005aa0;
    line-height: 45px;
    cursor: pointer;
  }
</style>
