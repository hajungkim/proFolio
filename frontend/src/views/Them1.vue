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
          <Them1Skill/>
          <Them1Exp/>
          <Them1Certi/>
          <Them1Awards/>
          <Them1Project/>
      </div>
  </div>
</template>

<script>
import Them1Info from '../components/Them1Info.vue';
import Them1Skill from '../components/Them1Skill.vue';
import Them1Exp from '../components/Them1Exp.vue';
import Them1Awards from '../components/Them1Awards.vue';
import Them1Certi from '../components/Them1Certi.vue';
import Them1Project from '../components/Them1Project.vue';

export default {
  name: 'Them1',
  components: {
    Them1Info,
    Them1Skill,
    Them1Exp,
    Them1Awards,
    Them1Certi,
    Them1Project,
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
