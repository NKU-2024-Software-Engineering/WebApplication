import {createApp} from 'vue'
import App from './App.vue'
import './assets/global.css'
import axios from 'axios';
import VueAxios from 'vue-axios'

axios.defaults.baseURL = 'http://localhost:8090';


const app = createApp(App)
app.use(VueAxios,axios);
app.mount('#app')
