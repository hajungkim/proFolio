import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
});

function login(social) {
  window.location.href = `${process.env.VUE_APP_API_URL}/auth/${social}`;
}

function getUserInfo(userId) {
  return axiosService.get(`user/${userId}`);
}

function putUserInfo(userId, userInfo) {
  return axiosService.put(`user/${userId}`, userInfo, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
}

export { login, getUserInfo, putUserInfo };
