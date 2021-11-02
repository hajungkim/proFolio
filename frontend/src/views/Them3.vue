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
            <div @click="test">PDF변환</div>
          </div>
        </div>
      <div class="them3-content">
        <Them3Edu/>
        <Them3Certi/>
        <Them3Exp/>
        <Them3Skill/>
        <Them3Awards/>
        <Them3Project/>
      </div>
  </div>
</template>

<script>
import html2pdf from 'html2pdf.js';
import Them3Awards from '../components/Them3Awards.vue';
import Them3Certi from '../components/Them3Certi.vue';
import Them3Edu from '../components/Them3Edu.vue';
import Them3Exp from '../components/Them3Exp.vue';
import Them3Info from '../components/Them3Info.vue';
import Them3Project from '../components/Them3Project.vue';
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
    Them3Project,
  },
  data() {
    return {
    };
  },
  methods: {
    test() {
      const element = document.getElementById('pdf');
      html2pdf().from(element).set({
        margin: 10,
        filename: 'test.pdf',
        html2canvas: {
          scale: 1,
          allowTaint: false,
          useCORS: true,
        },
        jsPDF: {
          orientation: 'portrait',
          unit: 'mm',
          format: 'a3',
          compress: true,
        },
      }).save();
    },
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
