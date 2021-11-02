<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>주최기관</th>
      <td><input type="text" :placeholder="certificate.organization"></td>
    </tr>
    <tr>
      <th>시험명</th>
      <td><input type="text" :placeholder="certificate.name"></td>
      <th class="pl-15">취득일</th>
      <td style="padding-left:10px;">
        <v-app class="date-pick">
          <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            :return-value.sync="date1"
            transition="scale-transition"
            offset-y
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="date1"
                :label="cert_date"
                prepend-icon="mdi-calendar"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="date1"
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
                @click="$refs.menu1.save(date1)"
              >
                OK
              </v-btn>
            </v-date-picker>
          </v-menu>
        </v-app>
      </td>
    </tr>
  </table>
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
      date1: null,
      menu1: false,
      cert_date: this.certificate.certifieddate,
    };
  },
};
</script>

<style>

</style>
