<template>
  <div>
    <div class="resume-part-title">part3</div>
    <div class="resume-part-sub">어학, 자격증, 수상 내역을을 입력해주세요</div>
    <div>
      <strong  class="plus-btn-box">
        <div>어학</div>
        <div class="plus-btn" @click="addCreateLanguage">+</div>
      </strong>
      <CreateLanguage
       v-for="(language) in language" :key="language.id" :language="language"
       />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong  class="plus-btn-box">
        <div>자격증</div>
        <div class="plus-btn" @click="addCreateCert">+</div>
      </strong>
      <CreateCertificate
       v-for="(certificate) in certificate" :key="certificate.id" :certificate="certificate"
       />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong  class="plus-btn-box">
        <div>수상</div>
        <div class="plus-btn" @click="addCreateAward">+</div>
      </strong>
      <CreateAward
       v-for="(award) in awards" :key="award.id" :award="award"
       />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateLanguage from './CreateLanguage.vue';
import CreateCertificate from './CreateCertificate.vue';
import CreateAward from './CreateAward.vue';

export default {
  name: 'ResumePart3',
  components: {
    CreateLanguage,
    CreateCertificate,
    CreateAward,
  },
  data() {
    return {
      language: null,
      certificate: null,
      awards: null,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateLanguage() {
      const newLang = {
        id: this.language.length + 1, language: '', name: '', score: '', certifieddate: '',
      };
      this.language.unshift(newLang);
    },
    addCreateCert() {
      const newCert = {
        id: this.certificate.length + 1, organization: '', name: '', score: '', certifieddate: '',
      };
      this.certificate.unshift(newCert);
    },
    addCreateAward() {
      const newAward = {
        id: this.awards.length + 1, description: '', name: '', prize: '', awardsdate: '',
      };
      this.awards.unshift(newAward);
    },
  },
  beforeMount() {
    this.language = JSON.parse(JSON.stringify(this.resume.foreignlang));
    this.certificate = JSON.parse(JSON.stringify(this.resume.certificate));
    this.awards = JSON.parse(JSON.stringify(this.resume.awards));
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
