<template>
  <div class="them2-box">
    <div class="them2-subtitle" v-if="portfolio.technologyStack">Tech Stack</div>
      <div class="skill-desc">
          <div class="flex">
                <div class="levelred level-color">5</div>
                <div class="skill-desc-detail">대규모 프로그램 및 시스템을 참고사항(책/인터넷)없이 개발할 수 있음</div>
          </div>
          <div class="flex">
                <div class="levelgreen level-color">3 - 4</div>
                <div class="skill-desc-detail">중간 규모 프로그램 및 시스템을 개발할 수 있으며, 능숙하게 다룰 수 있음</div>
          </div>
          <div class="flex">
                <div class="levelyellow level-color">1 - 2</div>
                <div class="skill-desc-detail">능숙하지는 않지만 책/인터넷을 참고하며 개발할 수 있음</div>
          </div>
      </div>
      <div class="skill-list">
          <Them2SkillContent :title="Language" :list="langArr"/>
          <Them2SkillContent :title="Framework" :list="frameArr"/>
          <Them2SkillContent :title="Management" :list="manaArr"/>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Them2SkillContent from './Them2SkillContent.vue';

export default {
  name: 'Them2Skill',
  props: {
    edit: {
      type: Boolean,
    },
  },
  components: {
    Them2SkillContent,
  },
  data() {
    return {
      Language: 'Language',
      Framework: 'Framework',
      Management: 'Management',
      langArr: [],
      frameArr: [],
      manaArr: [],
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
  mounted() {
    const list = this.portfolio.technologyStack;
    let i;
    for (i = 0; i < list.length; i += 1) {
      if (list[i].kind === 1) this.langArr.push(list[i]);
      if (list[i].kind === 2) this.frameArr.push(list[i]);
      if (list[i].kind === 3) this.manaArr.push(list[i]);
    }
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
