<template>
  <div>
    <button @click="goToThem1">them1</button>
    <button @click="goToThem2">them2</button>
    <button @click="goToThem3">them3</button>
    <div class="portfolio-content">
      <div v-for="(port) in list" :key="port.id" class="portfolio-card">
        <div>{{port.name}}</div>
      </div>
      <div class="portfolio-card add-btn">+</div>
    </div>
  </div>
</template>

<script>
import { getPortfolio } from '../store/modules/PortfolioAPI';

export default {
  name: 'LookPortFolio',
  data() {
    return {
      list: [],
    };
  },
  created() {
    getPortfolio(1)
      .then((res) => {
        console.log(res.data);
        this.list = res.data.data;
      });
  },
  methods: {
    goToThem1() {
      this.$router.push({ name: 'Them1' });
    },
    goToThem2() {
      this.$router.push({ name: 'Them2' });
    },
    goToThem3() {
      this.$router.push({ name: 'Them3' });
    },
  },
};
</script>

<style>
@import '../assets/styles/Portfolio.css';
</style>
