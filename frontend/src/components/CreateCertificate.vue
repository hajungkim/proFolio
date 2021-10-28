<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>주최기관</th>
      <td><input type="text" :placeholder="certificate.organization"></td>
    </tr>
    <tr>
      <th>시험명</th>
      <td><input type="text" :placeholder="certificate.name"></td>
      <th class="pl-15">취득일</th>
      <td><input type="text" :placeholder="certificate.certified_date"></td>
    </tr>
  </table>
</div>
</template>

<script>
export default {
  name: 'CreateCertificate',
  props: {
    certificate: {
      type: Object,
    },
  },
};
</script>

<style>

</style>
