import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
});

function login(social) {
  return axiosService.get(`auth/${social}`, {
    headers: { 'Access-Control-Allow-Origin': '*' },
  });
}

function getUserInfo(userId) {
  return axiosService.get(`user/${userId}`);
}

function putUserInfo(userId, userInfo) {
  return axiosService.put(`user/${userId}`, userInfo);
}

export { login, getUserInfo, putUserInfo };
