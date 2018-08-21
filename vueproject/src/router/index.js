import Vue from 'vue'
import Router from 'vue-router'
import DataTable from '@/components/dataTable/DataTable'
import Tree from '@/components/tree/Tree'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: DataTable
    },
    {
      path: '/Tree',
      component: Tree
    }
  ]
})
