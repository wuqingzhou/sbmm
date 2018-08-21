// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Index from './components/Index'
import App from './App'
import router from './router'
// import VueRouter from 'vue-router'
import ElementUI from 'element-ui'
// import CircularJSON from 'circular-json'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/common.css'

Vue.config.productionTip = false
Vue.use(ElementUI)
// Vue.use(VueRouter)
// Vue.use(CircularJSON)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {Index, App},
  template: '<Index/>'
})
