<template>
  <div class="text-center dialog-div">
    <v-dialog
      v-model="dialog"
      width="500"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          class="outer-btn-add"
        >
          ADD
        </v-btn>
      </template>

      <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          Add Item
        </v-card-title>

        <div class="card-body" v-if="availableItem.length">
          <div v-if="type==='project'">
            <div v-for="(pro) in availableItem" :key="pro.id">
              <div class="card-item" @click="addItem(pro)">
                {{pro.title}}: {{pro.summary}}
              </div>
            </div>
          </div>
          <div v-else-if="type==='awards'">
            <div v-for="(award) in availableItem" :key="award.id">
              <div class="card-item" @click="addItem(award)">
                {{award.name}} {{award.prize}}
              </div>
            </div>
          </div>
          <div v-else-if="type==='activity'">
            <div v-for="(act) in availableItem" :key="act.id">
              <div class="card-item" @click="addItem(act)">
                {{act.name}}
              </div>
            </div>
          </div>
        </div>
        <div class="card-body" v-else>
          Nothing to add...
        </div>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="dialog = false"
          >
            Close
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';

export default {
  props: {
    type: String,
  },
  data() {
    return {
      dialog: false,
    };
  },
  computed: {
    ...mapState([
      'resume',
      'portfolio',
    ]),
    availableItem() {
      const resumeItem = this.resume[this.type];
      const portfolioItem = this.portfolio[this.type];
      const newArray = _.differenceWith(resumeItem, portfolioItem, _.isEqual);
      return newArray;
    },
  },
  methods: {
    // 아이템 추가하는 함수는 따로 만들던지 같이 쓰던지
    addItem(item) {
      // console.log(this.type, pro);
      switch (this.type) {
        case 'project':
          this.$store.dispatch('portfolioProjectAdd', item);
          break;
        case 'awards':
          this.$store.dispatch('portfolioAwardsAdd', item);
          break;
        case 'activity':
          this.$store.dispatch('portfolioActivityAdd', item);
          break;
        default:
      }
      this.dialog = false;
    },
  },
  mounted() {
    if (this.type === 'activity') {
      console.log(this.availableItem);
    }
  },
};
</script>

<style>
@import '../assets/styles/Dialog.css';
@import '../assets/styles/Button.css';
</style>
