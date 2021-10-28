<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>대회명</th>
      <td><input type="text" :placeholder="award.name"></td>
    </tr>
    <tr>
      <th>성적</th>
      <td><input type="text" :placeholder="award.prize"></td>
      <th>날짜</th>
      <td><input type="text" :placeholder="award.awards_date"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="4" >
        <textarea type="text" :placeholder="award.description" class="resume-p2-award"/>
      </td>
    </tr>
  </table>
</div>
</template>

<script>
export default {
  name: 'CreateAward',
  props: {
    award: {
      type: Object,
    },
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
