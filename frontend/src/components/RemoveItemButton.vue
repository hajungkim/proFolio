<template>
  <button
    @click="remove"
    class="outer-btn-remove"
  >
  <!-- hello -->
  <span class="material-icons outer-btn-remove">delete_outline</span>
  </button>
</template>

<script>
export default {
  props: {
    item: Object,
    type: String,
  },
  methods: {
    remove() {
      switch (this.type) {
        case 'project':
          this.$store.dispatch('portfolioProjectDelete', this.item);
          break;
        case 'career':
          this.$store.dispatch('portfolioCareerDelete', this.item);
          break;
        case 'awards':
          this.$store.dispatch('portfolioAwardsDelete', this.item);
          break;
        case 'activity':
          this.$store.dispatch('portfolioActivityDelete', this.item);
          break;
        default:
      }
    },
  },
};
</script>

<style>
@import '../assets/styles/Button.css';
</style>
