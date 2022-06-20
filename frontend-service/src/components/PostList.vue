<template>
    <div v-if="posts.length > 0" class="posts-list">
        <h3>List of Posts</h3>
        <transition-group name="posts-list-tr">
            <post-item 
                v-for="post in posts" 
                :post="post" 
                :key="post.id"
                @remove="$emit('remove', post)"    
            />
        </transition-group>
    </div>
    <h2 v-else style="color: red; margin: 15px 0;"> 
        List of posts is empty
    </h2>
</template>

<script>
import PostItem from "@/components/PostItem";
export default {
  components: { PostItem },
   props: {
       posts: {
           type: Array,
           required: true 
       }
   }
}

</script>

<style scoped>
.posts-list {
    padding: 15px;
    border: 2px solid teal;
    margin-top: 15px;
    }

.posts-list-tr-item {
    display: inline-block;
    margin-right: 10px;
}

.posts-list-tr-enter-active,
.posts-list-tr-leave-active {
    transition: all 0.5s ease;
}

.posts-list-tr-enter-from,
.posts-list-tr-leave-to {
    opacity: 0;
    transform: translateX(130px);
}

.posts-list-tr-move {
  transition: transform 0.8s ease;
}

</style>