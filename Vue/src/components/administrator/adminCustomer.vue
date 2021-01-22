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

                <div class="form-group" v-show="!updateinfo">

                    <div class="input-group">
                      <input v-model="keyword" type="search" id="searchInfo" name="keyword" class="form-control" placeholder="请输入您想搜索的信息">
                      <button id="search"  @click="search" name="search" type="button" class="btn btn-primary"><i class="fa fa-search"></i> 搜 索</button>
                    </div>

                  <table class="table table-bordered table-responsive table-striped">
                    <thead>
                    <tr>
                      <th>名字</th>
                      <th>昵称</th>
                      <th>性别</th>
                      <th>手机号码</th>
                      <th>Email</th>
                      <th>生日</th>
                      <th>注册日期</th>
                      <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(item,index) in arrayData">
                      <td>{{item.realname}}</td>
                      <td>{{item.nickname}}</td>
                      <td>{{item.sex}}</td>
                      <td>{{item.mobilephone}}</td>
                      <td>{{item.email}}</td>
                      <td>{{item.birthday}}</td>
                      <td>{{item. createtime}}</td>
                      <td class="inline">
                        <button id="updateInfo" @click="updateInfo" name="updateInfo" type="button" class="btn btn-w-m btn-primary">修改信息</button>
                        <br><br>
                        <button id="deleteCustomer" @click="deleteCustomer(index)" name="deleteCustomer" type="button" class="btn btn-w-m btn-danger">删除客户</button>
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

              <div class="middle-box text-center loginscreen   animated fadeInDown" v-show="updateinfo">
                <form  id="registerForm"  class="m-t" role="form">
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
                  <div class="form-group">
                    <input id="birthday" name="birthday" v-model="birthday" type="text" class="form-control" placeholder="请输入生日">
                  </div>
                  <div class="form-group text-center">
                    <select id="selectSex" v-model="selectSex" name="selectSex">
                      <option>男</option>
                      <option>女</option>
                    </select>
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
          //更新列表显示
          updateinfo:false,
          keyword:'',
          //修改信息
          phone:'',
          nickName:'',
          email:'',
          realName:'',
          selectSex:'',
          birthday:''
        }
      },
      methods:{
          //error: handle is undefined
        //记得把写的方法全给实现了，不然煞笔不给你过！！！！
        updateInfo:function (evt) {
          evt.preventDefault();

          this.updateinfo = true;
        },
        deleteCustomer:function (index) {

          let chose = confirm("是否删除？");

          if(chose == true){
            this.$axios.post('http://localhost:8080/api/deleteByCustomerId',qs.stringify({
                userID:this.arrayData[index].id
              })
            ).then(res =>{
              let status = res.data;
              if(status === 'success'){
                alert("删除成功");
                //此写法不仅能刷新数据，如有分页还会停留在当前页面
                this.search();
              }else {
                alert("删除失败")
              }
            }).catch(error =>{
              console.log(error);
            })
          }else{
            this.search(evt);
          }
        },
        submit:function (evt) {
          evt.preventDefault();

          this.$axios.post('http://localhost:8080/api/updateCustomer',qs.stringify({
            userID:this.arrayData[0].id,
            'phone' : this.phone,
            'nickName' : this.nickName,
            'email' : this.email,
            'realName' : this.realName,
            'selectSex' : this.selectSex,
            'birthday':this.birthday
          })).then(res =>{
            let status = res.data;
            if(status === 'successful'){
              alert("修改成功");
              this.updateinfo = false;
              this.search(evt);
            }else{
              alert("修改失败");
            }
            console.log(res);
          }).catch(error =>{
            console.log(error);
          });
        },
        search:function () {

          //按搜索呈现数据
          this.$axios.get('http://localhost:8080/api/searchByCustomerKeyword',{
            params:{
              keyword:this.keyword
            }
          }).then(res =>{
            this.arrayData = res.data;
          }).catch(error =>{
            console.log(error)
          })

        },
        showPage(pageIndex, $event, forceRefresh){

          //表格内容全展示
          //写法参考 https://segmentfault.com/q/1010000010878364

          this.$axios.get('http://localhost:8080/api/searchAllCustomer').then(res =>{
            //取到值直接扔进数组里
            //v-for直接取后台传来的数据
            this.arrayData = res.data;
            console.log(this.arrayData);
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


            this.pageCurrent = pageIndex;
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
