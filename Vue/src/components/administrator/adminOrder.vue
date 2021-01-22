<template>
  <div class="sidebar-fixed header-fixed">
    <div class="page-wrapper">
      <nav class="navbar page-header">


        <div class="navbar-brand">
          <p>东方航空公司后台管理系统</p>
        </div>


        <ul class="navbar-nav ml-auto">
          <li class="nav-item d-md-down-none">
            <a href="#">
              <i class="fa fa-bell"></i>
              <span class="badge badge-pill badge-danger">999+</span>
            </a>
          </li>

          <li class="nav-item d-md-down-none">
            <a href="#">
              <i class="fa fa-envelope-open"></i>
              <span class="badge badge-pill badge-danger">999+</span>
            </a>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <img src="../../../static/image/jay.jpg" class="avatar avatar-sm" alt="logo">
              <span class="small ml-1 d-md-down-none">ZiGeng_Huang</span>
            </a>

            <div class="dropdown-menu dropdown-menu-right">
              <div class="dropdown-header">Account</div>

              <router-link to="/" class="dropdown-item">
                <i class="fa fa-user"></i> 官网主页
              </router-link>

              <router-link to="/adminlogin" class="dropdown-item">
                <i class="fa fa-lock"></i> Logout
              </router-link>
            </div>
          </li>
        </ul>
      </nav>

      <div class="main-container">
        <div class="sidebar">
          <nav class="sidebar-nav">
            <ul class="nav">
              <li class="nav-title">Navigation</li>

              <li class="nav-item">
                <router-link to="/adminmain" class="nav-link active">
                  <i class="icon icon-speedometer"></i> 主页
                </router-link>
              </li>

              <li class="nav-item ">
                <router-link to="/admincustomer" class="nav-link ">
                  <i class="icon icon-target"></i> 客户管理
                </router-link>
              </li>

              <li class="nav-item ">
                <router-link to="/adminflights" class="nav-link ">
                  <i class="icon icon-energy"></i> 航班管理
                </router-link>
              </li>

              <li class="nav-item ">
                <router-link to="/adminorder" class="nav-link ">
                  <i class="icon icon-graph"></i> 订单管理
                </router-link>
              </li>


            </ul>
          </nav>
        </div>

        <div class="content">
          <div class="container-fluid">
            <div class="row">

              <div class="form-group" v-show="!showInfo">
                <table class="table table-bordered table-responsive table-striped" v-show="!searchinfo">

                  <div class="input-group">
                    <input v-model="keyword" type="search" id="searchInfo" name="searchInfo" class="form-control" placeholder="请输入您想搜索的信息">
                    <button @click="search" type="button" class="btn btn-primary"><i class="fa fa-search"></i> 搜 索</button>
                  </div>

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
                    <td class="inline">
                      <button id="updateOrder" @click="updateInfo" name="updateOrder" type="button" class="btn btn-w-m btn-primary">修改订单</button>
                      <br><br>
                      <button id="deleteOrder" @click="deleteOrders(index)" name="deleteOrders" type="button" class="btn btn-w-m btn-danger">删除订单</button>
                    </td>
                  </tr>
                  </tbody>
                </table>


                <div class="pager" id="pager">
                    <span class="form-inline">
                        <select class="form-control" v-model="pagesize" v-on:change="showPage(pageCurrent,$event,true)" number>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                        </select>
                    </span>
                  <span v-for="item in pageCount+1">
                        <span v-if="item==1" class="btn btn-default" v-on:click="showPage(1,$event)" :class="{'disabled':fDisabled}">
                            首页
                        </span>
                        <span v-if="item==1" class="btn btn-default" v-on:click="showPage(pageCurrent-1,$event)" :class="{'disabled':fDisabled}">
                            上一页
                        </span>
                        <span v-if="item==1" class="btn btn-default" v-on:click="showPage(item,$event)">
                            {{item}}
                        </span>
                        <span v-if="item==1&&item<showPagesStart-1" class="btn btn-default disabled">
                            ...
                        </span>
                        <span v-if="item>1&&item<=pageCount-1&&item>=showPagesStart&&item<=showPageEnd&&item<=pageCount" class="btn btn-default" v-on:click="showPage(item,$event)">
                            {{item}}
                        </span>
                        <span v-if="item==pageCount&&item>showPageEnd+1" class="btn btn-default disabled">
                            ...
                        </span>
                        <span v-if="item==pageCount" class="btn btn-default" v-on:click="showPage(item,$event)"  >
                            {{item}}
                        </span>
                        <span v-if="item==pageCount" class="btn btn-default" v-on:click="showPage(pageCurrent+1,$event)" :class="{'disabled':lDisabled}">
                            下一页
                        </span>
                        <span v-if="item==pageCount" class="btn btn-default" v-on:click="showPage(pageCount,$event)" :class="{'disabled':lDisabled}">
                            尾页
                        </span>
                    </span>
                  <span>{{pageCurrent}}/{{pageCount}}</span>
                </div>
              </div>

              <div class="middle-box text-center loginscreen   animated fadeInDown" v-show="showInfo">
                <form  id="registerForm"  class="m-t" role="form">
                  <div class="form-group">
                    <input id="flightNo" name="flightNo" v-model="flightNo" type="text" class="form-control" placeholder="请输入航班号">
                  </div>
                  <div class="form-group">
                    <input id="phone" name="phone" v-model="phone" type="text" class="form-control" placeholder="请输入手机号">
                  </div>
                  <div class="form-group">
                    <input id="realName" name="realName" v-model="Name" type="text" class="form-control" placeholder="请输入姓名">
                  </div>
                  <div class="form-group">
                    <input id="IDCard" name="IDCard" v-model="IDCard" type="text" class="form-control" placeholder="请输入身份证号">
                  </div>
                  <div class="form-group">
                    <input id="email" name="email" v-model="email" type="email" class="form-control" placeholder="请输入email">
                  </div>
                  <button id="submit" @click="submit" type="submit" class="btn btn-primary block full-width m-b">提 交</button>

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
    </div>
  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    name: "adminCustomer",
    data() {
      return {
        //为第一页或者最后一页时，首页，尾页不能点击
        fDisabled: false,
        lDisabled: false,
        //总项目数
        totalCount: 200,
        //分页数
        pageCount: 20,
        //当前页面
        pageCurrent: 1,
        //分页大小
        pagesize: 10,
        //显示分页按钮数
        showPages: 11,
        //开始显示的分页按钮
        showPagesStart: 1,
        //结束显示的分页按钮
        showPageEnd: 100,
        //分页数据
        arrayData: [],
        showInfo:false,
        searchinfo:false,
        keyword:''
      }
    },
    methods:{
      //error: handle is undefined
      //记得把写的方法全给实现了，不然煞笔不给你过！！！！
      updateInfo:function (evt) {
        evt.preventDefault();

        //更新信息
        this.showInfo = true;
      },
      deleteOrders:function (index) {


        let choose = confirm("是否删除？");
        if(choose == true) {
          this.$axios.post('http://localhost:8080/api/deleteByOrderId',qs.stringify({
            orderID:this.arrayData[index].id,
          })).then(res =>{
            if(res.data === 'success'){
              alert("删除成功");
              this.search();
            }else{
              alert("删除失败");
            }
          })
        }

      },
      submit:function (evt) {
        evt.preventDefault();

        this.showInfo = false;
      },
      search:function(){
        this.$axios.get('http://localhost:8080/api/orderKeyword',{
          params:{
            keyword:this.keyword
          }
        }).then(res =>{
          this.arrayData = res.data;
        }).catch(error =>{
          console.log(error);
        })
      },
      showPage(pageIndex, $event, forceRefresh){

        this.$axios.get('http://localhost:8080/api/searchAllOrders').then(res =>{
          this.arrayData = res.data;
        }).catch(error=>{
          console.log(error)
        })

        if (pageIndex > 0) {
          if (pageIndex > this.pageCount) {
            pageIndex = this.pageCount;
          }
          //判断数据是否需要更新
          var currentPageCount = Math.ceil(this.totalCount / this.pagesize);
          if (currentPageCount != this.pageCount) {
            pageIndex = 1;
            this.pageCount = currentPageCount;
          }
          else if (this.pageCurrent == pageIndex && currentPageCount == this.pageCount && typeof (forceRefresh) == "undefined") {
            console.log("not refresh");
            return;
          }

          //处理分页点中样式
          var buttons = $("#pager").find("span");
          for (var i = 0; i < buttons.length; i++) {
            if (buttons.eq(i).html() != pageIndex) {
              buttons.eq(i).removeClass("active");
            }
            else {
              buttons.eq(i).addClass("active");
            }
          }

          //测试数据 随机生成的
          var newPageInfo = [];
          var time=new Date();
          for (var i = 0; i < this.pagesize; i++) {
            newPageInfo[newPageInfo.length] = {
              timestamp: time,
              count: (i + (pageIndex - 1) * 20)
            };
          }

          this.pageCurrent = pageIndex;
          this.arrayData = newPageInfo;
          //如果当前页首页或者尾页，则上一页首页就不能点击，下一页尾页就不能点击
          if(this.pageCurrent===1){
            this.fDisabled=true;
          }else if(this.pageCurrent===this.pageCount){
            this.lDisabled=true;
          }else{
            this.fDisabled=false;
            this.lDisabled=false;
          }

          //计算分页按钮数据
          if (this.pageCount > this.showPages) {
            if (pageIndex <= (this.showPages - 1) / 2) {
              this.showPagesStart = 1;
              this.showPageEnd = this.showPages - 1;
              console.log("showPage1")
            }
            else if (pageIndex >= this.pageCount - (this.showPages - 3) / 2) {
              this.showPagesStart = this.pageCount - this.showPages + 2;
              this.showPageEnd = this.pageCount;
              console.log("showPage2")
            }
            else {
              console.log("showPage3")
              this.showPagesStart = pageIndex - (this.showPages - 3) / 2;
              this.showPageEnd = pageIndex + (this.showPages - 3) / 2;
            }
          }
          console.log("showPagesStart:" + this.showPagesStart + ",showPageEnd:" + this.showPageEnd + ",pageIndex:" + pageIndex);
        }
      }
    },
    mounted(){
      this.showPage(this.pageCurrent, null, true);

    }
  }
</script>

<style scoped>
  @import "../../../static/css/simple-line-icons/css/simple-line-icons.css";
  @import "../../../static/css/font-awesome/css/fontawesome-all.min.css";
  @import "../../../static/css/font-awesome/styles.css";
</style>
