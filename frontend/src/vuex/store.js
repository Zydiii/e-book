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
      address: "",
      id: 1,
      identity: 0,
      logid: "",
      name: "",
      password: "",
      phone: "",
      valid: 0

    },
    signUpStep: 0,
    marketing: {
      CarouselItems: [],
      activity: []
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
