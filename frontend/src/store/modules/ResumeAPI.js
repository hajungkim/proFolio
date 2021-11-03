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
function putCareer(id, data) {
  return axiosService.put(`resume/career/${id}`, data);
}
function deleteCareer(id) {
  return axiosService.delete(`resume/career/${id}`);
}
function getCareer(userId) {
  return axiosService.get(`resume/career/${userId}`);
}
function postCareer(data) {
  return axiosService.post('resume/career', data);
}
function putActivity(id, data) {
  return axiosService.put(`resume/activity/${id}`, data);
}
function deleteActivity(id) {
  return axiosService.delete(`resume/activity/${id}`);
}
function getActivity(userId) {
  return axiosService.get(`resume/activity/${userId}`);
}
function postActivity(data) {
  return axiosService.post('resume/activity', data);
}
function putLanguage(id, data) {
  return axiosService.put(`resume/foreign/${id}`, data);
}
function deleteLanguage(id) {
  return axiosService.delete(`resume/foreign/${id}`);
}
function getLanguage(userId) {
  return axiosService.get(`resume/foreign/${userId}`);
}
function postLanguage(data) {
  return axiosService.post('resume/foreign', data);
}
export {
  putEducation, deleteEducation, getEducation, postEducation, putCareer, deleteCareer,
  getCareer, postCareer, putActivity, deleteActivity, getActivity, postActivity,
  putLanguage, deleteLanguage, getLanguage, postLanguage,
};
