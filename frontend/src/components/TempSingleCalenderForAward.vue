<template>
  <v-app class="date-pick">
    <v-menu
      ref="menu1"
      v-model="menu1"
      :close-on-content-click="false"
      :return-value.sync="item.awardsDate"
      transition="scale-transition"
      offset-y
      min-width="auto"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-text-field
          v-model="item.awardsDate"
          label="취득일"
          prepend-icon="mdi-calendar"
          readonly
          v-bind="attrs"
          v-on="on"
        ></v-text-field>
      </template>
      <v-date-picker
        v-model="item.awardsDate"
        no-title
        scrollable
        type="date"
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
          @click="dateUpdate"
        >
          OK
        </v-btn>
      </v-date-picker>
    </v-menu>
  </v-app>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'SingleCallendar',
  props: {
    item: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    dateUpdate() {
      this.$refs.menu1.save(this.item.awardsDate);
    },
  },
};
</script>

<style>

</style>
