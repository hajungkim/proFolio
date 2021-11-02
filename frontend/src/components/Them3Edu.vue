<template>
  <div class="them3-edu">
        <div class="name">Education</div>
            <div class="university">{{resume.education.university}}</div>
            <div class="raw">
                <div class="sub">
                    {{resume.education.admissionDate}} ~ {{resume.education.graduationDate}}
                </div>
                    <div v-if="resume.education.graduation">졸업</div>
            </div>
            <div class="raw">
                <div class="sub">전공</div>
                {{resume.education.major}}
            </div>
            <div class="raw">
                <div class="sub">부전공</div>
                {{resume.education.minor}}
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
