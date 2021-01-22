<template>
    <div class="gray-bg">
      <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
          <div>

            <h1 class="logo-name">H</h1>

          </div>
          <h3>欢迎注册</h3>
          <form  id="registerForm" class="m-t" role="form">
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
              <input id="password" name="password" v-model="password" type="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="请再次输入密码">
            </div>
            <div class="form-group">
              <input id="email" name="email" v-model="email" type="email" class="form-control" placeholder="请输入email">
            </div>
            <div class="form-group text-center">
              <select id="selectSex" v-model="selectSex" name="selectSex">
                <option>男</option>
                <option>女</option>
              </select>
            </div>
            <div class="form-group text-left">
              <div class="checkbox i-checks">
                <label class="no-padding">
                  <input type="checkbox"><i></i> 我同意注册协议</label>
              </div>
            </div>
            <button id="submit" @click="submit" type="submit" class="btn btn-primary block full-width m-b">注 册</button>

            <p class="text-muted text-center"><small>已经有账户了？</small><router-link to="/customerlogin">点此登录</router-link>
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
    import qs from 'qs'
    export default {
        name: "register",
        data(){
          return{
            phone:'',
            nickName:'',
            password:'',
            email:'',
            realName:'',
            selectSex:''
          }
        },
      methods:{
          submit:function (evt) {
            evt.preventDefault();

            if(this.phone !== ''&& this.nickName !== '' && this.password !== '' && this.email !== '' && this.realName !== '' && this.selectSex !== ''){
              this.$axios.post('http://localhost:8080/api/register',qs.stringify({
                'phone' : this.phone,
                'nickName' : this.nickName,
                'password' : this.password,
                'email' : this.email,
                'realName' : this.realName,
                'selectSex' : this.selectSex
              })).then(res =>{
                let status = res.data;
                if(status === 'successful'){
                  alert("注册成功！");
                  this.$router.push({name:'customerlogin'});
                }else{
                  alert("注册失败");
                }
                console.log(res);
              }).catch(error =>{
                console.log(error);
              });
            }else {
              alert("请输入完整信息！");
            }


          }
      }
    }
</script>

<style scoped>
  @import "../../static/css/bootstrap.min.css";
  @import "../../static/css/font-awesome.css";
  @import "../../static/css/animate.css";
  @import "../../static/css/style.css";
  @import "../../static/css/plugins/iCheck/custom.css";
</style>
