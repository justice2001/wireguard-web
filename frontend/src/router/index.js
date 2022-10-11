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
                path: 'clients/edit',
                component: () => import('../view/main/clients/Edit.vue')
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
        name: 'Login',
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

// { username: xxx, permission: 'admin', login_at: xxx, login: 1 }

router.beforeEach((to, from) => {
    console.log(to)
    let user = window.localStorage.getItem('user')
    if (to.meta.needLogin) {
        if (user === null) {
            return {name: 'Login'}
        }
        user = JSON.parse(user)
        // 检查用户状态
        if (!user.login)
            return {name: 'Login'}
    }
    return true
})

export default router