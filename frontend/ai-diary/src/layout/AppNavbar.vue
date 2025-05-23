<template>
  <div>
    <button @click="toggleNavbar" class="hamburger-btn">
      <span class="line" v-for="i in 3" :key="i"></span>
    </button>

    <transition name="slide-fade">
      <nav v-if="showNavbar" class="navbar">
        <div class="navbar-top-container">
          <router-link to="/User" @click="toggleNavbar">
            <i class="fas fa-user"></i> Profile
          </router-link>
          <a href="#">
            <i class="fas fa-book-open"></i> Browse articles
          </a>
          <a href="#">
            <i class="fas fa-file-alt"></i> My articles
          </a>
        </div>
        <div class="navbar-bottom-container">
          <a href="#">
            <i class="fas fa-sign-out-alt"></i> Disconnect
          </a>
        </div>
      </nav>
    </transition>
  </div>
</template>

<script>
export default {
  name: "AppNavbar",
  data() {
    return {
      showNavbar: false
    };
  },
  methods: {
    toggleNavbar() {
      this.showNavbar = !this.showNavbar;
    }
  }
};
</script>

<style scoped>
.hamburger-btn {
  position: fixed;
  top: 30px;
  right: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 6px;
  width: 40px;
  height: 40px;
  background: none;
  border: none;
  cursor: pointer;
  padding: 8px;
  border-radius: 8px;
  z-index: 1100; /* higher than navbar */
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.hamburger-btn:hover {
  background-color: #afafaf;
  transform: scale(1.1);
}

.hamburger-btn .line {
  width: 24px;
  height: 4px;
  background: black;
  border-radius: 2px;
}

/* Button when navbar is closed (fixed to screen corner) */
.fixed-btn {
  position: fixed;
  top: 20px;
  right: 20px;
}

/* Button inside the navbar (positioned in corner of navbar) */
.inside-btn {
  align-self: flex-end;
  margin-bottom: 20px;
}

/* Rounded and floating navbar */
.navbar {
  position: fixed;
  right: 20px;
  top: 20px;
  height: calc(100vh - 40px);
  width: 200px;
  background-color: #e5dfdf;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 20px;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  z-index: 1000;
}

.navbar-top-container {
  margin-top: 40px;
}

.navbar-bottom-container {
  margin-top: auto; /* This pushes it to the bottom */
}

.navbar-bottom-container a:hover {
  background-color: #afafaf;
  color: black;
  transform: scale(1.05);
}

.navbar-top-container a,
.navbar-bottom-container a {
  display: block;
  padding: 10px 15px;
  color: black;
  text-decoration: none;
  border-radius: 8px;
  font-size: 1.2rem; /* <-- increase this value as needed */
  transition: background-color 0.3s ease, color 0.3s ease, transform 0.2s ease;
  margin-bottom: 8px;
}

.navbar-top-container a:hover {
  background-color: #afafaf;
  color: black;
  transform: scale(1.05); /* slightly bigger on hover */
}

/* Transition classes */
.slide-fade-enter-active,
.slide-fade-leave-active {
  transition: all 0.4s ease;
}
.slide-fade-enter-from,
.slide-fade-leave-to {
  opacity: 0;
  transform: translateX(100%);
}
.slide-fade-enter-to,
.slide-fade-leave-from {
  opacity: 1;
  transform: translateX(0);
}

</style>
