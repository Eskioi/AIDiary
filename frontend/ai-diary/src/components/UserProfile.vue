<template>
  <section class="user-profile">
    <h2>{{ user.username }}</h2>
    <p><strong>First name:</strong> {{ user.firstName }}</p>
    <p><strong>Surname:</strong> {{ user.surname }}</p>
    <p><strong>Email:</strong> {{ user.email }}</p>
    <p><strong>Points:</strong> {{ user.points }}</p>
  </section>
</template>

<script>
export default {
  name: "UserProfile",
  props: {
    user: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.user-profile {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 6px rgb(0 0 0 / 0.1);
}

.user-profile h2 {
  margin-bottom: 12px;
  font-size: 1.8rem;
  color: #333;
}

.user-profile p {
  margin: 6px 0;
  font-size: 1.1rem;
  color: #555;
}
</style>
