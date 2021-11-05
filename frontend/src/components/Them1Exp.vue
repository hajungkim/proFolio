<template>
  <div class="skill">
    <div class="name">EXPERIENCE</div>
    <AddItemButton type="activity"/>
    <draggable class="draggable-container-row">
      <div v-for="(exp) in portfolio.activity" :key="exp.id" class="card">
        <RemoveItemButton
            type="activity"
            :item="exp"
          />
        <div style="margin-bottom: 20px">
          <span style="font-weight: bold; margin-right: 15px">{{exp.name}}</span>
          <span style="color: #656060">{{exp.startDate}} ~ {{exp.endDate}}</span>
        </div>
        <div>
          <span style="color: #656060; margin-right: 15px">활동 기관</span>
          {{exp.organization}}
        </div>
        <div>
          <span style="color: #656060; margin-right: 15px">활동 내용</span>
          {{exp.description}}
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
  name: 'Them1Exp',
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
