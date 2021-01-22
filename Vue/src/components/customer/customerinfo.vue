<template>
  <div>
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <router-link to="/" class="navbar-brand">东方航空</router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <router-link to="/" class="nav-link">主页 <span class="sr-only">(current)</span></router-link>
            </li>
            <li class="nav-item active">
              <router-link to="/orderticket" class="nav-link" >订购机票</router-link>
            </li>
            <li class="nav-item active">
              <router-link to="/contact" class="nav-link" >反馈意见</router-link>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0" id="LoginAndRegister">
            <router-link to="/customerlogin" v-show="!isLogin"><button class="btn btn-outline-success my-2 my-sm-0" type="button">登录/注册</button></router-link>
            <div class="btn-group">
              <button v-show="isLogin" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">个人中心
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li>
                  <router-link to="/customerinfo">个人信息</router-link>
                </li>
                <li>
                  <router-link to="/orderinfo">我的订单</router-link>
                </li>
                <li>
                  <router-link to="/customerlogin">退出</router-link>
                </li>
              </ul>
            </div>
          </form>
        </div>
      </nav>
    </header>

    <div class="gray-bg">
    <hr class="featurette-divider">

      <div v-show="!update" class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
          <div class="col-sm-8">
            <div class="ibox float-e-margins">
              <div class="ibox-title">
                <h5>个人资料</h5>
              </div>
              <div>
                <div class="ibox-content profile-content">
                  <p>姓名：{{this.arrayData[0].realname}}</p>
                  <p>性别：{{this.arrayData[0].sex}}</p>
                  <p>email：{{this.arrayData[0].email}}</p>
                  <p>电话号码：{{this.arrayData[0].mobilephone}}</p>
                  <p>昵称：{{this.arrayData[0].nickname}}</p>
                  <p>注册时间：{{this.arrayData[0].createtime}}</p>
                  <div class="user-button">
                    <div class="row">
                      <div class="col-sm-3">
                        <button id="updateInfo" @click="updateInfo" name="updateInfo" type="button" class="btn btn-primary btn-sm btn-block">修改资料</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="middle-box text-center loginscreen   animated fadeInDown">
    <form  id="registerForm" v-show="update" class="m-t" role="form">
      <div class="form-group">
        <input id="phone" name="phone" v-model="phone" type="text" class="form-control" placeholder="请输入手机号">
      </div>
      <div class="form-group">
        <input id="realName" name="realName" v-model="realName" type="text" class="form-control" placeholder="请输入姓名">
      </div>
      <div class="form-group">
        <input id="nickName" name="nickName" v-model="nickName" type="text" class="form-control" placeholder="取一个昵称吧！">
      </div>
      <div class="form-group">
        <input id="email" name="email" v-model="email" type="email" class="form-control" placeholder="请输入email">
      </div>
      <button id="submit" @click="submit" type="submit" class="btn btn-primary block full-width m-b">提 交</button>

    </form>
    </div>



  <footer class="container">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
  </footer>
  </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "customerinfo",
      data(){
        this.$axios.get('http://localhost:8080/api/searchByCustomerKeyword',{
          params:{
            keyword:this.$store.state.username
          }}).then(res =>{
            this.arrayData = res.data
        }).catch(error =>{
            console.log(error)
        });
          return{
            update:false,
            arrayData:[],
            phone:'',
            realName:'',
            nickName:'',
            email:''
          }
      },
      methods:{
          updateInfo:function (evt) {
            evt.preventDefault();

            this.update = true;
          },
        submit:function (evt) {
          evt.preventDefault();

          this.$axios.post('http://localhost:8080/api/updateCustomer',qs.stringify({
            userID:this.arrayData[0].id,
            phone:this.phone,
            realName:this.realName,
            nickName:this.nickName,
            email:this.email
          })).then(res =>{
            let result = res.data;
            if(result === 'successful'){
              alert("更新成功,需要重新登陆");
              this.$router.push({name:'customerlogin'});
            }else{
              alert("更新失败");
            }
          })
        }
      },
      computed: {
        isLogin: function () {
          return this.$store.getters.getIsLogin;
        }
      }
    }
</script>

<style scoped>
  @import "../../../static/css/font-awesome.css";
  @import "../../../static/css/bootstrap.css";
  @import "../../../static/css/carousel.css";
  @import "../../../static/css/animate.css";
  @import "../../../static/css/style.css";
  @import "../../../static/css/plugins/iCheck/custom.css";
</style>
