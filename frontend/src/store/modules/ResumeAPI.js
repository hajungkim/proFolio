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
function putCertificate(id, data) {
  return axiosService.put(`resume/certificate/${id}`, data);
}
function deleteCertificate(id) {
  return axiosService.delete(`resume/certificate/${id}`);
}
function getCertificate(userId) {
  return axiosService.get(`resume/certificate/${userId}`);
}
function postCertificate(data) {
  return axiosService.post('resume/certificate', data);
}
function putAwards(id, data) {
  return axiosService.put(`resume/awards/${id}`, data);
}
function deleteAwards(id) {
  return axiosService.delete(`resume/awards/${id}`);
}
function getAwards(userId) {
  return axiosService.get(`resume/awards/${userId}`);
}
function postAwards(data) {
  return axiosService.post('resume/awards', data);
}
function putTech(id, data) {
  return axiosService.put(`resume/technology/${id}`, data);
}
function deleteTech(id) {
  return axiosService.delete(`resume/technology/${id}`);
}
function getTech(userId) {
  return axiosService.get(`resume/technology/${userId}`);
}
function postTech(data) {
  return axiosService.post('resume/technology', data);
}
function putProject(id, data) {
  return axiosService.put(`resume/project/${id}`, data);
}
function deleteProject(id) {
  return axiosService.delete(`resume/project/${id}`);
}
function getProject(userId) {
  return axiosService.get(`resume/project/${userId}`);
}
function postProject(data) {
  return axiosService.post('resume/project', data);
}
export {
  putEducation, deleteEducation, getEducation, postEducation, putCareer, deleteCareer,
  getCareer, postCareer, putActivity, deleteActivity, getActivity, postActivity,
  putLanguage, deleteLanguage, getLanguage, postLanguage, putCertificate, deleteCertificate,
  getCertificate, postCertificate, putAwards, deleteAwards, getAwards, postAwards,
  putTech, deleteTech, getTech, postTech, putProject, deleteProject, getProject, postProject,
};
