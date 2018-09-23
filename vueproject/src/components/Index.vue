<template>
  <div id="app">
    <el-container>
      <el-header class="header">
        <el-row>
          <el-col :span="4">
            <h2 class="headerLogoTxt">测试系统</h2>
          </el-col>
          <el-col :span="16">
            <el-menu class="headerNav" mode="horizontal" background-color="#434A50" text-color="#fff"
                     default-active="/"
                     :router="menuEnableRouter"
                     active-text-color="#ffd04b">
              <el-menu-item index="/">数据表格</el-menu-item>
              <el-menu-item index="/Tree">树结构</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="4">
            <span class="welcomeTxt">欢迎你：{{ username }}</span>
          </el-col>
        </el-row>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        username: '吴庆周',
        menuEnableRouter: true
      }
    },
    watch: {
      '$route'(to, from) {  // 监听路由变化
        console.log("route 改变了, from:" + from.path + " to: " + to.path);
      }
    },
    mounted: function(){
    }
  }
</script>

<style scoped>
  .header {
    height: 100%;
    line-height: 60px;
    background-color: #434a50;
  }

  .headerLogoTxt {
    color: #fff;
    margin: 0;
  }

  .headerNav {
    width: 100%;
  }

  .welcomeTxt {
    color: #ffd04b;
  }
</style>
