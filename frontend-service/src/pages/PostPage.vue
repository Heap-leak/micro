<template>
    <div>
        <h1>Posts page</h1>
        <custom-input v-focus v-model="searchQuery" placeholder="Search ...">
        </custom-input>
        <div class="app__buttons">
            <custom-button @click="showDialog">New post</custom-button>
            <custom-select 
                v-model="selectedSort"
                :options="sortOptions"
            >
            </custom-select>
        </div>

        <custom-dialog v-model:show="dialogVisible">
            <post-form @create="createPost"/>
        </custom-dialog>
      
        <post-list 
            :posts="sortedAndSearchedPosts"
            @remove="removePost"
            v-if="!isPostsLoading"
        />
        
        <div v-else> Posts loading in progress...</div>
        <div v-intersection="loadMorePosts" class="observer"></div>
        <!-- <div class="page__wraper">
            <div 
                v-for="pageNumber in totalPages" 
                :key="pageNumber" 
                class="page"
                :class="{
                    'current-page': page === pageNumber ? true : false
                    }"
                @click="changePage(pageNumber)"
                > {{pageNumber}}
            </div>
        </div> -->
    </div>
</template>

<script>
import PostForm from '@/components/PostForm.vue';
import PostList from '@/components/PostList.vue';
import axios from 'axios';
import CustomMenu from '@/components/UI/CustomMenu.vue';
export default {
    components: {
    PostForm,
    PostList,
    CustomMenu
},
     data() {
        return {
            posts: [],
            dialogVisible: false,
            isPostsLoading: false,
            selectedSort: '',
            searchQuery: '',
            page: 1,
            postsLimit: 10,
            totalPages: 0,
            sortOptions:  [
                { value: 'title', name: 'Sort by name'},
                { value: 'body', name: 'Sort by description'}
                //add Sort by id
            ],
            
        }
    },
    methods: {
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
        },
        //changePage(pageNumber) {
        //    this.page = pageNumber
        //},
        async fetchPosts() {
            try {
                this.isPostsLoading = true;
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts', {
                    params: {
                        _page: this.page,
                        _limit: this.postsLimit
                    }
                }); //mock rest api
                this.totalPages = Math.ceil(response.headers['x-total-count'] / this.postsLimit)
                this.posts = response.data;
                
            } catch (error) {
                alert('Error!!!')
            } finally {
                this.isPostsLoading = false;
            }
        },
        async loadMorePosts() {
            try {
                this.page +=1
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts', {
                    params: {
                        _page: this.page,
                        _limit: this.postsLimit
                    }
                }); //mock rest api
                this.totalPages = Math.ceil(response.headers['x-total-count'] / this.postsLimit)
                this.posts = [... this.posts, ... response.data];
                
            } catch (error) {
                alert('Error!!!')
            } 
        },
    },
    mounted() {
        this.fetchPosts();
    },
    computed: {
        //will create new array (from source) and return new sorted array
        sortedPosts() {
            return [...this.posts].sort((post1, post2) => post1[this.selectedSort]?.localeCompare(post2[this.selectedSort]))
        },
        sortedAndSearchedPosts() {
            return this.sortedPosts.filter(post => post.title.toLowerCase().includes(this.searchQuery.toLowerCase()))
        }
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