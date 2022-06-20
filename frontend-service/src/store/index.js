import { createStore } from "vuex"
import { postModule } from "./postModule"

export default createStore({
    // I can yse it for Auth logic
    //state: { 
    //    isAuth: false
    //}
    modules: {
        post: postModule  
    }
})