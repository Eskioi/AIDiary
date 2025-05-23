<template>
  <div id="app">
    <AppNavbar />
    <router-view />
  </div>
</template>

<script>
import AppNavbar from '@/layout/AppNavbar.vue';

export default {
  name: 'App',
  components: {
    AppNavbar,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 60px;
}
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

</style>