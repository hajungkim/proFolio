<template>
  <div>
    <strong  class="plus-btn-box">
      <div>자격증</div>
      <div class="plus-btn" @click="addCertificate">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(cert) in resume.certificate" :key="cert.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>시험명</th>
          <td>
            <input
              type="text"
              :value="cert.name"
              name="name"
              @change="changeInput($event, cert)"
            />
          </td>
          <th class="pl-15">취득일</th>
          <td style="padding-left:10px;">
            <SingleCalender :item="cert" />
          </td>
        </tr>
      </table>
      <div class="delete-btn" @click="deleteCertificate(cert)">X</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import SingleCalender from './TempSingleCalender.vue';

export default {
  name: 'Certificate',
  components: {
    SingleCalender,
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
    addCertificate() {
      const newItem = {
        id: `${Date.now()}`,
        name: '',
        certifiedDate: '',
      };
      this.$store.commit('CHANGE_CERTIFICATE_LIST', [...this.resume.certificate, newItem]);
    },
    deleteCertificate(item) {
      const newList = _.differenceWith(this.resume.certificate, [item], _.isEqual);
      this.$store.commit('CHANGE_CERTIFICATE_LIST', newList);
    },
    changeInput(event, cert) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_CERTIFICATE_INFO', { name, value, certificate: cert });
    },
  },
};
</script>

<style>

</style>
