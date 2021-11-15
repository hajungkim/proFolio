<template>
  <div class="them2-box" v-if="edit || portfolio.career.length">
    <div class="them2-subtitle">Career</div>
    <AddItemButton type="career" v-if="edit"/>
    <draggable
      ghost-class="ghost"
    >
      <div v-for="(career) in portfolio.career" :key="career.id" class="them2-card">
        <span class="them2-cardname">{{career.company}}</span>
        <span class="them2-grayfont">({{career.startDate}} ~ {{career.endDate}})</span>
        <RemoveItemButton
          v-if="edit"
          type="career"
          :item="career"
          :edit="edit"
        />
        <div>
          <span style="color: #0014BC; margin-right: 5%">직무</span>
          <span>{{career.duty}}</span>
        </div>
        <div class="them2-summary">
          <!-- <span>{{career.description}}</span> -->
          <span v-html="adjustHtml(career.description)"></span>
        </div>
      </div>
    </draggable>
  </div>
</template>

<script>
import draggable from "vuedraggable";
import { mapState } from 'vuex';
import RemoveItemButton from './RemoveItemButton.vue';
import AddItemButton from './AddItemButton.vue';

export default {
  name: 'Them2Careers',
  props: {
    edit: {
      type: Boolean,
    },
  },
  components: {
    draggable,
    RemoveItemButton,
    AddItemButton,
  },
  data() {
    return {
      skills: [],
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
@import '../assets/styles/Them2.css';

</style>
