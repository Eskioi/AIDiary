<template>
  <nav :class="['navbar', { 'navbar-collapsed': !isMenuOpen }]" @mouseenter="openMenu" @mouseleave="closeMenu">
    <div class="navbar-container">
      <!-- Top Section with Home Icon and Links -->
      <div class="navbar-top">
        <!-- Google Home Icon -->
        <router-link to="/" class="home-icon" @click="closeMenu">
          <span class="material-icons">home</span>
        </router-link>
        
        <!-- Navigation Links -->
        <ul :class="['nav-links', { 'nav-active': isMenuOpen }]">
          <li><router-link to="/Selection" @click="closeMenu">Article selection</router-link></li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "AppNavbar",
  data() {
    return {
      isMenuOpen: false,
    };
  },
  methods: {
    openMenu() {
      this.isMenuOpen = true;
    },
    closeMenu() {
      this.isMenuOpen = false;
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/icon?family=Material+Icons');

.navbar {
  background-color: #808080;
  position: fixed;
  height: 100%;
  top: 0;
  overflow: hidden;
  width: 5%;
  transition: width 0.3s ease;
}

.navbar-collapsed {
  width: 5rem;
}

.navbar:not(.navbar-collapsed) {
  width: 15%;
}

.navbar-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 1rem;
}

.navbar-top {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.home-icon .material-icons {
  font-size: 2rem;
  color: #333;
  margin-bottom: 1rem;
  border-radius: 8px;
  padding: 0.5rem;
  transition: background-color 0.2s ease, padding 0.2s ease;
}

.home-icon:hover .material-icons {
  background-color: #b0b0b0;
  border-radius: 8px;
  padding: 0.5rem;
}

.nav-links {
  list-style: none;
  opacity: 0;
  max-height: 0;
  transition: opacity 0.3s ease, max-height 0.3s ease;
  gap: 1rem;
}

.nav-links.nav-active {
  opacity: 1;
  max-height: 500px;
}

.nav-links li {
  text-align: left;
  padding: 0.5rem 0;
}

.nav-links a {
  text-decoration: none;
  color: #333;
  font-weight: 500;
  padding: 0.5rem;
  border-radius: 8px;
  white-space: nowrap;
  transition: background-color 0.2s ease, padding 0.2s ease;
}

.nav-links a:hover {
  background-color: #b0b0b0;
  border-radius: 8px;
  padding: 0.75rem;
}
</style>

<!-- Let me know if you want me to tweak anything else! -->