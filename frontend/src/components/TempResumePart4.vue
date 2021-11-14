<template>
  <div>
    <div class="resume-part-title">part4</div>
    <div class="resume-part-sub">기술스택을 입력해주세요.</div>
    <!-- 설명 -->
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
    <div>
      <TechStack />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import TechStack from './TempTechStack.vue';

export default {
  name: 'ResumePart4',
  components: {
    TechStack,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
  },
  beforeDestroy() {
    this.$emit('save', 3);
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
