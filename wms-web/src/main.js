import {createApp} from 'vue'
import App from './App.vue'
import './assets/global.css'
import axios from 'axios';
import VueAxios from 'vue-axios'
import router from './router'
axios.defaults.baseURL = 'http://localhost:8090';


const app = createApp(App)
app.use(VueAxios,axios);
app.use(router);
app.mount('#app')
