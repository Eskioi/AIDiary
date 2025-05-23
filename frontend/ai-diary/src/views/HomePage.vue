<template>
  <ArticleView :article="sampleArticle" />
</template>

<script>
import ArticleView from '@/components/ArticleView.vue';

export default {
  components: {
    ArticleView
  },
  data() {
    return {
      sampleArticle: {
        id: 1,
        creatorUserId: 42,
        creatorName: 'Jane Doe',
        date: '2025-05-23',
        type: 1,
        headline: 'The Rise of Vue 3',
        subHeadline1: 'Why Vue is a Game Changer in Modern Web Development',
        text1: `Vue 3 has significantly transformed the landscape of frontend development by introducing the Composition API, improved performance, and better TypeScript integration. 
        Developers now have greater control and flexibility, making it easier to write scalable and maintainable code. Vue's lightweight core, coupled with its ecosystem of tools 
        like Vue Router and Pinia, ensures seamless integration for both small and enterprise-scale applications. The new reactivity system is more intuitive and performant, 
        allowing real-time updates and faster render cycles. As businesses demand more dynamic and responsive user interfaces, Vue 3’s advancements make it an ideal solution. 
        Furthermore, the community support and extensive documentation help new developers onboard quickly. Its approachable design and powerful capabilities strike a perfect 
        balance between simplicity and complexity.`,
        subHeadline2: 'Key Features of Vue 3 That Developers Love',
        text2: `Vue 3's Composition API provides greater logic reuse, making components cleaner and more modular. 
        Performance optimizations reduce app bundle sizes and improve runtime speed, especially for large-scale apps.`,
        subHeadline3: 'Final Thoughts on Vue 3’s Impact',
        text3: `Vue 3 is a robust and flexible framework, enabling faster development cycles and improved maintainability. 
        It’s quickly becoming the go-to choice for developers seeking efficiency and elegance in UI development.`
      }
    };
  }
};
</script>

<style scoped>
</style>
