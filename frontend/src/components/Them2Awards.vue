<template>
  <div class="them2-box"  v-if="edit || portfolio.awards.length">
    <div class="them2-subtitle">Awards</div>
    <AddItemButton type="awards" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(award) in portfolio.awards" :key="award.id" class="them2-card">
        <span class="them2-cardname">{{award.name}}</span>
        <span class="them2-grayfont">({{award.awardsDate}})</span>
        <RemoveItemButton
          v-if="edit"
          type="awards"
          :item="award"
        />
        <div class="them2-summary">{{award.prize}}</div>
        <!-- <div class="them2-grayfont">{{award.description}}</div> -->
        <div class="them2-grayfont" v-html="adjustHtml(award.description)"></div>
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
  name: 'Them2Awards',
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
  @import '../assets/styles/Them2.css';
</style>
