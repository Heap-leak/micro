<template>
  <div class="navbar">
    <div @click="$router.push('/')">Project "Micro"</div>
    <div class="navbar__btns">
      <custom-button @click="$router.push('/posts')"> Posts </custom-button>
      <custom-button @click="$router.push('/store')" style="margin-left: 20px"> Store </custom-button> 
      <custom-button @click="$router.push('/compose')" style="margin-left: 20px"> Composition Api </custom-button> 
      <custom-button @click="$router.push('/about')" style="margin-left: 20px"> About </custom-button>         
    </div>
  </div>

</template>

<script>
export default {
}
</script>

<style>
.navbar {
  height: 50px;
  background: lightgreen;
  box-shadow: 2px 2px 4px gray;
  display: flex;
  align-items: center;
  padding: 0 15px;
}

.navbar__btns {
  margin-left: auto;
}
</style>