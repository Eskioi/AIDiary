<template>
  <div class="article-view">
    <h1 class="headline">{{ article.headline }}</h1>
    <div class="meta">By {{ article.creatorName }} • {{ article.date }}</div>

    <div class="section full-width">
      <h2 class="subheadline">{{ article.subHeadline1 }}</h2>
      <p class="text text-70">{{ article.text1 }}</p>
    </div>

    <div class="section split-columns">
      <div class="column">
        <h2 class="subheadline">{{ article.subHeadline2 }}</h2>
        <p class="text text-70">{{ article.text2 }}</p>
      </div>
      <div class="column">
        <h2 class="subheadline">{{ article.subHeadline3 }}</h2>
        <p class="text text-70">{{ article.text3 }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ArticleView',
  props: {
    article: Object
  }
};
</script>

<style scoped>
.article-view {
  max-width: 70%;
  margin: 0 auto;
  font-family: Arial, sans-serif;
  text-align: center; /* center all text */
}

.headline {
  font-size: 2.5rem;
  margin-bottom: 10px;
}

.meta {
  font-size: 0.8rem;
  color: #666;
  margin-bottom: 40px;
}

.subheadline {
  font-size: 1.5rem;
  margin-bottom: 12px;
}

.text {
  font-size: 1rem;
  line-height: 1.6;
  margin-left: auto;
  margin-right: auto;
}

.text-70 {
  width: 70%;
  margin-left: auto;
  margin-right: auto;
}

.section {
  margin-bottom: 50px;
}

.full-width {
  display: flex;
  flex-direction: column;
  align-items: center; /* center children horizontally */
  text-align: center; /* ensure nested text is centered */
}

.split-columns {
  display: flex;
  justify-content: center; /* center columns horizontally */
  gap: 40px;
}

.column {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center; /* center column content */
  text-align: center;  /* center text inside columns */
}

</style>
