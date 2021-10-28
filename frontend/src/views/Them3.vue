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
      </div>
  </div>
</template>

<script>
import Them3Certi from '../components/Them3Certi.vue';
import Them3Edu from '../components/Them3Edu.vue';
import Them3Info from '../components/Them3Info.vue';

export default {
  components: { Them3Info, Them3Edu, Them3Certi },
  name: 'Them3',
  data() {
    return {
    };
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
