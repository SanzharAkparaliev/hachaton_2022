<template>
  <div class="container">
    <div class="sign-in__block">
      <div class="sign-in__block_content">
        <div class="sign-in__block_img">
          <img :src="signin" alt="photo">
        </div>
      </div>
      <div class="sign-in__block_content">
        <div class="sign-in__block_form">
          <h2 class="sign-in__title">Вход</h2>

          <NuxtLink to="/register"><h3 class="sign-in__subtitle">Регистрация</h3></NuxtLink>
          <form action="" class="contact__form">
            <div class="contact__inputs">
              <div class="contact__content">
                <label class="contact__label"></label>
                <v-text-field type="text" class="contact__input"
                              label="Username"
                              v-model="loginRequest.username"/>
              </div>
              <div class="contact__content">
                <label class="contact__label"></label>
                <v-text-field type="password" class="contact__input"
                              label="Пароль"
                              v-model="loginRequest.password"/>
              </div>
            </div>

            <div>
              <button class="contact__button"
                      @click="login(loginRequest)">Войти
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import signin from 'assets/img/sign in.png'
import signinWinter from 'assets/img/sign inwinter.png'
import * as registerService from '@/service/RegisterService'


export default {
  name: "Login",
  data() {
    return {
      signin: signin,
      signinWinter: signinWinter,
      loginRequest: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login(data) {
      let response = registerService.login(data)
      alert(response)
    }
  }

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat+Alternates:wght@300;400;500;600;700;800&display=swap');

*, *::before, *::after{
  margin: 0;
  padding: 0;
  border: none;
  box-sizing: border-box;
  font-family: 'Montserrat Alternates', sans-serif;
}
a{
  text-decoration: none;
  color: unset;
}
.container{
  width: 80%;
  margin: 0 auto;

}
.navbar{
  display:flex;
  align-items: center;
  justify-content: center;
  background-color: white;
  padding: 0 30px;
  border-radius: 0px 0px 15px 15px;
  box-shadow: 0px 7px 15px rgba(41, 71, 38, 0.6);
}
.main{
  margin-top: 60px;
}
.sign-in__block{
  display: flex;
  justify-content: space-around;
  align-items: flex-start;
}
.sign-in__block_content{
  margin: 0 70px;
}

.sign-in__block_img img{
  width: 650px;
  border-color: #000;
}

.sign-in__block_form{
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 400px;
  height: 500px;
  /* border: 1px solid #000; */
  border-radius: 15px;
  box-shadow: 0px 7px 15px rgba(41, 71, 38, 0.6);
}
.sign-in__title{
  margin-top: 53px;
  font-size: 32px;
  font-weight: 400;
}
.sign-in__subtitle{
  margin-top: 12px;
  font-size: 20px;
  font-weight: 500;
  color: #584308CC;
}
.contact__content{
  margin-top: 35px;
}
.contact__content:first-child{
  margin-top: 90px;
}
.contact__button{
  display: flex;
  justify-content: center;
  margin-top: 130px;
  height: 34px;
  width: 146px;
  border-radius: 8px;
  padding: 7px 32px 7px 32px;
  color: white;
  background-color:#E7AB07;
  text-align: center;
  align-items: center;
}
</style>
