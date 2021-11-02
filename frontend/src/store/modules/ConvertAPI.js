import axios from 'axios';

const axiosService = axios.create({
  baseURL: process.env.VUE_APP_DJANGO_URL,
});

axiosService.defaults.xsrfCookieName = 'csrftoken';
axiosService.defaults.xsrfHeaderName = 'X-CSRFToken';
axiosService.defaults.withCredentials = true;
// axiosService.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';
// axiosService.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

const convert = (formData) => axiosService.post('convert/', formData, {
  headers: {
    'Content-Type': 'multipart/form-data',
  },
});

export default convert;
