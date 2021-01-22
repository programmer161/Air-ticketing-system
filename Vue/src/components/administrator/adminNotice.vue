<template>
  <div class="sidebar-fixed header-fixed">
    <div class="page-wrapper">
      <nav class="navbar page-header">


        <div class="navbar-brand">
          <p>安航后台管理系统</p>
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

              <a href="#" class="dropdown-item">
                <i class="fa fa-envelope"></i> Messages
              </a>

              <div class="dropdown-header">Settings</div>

              <a href="#" class="dropdown-item">
                <i class="fa fa-bell"></i> Notifications
              </a>

              <a href="#" class="dropdown-item">
                <i class="fa fa-wrench"></i> Settings
              </a>

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

              <li class="nav-item">
                <router-link to="/adminnotice" class="nav-link">
                  <i class="icon icon-puzzle"></i> 公告信息
                </router-link>
              </li>

            </ul>
          </nav>
        </div>

        <div class="content">
          <div class="container-fluid">
            <div class="row">

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
    export default {
        name: "adminNotice"
    }
</script>

<style scoped>
  @import "../../../static/css/simple-line-icons/css/simple-line-icons.css";
  @import "../../../static/css/font-awesome/css/fontawesome-all.min.css";
  @import "../../../static/css/font-awesome/styles.css";
</style>
