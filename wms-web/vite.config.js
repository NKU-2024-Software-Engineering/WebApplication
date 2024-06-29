import {fileURLToPath, URL} from 'node:url'
import path from 'path'
import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import Icons from 'unplugin-icons/vite'
import IconsResolver from 'unplugin-icons/resolver'

const pathSrc = path.resolve(__dirname, 'src')

// module.exports = {
//   pages:{
//     index:{
//       entry:'src/main.js',
//       template:'index.html',
//       filename:'index.html'
//     },
//     backend:{
//       entry:'src/pages/backend/main.js',
//       template:'backend.html',
//       filename:'backend.html'
//     },
//     frontend:{
//       entry:'src/pages/frontend/main.js',
//       template:'frontend.html',
//       filename:'frontend.html'
//     }
//   }
// }

// https://vitejs.dev/config/
export default defineConfig({
    // root: './pages',
    // base: '/',
    // define: {},

    plugins: [
        vue(),
        AutoImport({
          imports: ['vue'],
          resolvers: [ElementPlusResolver(),
            IconsResolver({
          prefix: 'Icon',
        }),],
        dts: path.resolve(pathSrc, 'auto-imports.d.ts'),
    }),

    Components({
      resolvers: [ElementPlusResolver(),       
        IconsResolver({
          enabledCollections: ['ep'],
        }),],
    }),
    Icons({
      autoInstall: true,
    }),
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        }
    },
    server:{
      port:8091,
    },
    build:{
      rollupOptions:{
        //配置多页面
        input: {
          index: path.resolve(__dirname,'index.html'),
          // frontend: path.resolve(__dirname,'frontend.html'),
          //backend: path.resolve(__dirname,'backend.html')
        }
      }
    }
})



