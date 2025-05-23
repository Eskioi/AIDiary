<template>
  <div class="article-list">
    <h1 class="title">My Articles</h1>
    
    <ul>
      <li v-for="article in paginatedArticles" :key="article.id" class="article-item">
        <h2 class="headline">{{ article.headline }}</h2>
        <p class="meta">
          <span v-if="showCreator" class="creator">By: {{ article.creatorName || 'Unknown' }}</span>
          <span class="date">{{ formatDate(article.date) }}</span>
        </p>
      </li>
    </ul>

    <nav class="pagination" v-if="totalPages > 1">
      <button @click="changePage(currentPage - 1)" :disabled="currentPage === 1">
        Prev
      </button>

      <button
        v-for="page in pagesToShow"
        :key="page"
        @click="changePage(page)"
        :class="{ active: page === currentPage }"
      >
        {{ page }}
      </button>

      <button @click="changePage(currentPage + 1)" :disabled="currentPage === totalPages">
        Next
      </button>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'ArticleList',
  props: {
    articles: {
        type: Array,
        required: true,
    },
    itemsPerPage: {
        type: Number,
        default: 7,
    },
    showCreator: {
        type: Boolean,
        default: true,
    },
  },
  data() {
    return {
      currentPage: 1,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.articles.length / this.itemsPerPage);
    },
    paginatedArticles() {
      const start = (this.currentPage - 1) * this.itemsPerPage;
      return this.articles.slice(start, start + this.itemsPerPage);
    },
    pagesToShow() {
      // Show up to 5 page buttons, centered on current page
      const total = this.totalPages;
      const current = this.currentPage;
      const maxButtons = 5;
      let start = Math.max(current - 2, 1);
      let end = Math.min(start + maxButtons - 1, total);

      // Adjust start if we don't have enough pages at the end
      start = Math.max(end - maxButtons + 1, 1);

      const pages = [];
      for (let i = start; i <= end; i++) {
        pages.push(i);
      }
      return pages;
    },
  },
  methods: {
    changePage(page) {
      if (page < 1 || page > this.totalPages) return;
      this.currentPage = page;
      this.$emit('page-changed', page);
    },
    formatDate(dateStr) {
      const date = new Date(dateStr);
      return date.toLocaleDateString(undefined, { year: 'numeric', month: 'short', day: 'numeric' });
    },
  },
};
</script>

<style scoped>
.article-list {
  max-width: 600px;
  margin: 0 auto;
  padding: 1rem;
}

.article-item {
  border-bottom: 1px solid #ccc;
  padding: 1rem 0;
}

.headline {
  margin: 0 0 0.25rem;
  font-size: 1.25rem;
}

.meta {
  font-size: 0.9rem;
  color: #555;
  display: flex;
  justify-content: space-between;
}

.pagination {
  display: flex;
  justify-content: center;
  margin-top: 1rem;
  gap: 0.5rem;
}

.pagination button {
  padding: 0.4rem 0.8rem;
  border: none;
  background-color: #eee;
  cursor: pointer;
  border-radius: 4px;
  font-weight: 600;
}

.pagination button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.pagination button.active {
  background-color: #6c63ff;
  color: white;
}

ul {
  list-style: none;
  padding-left: 0; /* Optional: remove left padding for better alignment */
}
</style>