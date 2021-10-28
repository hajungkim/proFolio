<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>외국어명</th>
        <td><input type="text" :placeholder="language.language"></td>
        <th class="pl-15">취득일</th>
        <td><input type="text" :placeholder="language.certified_date"></td>
      </tr>
      <tr>
        <th>시험명</th>
        <td><input type="text" :placeholder="language.name"></td>
        <th class="pl-15">점수</th>
        <td><input type="text" :placeholder="language.score"></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateLanguage',
  props: {
    language: {
      type: Object,
    },
  },
};
</script>

<style>

</style>
