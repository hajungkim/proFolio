import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
});

function getPortfolio(userId) {
  return axiosService.get(`portfolio/list?userId=${userId}`);
}
function postPortfolio(data) {
  return axiosService.post('portfolio/upload', data, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
}
function deletePortfolio(id) {
  return axiosService.delete(`portfolio/${id}`);
}
export {
  getPortfolio, postPortfolio, deletePortfolio,
};
