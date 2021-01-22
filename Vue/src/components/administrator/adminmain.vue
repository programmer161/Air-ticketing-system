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
              <i class="fa fa-lock"></i> 退出
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

            <li class="nav-item">
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
            <div class="col-md-3">
              <div class="card p-4">
                <div class="card-body d-flex justify-content-between align-items-center">
                  <div>
                    <span class="h4 d-block font-weight-normal mb-2">2,000,000,000</span>
                    <span class="font-weight-light">客户总数</span>
                  </div>

                  <div class="h2 text-muted">
                    <i class="icon icon-people"></i>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-3">
              <div class="card p-4">
                <div class="card-body d-flex justify-content-between align-items-center">
                  <div>
                    <span class="h4 d-block font-weight-normal mb-2">¥302,600</span>
                    <span class="font-weight-light">今日收入</span>
                  </div>

                  <div class="h2 text-muted">
                    <i class="icon icon-wallet"></i>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-3">
              <div class="card p-4">
                <div class="card-body d-flex justify-content-between align-items-center">
                  <div>
                    <span class="h4 d-block font-weight-normal mb-2">¥7,052,450</span>
                    <span class="font-weight-light">本月收入</span>
                  </div>

                  <div class="h2 text-muted">
                    <i class="icon icon-wallet"></i>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-3">
              <div class="card p-4">
                <div class="card-body d-flex justify-content-between align-items-center">
                  <div>
                    <span class="h4 d-block font-weight-normal mb-2">¥8,056,302,600</span>
                    <span class="font-weight-light">年度收入</span>
                  </div>

                  <div class="h2 text-muted">
                    <i class="icon icon-wallet"></i>
                  </div>
                </div>
              </div>
            </div>

          </div>

          <div class="row ">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header">
                  客户增长
                </div>

                <div class="card-body p-0">
                  <div class="p-5">
                    <p class="small">单位：千万</p>
                    <canvas id="linechart" width="100%" height="20"></canvas>
                  </div>
                </div>
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
</div>
</template>

<script>
    export default {
        name: "adminmain",
      mounted(){
          var lineChart = document.getElementById("linechart");

          var linechart = new Chart(lineChart,{
            type: 'line',
            data: {
              labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
              datasets: [{
                label: 'Users',
                data: [0.5, 3, 3, 4, 3, 2,1,1.5,0.7 ,0.7 ,0.4 ,0.2],
                backgroundColor: 'rgba(66, 165, 245, 0.5)',
                borderColor: '#2196F3',
                borderWidth: 1
              }]
            },
            options: {
              legend: {
                display: false
              },
              scales: {
                yAxes: [{
                  ticks: {
                    beginAtZero: true
                  }
                }]
              }
            }
          });
      }
    }
</script>

<style scoped>
  @import "../../../static/css/simple-line-icons/css/simple-line-icons.css";
  @import "../../../static/css/font-awesome/css/fontawesome-all.min.css";
  @import "../../../static/css/font-awesome/styles.css";
</style>
