<template>
  <div class="them2-box" v-if="portfolio.activity.length || portfolio.education">
      <div class="them2-subtitle">
        Education &amp; Experience
      </div><br>
      <ul class="tl">
        <li v-for="(exp) in portfolio.activity" :key="exp.id" class="tl-item">
          <div class="timestamp">{{exp.startDate}} ~ {{exp.endDate}}</div>
          <div class="item-title">{{exp.name}}</div>
          <!-- <div class="item-detail">{{exp.description}}</div> -->
          <div class="item-detail" v-html="adjustHtml(exp.description)"></div>
        </li>
        <li class="tl-item">
          <div class="timestamp">
            {{portfolio.education.admissionDate}} ~
            {{portfolio.education.graduationDate}}</div>
          <div class="item-title">{{portfolio.education.university}}</div>
          <div class="item-detail">{{portfolio.education.major}}</div>
        </li>
      </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Exp',
  props: {
    edit: Boolean,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
  methods: {
    adjustHtml(strVal) {
      return strVal.replace(/(\n|\r\n)/g, '<br>');
    },
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
