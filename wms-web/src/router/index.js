import { createRouter,createWebHistory } from "vue-router";

const routes = [
  {
    path: '/backend',
    name:'backend',
    component: () => import('../views/backend/Login.vue'),  // 登录
  },
  {
    path: '/backend/manage',
    name:'manage',
    component: () => import('../views/backend/Index.vue'),  // 后台
    children:[
      {
        path:'',
        name:'umanage',
        component: () => import('../components/backend/Main.vue'),  // 管理用户
      },
      {
        path: 'j',
        name:'jmanage',
        component: () => import('../components/backend/Jmanage.vue'),  // 管理求职者
      },
      {
        path: 'h',
        name:'hmanage',
        component: () => import('../components/backend/Hmanage.vue'),  // 管理HR
      }
    ]
  },
  {
    path: '/',
    name: '404',
    component: () => import('../components/common/404.vue'),  // 登录
  },
  {
    path: '/frontend',
    name: 'frontend',
    component: () => import('../views/frontend/Login.vue'),  // 前台登录
  },
  {
    path: '/main',
    name: 'main',
    component: () => import('../views/frontend/Index.vue'),  // 登录
  },
  {
    path: '/reg',
    name: 'reg',
    component: () => import('../views/frontend/Reg.vue'),  // 登录
  }
]

const router = createRouter({
  history: createWebHistory(), // 路由类型
  routes // short for `routes: routes`
})
export default router
