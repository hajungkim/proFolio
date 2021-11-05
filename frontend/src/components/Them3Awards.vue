<template>
  <div class="them3-awards">
    <div class="name">Awards</div>
    <AddItemButton type="awards"/>
    <draggable class="draggable-container-row">
      <div v-for="(award) in portfolio.awards" :key="award.id" class="them3-awards-card">
        <RemoveItemButton
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
