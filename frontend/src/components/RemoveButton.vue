<template>
  <button @click="remove">remove</button>
</template>

<script>
export default {
  props: {
    project: Object,
    type: String,
  },
  methods: {
    remove() {
      // console.log('hi', this.type, this.project);
      this.$store.dispatch(this.type, this.project);
    },
  },
};
</script>

<style>

</style>
