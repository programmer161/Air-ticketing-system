<template>
  <div>
    <div class="loginmain">
      <div class="signinpanel">
        <div class="row">
          <div class="col-sm-12">
            <form id="loginform">
              <h4 class="no-margins">登录：</h4>
              <input id="username" v-model="username" name="username" type="text" class="form-control uname" placeholder="请输入手机号" />
              <input id="password" v-model="password" name="password" type="password" class="form-control pword m-b" placeholder="请输入密码" />
              <a id="forgetpwd" @click="forgetpwd">忘记密码了？</a>&nbsp &nbsp &nbsp  | &nbsp &nbsp &nbsp &nbsp <router-link to="/register" id="register">注册新账号</router-link>
              <button id="loginsubmit" @click="onSubmit" class="btn btn-success btn-block" type="submit">登录</button>
            </form>
          </div>
        </div>
        <footer class="container">
          <p class="float-right"><a href="#">Back to top</a></p>
          <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
        </footer>
      </div>
    </div>
  </div>
</template>

<script>
    import qs from "qs"
    export default {
        name: "customerlogin",
      data(){
          return{
            username:'',
            password:'',
          }
      },
      methods:{
          onSubmit:function(evt){
            evt.preventDefault();

            if(this.username !== '' && this.password !== ''){
              this.$axios.post('http://localhost:8080/api/customerlogin',qs.stringify({
                  'username':this.username,
                  'password':this.password
                })
              ).then(res => {
                let status = res.data;
                if(status === 'successful'){
                  this.$store.dispatch('setuser',this.username);
                  this.$router.push({name:'flightmain'});
                  console.log();
                }else{
                  alert("账户或密码错误！");
                }
                console.log(res);
              }).catch(e => {
                console.log(e);
              });
            }else{
              alert("请输入完整信息");
            }


          },
        forgetpwd:function () {
          alert("找管理员吧~");
        }
      },
      beforeRouteEnter:(to,form,next)=>{
          next(vm =>{
            vm.$store.dispatch("setuser",null);
          });
      }
    }

</script>

<style scoped>
  @import "../../static/css/bootstrap.css";
  @import "../../static/css/font-awesome.css";
  @import "../../static/css/animate.css";
  @import "../../static/css/style.css";
  @import "../../static/css/login.css";
  .loginmain{
    background: #18c8f6;
    background:url("../../static/image/login-background.jpg") no-repeat center fixed;
    height: 580px;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    color: rgba(255,255,255,.95);
  }
</style>
