<template>
  <button @click="open">add</button>
  <!-- popup dialog -->
</template>

<script>
import { mapState } from 'vuex';

export default {
  props: {
    type: String,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
      'portfolio',
    ]),
  },
  methods: {
    open() {
      console.log('hi', this.type);
      // this.$store.dispatch(this.type, this.project);
      // 추가할수 있는 프로젝트를 보여주는 팝업 띄우기
      console.log(this.resume[this.type]);
      // 아이템 추가하는 함수는 따로 만들던지 같이 쓰던지
    },
    addItem() {},
  },
};
</script>

<style>

</style>
