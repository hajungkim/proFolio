<template>
  <div class="them2-box">
      <div class="them2-subtitle">Tech Stack</div>
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
          <Them2SkillContent :title="Language" :list="lang_arr"/>
          <Them2SkillContent :title="Framework" :list="frame_arr"/>
          <Them2SkillContent :title="Management" :list="mana_arr"/>
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
      lang_arr: [],
      frame_arr: [],
      mana_arr: [],
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  mounted() {
    const list = this.resume.technology_stack;
    let i;
    for (i = 0; i < list.length; i += 1) {
      if (list[i].kind === 1) this.lang_arr.push(list[i]);
      if (list[i].kind === 2) this.frame_arr.push(list[i]);
      if (list[i].kind === 3) this.mana_arr.push(list[i]);
    }
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
