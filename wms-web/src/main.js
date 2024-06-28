import {createApp} from 'vue'
import App from './App.vue'
import './assets/global.css'
import axios from 'axios';
import VueAxios from 'vue-axios'
import router from './router'

import components from './components/components';
import backcomponents from './components/backcomponents';
import frontcomponents from './components/frontcomponents';

axios.defaults.baseURL = 'http://localhost:8090';




const app = createApp(App)



app.use(VueAxios,axios);
app.use(router);
app.use(components);
app.use(backcomponents);
app.use(frontcomponents);
app.mount('#app')
