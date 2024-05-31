import { createRouter,createWebHistory } from "vue-router";

const routes = [
  {
    path: '/',
    name:'Login',
    component: () => import('../components/Login.vue')  // 登录组件
  },
  {
    path: '/backend',
    name: 'backend',
    component: () => import('../components/Index.vue')  // 后台
  }
]

const router = createRouter({
  history: createWebHistory(), // 路由类型
  routes // short for `routes: routes`
})
export default router
