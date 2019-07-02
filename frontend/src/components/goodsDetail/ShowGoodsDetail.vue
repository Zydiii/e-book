<template>
  <div>
    <div class="item-intro-show">
      <div class="item-intro-recommend">
        <div class="item-recommend-title">
          <p>为您推荐</p>
        </div>
        <div class="item-intro-recommend-column">
          <div class="item-recommend-column" >
            <div class="item-recommend-img">
              <img :src="'http://localhost:8088/image/' + goodsInfo.cover" alt="">
            </div>
            <div class="item-recommend-intro">
              <span>
                <span class="item-recommend-top-num">{{ 1}}</span>{{goodsInfo.title}}</span>
              <span class="item-recommend-price">￥{{goodsInfo.price}}</span>
            </div>
          </div>
        </div>
      </div>
      <div class="item-intro-detail" ref="itemIntroDetail">
        <div class="item-intro-nav item-tabs">
          <Tabs>
            <TabPane label="书籍详情">
              <span class="item-param-box">
                  <div class="remarks-title">书籍简介</div>
                </span>
              {{goodsInfo.intro}}

            </TabPane>
            <TabPane label="书籍信息">
              <div class="item-param-container">
                <span class="item-param-box">
                  ISBN: {{goodsInfo.isbn}}
                </span>

                <span class="item-param-box">
                  <span class="item-param-title"> </span>
                </span>
              </div>
            </TabPane>
            <TabPane label="书籍评价">
              <div>
                <div class="remarks-box" v-for="(item, index) in this.comments" :key="index" >
                  <div class="remarks-user">
                    <p class="username-p">
                      <Avatar class="person-icon" icon="md-person" size="small" /> <span class="username">{{item.logid}} </span>
                    </p>
                  </div>
                  <div class="remarks-content-box">
                    <p>
                      <Rate disabled :value="item.star" allow-half class="remarks-star"></Rate>
                    </p>
                    <p class="remarks-content">{{item.comment}}</p>
                    <p class="remarks-sub">
                      <span class="remarks-time">{{item.time}}</span>
                    </p>
                  </div>
                </div>
              </div>
            </TabPane>
          </Tabs>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import store from '@/vuex/store';
  import { mapState } from 'vuex';
  import axios from 'axios'
  export default {
    name: 'ShowGoodsDetail',
    data () {
      return {
        tagsColor: [ 'blue', 'green', 'red', 'yellow' ],
        goodsInfo: [],
        comments: []
      };
    },
    mounted: function () {
      this.id = this.$route.params.id;
      axios.get('http://localhost:8088/book/detail?ID='+this.id.toString())
        .then((response) => {
          this.goodsInfo = response.data;
        }).catch((error) => {
        console.log(error);
      });
      axios.get('http://localhost:8088/comment/getCommentBook?ID='+this.id.toString())
        .then((response) => {
          this.comments = response.data;
          console.log(this.comments);
        }).catch((error) => {
        console.log(error);
      });

    },
    store
  };
</script>

<style scoped>
  .item-intro-show{
    width: 80%;
    margin: 15px auto;
    display: flex;
    flex-direction: row;
    background-color: #fff;
  }
  .item-intro-recommend{
    width: 200px;
    height: 700px;
    display: flex;
    flex-direction: column;
  }
  .item-intro-recommend-column{
    display: flex;
    flex-direction: column;
    box-shadow: 0px 0px 5px #999;
  }
  .item-recommend-title{
    width: 100%;
    height: 38px;
    font-size: 16px;
    line-height: 38px;
    color: #fff;
    background-color: #25b7c4;
    box-shadow: 0px 0px 5px #25b7c4;
    text-align: center;
  }
  .item-recommend-column{
    margin-top: 15px;
  }
  .item-recommend-intro{
    padding: 5px 15px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    font-size: 12px;
    color: #999;
    cursor: pointer;
  }
  .item-recommend-img{
    width: 80%;
    margin: 0px auto;
    cursor: pointer;
  }
  .item-recommend-img img{
    width: 100%;
  }
  .item-recommend-top-num{
    color: #fff;
    margin: 0px 2px;
    padding: 1px 5px;
    border-radius: 12px;
    background-color: #25b7c4;
  }
  .item-recommend-price{
    color: #25b7c4;
    font-weight: bolder;
  }
  .item-intro-detail{
    margin-left: 30px;
    width: calc(80vw - 300px);
  }
  .item-intro-nav{
    width: 100%;
    height: 38px;
    background-color: #F7F7F7;
    border-bottom: 1px solid #25b7c4;
  }
  .item-intro-nav ul{
    margin: 0px;
    padding: 0px;
    list-style: none;
  }
  .item-intro-nav li{
    float: left;
    height: 100%;
    width: 120px;
    line-height: 38px;
    text-align: center;
    color: #25b7c4;
  }
  .item-intro-nav li:first-child{
    background-color: #25b7c4;
    color: #fff;
  }
  .item-intro-img{
    width: 100%;
  }
  .item-intro-img img{
    width: 100%;
  }
  .item-param-container {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    justify-content: space-between;
  }
  .item-param-box {
    width: 200px;
    height: 36px;
    font-size: 12px;
  }
  .item-param-title {
    color: #232323;
  }
  .item-param-content {
    color: #999;
  }
  .remarks-title {
    padding-left: 15px;
    height: 36px;
    font-size: 16px;
    font-weight: bolder;
    line-height: 36px;
    color: #666666;
    background-color: #F7F7F7;
  }
  .remarks-analyse-box {
    padding: 15px;
    display: flex;
    align-items: center;
  }
  .remarks-analyse-goods {
    margin-left: 15px;
    margin-right: 15px;
  }
  .remarks-analyse-num {
    font-size: 26px;
  }
  .remarks-analyse-title {
    font-size: 12px;
    line-height: 20px;
  }
  .remarks-bar {
    padding-left: 15px;
    height: 36px;
    line-height: 36px;
    color: #666666;
    background-color: #F7F7F7;
  }
  .remarks-bar span {
    margin-right: 15px;
  }
  .remarks-box {
    padding: 15px;
    display: flex;
    flex-direction: row;
    border-bottom: 1px #ccc dotted;
  }
  .remarks-user {
    width: 180px;
  }
  .remarks-user-name {
    padding-left: 15px;
  }
  .remarks-content-box {
    width: calc(100% - 180px);
  }
  .remarks-star {
    background-color: #fff;
  }
  .remarks-content {
    font-size: 14px;
    color: #232323;
    line-height: 28px;
  }
  .remarks-sub {
    margin-top: 15px;
    color: #ccc;
  }
  .remarks-time {
    margin-left: 15px;
  }
  .remarks-page {
    margin: 15px;
    display: flex;
    justify-content:flex-end;
  }
</style>

<style>

  .ivu-tabs-ink-bar {
    background-color: #25b7c4 !important;
  }
  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab{
    border-radius: 0px;
    color: #999;
    height: 38px;
    background: #F7F7F7;
  }
  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab-active{
    color: #fff;
    background-color: #25b7c4;
  }
  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab-active:before{
    content: '';
    display: block;
    width: 100%;
    height: 1px;
    color: #fff;
    background: #F7F7F7;
    position: absolute;
    top: 0;
    left: 0;
  }
  .ivu-rate-star-full:before, .ivu-rate-star-half .ivu-rate-star-content:before {
    color: #E4393C;
  }
</style>
