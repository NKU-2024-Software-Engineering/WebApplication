import {createApp} from 'vue'
import App from './App.vue'

import '../../assets/global.css'

import Aside from './components/Aside.vue';
import Header from './components/Header.vue';
import Main from './components/Main.vue';

import axios from 'axios';
import VueAxios from 'vue-axios'
import router from './router'
axios.defaults.baseURL = 'http://localhost:8090';


const app = createApp(App)

app.component('Aside',Aside);
app.component('Header',Header);
app.component('Main',Main);
app.use(VueAxios,axios);
app.use(router);
app.mount('#app')
