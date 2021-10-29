<template>
  <div class="them2">
    <div class="them2-title">Portfolio</div>
    <Them2Info/>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Them2Info from '../components/Them2Info.vue';

export default {
  components: { Them2Info },
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
