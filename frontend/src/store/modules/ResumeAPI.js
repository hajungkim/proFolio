import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
});

function putEducation(id, data) {
  return axiosService.put(`resume/education/${id}`, data);
}
function deleteEducation(id) {
  return axiosService.delete(`resume/education/${id}`);
}
function getEducation(userId) {
  return axiosService.get(`resume/education/${userId}`);
}
function postEducation(data) {
  return axiosService.post('resume/education', data);
}
export {
  putEducation, deleteEducation, getEducation, postEducation,
};
