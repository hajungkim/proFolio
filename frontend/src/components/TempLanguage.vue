<template>
  <div>
    <strong  class="plus-btn-box">
      <div>어학</div>
      <div class="plus-btn" @click="addLanguage">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(lang) in resume.foreignLang" :key="lang.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>외국어명</th>
          <td>
            <input
              type="text"
              :value="lang.language"
              name="language"
              @change="changeInput($event, lang)"
            />
          </td>
          <th class="pl-15">점수</th>
          <td>
            <input type="text"
              :value="lang.score"
              name="score"
              @change="changeInput($event, lang)"
            />
          </td>
        </tr>
        <tr>
          <th>시험명</th>
          <td>
            <input
              type="text"
              :value="lang.name"
              name="name"
              @change="changeInput($event, lang)"
            />
          </td>
          <th class="pl-15">취득일</th>
          <td style="padding-left:10px;">
            <SingleCalender :item="lang" />
          </td>
        </tr>
      </table>
      <div class="delete-btn" @click="deleteLanguage(lang)">x</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import SingleCalender from './TempSingleCalender.vue';

export default {
  components: {
    SingleCalender,
  },
  name: 'Language',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
      'userId',
    ]),
  },
  methods: {
    addLanguage() {
      const newLang = {
        id: `${Date.now()}`,
        name: '',
        score: '',
        language: '',
        certifiedDate: '',
        userId: this.userId,
      };
      if (!this.resume.foreignLang) {
        this.$store.commit('CHANGE_LANGUAGE_LIST', [newLang]);
      } else {
        this.$store.commit('CHANGE_LANGUAGE_LIST', [...this.resume.foreignLang, newLang]);
      }
    },
    deleteLanguage(item) {
      const newList = _.differenceWith(this.resume.foreignLang, [item], _.isEqual);
      this.$store.commit('CHANGE_LANGUAGE_LIST', newList);
    },
    changeInput(event, lang) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_LANGUAGE_INFO', { name, value, language: lang });
    },
  },
};
</script>

<style>

</style>
