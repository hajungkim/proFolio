<template>
  <div class="them1">
      <div class="menu">
          <div class="menu-item">Info</div>
          <div class="menu-item">Skills</div>
          <div class="menu-item">Experience</div>
          <div class="menu-item">Certificate/Language</div>
          <div class="menu-item">Awards</div>
          <div class="menu-item">Projects</div>
          <div class="menu-buttons">
              <div>저장</div>
              <div>PDF변환</div>
          </div>
      </div>
      <div class="content">
          <Them1Info/>
      </div>
  </div>
</template>

<script>
import Them1Info from '../components/Them1Info.vue';

export default {
  name: 'Them1',
  components: {
    Them1Info,
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
