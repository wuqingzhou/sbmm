import axios from 'axios'

export default {
  getTbUserList(json) {
    return axios.get('/api/tbUser/list', {params: json}).then(function (res) {
      return res;
    })
  }
}
