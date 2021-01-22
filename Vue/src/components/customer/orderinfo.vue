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



    <div class="form-group">
      <hr class="featurette-divider">
      <div class="page-header">
        <h3>个人订单</h3>
      </div>
      <table class="table table-bordered table-responsive table-striped">
        <thead>
        <tr>
          <th>订单号</th>
          <th>航班号</th>
          <th>起飞城市</th>
          <th>降落城市</th>
          <th>起飞时间</th>
          <th>降落时间</th>
          <th>乘机人</th>
          <th>电话</th>
          <th>身份证号</th>
          <th>机票价格</th>
          <th>舱位</th>
          <th>航班状态</th>
          <th>订购时间</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item,index) in arrayData">
          <td>{{item.orderNo}}</td>
          <td>{{item.flightNo}}</td>
          <td>{{item.startCity}}</td>
          <td>{{item.endCity}}</td>
          <td>{{item.startTime}}</td>
          <td>{{item.arrivalTime}}</td>
          <td>{{item.person}}</td>
          <td>{{item.phone}}</td>
          <td>{{item.idcard}}</td>
          <td>{{item.price}}</td>
          <td>{{item.flightClass}}</td>
          <td>{{item.orderStatus}}</td>
          <td>{{item.createTime}}</td>
          <td>
            <button id="deleteOrder" @click="deleteOrders(index)" name="deleteOrders" type="button" class="btn btn-w-m btn-danger">删除订单</button>
          </td>
        </tr>
        </tbody>
      </table>
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
        name: "orderinfo",
      data(){
        this.$axios.get('http://localhost:8080/api/searchByOrderKeyword',{
          params:{
            keyword:this.$store.state.username
          }}).then(res =>{
          this.arrayData = res.data
        }).catch(error =>{
          console.log(error)
        });
        return{
          arrayData:[],
        }
      },
      computed: {
        isLogin: function () {
          return this.$store.getters.getIsLogin;
        }
      },
      methods:{
        deleteOrders:function (index) {

          let choose = confirm("是否删除？");
          if(choose == true) {
            this.$axios.post('http://localhost:8080/api/deleteOrdersId',qs.stringify({
              orderID:this.arrayData[index].id,
            })).then(res =>{
              if(res.data === 'success'){
                alert("删除成功");
                thisthis.$router.push({name: 'orderinfo'});
              }else if(res.data === 'error'){
                alert("删除失败");
              }else if(res.data === 'timeout'){
                alert("距离登机时间小于30分钟，不允许退票!");
              }
            })
          }
        },
      }
    }
</script>

<style scoped>
  @import "../../../static/css/font-awesome.css";
  @import "../../../static/css/bootstrap.css";
  @import "../../../static/css/carousel.css";
  @import "../../../static/css/plugins/dataTables/dataTables.bootstrap.css";
  @import "../../../static/css/animate.css";
  @import "../../../static/css/style.css";
</style>
