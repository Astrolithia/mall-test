// import {fileURLToPath, URL} from 'node:url'

// import {defineConfig} from 'vite'
// import vue from '@vitejs/plugin-vue'
// import vueDevTools from 'vite-plugin-vue-devtools'

// // https://vite.dev/config/
// export default defineConfig({
//     plugins: [
//         vue(),
//         vueDevTools(),
//     ],
//     resolve: {
//         alias: {
//             '@': fileURLToPath(new URL('./src', import.meta.url))
//         },
//     },
//     server: {
//         proxy: {
//             '/api': { // 获取路径中包含了/api的请求
//                 target: 'http://localhost:8080', // 后台服务所在的源
//                 changeOrigin: true,
//                 rewrite: (path) => path.replace(/^\/api/, ''),
//             },
//         },
//     },
// });
import {fileURLToPath, URL} from 'node:url'
import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

export default defineConfig({
    plugins: [
        vue(),
        vueDevTools(),
    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        },
    },
    server: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                secure: false,
                rewrite: (path) => path.replace(/^\/api/, ''),
                configure: (proxy, options) => {
                    proxy.on('error', (err, req, res) => {
                        console.log('proxy error', err)
                    })
                    proxy.on('proxyReq', (proxyReq, req, res) => {
                        console.log('Proxy Request:', {
                            path: proxyReq.path,
                            method: proxyReq.method,
                            headers: proxyReq.getHeaders()
                        })
                    })
                    proxy.on('proxyRes', (proxyRes, req, res) => {
                        console.log('Proxy Response:', {
                            status: proxyRes.statusCode,
                            headers: proxyRes.headers
                        })
                    })
                }
            },
        },
    },
})