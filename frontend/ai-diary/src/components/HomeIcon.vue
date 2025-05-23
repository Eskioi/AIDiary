<template>
  <router-link
    v-if="$route.path !== '/'"
    to="/"
    class="home-icon"
    aria-label="Go to homepage"
  >
    <svg
      xmlns="http://www.w3.org/2000/svg"
      class="icon"
      viewBox="0 0 24 24"
      fill="currentColor"
    >
      <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />
    </svg>
  </router-link>
</template>

<script>
export default {
  name: 'HomeIcon',
};
</script>

<style scoped>
.home-icon {
  position: fixed;
  top: 3.5vh;
  left: 2vw;
  z-index: 1000;
  transition: transform 0.2s ease;
}

.home-icon:hover {
  transform: scale(1.1);
}

.icon {
  width: 28px;
  height: 28px;
  color: #333;
}
</style>
