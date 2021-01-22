import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    //存储公共数据
    isLogin:false,
    username:''
  },
  getters:{
    getIsLogin:state => state.isLogin,
    getUser:state => state.username
  },
  actions:{
    //响应mutations
    setuser({commit},user){
     commit('userStatus',user)
      //console.log(user);
    }
  },
  mutations:{
    //更改数据
    setuser(state,user){
      state.username = user;
    },
    userStatus(state,user){
      if(user){
        state.isLogin = true;
        state.username = user;
      }else{
        state.isLogin = false
      }
    }
  }
})
