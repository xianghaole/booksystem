import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManager from '../views/BookManager.vue'
import Index from '../views/Index.vue'
import AddBook from '../views/AddBook.vue'
import UpdateBook from '../views/UpdateVue.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '图书管理',
    component: Index,
    redirect:'/BookManager',
    children:[
        {   show:true,
            path: '/BookManager',
            name: '查询图书',
            component: BookManager
        },
        {   show:true,
            path: '/AddBook',
            name: '添加图书',
            component: AddBook
        }
        ,
        {   show:false,
            path:'/UpdateBook',
            name:'更新页面',
            component:UpdateBook
        }
    ]
  }

]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
