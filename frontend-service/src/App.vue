<template>
  <!-- navbar/>
  <div class="app">
      <router-view></router-view>
  </div -->
  <div class="app">
    <custom-menu></custom-menu>
    <router-view></router-view>
  </div>

</template>

<script>
//import Navbar from './components/UI/Navbar.vue'
import CustomMenu from './components/UI/CustomMenu.vue'
export default {
  //components: { Navbar },
  components: { CustomMenu },

}
</script>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.app {
    padding: 28px;
}
</style>