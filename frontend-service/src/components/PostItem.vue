<template>
    <div class="post-item">
        <div>
            <div><strong>Post  ID: </strong>{{ post.id }}</div>
            <div><strong>Title: </strong> {{post.title}}</div>    
            <div><strong>Description: </strong> {{post.body}}</div>
        </div> 
        <div class="post__btns">
            <custom-button @click="$router.push(`/posts/${post.id}`)">Open post</custom-button>
            <custom-button style="color:red; border: 1px solid red;" @click="$emit('remove', post)">Delete post</custom-button>
        </div>
    </div>
</template>

<script>
export default {
    props: {
       post: {
           type: Object,
           required: true 
       }
   }
}
</script>

<style scoped>
.post-item {
    padding: 15px;
    border: 2px solid teal;
    background: white;
    margin-top: 15px;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.post__btns {
    display: flex;
}
</style>