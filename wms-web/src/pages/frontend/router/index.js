import { createRouter,createWebHistory } from "vue-router";

const routes = [
  {
    path: '/frontend',
    name:'frontend',
    component: () => import('../App.vue'),  // 登录
  }
]

const router = createRouter({
  history: createWebHistory(), // 路由类型
  routes // short for `routes: routes`
})
export default router
