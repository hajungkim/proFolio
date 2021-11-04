<template>
  <div>
    <button @click="goToThem1">them1</button>
    <button @click="goToThem2">them2</button>
    <button @click="goToThem3">them3</button>
    <div class="portfolio-content">
      <div v-for="(port) in list" :key="port.id">
        <div
          @click="downloadFile(port.url)"
          @mouseover="addPreview(port.url, port.id)"
          @mouseout="removePreview(port.id)"  class="portfolio-card">{{port.name}}</div>
        <div class="preview"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import { getPortfolio } from '../store/modules/PortfolioAPI';

export default {
  name: 'LookPortFolio',
  data() {
    return {
      list: [],
    };
  },
  computed: {
    ...mapState([
      'userId',
    ]),
  },
  created() {
    getPortfolio(this.userId)
      .then((res) => {
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
    downloadFile(url) {
      window.open(url, '_blank');
    },
    addPreview(url, id) {
      const element = document.getElementsByClassName('preview')[id - 1];
      element.innerHTML += `<iframe src=${url} class="preview_img"/>`;
    },
    removePreview(id) {
      const element = document.getElementsByClassName('preview')[id - 1];
      element.innerHTML = '';
    },
  },
};
</script>

<style>
@import '../assets/styles/Portfolio.css';
</style>
