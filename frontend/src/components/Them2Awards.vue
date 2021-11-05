<template>
  <div class="them2-box"  v-if="edit || portfolio.awards.length">
    <div class="them2-subtitle">Awards</div>
    <AddItemButton type="awards" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(award) in portfolio.awards" :key="award.id" class="them2-card">
        <RemoveItemButton
          v-if="edit"
          type="awards"
          :item="award"
        />
        <span class="them2-cardname">{{award.name}}</span>
        <span class="them2-grayfont">({{award.awardsDate}})</span>
        <div class="them2-summary">{{award.prize}}</div>
        <div class="them2-grayfont">{{award.description}}</div>
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
  props: {
    edit: {
      type: Boolean,
    },
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
    remove() {
      console.log('@this.resume: ', this.resume.awards);
      this.resume.awards = '';
    },
  },
};
</script>

<style>
  @import '../assets/styles/Them2.css';
</style>
