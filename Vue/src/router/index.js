import Vue from 'vue'
import Router from 'vue-router'
import flightmain from "../components/flightmain";
import lostpage from "../components/lostpage";
import mistakepage from "../components/mistakepage";
import contact from "../components/contact"
import customerlogin from "../components/customerlogin"
import orderticket from "../components/orderticket"
import register from "../components/register";
import adminlogin from "../components/adminlogin";
import customerinfo from "../components/customer/customerinfo";
import orderinfo from "../components/customer/orderinfo";
import adminmain from "../components/administrator/adminmain";
import adminCustomer from "../components/administrator/adminCustomer";
import adminFlights from "../components/administrator/adminFlights";
import adminOrder from "../components/administrator/adminOrder";
import adminNotice from "../components/administrator/adminNotice";

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'flightmain',
      component: flightmain,
      meta:{
        title:'东方航空'
      }
    },
    {
      path: '/404',
      name: '404',
      component:lostpage,
      meta:{
        title:'哦~找不到~'
      }
    },
    {
      path: '/500',
      name: '500',
      component:mistakepage,
      meta:{
        title:'哦~错误咯~'
      }
    },
    {
      path: '/contact',
      name: 'contact',
      component:contact,
      meta:{
        title:'反馈意见'
      }
    },
    {
      path: '/customerlogin',
      name: 'customerlogin',
      component:customerlogin,
      meta:{
        title:'欢迎登录'
      }
    },
    {
      path: '/orderticket',
      name: 'orderticket',
      component:orderticket,
      meta:{
        title:'订购机票'
      }
    },
    {
      path: '/register',
      name: 'register',
      component:register,
      meta:{
        title:'欢迎注册'
      }
    },
    {
      path: '/adminlogin',
      name: 'adminlogin',
      component:adminlogin,
      meta:{
        title:'管理员登录'
      }
    },
    {
      path: '/customerinfo',
      name: 'customerinfo',
      component:customerinfo,
      meta:{
        title:'个人信息'
      }
    },
    {
      path: '/orderinfo',
      name: 'orderinfo',
      component:orderinfo,
      meta:{
        title:'我的订单'
      }
    },
    {
      path: '/adminmain',
      name: 'adminmain',
      component:adminmain,
      meta:{
        title:'后台管理'
      }
    },
    {
      path: '/admincustomer',
      name: 'adminCustomer',
      component:adminCustomer,
      meta:{
        title:'客户管理'
      }
    },
    {
      path: '/adminflights',
      name: 'adminFlights',
      component:adminFlights,
      meta:{
        title:'航班管理'
      }
    },
    {
      path: '/adminorder',
      name: 'adminOrder',
      component:adminOrder,
      meta:{
        title:'订单管理'
      }
    },
    {
      path: '/adminnotice',
      name: 'adminNotice',
      component: adminNotice,
      meta: {
        title: '公告管理'
      }
    }
  ]
})
