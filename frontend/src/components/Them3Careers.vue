<template>
  <div class="them3-exp" v-if="edit || portfolio.career.length">
    <div class="name">Career</div>
    <AddItemButton type="career" v-if="edit"/>
    <draggable class="draggable-container-row" ghost-class="ghost">
      <div v-for="(career) in portfolio.career" :key="career.id" class="card">
        <RemoveItemButton
          v-if="edit"
          type="career"
          :item="career"
        />
        <div style="margin-bottom: 20px">
          <span style="font-weight: bold; margin-right: 15px">{{career.company}}</span>
          <span style="color: #656060">{{career.startDate}} ~ {{career.endDate}}</span>
        </div>
        <div style="display: flex">
          <div style="color: #656060; margin-right: 15px">직무</div>
          <div>{{career.duty}}</div>
        </div>
        <div style="display: flex">
          <div style="color: #656060; margin-right: 15px">활동 내용</div>
          <!-- {{career.description}} -->
          <span v-html="adjustHtml(career.description)"></span>
        </div>
      </div>
    </draggable>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import draggable from 'vuedraggable';
import RemoveItemButton from './RemoveItemButton.vue';
import AddItemButton from './AddItemButton.vue';

export default {
  name: 'Them3Exp',
  props: {
    edit: Boolean,
  },
  components: {
    draggable,
    RemoveItemButton,
    AddItemButton,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
  methods: {
    adjustHtml(strVal) {
      return strVal.replace(/(\n|\r\n)/g, '<br>');
    },
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
