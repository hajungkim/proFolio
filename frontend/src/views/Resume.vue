<template>
  <div class="resume">
    <div class="resume-wrapper">
      <ul class="step-progress">
        <li class="step-progress-item current" data-step="1" @click="stepChange">
          <strong data-step="1" @click="stepChange">인적사항</strong>
        </li>
        <li class="step-progress-item" data-step="2" @click="stepChange">
          <strong data-step="2" @click="stepChange">학력/경력/활동</strong>
        </li>
        <li class="step-progress-item" data-step="3" @click="stepChange">
          <strong data-step="3" @click="stepChange">어학/자격증/수상</strong>
        </li>
        <li class="step-progress-item" data-step="4" @click="stepChange">
          <strong data-step="4" @click="stepChange">기술스택</strong>
        </li>
        <li class="step-progress-item" data-step="5" @click="stepChange">
          <strong data-step="5" @click="stepChange">프로젝트</strong>
        </li>
      </ul>
    </div>
    <div class="resume-part">
      <ResumePart1 v-if="resumePart==0" />
      <ResumePart2 v-if="resumePart==1" />
      <ResumePart3 v-if="resumePart==2"/>
      <ResumePart4 v-if="resumePart==3"/>
      <ResumePart5 v-if="resumePart==4"/>
    </div>
  </div>
</template>

<script>
import ResumePart1 from '../components/ResumePart1.vue';
import ResumePart2 from '../components/ResumePart2.vue';
import ResumePart3 from '../components/ResumePart3.vue';
import ResumePart4 from '../components/ResumePart4.vue';
import ResumePart5 from '../components/ResumePart5.vue';

export default {
  name: 'Resume',
  components: {
    ResumePart1,
    ResumePart2,
    ResumePart3,
    ResumePart4,
    ResumePart5,
  },
  data() {
    return {
      resumePart: 0,
    };
  },
  methods: {
    stepChange(event) {
      const Now = event.target.getAttribute('data-step') - 1;
      const stepList = document.querySelectorAll('.step-progress-item');
      for (let i = 0; i < 5; i += 1) {
        if (i < Now) stepList[i].className = 'step-progress-item is-done';
        else if (i === Now) stepList[i].className = 'step-progress-item current';
        else stepList[i].className = 'step-progress-item';
      }
      this.resumePart = Now;
    },
  },
};
</script>

<style>
@import '../assets/styles/Resume.css';
</style>
