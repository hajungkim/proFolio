<template>
  <div class="them3-awards">
      <div class="name">Awards</div>
      <div v-for="(award) in resume.awards" :key="award.id">
          <div style="margin:10% 0">
              <span style="font-weight: bold; margin-right: 15px">{{award.name}}</span>
              <span
                style="font-weight: bold; margin-right: 15px; color: #656060">
                {{award.prize}}
              </span>
              <div style="color: #656060; margin: 5% 0">{{award.awardsDate}}</div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Awards',
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
