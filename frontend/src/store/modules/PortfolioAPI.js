import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
});

function getPortfolio(userId) {
  return axiosService.get(`portfolio/list?userId=${userId}`);
}
function postEducation(data) {
  return axiosService.post('portfolio/upload', data);
}
export {
  getPortfolio, postEducation,
};
