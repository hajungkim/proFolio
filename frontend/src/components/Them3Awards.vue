<template>
  <div class="them3-awards" v-if="edit || portfolio.awards.length">
    <div class="name">Awards</div>
    <AddItemButton type="awards" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(award) in portfolio.awards" :key="award.id" class="them3-awards-card">
        <RemoveItemButton
          v-if="edit"
          type="awards"
          :item="award"
        />
        <div  style="margin:10% 0">
          <span style="font-weight: bold; margin-right: 15px">{{award.name}}</span>
          <span
            style="font-weight: bold; margin-right: 15px; color: #656060">
            {{award.prize}}
          </span>
          <div style="color: #656060; margin: 5% 0">{{award.awardsDate}}</div>
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
  name: 'Them3Awards',
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
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
