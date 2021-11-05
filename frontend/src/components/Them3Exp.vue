<template>
  <div class="them3-exp" v-if="edit || portfolio.activity.length">
    <div class="name">Experience</div>
    <AddItemButton type="activity" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(exp) in portfolio.activity" :key="exp.id" class="card">
        <RemoveItemButton
          v-if="edit"
          type="activity"
          :item="exp"
        />
        <div style="margin-bottom: 20px">
          <span style="font-weight: bold; margin-right: 15px">{{exp.name}}</span>
          <span style="color: #656060">{{exp.startDate}} ~ {{exp.endDate}}</span>
        </div>
        <div style="display: flex">
          <div style="color: #656060; margin-right: 15px">활동 기관</div>
          <div>{{exp.organization}}</div>
        </div>
        <div style="display: flex">
          <div style="color: #656060; margin-right: 15px">활동 내용</div>
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
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
