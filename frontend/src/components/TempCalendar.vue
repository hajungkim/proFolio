<template>
  <tr>
    <th>시작일</th>
    <td style="padding-left:10px;">
      <v-app class="date-pick">
        <v-menu
          ref="menu1"
          v-model="menu1"
          :close-on-content-click="false"
          :return-value.sync="item.startDate"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="item.startDate"
              label="시작일"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="item.startDate"
            no-title
            scrollable
            type="month"
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
              @click="startDateUpdate"
            >
              OK
            </v-btn>
          </v-date-picker>
        </v-menu>
      </v-app>
    </td>
    <th class="pl-15">종료일</th>
    <td style="padding-left:10px;">
      <v-app class="date-pick">
        <v-menu
          ref="menu2"
          v-model="menu2"
          :close-on-content-click="false"
          :return-value.sync="item.endDate"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="item.endDate"
              label="종료일"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="item.endDate"
            no-title
            scrollable
            type="month"
          >
            <v-spacer></v-spacer>
            <v-btn
              text
              color="primary"
              @click="menu2 = false"
            >
              Cancel
            </v-btn>
            <v-btn
              text
              color="primary"
              @click="endDateUpdate"
            >
              OK
            </v-btn>
          </v-date-picker>
        </v-menu>
      </v-app>
    </td>
  </tr>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Callendar',
  props: {
    item: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      menu2: false,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    startDateUpdate() {
      this.$refs.menu1.save(this.item.startDate);
    },
    endDateUpdate() {
      this.$refs.menu2.save(this.item.endDate);
    },
  },
};
</script>

<style>
</style>
