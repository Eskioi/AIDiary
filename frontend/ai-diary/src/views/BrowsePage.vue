<template>
  <div class="browse-page">
    <form class="search-form" @submit.prevent="applyFilters">
      <input
        v-model="filters.keyword"
        type="text"
        placeholder="Search articles..."
        class="input keyword-input"
      />

      <label class="date-label">
        From:
        <input
          v-model="filters.startDate"
          type="date"
          class="input date-input"
        />
      </label>

      <label class="date-label">
        To:
        <input
          v-model="filters.endDate"
          type="date"
          class="input date-input"
        />
      </label>

      <button type="submit" class="submit-button">Search</button>
    </form>

    <ArticleList :articles="filteredArticles" />
  </div>
</template>

<script>
import ArticleList from '@/components/ArticleList.vue';

export default {
  name: 'BrowsePage',
  components: { ArticleList },
  data() {
    return {
      filters: {
        keyword: '',
        startDate: '',
        endDate: '',
      },
      allArticles: [
        { id: 1, headline: 'Intro to Vue', date: '2025-05-01', creatorName: 'Alice' },
        { id: 2, headline: 'Advanced Composition API', date: '2025-05-08', creatorName: 'Bob' },
        { id: 3, headline: 'Frontend Trends 2025', date: '2025-04-20', creatorName: 'Carol' },
      ],
    };
  },
  computed: {
    filteredArticles() {
      return this.allArticles.filter(article => {
        const matchesKeyword = article.headline.toLowerCase().includes(this.filters.keyword.toLowerCase());
        const articleDate = new Date(article.date);
        const afterStart = !this.filters.startDate || articleDate >= new Date(this.filters.startDate);
        const beforeEnd = !this.filters.endDate || articleDate <= new Date(this.filters.endDate);
        return matchesKeyword && afterStart && beforeEnd;
      });
    },
  },
  methods: {
    applyFilters() {
      // Reactivity handles the filtering
    },
  },
};
</script>

<style scoped>
.browse-page {
  padding: 1.5rem;
  max-width: 800px;
  margin: 0 auto;
}

.search-form {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 0.75rem;
  margin-bottom: 1.5rem;
}

.input {
  font-size: 1rem;
  padding: 0.4rem 0.6rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.keyword-input {
  flex: 2;
  min-width: 200px;
}

.date-label {
  display: flex;
  align-items: center;
  font-size: 0.95rem;
  gap: 0.3rem;
}

.date-input {
  font-size: 0.9rem;
  padding: 0.25rem 0.4rem;
  width: 135px;
}

.submit-button {
  padding: 0.45rem 1rem;
  background-color: #6c63ff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  white-space: nowrap;
}

.submit-button:hover {
  background-color: #5751d8;
}
</style>
