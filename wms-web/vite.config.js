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

// https://vitejs.dev/config/
export default defineConfig({
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
    // build:{
    //   rollupOptions:{
    //     //配置多页面
    //     input:{
    //       login: './login.html',
    //       backend: './backend.html',
    //     }
    //   }
    // }
})



