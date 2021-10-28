<template>
  <div>
    PortFolio
    <button @click="goToThem1">them1</button>
  </div>
</template>

<script>
export default {
  name: 'LookPortFolio',
  methods: {
    goToThem1() {
      this.$router.push({ name: 'Them1' });
    },
  },
};
</script>

<style>

</style>
