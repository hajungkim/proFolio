<template>
  <div>
    <div class="resume-part-title">part5</div>
    <div class="resume-part-sub">프로젝트를 입력해주세요.</div>
    <Project />
    <div class="hr-border-m-40"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Project from './TempProject.vue';

export default {
  name: 'ResumePart5',
  components: {
    Project,
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
    this.$emit('save', 4);
  },
};
</script>

<style>

</style>
