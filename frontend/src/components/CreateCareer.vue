<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>기업명</th>
        <td>
          <input type="text"
          :placeholder="career.company">
        </td>
        <th class="pl-15">직무</th>
        <td><input type="text" :placeholder="career.duty"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type="text" :placeholder="career.start_date"></td>
        <th class="pl-15">종료일</th>
        <td><input type="text" :placeholder="career.end_date"></td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="4">
          <textarea class="resume-p2-career" :placeholder="career.description"></textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateCareer',
  props: {
    career: {
      type: Object,
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
