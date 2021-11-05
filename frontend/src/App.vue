<template>
  <v-app id="app">
    <div id="nav">
      <Navbar/>
    </div>
    <router-view/>
  </v-app>
</template>
<script>
import Navbar from './components/Navbar.vue';

export default {
  components: {
    Navbar,
  },
};
</script>

<style>
</style>
