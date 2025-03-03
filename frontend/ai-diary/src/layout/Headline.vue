<template>
    <div class="article-layout">
      <h1 class="headline">{{ title }}</h1>
      <div class="content">
        <div class="image-container">
          <img :src="imageSrc" :alt="title" />
        </div>
        <div class="headlines-list">
          <h2>Sections</h2>
          <ul>
            <li v-for="(headline, index) in headlines" :key="index">
              <a :href="headline.link">{{ headline.text }}</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ArticleLayout',
    props: {
      title: {
        type: String,
        required: true
      },
      imageSrc: {
        type: String,
        required: true
      },
      headlines: {
        type: Array,
        required: true
      }
    }
  }
  </script>
  
  <style scoped>
  .article-layout {
    display: flex;
    flex-direction: column;
    gap: 20px;
    padding: 20px;
  }
  
  .headline {
    font-size: 2rem;
    text-align: center;
  }
  
  .content {
    display: grid;
    grid-template-columns: 1fr 2fr;
    gap: 20px;
  }
  
  .image-container img {
    width: 100%;
    height: auto;
    border-radius: 10px;
  }
  
  .headlines-list h2 {
    font-size: 1.5rem;
  }
  
  .headlines-list ul {
    list-style: none;
    padding: 0;
  }
  
  .headlines-list li a {
    text-decoration: none;
    color: #007bff;
    font-size: 1.2rem;
  }
  
  .headlines-list li a:hover {
    text-decoration: underline;
  }
  </style>
  