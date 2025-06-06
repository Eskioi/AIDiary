import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';
import SelectionPage from '@/views/SelectionPage.vue';
import LoginPage from '@/views/LoginPage.vue';
import UserPage from '@/views/UserPage.vue';
import BrowsePage from '@/views/BrowsePage.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage,
  },
  {
    path: '/Selection',
    name: 'article_selection',
    component: SelectionPage,
  },
  {
    path: '/User',
    name: 'user',
    component: UserPage,
  },
    {
    path: '/Browse',
    name: 'browse',
    component: BrowsePage,
  },
  {
    path: '/Login',
    name: 'login_page',
    component: LoginPage,
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/',
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;