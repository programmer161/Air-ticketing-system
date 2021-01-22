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
                <router-link to="/orderticket" class="nav-link">订购机票</router-link>
              </li>
              <li class="nav-item active">
                <router-link to="/contact" class="nav-link">反馈意见</router-link>
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

      <main role="main">

        <!-- START THE FEATURETTES -->
        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">提出您的宝贵意见</h2>
            <p class="lead">
              我们由衷的希望您能给我们提供宝贵的意见，促进我们的共同发展，一起创造美好的旅途！
            </p>
          </div>
          <div class="col-md-5">
            用户名：<input v-model="username" type="text" name="" class="form-control" placeholder="请输入您的用户名">
            邮箱：<input v-model="email" type="text" name="" class="form-control" placeholder="请输入您的邮箱">
            <br>
            请留下您的宝贵意见：
            <textarea v-model="contacts" name="textarea" cols="60" rows="10" ></textarea>
            <br><br>
            <button @click="submit" class="btn btn-sm btn-info" type="submit">提 交</button>
          </div>
        </div>
  <!-- FOOTER -->
  <footer class="container">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
  </footer>
  </main>
    </div>
</template>

<script>
    export default {
        name: "contact",
      data(){
          return{
            username:'',
            email:'',
            contacts:''
          }
      },
      methods:{
          submit:function (evt) {
            evt.preventDefault();
            if(this.$store.state.username){
              if(this.username !=='' && this.email !=='' && this.contacts !==''){
                alert("谢谢您的建议，我们马上进行处理，并给您回复邮件！");
              }else {
                alert("请输入正确信息！");
              }
            }else {
              alert("请先登录，再进行反馈！");
              this.$router.push({name:'customerlogin'});
            }


          }
      },
      computed:{
        isLogin:function () {
          return this.$store.getters.getIsLogin;
        }
      }
    }
</script>

<style scoped>
  @import "../../static/css/bootstrap.css";
  @import "../../static/css/carousel.css";
</style>
