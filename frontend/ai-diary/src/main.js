import { createApp } from 'vue';
import App from './App.vue';
import router from './components/router';
import '@fortawesome/fontawesome-free/css/all.css';

const app = createApp(App);

app.use(router);
app.mount('#app');
