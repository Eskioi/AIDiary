<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white p-8 rounded-2xl shadow-md w-full max-w-md">
      <h2 class="text-2xl font-bold mb-6 text-center">Login</h2>
      <form @submit.prevent="handleLogin" class="space-y-4">
        <div>
          <label class="block text-sm font-medium text-gray-700">Email</label>
          <input
            v-model="email"
            type="email"
            class="mt-1 w-full p-2 border border-gray-300 rounded-md"
            placeholder="you@example.com"
          />
          <p v-if="errors.email" class="text-red-500 text-sm">{{ errors.email }}</p>
        </div>

        <div>
          <label class="block text-sm font-medium text-gray-700">Password</label>
          <input
            v-model="password"
            type="password"
            class="mt-1 w-full p-2 border border-gray-300 rounded-md"
          />
          <p v-if="errors.password" class="text-red-500 text-sm">{{ errors.password }}</p>
        </div>

        <p v-if="loginError" class="text-red-500 text-sm text-center">{{ loginError }}</p>

        <button
          type="submit"
          class="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-600 disabled:opacity-50"
          :disabled="!isFormValid || loading"
        >
          {{ loading ? 'Logging in...' : 'Login' }}
        </button>
      </form>

      <p class="text-center text-sm text-gray-600 mt-4">
        Not registered yet?
        <button class="text-blue-500 hover:underline" @click="goToRegister">
          Register
        </button>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/auth'

const auth = useAuthStore()

const router = useRouter()

const email = ref('')
const password = ref('')
const loginError = ref('')
const loading = ref(false)

const errors = ref({
  email: '',
  password: '',
})

const validate = () => {
  errors.value.email = email.value.includes('@') ? '' : 'Valid email is required'
  errors.value.password = password.value ? '' : 'Password is required'
}

const isFormValid = computed(() => {
  return email.value.trim().includes('@') && password.value.trim() !== ''
})

const handleLogin = async () => {
  validate()
  loginError.value = ''
  if (!isFormValid.value) return

  loading.value = true

  try {
    const response = await fetch('http://localhost:8081/user/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        email: email.value,
        password: password.value,
      }),
    })

    const data = await response.json()

    if (!response.ok) {
      throw new Error(data.message || 'Login failed')
    }

    // ✅ Save JWT token
    localStorage.setItem('token', data.token)
    auth.login(email.value)

    // ⏩ Redirect after successful login
    router.push('/dashboard')
  } catch (err) {
    loginError.value = err.message
  } finally {
    loading.value = false
  }
}

const goToRegister = () => {
  router.push('/register')
}
</script>
