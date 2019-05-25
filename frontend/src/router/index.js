import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index';
import Login from '@/components/Login.vue'
import Information from '@/components/Information.vue'
const GoodsList = resolve => require(['@/components/GoodsList'], resolve);
const GoodsDetail = resolve => require(['@/components/GoodsDetail'], resolve);
const ShoppingCart = resolve => require(['@/components/ShoppingCart'], resolve);
const Order = resolve => require(['@/components/Order'], resolve);
const PayDone = resolve => require(['@/components/PayDone'], resolve);
const SignUp = resolve => require(['@/components/SignUp'], resolve);
const CheckPhone = resolve => require(['@/components/signUp/CheckPhone'], resolve);
const InputInfo = resolve => require(['@/components/signUp/InputInfo'], resolve);
const SignUpDone = resolve => require(['@/components/signUp/SignUpDone'], resolve);
const Home = resolve => require(['@/components/Home'], resolve);
const MyAddress = resolve => require(['@/components/home/MyAddress'], resolve);
const AddAddress = resolve => require(['@/components/home/AddAddress'], resolve);
const MyOrder = resolve => require(['@/components/home/MyOrder'], resolve);
const TimeOrder = resolve => require(['@/components/home/TimeOrder'], resolve);
const MyShoppingCart = resolve => require(['@/components/home/MyShoppingCart'], resolve);
const Feedback = resolve => require(['@/components/Feedback'], resolve);
const ManageUser = resolve => require(['@/components/home/ManageUser'], resolve);
const ManageBook = resolve => require(['@/components/home/ManageBook'], resolve);
const Default = resolve => require(['@/components/home/Default'], resolve);
const ManageOrder = resolve => require(['@/components/home/ManageOrder'], resolve);
const EvalOrder = resolve => require(['@/components/home/EvalOrder'], resolve);
const SeeOrder = resolve => require(['@/components/home/SeeOrder'], resolve);
const SeeUser = resolve => require(['@/components/home/SeeUser'], resolve);

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/', // 首页
      name: 'Index',
      component: Index
    },
    {
      path: '/information',
      name: 'Information',
      component: Information
    },
    {
      path: '/feedback', // 反馈页面
      name: 'Feedback',
      component: Feedback
    },
    {
      path: '/goodsList', // 商品列表
      name: 'GoodsList',
      component: GoodsList
    },
    {
      path: '/goodsDetail/:id', // 商品详情
      name: 'GoodsDetail',
      component: GoodsDetail
    },
    {
      path: '/shoppingCart',
      name: 'ShoppingCart',
      component: ShoppingCart
    },
    {
      path: '/order', // 订单页面
      name: 'Order',
      component: Order
    },
    {
      path: '/payDone', // 支付成功页面
      name: 'PayDone',
      component: PayDone
    },
    {
      path: '/Login', // 登陆
      name: 'Login',
      component: Login
    },
    {
      path: '/SignUp', // 注册
      name: 'SignUp',
      component: SignUp,
      children: [
        {
          path: '/',
          name: 'index',
          component: CheckPhone
        },
        {
          path: 'checkPhone',
          name: 'CheckPhone',
          component: CheckPhone
        },
        {
          path: 'inputInfo',
          name: 'InputInfo',
          component: InputInfo
        },
        {
          path: 'signUpDone',
          name: 'SignUpDone',
          component: SignUpDone
        }
      ]
    },
    {
      path: '/home', // 主页
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/',
          name: 'default',
          component: Default
        },
        // {
        //   path: '/',
        //   name: 'index',
        //   component: MyOrder
        // },
        {
          path: 'manageBook',
          name: 'ManageBook',
          component: ManageBook
        },
        {
          path: 'manageOrder',
          name: 'ManageOrder',
          component: ManageOrder
        },
        {
          path: 'myAddress',
          name: 'MyAddress',
          component: MyAddress
        },
        {
          path: 'addAddress',
          name: 'AddAddress',
          component: AddAddress
        },
        {
          path: 'myOrder',
          name: 'MyOrder',
          component: MyOrder
        },
        {
          path: 'seeOrder',
          name: 'SeeOrder',
          component: SeeOrder
        },
        {
          path: 'seeUser',
          name: 'SeeUser',
          component: SeeUser
        },
        {
          path: 'timeOrder',
          name: 'TimeOrder',
          component: TimeOrder
        },
        {
          path: 'evalOrder',
          name: 'EvalOrder',
          component: EvalOrder
        },
        {
          path: 'myShoppingCart',
          name: 'MyShoppingCart',
          component: MyShoppingCart
        },
        {
          path: 'manageUser',
          name: 'ManageUser',
          component: ManageUser
        }
      ]
    }
  ]
})
