import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    isAuthenticated: false,
    user: null,
  }),
  actions: {
    login(email) {
      this.isAuthenticated = true
      this.user = { email }
    },
    logout() {
      this.isAuthenticated = false
      this.user = null
    }
  }
})