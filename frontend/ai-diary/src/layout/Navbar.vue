<template>
    <nav class="navbar">
      <div class="navbar-container">
        <!-- Menu Button for Mobile -->
        <button class="menu-button" @click="toggleMenu">
          ☰
        </button>
        <!-- Navigation Links -->
        <ul :class="['nav-links', { 'nav-active': isMenuOpen }]">
          <li><router-link to="/" @click="closeMenu">Home</router-link></li>
          <li><router-link to="/Home" @click="closeMenu">Previous articles</router-link></li>
        </ul>
      </div>
    </nav>
  </template>
  
  <script>
    export default {
    name: "AppNavbar",
    data() {
        return {
        isMenuOpen: false, // Initialize the menu state
        };
    },
    methods: {
        toggleMenu() {
        this.isMenuOpen = !this.isMenuOpen; // Toggle the menu state
        },
        closeMenu() {
        this.isMenuOpen = false; // Close the menu
        },
    },
    };
    </script>

  
  
  <style scoped>
  /* Navbar Container */
  .navbar {
    background-color: #ffffff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    position: fixed;
    width: 100%;
    top: 0;
    left: 0;
    z-index: 900; /* Ensure this value is higher than other components */
  }
  
  .navbar-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0.5rem 1rem;
  }
  
  /* Menu Button (Hamburger Icon) */
  .menu-button {
    color: #333;
    display: none;
    font-size: 1.5rem;
    background: none;
    border: none;
    cursor: pointer;
  }
  
  /* Navigation Links */
  .nav-links {
    list-style: none;
    display: flex;
    gap: 1rem;
    margin: 0;
    padding: 0;
  }
  
  .nav-links li {
    display: inline;
  }
  
  .nav-links a {
    text-decoration: none;
    color: #333;
    font-weight: 500;
  }
  
  /* Auth Button */
  .auth-button {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    padding: 0.5rem 1rem;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1rem;
    font-weight: 500;
  }
  
  .auth-button:hover {
    background-color: #0056b3;
  }
  
  /* Responsive Styles */
  @media (max-width: 768px) {
    .menu-button {
      display: block;
    }
    .nav-links {
      display: none;
      flex-direction: column;
      width: 100%;
      position: absolute;
      top: 100%;
      left: 0;
      background-color: #ffffff;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .nav-links.nav-active {
      display: flex;
    }
    .nav-links li {
      text-align: center;
      padding: 0.5rem 0;
    }
  }
  
  
  .nav-links a {
    text-decoration: none;
    color: #333;
    font-weight: 500;
  }
  
  /* Greyed-out Links */
  .disabled {
    color: grey;
    opacity: 0.5;
    pointer-events: none;
    cursor: not-allowed;
  }
  
  
  </style>