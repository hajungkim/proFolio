<template>
  <div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
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
