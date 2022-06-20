import axios from "axios";
import {ref, onMounted} from 'vue'

export function usePosts(postsLimit) {
    const posts = ref([])
    const totalPages = ref(0)
    const isPostsLoading = ref(true)

    const fetching = async () => {
        try {
            const response = await axios.get('https://jsonplaceholder.typicode.com/posts', {
                params: {
                    _page: 1,
                    _limit: postsLimit.value
                }
            }); //mock rest api
            totalPages.value = Math.ceil(response.headers['x-total-count'] / postsLimit)
            posts.value = response.data;
            
        } catch (error) {
            alert('Error!!!')
        } finally {
            isPostsLoading.value = false;
        }
    }

    onMounted(fetching)

    return {
        posts, isPostsLoading, totalPages 
    }      
};