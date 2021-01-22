<template>
    <div class="gray-bg">
      <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
          <div>

            <h1 class="logo-name">h</h1>

          </div>
          <h3>欢迎使用 hAdmin</h3>

          <form id="loginform" class="m-t" role="form">
            <div class="form-group">
              <input id="username" v-model="username" name="username" type="text" class="form-control" placeholder="用户名">
            </div>
            <div class="form-group">
              <input id="password" v-model="password" name="password" type="password" class="form-control" placeholder="密码">
            </div>
            <button id="submit" @click="onSubmit" type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center">
              <a @click="forgetpwd"><small>忘记密码了？</small></a>
            </p>

          </form>
        </div>
      </div>
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
      </footer>
    </div>
</template>

<script>
  import qs from "qs"
    export default {
        name: "adminlogin",
      data(){
          return{
            username: '',
            password: ''
          }
      },
      methods: {
        onSubmit: function (evt) {
          evt.preventDefault();

          this.$axios.post('http://localhost:8080/api/adminlogin', qs.stringify({
              'username': this.username,
              'password': this.password
            })
          ).then(res => {
            var status = res.data;
            if (status === 'successful') {
              this.$router.push({name: 'adminmain'});
            } else {
              alert("账户或密码错误！");
            }
            console.log(res);
          }).catch(e => {
            console.log(e);
          });
        },
        forgetpwd: function () {
          alert("你自己就是管理员！");
        }
      }
    }
</script>

<style scoped>
  @import "../../static/css/bootstrap.css";
  @import "../../static/css/font-awesome.css";
  @import "../../static/css/animate.css";
  @import "../../static/css/style.css";
</style>
