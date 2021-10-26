import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from '../views/Main.vue';
import Login from '../views/Login.vue';
import MyPage from '../views/MyPage.vue';
import Resume from '../views/Resume.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
  },
  {
    path: '/resume',
    name: 'Resume',
    component: Resume,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
