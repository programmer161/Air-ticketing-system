// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from "axios"
import store from './store/index'
import VueWechatTitle from 'vue-wechat-title'



//将axios挂载到原型上
Vue.prototype.$axios = axios;
axios.defaults.withCredentials=true;

Vue.config.productionTip = false

// use vue title plugin
Vue.use(VueWechatTitle)




/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
