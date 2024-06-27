import { createRouter,createWebHistory } from "vue-router";

const routes = [
  {
    path: '/backend',
    name:'backend',
    component: () => import('../components/Login.vue'),  // 登录
  },
  {
    path: '/backend/manage',
    name:'manage',
    component: () => import('../components/Index.vue'),  // 后台
    children:[
      {
        path:'',
        name:'umanage',
        component: () => import('../components/Main.vue'),  // 管理用户
      },
      {
        path: 'j',
        name:'jmanage',
        component: () => import('../components/Jmanage.vue'),  // 管理求职者
      },
      {
        path: 'h',
        name:'hmanage',
        component: () => import('../components/Hmanage.vue'),  // 管理HR
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(), // 路由类型
  routes // short for `routes: routes`
})
export default router
