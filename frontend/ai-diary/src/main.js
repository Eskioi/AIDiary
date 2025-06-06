import { createApp } from 'vue';
import { createPinia } from 'pinia';
import App from './App.vue';
import router from './components/router';
import '@fortawesome/fontawesome-free/css/all.css';

const app = createApp(App);
const pinia = createPinia();

app.use(router);
app.use(pinia);
app.mount('#app');
