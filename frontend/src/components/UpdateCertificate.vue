<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <!-- <tr>
      <th>주최기관</th>
      <td><input type="text" @change="certOrganizaion" :placeholder="certificate.organization"></td>
    </tr> -->
    <tr>
      <th>시험명</th>
      <td><input type="text" @change="certName" :placeholder="certificate.name"></td>
      <th class="pl-15">취득일</th>
      <td style="padding-left:10px;">
        <v-app class="date-pick">
          <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            :return-value.sync="certUpdate.certificate.certifiedDate"
            transition="scale-transition"
            offset-y
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="certUpdate.certificate.certifiedDate"
                label="취득일"
                prepend-icon="mdi-calendar"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="certUpdate.certificate.certifiedDate"
              no-title
              scrollable
            >
              <v-spacer></v-spacer>
              <v-btn
                text
                color="primary"
                @click="menu1 = false"
              >
                Cancel
              </v-btn>
              <v-btn
                text
                color="primary"
                @click="certifiedDateUpdate"
              >
                OK
              </v-btn>
            </v-date-picker>
          </v-menu>
        </v-app>
      </td>
    </tr>
  </table>
  <div class="delete-btn" @click="deleteCert">X</div>
</div>
</template>

<script>
export default {
  name: 'UpdateCertificate',
  props: {
    certificate: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      certUpdate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.certUpdate.isUpdated = true;
      this.$emit('updateCert', this.certUpdate);
    },
    certifiedDateUpdate() {
      this.$refs.menu1.save(this.certUpdate.certificate.certifiedDate);
      this.dataUpdate();
    },
    certName(event) {
      this.certUpdate.certificate.name = event.target.value;
      this.dataUpdate();
    },
    // certOrganizaion(event) {
    //   this.certUpdate.certificate.organization = event.target.value;
    //   this.dataUpdate();
    // },
    deleteCert() {
      this.certUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.certUpdate.certificate = this.certificate;
    this.certUpdate.isDeleted = false;
    this.certUpdate.isUpdated = false;
  },
};
</script>

<style>

</style>
