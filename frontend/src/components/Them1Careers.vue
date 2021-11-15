<template>
  <div class="skill"  v-if="edit || portfolio.career.length">
    <div class="name">CAREERS</div>
    <AddItemButton type="career" v-if="edit"/>
    <draggable class="draggable-container-row" ghost-class="ghost">
      <div v-for="(career) in portfolio.career" :key="career.id" class="card">
        <div style="margin-bottom: 20px">
          <span style="font-weight: bold; margin-right: 15px">{{career.company}}</span>
          <span style="color: #656060">{{career.startDate}} ~ {{career.endDate}}</span>
          <RemoveItemButton
            v-if="edit"
            type="career"
            :item="career"
            :edit="edit"
          />
        </div>
        <div>
          <span style="color: #656060; margin-right: 15px">직무</span>
          {{career.duty}}
        </div>
        <div>
          <span style="color: #656060; margin-right: 15px"> 내용</span>
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
  name: 'Them1Careers',
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
@import '../assets/styles/Them1.css';
</style>
