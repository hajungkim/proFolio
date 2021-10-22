<template>
  <div class="my-page">
    <div class="tab-group">
      <div class="tab-sub-group">
        <div class="tab-menu">
          <div :class="[ resumeActive ? fullColor : halfColor ]" @click="resumeClick">
            <span>이력서</span>
          </div>
        </div>
        <div class="tab-menu">
          <div :class="[ resumeActive ? halfColor :  fullColor ]" @click="portFolioClick">
            <span>포트폴리오</span>
          </div>
        </div>
      </div>
    </div>
    <div v-if="resumeActive" class="my-page-content">
      <LookResume/>
    </div>
    <div v-else class="my-page-content">
      <LookPortFolio/>
    </div>
  </div>
</template>

<script>
import LookResume from '../components/LookResume.vue';
import LookPortFolio from '../components/LookPortFolio.vue';

export default {
  name: 'MyPage',
  components: {
    LookResume,
    LookPortFolio,
  },
  data() {
    return {
      resumeActive: true,
      fullColor: 'tab-btn-click',
      halfColor: 'tab-btn',
    };
  },
  methods: {
    resumeClick() {
      this.resumeActive = true;
    },
    portFolioClick() {
      this.resumeActive = false;
    },
  },
};
</script>

<style>
@import '../assets/styles/MyPage.css';
</style>
