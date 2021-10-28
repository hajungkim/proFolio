<template>
  <div>
    <div class="resume-part-title">part4</div>
    <div class="resume-part-sub">기술스택을 입력해주세요.</div>
    <div>
      <strong  class="plus-btn-box">
        <div>기술스택</div>
        <div class="plus-btn" @click="addCreateStack">+</div>
      </strong>
      <CreateTechStack v-for="(technology_stack, index) in technology_stack"
      :key="index" :technology_stack="technology_stack" :index="index"/>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateTechStack from './CreateTechStack.vue';

export default {
  name: 'ResumePart4',
  components: {
    CreateTechStack,
  },
  data() {
    return {
      technology_stack: null,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateStack() {
      const newStack = {
        id: this.technology_stack.length + 1, name: '', level: '', description: '', kind: '1',
      };
      this.technology_stack.push(newStack);
    },
  },
  beforeMount() {
    this.technology_stack = JSON.parse(JSON.stringify(this.resume.technology_stack));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
