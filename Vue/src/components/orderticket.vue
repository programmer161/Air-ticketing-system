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

      <class class="gray-bg">

        <hr class="featurette-divider">

        <form class="form-horizontal" role="form" v-show="orderSearch">
        <div class="col-md-8">

          <div  class="form-group">
            <label class="col-sm-3 control-label">起飞城市</label>
            <div class="col-sm-9">
              <select id="startCity" v-model="startCity" class="form-control" name="startCity">
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
          </div>

          <div class="form-group">
            <label class="col-sm-3 control-label">降落城市</label>
            <div class="col-sm-9">
              <select id="endCity" v-model="endCity"  class="form-control" name="endCity">
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
          </div>

          <button id="searchFlight" @click="search" name="search" class="btn btn-primary" type="submit">搜 索</button>

          <div class="form-group" v-show="!searchResult">
            <div class="form-group">
              <div class="page-header">
                航班
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
                  <td><button id="toOrder" @click="toOrder(index)" name="toOrder" class="btn btn-primary" type="button">订 购</button></td>
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
          </div>

        </div>
        </form>


        <div class="col-sm-3" v-show="orderForm">
        <form  id="orderForm"  class="m-t" role="form" v-for="item in orderData">
          <div class="form-group">
            <span>航班号：{{item.flightNo}}</span>
          </div>
          <div class="form-group">
            <span>起飞城市：{{item.startAirport}}</span>
          </div>
          <div class="form-group">
            <span>降落城市：{{item.endAirport}}</span>
          </div>
          <div class="form-group">
            <span>起飞时间：{{item.startTime}}</span>
          </div>
          <div class="form-group">
            <span>降落时间：{{item.arrivalTime}}</span>
          </div>
          <div class="form-group">
          <span>状态：{{item.status}}</span>
        </div>
          <div class="form-group">
            <select id="selectClass" v-model="selectClass" class="form-control" name="selectClass">
              <option>头等舱</option>
              <option>商务舱</option>
              <option>经济舱</option>
            </select>
          </div>

          <div class="form-group">
            <input id="passengerName" name="passengerName" v-model="passengerName" type="text" class="form-control" placeholder="请输入乘客姓名">
          </div>
          <div class="form-group">
            <input id="IDCard" name="IDCard" v-model="IDCard" type="text" class="form-control" placeholder="请输入身份证号">
          </div>
          <div class="form-group">
            <input id="phoneNumber" name="phoneNumber" v-model="phoneNumber" type="text" class="form-control" placeholder="请输入手机号">
          </div>
          <button id="order" @click="order" type="submit" class="btn btn-primary block full-width m-b">订 购</button>

        </form>
        </div>


        <!-- FOOTER -->
          <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
          </footer>
      </class>
    </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "orderticket",
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
          orderData:[],
          searchResult:true,
          orderForm:false,
          orderSearch:true,
          //数据
          startCity:'',
          endCity:'',
          selectClass:'',
          arrivalTime:'',
          startTime:'',
          flightNo:'',
          price:'',
          passengerName:'',
          phoneNumber:'',
          IDCard:''
        }
      },
      methods:{
          search:function(evt){
            evt.preventDefault();

            this.$axios.get('http://localhost:8080/api/selectFlight',{
              params:{
                startCity:this.startCity,
                endCity:this.endCity
              }}).then(res=>{
                this.arrayData = res.data
            }).catch(error =>{
              console.log(error)
            })

            this.searchResult = false;
          },

        toOrder:function(index){

            if(this.$store.state.username){
              this.$axios.get('http://localhost:8080/api/forOrderSelect',{
                params:{
                  orderStartCity:this.arrayData[index].startAirport,
                  orderEndCity:this.arrayData[index].endAirport,
                  flightNo:this.arrayData[index].flightNo
                }
              }).then(res =>{
                this.orderData = res.data
                console.log(this.orderData)
              }).catch(error =>{
                console.log(error)
              })

              this.orderForm = true;
              this.orderSearch = false
            }
            else{
              alert("请先登录，再进行购票！");
              this.$router.push({name:'customerlogin'});
            }
        },

        order:function(evt){
          evt.preventDefault();

          //判断舱位价格
          let headPrice;
          console.log(this.selectClass);
          if(this.selectClass === '头等舱'){
            headPrice = this.orderData[0].firstClassPrice;
          }else if(this.selectClass === '商务舱'){
            headPrice = this.orderData[0].businessClassPrice;
          }else if(this.selectClass === '经济舱'){
            headPrice = this.orderData[0].economyClassPrice;
          }

          this.$axios.post('http://localhost:8080/api/order',qs.stringify({
            startCity:this.orderData[0].startAirport,
            endCity:this.orderData[0].endAirport,
            selectClass:this.selectClass,
            arrivalTime:this.orderData[0].arrivalTime,
            startTime:this.orderData[0].startTime,
            flightNo:this.orderData[0].flightNo,
            price:headPrice,
            passengerName:this.passengerName,
            phoneNumber:this.phoneNumber,
            IDCard:this.IDCard,
            status:this.orderData[0].status,
            id:this.orderData[0].id
          })).then(res =>{
            if(res.data === 'successful'){
              alert("订购成功!")
              this.$router.push({name:'orderticket'});
            }else {
              alert("订购失败！")
            }
          }).catch(error =>{
            console.log(error)
          })
        },

        showPage(pageIndex, $event, forceRefresh){

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
  @import "../../static/css/font-awesome.css";
  @import "../../static/css/animate.css";
  @import "../../static/css/style.css";
</style>
