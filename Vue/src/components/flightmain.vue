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

  <main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img class="first-slide" src="../../static/image/bg_img.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption text-right">
              <h1>一次旅行，流连忘返</h1>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <img class="second-slide" src="../../static/image/mainimg3.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>世界离你很近</h1>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <img class="third-slide" src="../../static/image/mainimg4.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption text-right">
              <h1>万般享受，尽在此刻</h1>
            </div>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 order-md-2">
          <h2 class="featurette-heading">随心所欲，想去就去
            <br><span class="text-muted">领略祖国大好河山</span></h2>
        </div>
        <div class="col-md-5 order-md-1">
          <img class="featurette-image img-fluid mx-auto"  alt="500x500" style="width: 500px; height: 500px;" src="../../static/image/mainimg1.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">世界旅行，说走就走
            <br><span class="text-muted">距离因我们不再是问题</span></h2>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-fluid mx-auto"  alt="500x500" style="width: 500px; height: 500px;" src="../../static/image/mainimg2.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">公司未来的发展 <br><span class="text-muted">需要您和我们共同努力</span></h2>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-fluid mx-auto"   style="width: 500px; height: 500px;" src="../../static/image/timg.jpg" data-holder-rendered="true">
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->

    </div><!-- /.container -->


    <!-- FOOTER -->
    <footer class="container">
      <p class="float-right"><a href="#">Back to top</a></p>
      <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
    </footer>
  </main>
  </div>
</template>

<script>
export default {
  name: 'flightmain',
  computed:{
    isLogin:function () {
      return this.$store.getters.getIsLogin;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import "../../static/css/bootstrap.css";
  @import "../../static/css/carousel.css";
</style>
