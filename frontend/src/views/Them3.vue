<template>
  <div class="them3">
      <Them3Info/>
        <div class="menu">
          <ul class="itmes">
            <li>Info</li>
            <li>Education</li>
            <li>Certificate</li>
            <li>Experience</li>
            <li>Skills</li>
            <li>Awards</li>
            <li>Projects</li>
          </ul>
          <div class="menu-buttons">
            <div>저장</div>
            <div>변환</div>
          </div>
        </div>
      <div class="them3-content">
        <Them3Edu/>
        <Them3Certi/>
        <Them3Exp/>
        <Them3Skill/>
        <Them3Awards/>
      </div>
  </div>
</template>

<script>
import Them3Awards from '../components/Them3Awards.vue';
import Them3Certi from '../components/Them3Certi.vue';
import Them3Edu from '../components/Them3Edu.vue';
import Them3Exp from '../components/Them3Exp.vue';
import Them3Info from '../components/Them3Info.vue';
import Them3Skill from '../components/Them3Skill.vue';

export default {
  name: 'Them3',
  components: {
    Them3Info,
    Them3Edu,
    Them3Certi,
    Them3Exp,
    Them3Skill,
    Them3Awards,
  },
  data() {
    return {
    };
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
