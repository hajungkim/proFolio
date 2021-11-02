<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>기술스택 종류</th>
        <td class="pl-15">
          <div :class="[techStackKind === 1 ? techStackBoxSelected : '', techStackBox]"
          data-stack="1" @click="changeKind">
            Language
          </div>
          <div :class="[techStackKind === 2 ? techStackBoxSelected : '', techStackBox]"
          data-stack="2" @click="changeKind">
            DataBase
          </div>
          <div :class="[techStackKind === 3 ? techStackBoxSelected : '', techStackBox]"
          data-stack="3" @click="changeKind">
            Framework
          </div>
        </td>
      </tr>
      <tr>
        <th>기술스택명</th>
        <td><input type="text" :placeholder="technologyStack.name"></td>
      </tr>
      <tr>
        <th>레벨</th>
        <td class="pl-15">
          <input type="range" min="0" max="100" v-model="sliderValue" class="range"/>
          <span class="range-value">{{ sliderValue }}</span>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p2-career" :placeholder="technologyStack.description"></textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateTechStack',
  props: {
    technologyStack: {
      type: Object,
    },
    index: {
      type: Number,
    },
  },
  data() {
    return {
      techStackKind: this.technologyStack.kind,
      techStackBox: 'tech-stack-box',
      techStackBoxSelected: 'tech-stack-selected',
      sliderValue: 50,
      idx: this.index,
      picker: '',
    };
  },
  methods: {
    changeKind(event) {
      const Now = event.target.getAttribute('data-stack') - 1;
      this.techStackKind = Now + 1;
      const stackList = document.querySelectorAll('.tech-stack-box');
      for (let i = this.index * 3; i < this.index * 3 + 3; i += 1) {
        if (Now === (i % 3)) {
          stackList[i].className = 'tech-stack-box tech-stack-selected';
        } else stackList[i].className = 'tech-stack-box';
      }
    },
  },
};
</script>

<style>

</style>
