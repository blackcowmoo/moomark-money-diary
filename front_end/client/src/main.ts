import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import VModal from 'vue-js-modal'

createApp(App).use(router).use(VModal).mount('#app');
