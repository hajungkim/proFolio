<template>
  <div>
    PortFolio
    <button @click="goToThem1">them1</button>
    <button @click="goToThem3">them3</button>
  </div>
</template>

<script>
export default {
  name: 'LookPortFolio',
  methods: {
    goToThem1() {
      this.$router.push({ name: 'Them1' });
    },
    goToThem3() {
      this.$router.push({ name: 'Them3' });
    },
  },
};
</script>

<style>

</style>
