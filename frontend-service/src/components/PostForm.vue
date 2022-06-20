<template>
        <form @submit.prevent>
            <h4>Create post</h4>
            <custom-input v-focus v-model="post.title" type="text" placeholder="Title"/>
            <custom-input v-model="post.body" type="text" placeholder="Description"/>
            <custom-button 
                style="align-self: flex-end"
                @click="createPost">Add new post</custom-button>
        </form>
</template>

<script>
export default {
    data() {
        return {
            post: {
                title: '',
                body: ''
            } 
        }
    },
    methods:{
        createPost() {
            this.post.id = Date.now()
            this.$emit('create', this.post)
            this.post = {
                title: '',
                body: ''
            }
        }
    }
} 
</script>

<style scoped>
.form {
    display: flex;
    flex-direction: column;
}
</style>