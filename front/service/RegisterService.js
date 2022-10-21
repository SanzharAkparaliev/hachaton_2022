import axios from "axios";

const route = 'http://localhost:8081/auth/sign-in'
export  function login( data) {
    return axios.post(route, data).then((response)=>{
      this.$router.push('/')
    })

}
