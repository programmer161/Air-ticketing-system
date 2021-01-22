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
                    <button id="search" @click="search" type="button" class="btn btn-primary"><i class="fa fa-search"></i> 搜 索</button>
                    &nbsp
                    <button id="addFlights" @click="addFlights" name="addFlights" type="button" class="btn btn-w-m btn-primary">增加航班</button>
                  </div>

                <table class="table table-bordered table-responsive table-striped">
                  <thead>
                  <tr>
                    <th>航班号</th>
                    <th>起飞时间</th>
                    <th>起飞机场</th>
                    <th>到达时间</th>
                    <th>到达机场</th>
                    <th>头等舱座位数</th>
                    <th>商务舱座位数</th>
                    <th>经济舱座位数</th>
                    <th>头等舱价格</th>
                    <th>商务舱价格</th>
                    <th>经济舱价格</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>操作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr v-for="(item,index) in arrayData">
                    <td>{{item.flightNo}}</td>
                    <td>{{item.startTime}}</td>
                    <td>{{item.startAirport}}</td>
                    <td>{{item.arrivalTime}}</td>
                    <td>{{item.endAirport}}</td>
                    <td>{{item.firstClassAmount}}</td>
                    <td>{{item.businessClassAmount}}</td>
                    <td>{{item.economyClassAmount}}</td>
                    <td>{{item.firstClassPrice}}</td>
                    <td>{{item.businessClassPrice}}</td>
                    <td>{{item.economyClassPrice}}</td>
                    <td>{{item.status}}</td>
                    <td>{{item.createTime}}</td>
                    <td class="inline">
                      <button id="updateFlights" @click="updateFlights" name="updateFlights" type="button" class="btn btn-w-m btn-primary">修改航班</button>
                      <br><br>
                      <button id="deleteFlights" @click="deleteFlights(index)"  name="deleteFlights" type="button" class="btn btn-w-m btn-danger">删除航班</button>
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

              <div class="middle-box text-center loginscreen   animated fadeInDown" v-show="addFlight">
                <form  id="registerForm"  class="m-t" role="form">
                  <div class="form-group">
                    <input id="addFlightNo" name="addFlightNo" v-model="flightNo" type="text" class="form-control" placeholder="请输入航班号">
                  </div>
                  <div class="form-group">
                    <input id="addStartTime" name="addStartTime" v-model="startTime" type="text" class="form-control" placeholder="请输入起飞时间 yyyy-MM-dd HH:mm">
                  </div>
                  <div class="form-group">
                    <input id="addArrivalTime" name="addArrivalTime" v-model="arrivalTime" type="text" class="form-control" placeholder="请输入达到时间 yyyy-MM-dd HH:mm">
                  </div>
                  <div class="form-group">
                    <select id="addStartAirport" v-model="startAirport" class="form-control" name="startAirport">
                      <option>北京</option>
                      <option>天津</option>
                      <option>石家庄</option>
                      <option>邯郸</option>
                      <option>唐山</option>
                      <option>秦皇岛</option>
                      <option>张家口</option>
                      <option>太原</option>
                      <option>运城</option>
                      <option>呼和浩特</option>
                      <option>包头</option>
                      <option>鄂尔多斯</option>
                      <option>海拉尔</option>
                      <option>赤峰</option>
                      <option>通辽</option>
                      <option>满洲里</option>
                      <option>大连</option>
                      <option>沈阳</option>
                      <option>长春</option>
                      <option>哈尔滨</option>
                      <option>南京</option>
                      <option>无锡</option>
                      <option>连云港</option>
                      <option>杭州</option>
                      <option>温州</option>
                      <option>合肥</option>
                      <option>厦门</option>
                      <option>福州</option>
                      <option>南昌</option>
                      <option>青岛</option>
                      <option>烟台</option>
                      <option>郑州</option>
                      <option>洛阳</option>
                      <option>长沙</option>
                      <option>张家界</option>
                      <option>广州</option>
                      <option>深圳</option>
                      <option>珠海</option>
                      <option>湛江</option>
                      <option>南宁</option>
                      <option>桂林</option>
                      <option>三亚</option>
                      <option>海口</option>
                      <option>重庆</option>
                      <option>成都</option>
                      <option>贵阳</option>
                      <option>昆明</option>
                      <option>新疆</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <select id="addEndAirport" v-model="endAirport" class="form-control" name="endAirport">
                      <option>北京</option>
                      <option>天津</option>
                      <option>石家庄</option>
                      <option>邯郸</option>
                      <option>唐山</option>
                      <option>秦皇岛</option>
                      <option>张家口</option>
                      <option>太原</option>
                      <option>运城</option>
                      <option>呼和浩特</option>
                      <option>包头</option>
                      <option>鄂尔多斯</option>
                      <option>海拉尔</option>
                      <option>赤峰</option>
                      <option>通辽</option>
                      <option>满洲里</option>
                      <option>大连</option>
                      <option>沈阳</option>
                      <option>长春</option>
                      <option>哈尔滨</option>
                      <option>南京</option>
                      <option>无锡</option>
                      <option>连云港</option>
                      <option>杭州</option>
                      <option>温州</option>
                      <option>合肥</option>
                      <option>厦门</option>
                      <option>福州</option>
                      <option>南昌</option>
                      <option>青岛</option>
                      <option>烟台</option>
                      <option>郑州</option>
                      <option>洛阳</option>
                      <option>长沙</option>
                      <option>张家界</option>
                      <option>广州</option>
                      <option>深圳</option>
                      <option>珠海</option>
                      <option>湛江</option>
                      <option>南宁</option>
                      <option>桂林</option>
                      <option>三亚</option>
                      <option>海口</option>
                      <option>重庆</option>
                      <option>成都</option>
                      <option>贵阳</option>
                      <option>昆明</option>
                      <option>新疆</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <input id="addFirstClassAmount" name="addFirstClassAmount" v-model="firstClassAmount" type="text" class="form-control" placeholder="请输入头等舱票数">
                  </div>
                  <div class="form-group">
                    <input id="addBusinessClassAmount" name="addBusinessClassAmount" v-model="businessClassAmount" type="text" class="form-control" placeholder="请输入商务舱票数">
                  </div>
                  <div class="form-group">
                    <input id="addEconomyClassAmount" name="addEconomyClassAmount" v-model="economyClassAmount" type="text" class="form-control" placeholder="请输入经济舱票数">
                  </div>
                  <div class="form-group">
                    <input id="addFirstClassPrice" name="addFirstClassPrice" v-model="firstClassPrice" type="text" class="form-control" placeholder="请输入头等舱价格">
                  </div>
                  <div class="form-group">
                    <input id="addBusinessClassPrice" name="addBusinessClassPrice" v-model="businessClassPrice" type="text" class="form-control" placeholder="请输入商务舱价格">
                  </div>
                  <div class="form-group">
                    <input id="addEconomyClassPrice" name="addEconomyClassAmount" v-model="economyClassPrice" type="text" class="form-control" placeholder="请输入经济舱价格">
                  </div>
                  <div class="form-group">
                    <input id="addStatus" name="addStatus" v-model="status" type="text" class="form-control" placeholder="请输入航班状态">
                  </div>
                  <button id="addSubmit" @click="addSubmit" type="submit" class="btn btn-primary block full-width m-b">提 交</button>

                </form>
              </div>


              <div class="middle-box text-center loginscreen   animated fadeInDown" v-show="updateinfo">
                <form  id="updateForm"  class="m-t" role="form">
                  <div class="form-group">
                    <input id="updateFlightNo" name="updateFlightNo" v-model="flightNo" type="text" class="form-control" placeholder="请输入航班号">
                  </div>
                  <div class="form-group">
                    <input id="updateStartTime" name="updateStartTime" v-model="startTime" type="text" class="form-control" placeholder="请输入起飞时间 yyyy-MM-dd HH:mm">
                  </div>
                  <div class="form-group">
                    <input id="updateArrivalTime" name="updateArrivalTime" v-model="arrivalTime" type="text" class="form-control" placeholder="请输入达到时间 yyyy-MM-dd HH:mm">
                  </div>
                  <div class="form-group">
                    <select id="updateStartAirport" v-model="startAirport" class="form-control" name="startAirport">
                      <option>北京</option>
                      <option>天津</option>
                      <option>石家庄</option>
                      <option>邯郸</option>
                      <option>唐山</option>
                      <option>秦皇岛</option>
                      <option>张家口</option>
                      <option>太原</option>
                      <option>运城</option>
                      <option>呼和浩特</option>
                      <option>包头</option>
                      <option>鄂尔多斯</option>
                      <option>海拉尔</option>
                      <option>赤峰</option>
                      <option>通辽</option>
                      <option>满洲里</option>
                      <option>大连</option>
                      <option>沈阳</option>
                      <option>长春</option>
                      <option>哈尔滨</option>
                      <option>南京</option>
                      <option>无锡</option>
                      <option>连云港</option>
                      <option>杭州</option>
                      <option>温州</option>
                      <option>合肥</option>
                      <option>厦门</option>
                      <option>福州</option>
                      <option>南昌</option>
                      <option>青岛</option>
                      <option>烟台</option>
                      <option>郑州</option>
                      <option>洛阳</option>
                      <option>长沙</option>
                      <option>张家界</option>
                      <option>广州</option>
                      <option>深圳</option>
                      <option>珠海</option>
                      <option>湛江</option>
                      <option>南宁</option>
                      <option>桂林</option>
                      <option>三亚</option>
                      <option>海口</option>
                      <option>重庆</option>
                      <option>成都</option>
                      <option>贵阳</option>
                      <option>昆明</option>
                      <option>新疆</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <select id="updateEndAirport" v-model="endAirport" class="form-control" name="endAirport">
                      <option>北京</option>
                      <option>天津</option>
                      <option>石家庄</option>
                      <option>邯郸</option>
                      <option>唐山</option>
                      <option>秦皇岛</option>
                      <option>张家口</option>
                      <option>太原</option>
                      <option>运城</option>
                      <option>呼和浩特</option>
                      <option>包头</option>
                      <option>鄂尔多斯</option>
                      <option>海拉尔</option>
                      <option>赤峰</option>
                      <option>通辽</option>
                      <option>满洲里</option>
                      <option>大连</option>
                      <option>沈阳</option>
                      <option>长春</option>
                      <option>哈尔滨</option>
                      <option>南京</option>
                      <option>无锡</option>
                      <option>连云港</option>
                      <option>杭州</option>
                      <option>温州</option>
                      <option>合肥</option>
                      <option>厦门</option>
                      <option>福州</option>
                      <option>南昌</option>
                      <option>青岛</option>
                      <option>烟台</option>
                      <option>郑州</option>
                      <option>洛阳</option>
                      <option>长沙</option>
                      <option>张家界</option>
                      <option>广州</option>
                      <option>深圳</option>
                      <option>珠海</option>
                      <option>湛江</option>
                      <option>南宁</option>
                      <option>桂林</option>
                      <option>三亚</option>
                      <option>海口</option>
                      <option>重庆</option>
                      <option>成都</option>
                      <option>贵阳</option>
                      <option>昆明</option>
                      <option>新疆</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <input id="updateFirstClassAmount" name="updateFirstClassAmount" v-model="firstClassAmount" type="text" class="form-control" placeholder="请输入头等舱票数">
                  </div>
                  <div class="form-group">
                    <input id="updateBusinessClassAmount" name="updateBusinessClassAmount" v-model="businessClassAmount" type="text" class="form-control" placeholder="请输入商务舱票数">
                  </div>
                  <div class="form-group">
                    <input id="updateEconomyClassAmount" name="updateEconomyClassAmount" v-model="economyClassAmount" type="text" class="form-control" placeholder="请输入经济舱票数">
                  </div>
                  <div class="form-group">
                    <input id="updateFirstClassPrice" name="updateFirstClassPrice" v-model="firstClassPrice" type="text" class="form-control" placeholder="请输入头等舱价格">
                  </div>
                  <div class="form-group">
                    <input id="updateBusinessClassPrice" name="updateBusinessClassPrice" v-model="businessClassPrice" type="text" class="form-control" placeholder="请输入商务舱价格">
                  </div>
                  <div class="form-group">
                    <input id="updateEconomyClassPrice" name="updateEconomyClassAmount" v-model="economyClassPrice" type="text" class="form-control" placeholder="请输入经济舱价格">
                  </div>
                  <div class="form-group">
                    <input id="updateStatus" name="updateStatus" v-model="status" type="text" class="form-control" placeholder="请输入航班状态">
                  </div>
                  <button id="updateSubmit" @click="updateSubmit" type="submit" class="btn btn-primary block full-width m-b">提 交</button>

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
        arrayData:[],
        //更新列表显示
        updateinfo:false,
        //增加列表显示
        addFlight:false,
        keyword:'',
        //数据信息
        flightNo:'',
        startAirport:'',
        endAirport:'',
        startTime:'',
        arrivalTime:'',
        firstClassAmount:'',
        businessClassAmount:'',
        economyClassAmount:'',
        firstClassPrice:'',
        businessClassPrice:'',
        economyClassPrice:'',
        status:''
      }
    },
    methods:{
      //error: handle is undefined
      //记得把写的方法全给实现了，不然煞笔不给你过！！！！
      updateFlights:function (evt) {
        evt.preventDefault();

        this.updateinfo = true;
      },
      deleteFlights:function (index) {

        let choose = confirm("是否删除？");
        if(choose == true) {
          this.$axios.post('http://localhost:8080/api/deleteByFlightId',qs.stringify({
            flightID:this.arrayData[index].id,
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
      updateSubmit:function (evt) {
        evt.preventDefault();

        this.$axios.post('http://localhost:8080/api/updateFlight',qs.stringify({
          flightID: this.arrayData[0].id,
          flightNo: this.flightNo,
          startTime: this.startTime,
          startAirport: this.startAirport,
          arrivalTime: this.arrivalTime,
          endAirport: this.endAirport,
          firstClassAmount: this.firstClassAmount,
          businessClassAmount: this.businessClassAmount,
          economyClassAmount: this.economyClassAmount,
          firstClassPrice:this.firstClassPrice,
          businessClassPrice:this.businessClassPrice,
          economyClassPrice:this.economyClassPrice,
          status: this.status
        })).then(res=>{
          if(res.data === 'successful'){
            alert("更新成功");
            this.search();
            this.updateinfo = false;
          }else {
            alert("更新失败");
          }
        }).catch(error=>{
          console.log(error);
        })
      },
      addFlights:function (evt) {
        evt.preventDefault();

        this.addFlight = true;
      },
      addSubmit:function (evt) {
        evt.preventDefault();

        this.$axios.post('http://localhost:8080/api/addFlight',qs.stringify({
          flightNo: this.flightNo,
          startTime: this.startTime,
          startAirport: this.startAirport,
          arrivalTime: this.arrivalTime,
          endAirport: this.endAirport,
          firstClassAmount: this.firstClassAmount,
          businessClassAmount: this.businessClassAmount,
          economyClassAmount: this.economyClassAmount,
          firstClassPrice:this.firstClassPrice,
          businessClassPrice:this.businessClassPrice,
          economyClassPrice:this.economyClassPrice,
          status: this.status
        })).then(res=>{
          if(res.data === 'successful'){
            alert("添加成功");
            this.search(evt);
            this.addFlight = false;
          }else {
            alert('添加失败');
          }
        }).catch(error=>{
          console.log(error);
        })
      },
      search:function () {

        this.$axios.get('http://localhost:8080/api/searchByFlightKeyword',{
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

        this.$axios.get('http://localhost:8080/api/searchAllFlights').then(res=>{
          this.arrayData = res.data;
        }).catch(error=>{
          console.log(error);
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
