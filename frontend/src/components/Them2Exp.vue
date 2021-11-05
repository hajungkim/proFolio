<template>
  <div class="them2-box">
      <div class="them2-subtitle" v-if="this.resume.activity">Education &amp; Experience</div>
      <button
        @click="remove"
        id="remove-btn"
        :class="[edit ? '' : 'hidden']"
      >
        delete
      </button>
      <ul class="tl">
        <li v-for="(exp) in portfolio.activity" :key="exp.id" class="tl-item">
          <div class="timestamp">{{exp.startDate}} ~ {{exp.endDate}}</div>
          <div class="item-title">{{exp.name}}</div>
          <div class="item-detail">{{exp.description}}</div>
        </li>
        <li class="tl-item">
          <div class="timestamp">
            {{portfolio.education.admissionDate}} ~
            {{portfolio.education.graduationDate}}</div>
          <div class="item-title">{{portfolio.education.university}}</div>
          <div class="item-detail">전공 : {{portfolio.education.major}}</div>
        </li>
      </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Exp',
  props: {
    edit: {
      type: Boolean,
    },
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
    remove() {
      this.resume.activity = '';
      this.resume.education = '';
    },
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
