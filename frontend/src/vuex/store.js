import Vue from 'vue';
import Vuex from 'vuex';
import * as actions from './actions';
import * as mutations from './mutations';
import * as getters from './getters';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLoading: false,
    orderBy: 'sale',
    goodsInfo: {
      goodsImg: [],
      title: '',
      tags: [],
      discount: [],
      promotion: [],
      remarksNum: 0,
      setMeal: [],
      hot: [],
      goodsDetail: [],
      param: [],
      remarks: []
    },
    userInfo: {
      username: ''
    },
    signUpStep: 0,
    marketing: {
      CarouselItems: [],
      activity: []
    },
    seckills: {
      deadline: {
        hours: 0,
        minute: 0,
        seconds: 0
      },
      goodsList: []
    },
    computer: {
      deadline: {
        hours: 0,
        minute: 0,
        seconds: 0
      },
      goodsList:[]
    },
    eat: {
      deadline: {
        hours: 0,
        minute: 0,
        seconds: 0
      },
      goodsList:[]
    },
    asItems: [],
    goodsList: [],
    shoppingCart: [],
    newShoppingCart: [],
    recommend: []
  },
  getters,
  actions,
  mutations
});
