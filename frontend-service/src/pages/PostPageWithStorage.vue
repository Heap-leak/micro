<template>
    <div>
        <h1>Posts page</h1>
        <custom-input 
        v-focus 
        :model-value="searchQuery"
        @update:model-value="setSearchQuery"
        placeholder="Search ..."
        ></custom-input>
        <div class="app__buttons">
            <custom-button @click="showDialog">New post</custom-button>
            <custom-select 
                :model-value="selectedSort"
                @update:model-value="setSelectedSort"
                :options="sortOptions"
            >
            </custom-select>
        </div>

        <custom-dialog 
          v-model:show="dialogVisible"
        >
            <post-form @create="createPost"/>
        </custom-dialog>
        
        <post-list 
            :posts="sortedAndSearchedPosts"
            @remove="removePost"
            v-if="!isPostsLoading"
        />
        <div v-else> Posts loading in progress...</div>
        <div v-intersection="loadMorePosts" class="observer"></div>
    </div>
</template>

<script>
import PostForm from '@/components/PostForm.vue';
import PostList from '@/components/PostList.vue';
import {mapState, mapGetters, mapActions, mapMutations} from 'vuex'
export default {
    components: {
        PostForm, PostList
    },
     data() {
        return {
            dialogVisible: false            
        }
    },
    methods: {
        ...mapMutations({
          setPage: 'post/setPage',
          setSearchQuery: 'post/setSearchQuery',
          setSelectedSort: 'post/setSelectedSort'
        }),
        ...mapActions({
          loadMorePosts: 'post/loadMorePosts',
          fetchPosts: 'post/fetchPosts'          
        }),
        createPost (post) {
            console.log(post)
            this.posts.push(post);
            this.dialogVisible = false;
        },
        removePost(post) {
            this.posts = this.posts.filter(p => p.id !== post.id);
        },
        showDialog() {
            this.dialogVisible = true;
        }
    },
    mounted() {
      this.fetchPosts();
    },
    computed: {
        ...mapState({
          posts: state => state.post.posts,
          isPostsLoading: state => state.post.isPostsLoading,
          selectedSort: state => state.post.selectedSort,
          searchQuery: state => state.post.searchQuery,
          page: state => state.post.page,
          postsLimit: state => state.post.postsLimit,
          totalPages: state => state.post.totalPages,
          sortOptions:  state => state.post.sortOptions
        }),
        ...mapGetters({
          sortedPosts: 'post/sortedPosts',
          sortedAndSearchedPosts: 'post/sortedAndSearchedPosts'
        })
    },
    watch: {
        /* page() {
             this.fetchPosts()
        } */
        //source array changed
        //selectedSort( newValue ) {
        //    this.posts.sort((post1, post2) => {
               //return post1[this.selectedSort]?.localeCompare(post2[this.selectedSort])
        //       return post1[newValue]?.localeCompare(post2[newValue])
        //    })
        //}
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