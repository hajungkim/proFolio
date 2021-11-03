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
       v-for="(language) in langCreate" :key="language.id" :language="language"
       @createLang="createLang"
       />
      <UpdateLanguage
       v-for="(language) in langUpdate" :key="language.id" :language="language"
       @updateLang="updateLang"
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
import UpdateLanguage from './UpdateLanguage.vue';
import CreateCertificate from './CreateCertificate.vue';
import CreateAward from './CreateAward.vue';

export default {
  name: 'ResumePart3',
  components: {
    CreateLanguage,
    CreateCertificate,
    CreateAward,
    UpdateLanguage,
  },
  data() {
    return {
      langCreate: [],
      langUpdate: [],
      langDelete: new Set(),
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
        id: `create${Math.random()}`, language: '', name: '', score: '', certifiedDate: '',
      };
      this.langCreate.unshift(newLang);
    },
    addCreateCert() {
      const newCert = {
        id: this.certificate.length + 1, organization: '', name: '', score: '', certifiedDate: '',
      };
      this.certificate.unshift(newCert);
    },
    addCreateAward() {
      const newAward = {
        id: this.awards.length + 1, description: '', name: '', prize: '', awardsDate: '',
      };
      this.awards.unshift(newAward);
    },
    createLang(createLang) {
      if (createLang.isDeleted) {
        let sliceIndex = null;
        const idx = createLang.language.id;
        Object.entries(this.langCreate).forEach((language) => {
          if (Object.keys(language[1]).find((key) => language[1][key] === idx)) {
            [sliceIndex] = language;
          }
        });
        this.langCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createLangData', createLang.language);
      }
    },
    updateLang(updateLang) {
      if (updateLang.isDeleted) {
        let sliceIndex = null;
        const idx = updateLang.language.id;
        Object.entries(this.langUpdate).forEach((language) => {
          if (Object.keys(language[1]).find((key) => language[1][key] === idx)) {
            [sliceIndex] = language;
          }
        });
        this.langUpdate.splice(sliceIndex, 1);
        this.$emit('deleteLanguage', updateLang.language.id);
      } else if (updateLang.isUpdated) {
        this.$emit('updateLanguageData', updateLang.language);
      }
    },
  },
  beforeMount() {
    this.langUpdate = JSON.parse(JSON.stringify(this.resume.foreignLang));
    // this.certificate = JSON.parse(JSON.stringify(this.resume.certificate));
    // this.awards = JSON.parse(JSON.stringify(this.resume.awards));
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
