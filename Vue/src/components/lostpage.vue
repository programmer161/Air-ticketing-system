<template>
    <div class="middle-box text-center animated fadeInDown">
      <h1>404</h1>
      <h3 class="font-bold">页面未找到！</h3>

      <div class="error-desc">
        抱歉，页面好像去火星了~
        <form class="form-inline m-t" role="form">
          <div class="form-group">
            <input type="email" class="form-control" placeholder="请输入您需要查找的内容 …">
          </div>
          <button type="submit" class="btn btn-primary">搜索</button>
        </form>
      </div>
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p> ZiGeng_Huang Graduation design works · <a href="#">Github</a> · <a href="#">Gitee</a></p>
      </footer>
    </div>
</template>

<script>
  export default {
    name: '404',
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import "../../static/css/bootstrap.min.css";
  @import "../../static/css/font-awesome.css";
  @import "../../static/css/animate.css";
  @import "../../static/css/style.css";
</style>
