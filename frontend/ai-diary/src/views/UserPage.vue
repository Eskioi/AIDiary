<template>
  <div class="userpage-huge">
    <HomeIcon/>
    <div class="userpage-container">
    <div class="profile-container">
      <UserProfile :user="user" />
    </div>
    <div class="articles-container">
      <ArticleList :articles="articles" :showCreator="false"/>
    </div>
  </div>
  </div>
</template>

<script>
import UserProfile from '@/components/UserProfile.vue';
import ArticleList from '@/components/ArticleList.vue';
import HomeIcon from '@/components/HomeIcon.vue';

export default {
  components: { UserProfile, ArticleList, HomeIcon},
  data() {
    return {
      user: {
        id: 1,
        firstName: "First Name",
        surname: "Surname",
        email: "test@example.com",
        username: "TestUser",
        points: 1500
      },
      articles: [
        { id: 1, headline: 'My First Article', date: '2025-05-01', creatorName: 'TheUser' },
        { id: 2, headline: 'Another Great Article', date: '2025-05-02', creatorName: 'TheUser' },
        { id: 3, headline: 'Latest Thoughts', date: '2025-05-03', creatorName: 'TheUser' },
        { id: 4, headline: 'Vue.js Tips and Tricks', date: '2025-05-04', creatorName: 'TheUser' },
        { id: 5, headline: 'How to Write Clean Code', date: '2025-05-05', creatorName: 'TheUser' },
        { id: 6, headline: 'Understanding Reactivity', date: '2025-05-06', creatorName: 'TheUser' },
        { id: 7, headline: 'Frontend Performance Optimization', date: '2025-05-07', creatorName: 'TheUser' },
        { id: 8, headline: 'Deploying Your Vue App', date: '2025-05-08', creatorName: 'TheUser' },
        { id: 9, headline: 'State Management Made Easy', date: '2025-05-09', creatorName: 'TheUser' },
        { id: 10, headline: 'CSS Grid vs Flexbox', date: '2025-05-10', creatorName: 'TheUser' },
        { id: 11, headline: 'Accessibility Best Practices', date: '2025-05-11', creatorName: 'TheUser' },
        { id: 12, headline: 'Testing Vue Components', date: '2025-05-12', creatorName: 'TheUser' },
        { id: 13, headline: 'Working with APIs in Vue', date: '2025-05-13', creatorName: 'TheUser' },
        { id: 14, headline: 'Vue Router Deep Dive', date: '2025-05-14', creatorName: 'TheUser' },
        { id: 15, headline: 'Building Reusable Components', date: '2025-05-15', creatorName: 'TheUser' },
      ],
    };
  },
};
</script>

<style scoped>
.userpage-huge{
  display: flex;
  justify-content: center;
}

.userpage-container {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 20px;
  height: 90vh;
  width: 80%;
}

@media (min-aspect-ratio: 1/1) {
  .userpage-container {
    flex-direction: row;
  }
  .profile-container {
    flex: 0 0 40%;
    max-width: 40%;
  }
  .articles-container {
    flex: 1;
    max-width: 60%;
  }
}
</style>