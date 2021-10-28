<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>프로젝트명</th>
        <td><input type="text" :placeholder="project.title"></td>
      </tr>
      <tr>
        <th>인원</th>
        <td><input type="number" :placeholder="project.member_cnt"></td>
        <th class="pl-15">역할</th>
        <td><input type="text" :placeholder="project.role"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type="text" :placeholder="project.start_date"></td>
        <th class="pl-15">종료일</th>
        <td><input type="text" :placeholder="project.end_date"></td>
      </tr>
      <tr>
        <th>요약</th>
        <td colspan="4">
          <textarea class="resume-p5-summary" :placeholder="project.summary"></textarea>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p5-project" :placeholder="project.description"></textarea>
        </td>
      </tr>
      <tr>
        <th>사용스택</th>
        <td colspan="4">
          <input type="text" :placeholder="project.title" class="project-input-width">
        </td>
      </tr>
      <tr>
        <th>링크</th>
        <td colspan="4">
          <input type="text" :placeholder="project.title" class="project-input-width">
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateProject',
  props: {
    project: {
      type: Object,
    },
  },
};
</script>

<style>

</style>
