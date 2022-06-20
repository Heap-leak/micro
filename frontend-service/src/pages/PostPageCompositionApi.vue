<template>
    <div>
        <h1>Posts page</h1>
        <custom-input v-focus v-model="searchQuery" placeholder="Search ...">
        </custom-input>
        <div class="app__buttons">
            <custom-button>New post</custom-button>
            <custom-select 
                v-model="selectedSort"
                :options="sortOptions"
            >
            </custom-select>
        </div>

        <custom-dialog v-model:show="dialogVisible">
        </custom-dialog>
        
        <post-list 
            :posts="sortedAndSearchedPosts"
            v-if="!isPostsLoading"
        />
        <div v-else> Posts loading in progress...</div>
        <div v-intersection="loadMorePosts" class="observer"></div>
    </div>
</template>

<script>
import PostForm from '@/components/PostForm.vue';
import PostList from '@/components/PostList.vue';
export default {
    components: {
        PostForm, PostList 
    },
     data() {
        return {
            dialogVisible: false,
            sortOptions:  [
                { value: 'title', name: 'Sort by name'},
                { value: 'body', name: 'Sort by description'}
                //add Sort by id
            ]            
        }
    },
    setup(props) {
        
        const { posts, isPostsLoading, totalPages } = usePosts(10)
        const { selectedSort, sortedPosts}  = useSortedPosts(posts)
        const { searchQuery, sortedAndSearchedPosts } = useSortedAndSearchedPosts(sortedPosts)

        return {
            posts, 
            isPostsLoading, 
            totalPages , 
            selectedSort, 
            sortedPosts, 
            searchQuery, 
            sortedAndSearchedPosts
        }
    }
}
</script>

<style>


.app__buttons {
    margin: 15px 0;
    display: flex;
    justify-content: space-between;
}


.page__wraper{
    display: flex;
    margin: 15px;
}

.page {
    border: 1px solid black;
    padding: 10px;
}

.current-page {
    border: 2px solid green;
}

.observer {
    height: 30px;
    background: green;
}
</style>