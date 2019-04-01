
export const SET_SIGN_UP_SETP = (state, step) => {
  state.signUpStep = step;
};


export const SET_USER_LOGIN_INFO = (state, data) => {
  state.userInfo = data;
};


export const SET_LOAD_STATUS = (state, status) => {
  state.isLoading = status;
};


export const SET_SECKILLS_INFO = (state, seckills) => {
  state.seckills.goodsList = seckills[0];
  state.seckills.deadline = seckills[1];
};


export const SET_CAROUSELITEMS_INFO = (state, { carouselItems, activity }) => {
  state.marketing.CarouselItems = carouselItems;
  state.marketing.activity = activity;
};


export const REDUCE_SECKILLS_TIME = state => {
  state.seckills.deadline.seconds--;
  if (state.seckills.deadline.seconds === -1) {
    state.seckills.deadline.seconds = 59;
    state.seckills.deadline.minute--;
    if (state.seckills.deadline.minute === -1) {
      state.seckills.deadline.minute = 59;
      state.seckills.deadline.hour--;
    }
  }
};


export const SET_GOODS_LIST = (state, data) => {
  state.goodsList = data.goodsList;
  state.asItems = data.asItems;
};


export const SET_GOODS_ORDER_BY = (state, data) => {
  state.orderBy = data;
};


export const SET_GOODS_INFO = (state, data) => {
  state.goodsInfo = data;
};


export const ADD_SHOPPING_CART = (state, data) => {
  const item = {
    goods_id: data.goods_id,
    count: data.count,
    img: data.img,
    package: data.package.intro,
    price: data.price,
    title: data.title
  };
  state.shoppingCart.push(item);
  state.newShoppingCart = data;
};


export const SET_SHOPPING_CART = (state, data) => {
  state.shoppingCart = data;
};


export const SET_RECOMMEND_INFO = (state, data) => {
  state.recommend = data;
};


export const SET_USER_ADDRESS = (state, data) => {
  state.address = data;
};
