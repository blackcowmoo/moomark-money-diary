<template>
  <div id = "addcategory">
    <h1>Add Category modal components</h1>
    <AddCategoryComponent v-if="isModalViewed" @close-modal="isModalViewed=false">
    </AddCategoryComponent>
    <button @click="isModalViewed = true">Add Category</button>
  </div>
</template>
<script>
import AddCategoryComponent from '../components/AddCategoryComponent.vue';

export default {
  name: 'AddCategoryView',
  components: {
    AddCategoryComponent,
  },
  data() {
    return {
      isModalViewed: false,
    };
  },
};
</script>
