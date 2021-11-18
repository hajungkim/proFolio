<template>
  <div>
    <div class="portfolio-content">
      <div v-for="(port) in list" :key="port.id">
        <div class="material-icons outer-btn-remove deleteBtn"
            @click="removeItem(port.id)">delete_outline</div>
        <div
          @click="downloadFile(port.url)"
          @mouseover="addPreview(port.url, port.id)"
          @mouseout="removePreview(port.id)"  class="portfolio-card">
          <div>{{port.name}}</div>
        </div>
        <div class="preview"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import { getPortfolio, deletePortfolio } from '../store/modules/PortfolioAPI';

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
    removeItem(id) {
      deletePortfolio(id)
        .then(() => {
          getPortfolio(this.userId)
            .then((res) => {
              this.list = res.data.data;
            });
        });
    },
  },
};
</script>

<style>
@import '../assets/styles/Portfolio.css';
@import '../assets/styles/Them1.css';
</style>
