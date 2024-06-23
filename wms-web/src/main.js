import {createApp} from 'vue'
import App from './App.vue'
import './assets/global.css'
// import axios from 'axios';
// import VueAxios from 'vue-axios'
// import router from './router'
// axios.defaults.baseURL = 'http://localhost:8090';

// import Aside from './pages/backend/components/Aside.vue';
// import Header from './pages/backend/components/Header.vue';
// import Main from './pages/backend/components/Main.vue';


const app = createApp(App)

// app.component('Aside',Aside);
// app.component('Header',Header);
// app.component('Main',Main);

// app.use(VueAxios,axios);
// app.use(router);
app.mount('#app')
