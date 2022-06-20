import Main from "@/pages/Main"
import PostPage from "@/pages/PostPage"
import About from "@/pages/About"
import PostIdPage from "@/pages/PostIdPage"
import PostPageWithStorage from "@/pages/PostPageWithStorage"
import PostPageCompositionApi from "@/pages/PostPageCompositionApi"

import { createRouter, createWebHistory } from "vue-router"

const routes = [
    {
        path: "/",
        component: Main
    },
    {
        path: "/posts",
        component: PostPage
    },
    {
        path: "/about",
        component: About
    },
    {
        path: "/posts/:id",
        component: PostIdPage
    },
    {
        path: "/store",
        component: PostPageWithStorage
    },
    {
        path: "/compose",
        component: PostPageCompositionApi
    }
    
]

const router = createRouter({
    routes,
    history: createWebHistory(process.env.BASE_URL)
})

export default router;