<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>외국어명</th>
        <td><input type="text" @change="langLanguage"></td>
        <th class="pl-15">점수</th>
        <td><input type="text" @change="langScore"></td>
      </tr>
      <tr>
        <th>시험명</th>
        <td><input type="text" @change="langName"></td>
        <th class="pl-15">취득일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="langCreate.language.certifiedDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="langCreate.language.certifiedDate"
                  label="취득일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="langCreate.language.certifiedDate"
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
    <div class="delete-btn" @click="deleteLang">X</div>
  </div>
</template>

<script>
export default {
  name: 'CreateLanguage',
  props: {
    language: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      langCreate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('createLang', this.langCreate);
    },
    certifiedDateUpdate() {
      this.$refs.menu1.save(this.langCreate.language.certifiedDate);
      this.dataUpdate();
    },
    langName(event) {
      this.langCreate.language.name = event.target.value;
      this.dataUpdate();
    },
    langScore(event) {
      this.langCreate.language.score = event.target.value;
      this.dataUpdate();
    },
    langLanguage(event) {
      this.langCreate.language.language = event.target.value;
      this.dataUpdate();
    },
    deleteLang() {
      this.langCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.langCreate.language = this.language;
    this.langCreate.isDeleted = false;
  },
};
</script>

<style>

</style>
