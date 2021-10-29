<template>
  <div class="them2-box">
      <div class="them2-subtitle" @click="classify">Tech Stack</div>
      <div class="skill-desc">
          <div class="flex">
                <div class="red level-color">5</div>
                <div>대규모 프로그램 및 시스템을 참고사항(책/인터넷)없이 개발할 수 있음</div>
          </div>
          <div class="flex">
                <div class="green level-color">3 - 4</div>
                <div>중간 규모 프로그램 및 시스템을 개발할 수 있으며, 능숙하게 다룰 수 있음</div>
          </div>
          <div class="flex">
                <div class="yellow level-color">1 - 2</div>
                <div>능숙하지는 않지만 책/인터넷을 참고하며 개발할 수 있음</div>
          </div>
      </div>
      <div>
          <Them2SkillContent :title="Language" :list="resume.technology_stack"/>
          <Them2SkillContent :title="Framework" :list="resume.technology_stack"/>
          <Them2SkillContent :title="Management" :list="resume.technology_stack"/>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Them2SkillContent from './Them2SkillContent.vue';

export default {
  name: 'Them2Skill',
  components: {
    Them2SkillContent,
  },
  data() {
    return {
      Language: 'Language',
      Framework: 'Framework',
      Management: 'Management',
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
