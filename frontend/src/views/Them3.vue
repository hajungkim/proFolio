<template>
  <div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3',
  data() {
    return {
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
@import '../assets/styles/Them3.css';
</style>
