import {createRouter, createWebHashHistory} from "vue-router";

const routes = [
    {
        path: '',
        component: () => import('../view/Main.vue'),
        children: [
            {
                path: '',
                redirect: 'dashboard'
            },
            {
                path: 'dashboard',
                component: () => import('../view/main/Dashboard.vue')
            },
            {
                path: 'clients',
                component: () => import('../view/main/Clients.vue')
            },
            {
                path: 'server',
                component: () => import('../view/main/Server.vue')
            },
            {
                path: 'properties',
                component: () => import('../view/main/Properties.vue')
            }
        ],
        meta: {needLogin: true}
    },
    {
        path: '/login',
        component: () => import('../view/Login.vue')
    },
    {
        path: '/:pathMatch(.*)*',
        component: () => import('../view/NotFound.vue')
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router