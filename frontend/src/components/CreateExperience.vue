<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>활동명</th>
        <td><input type="text" :placeholder="activity.name"></td>
        <th class="pl-15">활동기관</th>
        <td><input type="text" :placeholder="activity.organization"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type="text" :placeholder="activity.start_date"></td>
        <th class="pl-15">종료일</th>
        <td><input type="text" :placeholder="activity.end_date"></td>
      </tr>
      <tr>
        <th>활동내용</th>
        <td colspan="4">
          <textarea class="resume-p2-exp" :placeholder="activity.description"></textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateExperience',
  props: {
    activity: {
      type: Object,
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
