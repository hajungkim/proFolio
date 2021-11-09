<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <!-- <tr>
      <th>주최기관</th>
      <td><input type="text" @change="certOrganizaion"></td>
    </tr> -->
    <tr>
      <th>시험명</th>
      <td><input type="text" @change="certName"></td>
      <th class="pl-15">취득일</th>
      <td style="padding-left:10px;">
        <v-app class="date-pick">
          <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            :return-value.sync="certCreate.certificate.certifiedDate"
            transition="scale-transition"
            offset-y
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="certCreate.certificate.certifiedDate"
                label="취득일"
                prepend-icon="mdi-calendar"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="certCreate.certificate.certifiedDate"
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
  name: 'CreateCertificate',
  props: {
    certificate: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      certCreate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('createCert', this.certCreate);
    },
    certifiedDateUpdate() {
      this.$refs.menu1.save(this.certCreate.certificate.certifiedDate);
      this.dataUpdate();
    },
    certName(event) {
      this.certCreate.certificate.name = event.target.value;
      this.dataUpdate();
    },
    // certOrganizaion(event) {
    //   this.certCreate.certificate.organization = event.target.value;
    //   this.dataUpdate();
    // },
    deleteCert() {
      this.certCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.certCreate.certificate = this.certificate;
    this.certCreate.isDeleted = false;
  },
};
</script>

<style>

</style>
