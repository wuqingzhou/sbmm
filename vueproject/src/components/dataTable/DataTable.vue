<template>
  <div>
    dddddddsdfffffffffffffffffff
    asdfsd
    f
    sdf


  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {}
    },
    mounted: function () {
      var url = "/api/tbUser/list";
      axios.get(url).then(function (res) {
        cosole.info(res);
      })
    }
  }
</script>

<style scoped>

</style>
