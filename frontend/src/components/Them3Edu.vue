<template>
  <div class="them3-edu">
        <div class="name">Education</div>
          <div v-for="(edu) in resume.education" :key="edu.id">
            <div class="university">{{edu.university}}</div>
            <div class="raw">
                <div class="sub">
                    {{edu.admissionDate}} ~ {{edu.graduationDate}}
                </div>
                    <div v-if="edu.graduation">졸업</div>
            </div>
            <div class="raw">
                <div class="sub">전공</div>
                {{edu.major}}
            </div>
            <div class="raw">
                <div class="sub">부전공</div>
                {{edu.minor}}
            </div>
          </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Edu',
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
