<template>
  <div>
    <div class="resume-part-title">part4</div>
    <div class="resume-part-sub">기술스택을 입력해주세요.</div>
    <div>
      <strong  class="plus-btn-box">
        <div>기술스택</div>
        <div class="plus-btn" @click="addCreateStack">+</div>
      </strong>
      <CreateTechStack v-for="(technologyStack, index) in technologyStack"
      :key="index" :technologyStack="technologyStack" :index="index"/>
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
      technologyStack: null,
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
        id: this.technologyStack.length + 1, name: '', level: '', description: '', kind: '1',
      };
      this.technologyStack.push(newStack);
    },
  },
  beforeMount() {
    this.technologyStack = JSON.parse(JSON.stringify(this.resume.technologyStack));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
