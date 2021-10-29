<template>
  <div class="them2">
    <div class="them2-title">Portfolio</div>
    <Them2Info/>
    <Them2Skill/>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Them2Info from '../components/Them2Info.vue';
import Them2Skill from '../components/Them2Skill.vue';

export default {
  components: {
    Them2Info,
    Them2Skill,
  },
  name: 'Them2',
  data() {
    return {
      uploadFile: '',
      name: '',
      birth: '',
      phone: '',
      email: '',
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
