<template>
  <div>
    <div class="resume-part-title">part3</div>
    <div class="resume-part-sub">어학, 자격증, 수상 내역을을 입력해주세요</div>
    <div>
      <Language />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <Certificate />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <Award />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Language from './TempLanguage.vue';
import Certificate from './TempCertificate.vue';
import Award from './TempAward.vue';

export default {
  name: 'ResumePart3',
  components: {
    Language,
    Certificate,
    Award,
  },
  data() {
    return {
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
        id: `create${Math.random()}`, name: '', score: '', certifiedDate: '',
      };
      this.certCreate.unshift(newCert);
    },
    addCreateAward() {
      const newAward = {
        id: `create${Math.random()}`, description: '', name: '', prize: '', awardsDate: '',
      };
      this.awardCreate.unshift(newAward);
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
    createCert(createCert) {
      if (createCert.isDeleted) {
        let sliceIndex = null;
        const idx = createCert.certificate.id;
        Object.entries(this.certCreate).forEach((certificate) => {
          if (Object.keys(certificate[1]).find((key) => certificate[1][key] === idx)) {
            [sliceIndex] = certificate;
          }
        });
        this.certCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createCertData', createCert.certificate);
      }
    },
    updateCert(updateCert) {
      if (updateCert.isDeleted) {
        let sliceIndex = null;
        const idx = updateCert.certificate.id;
        Object.entries(this.certUpdate).forEach((certificate) => {
          if (Object.keys(certificate[1]).find((key) => certificate[1][key] === idx)) {
            [sliceIndex] = certificate;
          }
        });
        this.certUpdate.splice(sliceIndex, 1);
        this.$emit('deleteCertificate', updateCert.certificate.id);
      } else if (updateCert.isUpdated) {
        this.$emit('updateCertificateData', updateCert.certificate);
      }
    },
    createAward(createAward) {
      if (createAward.isDeleted) {
        let sliceIndex = null;
        const idx = createAward.awards.id;
        Object.entries(this.awardCreate).forEach((awards) => {
          if (Object.keys(awards[1]).find((key) => awards[1][key] === idx)) {
            [sliceIndex] = awards;
          }
        });
        this.awardCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createAwardData', createAward.awards);
      }
    },
    updateAward(updateAward) {
      if (updateAward.isDeleted) {
        let sliceIndex = null;
        const idx = updateAward.awards.id;
        Object.entries(this.awardUpdate).forEach((awards) => {
          if (Object.keys(awards[1]).find((key) => awards[1][key] === idx)) {
            [sliceIndex] = awards;
          }
        });
        this.awardUpdate.splice(sliceIndex, 1);
        this.$emit('deleteAwards', updateAward.awards.id);
      } else if (updateAward.isUpdated) {
        this.$emit('updateAwardsData', updateAward.awards);
      }
    },
  },
  beforeMount() {
    this.langUpdate = JSON.parse(JSON.stringify(this.resume.foreignLang));
    this.certUpdate = JSON.parse(JSON.stringify(this.resume.certificate));
    this.awardUpdate = JSON.parse(JSON.stringify(this.resume.awards));
  },
  beforeDestroy() {
    this.$emit('save', 2);
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
