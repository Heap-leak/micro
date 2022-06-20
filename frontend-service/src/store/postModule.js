import axios from "axios";

export const postModule = {

    state: () => ({
        posts: [],
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
        ]
    }),

    getters: {
        //will create new array (from source) and return new sorted array
        sortedPosts(state) {
            return [...state.posts].sort((post1, post2) => post1[state.selectedSort]?.localeCompare(post2[state.selectedSort]))
        },
        sortedAndSearchedPosts(state, getters) {
            return getters.sortedPosts.filter(post => post.title.toLowerCase().includes(state.searchQuery.toLowerCase()))
        }
    },

    mutations: {
        setPosts(state, posts) {
            state.posts = posts;
        },
        setLoading(state, bool) {
            state.isPostsLoading = bool;
        },
        setSelectedSort(state, selectedSort){
            state.selectedSort = selectedSort;
        },
        setSearchQuery(state, searchQuery){
            state.searchQuery = searchQuery;
        },
        setPage(state, page){
            state.page = page;
        },
        setTotalPages(state, totalPages){
            state.totalPages = totalPages;
        }        
    },

    actions: {
        async fetchPosts({state, commit}) {
            try {
                commit('setLoading', true);
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts', {
                    params: {
                        _page: state.page,
                        _limit: state.postsLimit
                    }
                }); //mock rest api
                commit('setTotalPages', Math.ceil(response.headers['x-total-count'] / state.postsLimit))
                commit('setPosts', response.data);
                
            } catch (error) {
                console.log(error)
            } finally {
                commit('setLoading', false);
            }
        },
        async loadMorePosts({state, commit}) {
            try {
                commit('setPage', state.page + 1)
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts', {
                    params: {
                        _page: state.page,
                        _limit: state.postsLimit
                    }
                }); //mock rest api
                commit('setTotalPages', Math.ceil(response.headers['x-total-count'] / state.postsLimit))
                commit('setPosts', [...state.posts, ...response.data]);
                
            } catch (error) {
                console.log(error)
            } 
        },
    },
    namespaced: true
}