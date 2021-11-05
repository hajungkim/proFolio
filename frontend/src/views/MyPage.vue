<template>
  <div class="my-page">
    <div class="tab-group">
      <div class="tab-sub-group">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.css" />
        <div class="tab-menu">
          <button :class="[ resumeActive ? clickState : unclickState ]" @click="resumeClick">
            <div>My Resume</div>
            <i class="icon-arrow-right"></i>
          </button>
        </div>
        <div class="tab-menu">
          <button :class="[ resumeActive ? unclickState : clickState ]" @click="portFolioClick">
            <div>My Portfolio</div>
            <i class="icon-arrow-right"></i>
          </button>
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
      clickState: 'slide-click',
      unclickState: 'slide',
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
