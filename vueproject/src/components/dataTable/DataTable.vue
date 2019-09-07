<template>
  <div>
    <el-button v-on:click="startBtn">启动</el-button>
    <div id="msgDiv">

    </div>


  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        rtime: '1567830119494',
        buscode: 'LOGIN_BUSSINESS_CODE',
        code: '000000'
      }
    },
    mounted: function () {
      var url = "/api/test/code";
      axios.defaults.withCredentials=true;
      axios.get(url).then(function (res) {
        console.info(res);
      })
    },
    methods: {
      startBtn (){
        var _this = this
        var timer = setTimeout(function () {
          _this.submitRequest()
        },1000)
      },
      submitRequest(){
        var code = "000000"
        axios.defaults.withCredentials=true;
        var url = "http://gzlss.hrssgz.gov.cn/gzlss_web/business/anon/LetterVistsSMSCode/checkValidateCode.xhtml?buscode=LOGIN_BUSSINESS_CODE&code="
        url += code + "&rtime=" + new Date().getTime()
        axios.get(url).then(function (res) {
          console.info("--------")
          console.info(res)
          console.info("")
        })
      }
    }
  }
</script>

<style scoped>

</style>
