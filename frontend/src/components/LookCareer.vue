<template>
  <div class="resume-exp">
    <div>
      <span class="font-weight-b font-20">{{ career.company }}</span>
      <span class="ml-15">{{ career.startDate }} ~ {{ career.endDate }}</span>
    </div>
    <table class="read-resume-table">
      <tr>
        <th>직무</th>
        <td>{{ career.duty }}</td>
      </tr>
      <tr>
        <th>활동 내용</th>
        <!-- <td>{{ career.description }}</td> -->
        <td v-html="adjustHtml(career.description)"></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'LookCareer',
  props: {
    career: {
      type: Object,
    },
  },
  methods: {
    adjustHtml(strVal) {
      return strVal.replace(/(\n|\r\n)/g, '<br>');
    },
  },
};
</script>

<style>

</style>
