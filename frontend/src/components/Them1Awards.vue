<template>
  <div class="skill" v-if="edit || portfolio.awards.length">
    <div class="name">Awards</div>
    <AddItemButton type="awards" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(award) in portfolio.awards" :key="award.id" class="card">
        <RemoveItemButton
          v-if="edit"
          type="awards"
          :item="award"
        />
        <div style="margin-bottom: 20px">
          <span style="font-weight: bold; margin-right: 15px">{{award.name}}</span>
          <span
            style="font-weight: bold; margin-right: 15px; color: #656060">
            {{award.prize}}
          </span>
          <span style="color: #656060">{{award.awardsDate}}</span>
        </div>
        <div style="display:flex">
          <div style="color: #656060; margin-right: 15px; width:100px">수상 내용</div>
          <div>{{award.description}}</div>
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
  name: 'Them1Awards',
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
@import '../assets/styles/Them1.css';
</style>
