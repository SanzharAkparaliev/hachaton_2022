<template>
  <div class="container">
    <div class="navbar">
      <div class="nav__left">
        <ul class="nav-list">
          <li class="nav-item"
              @click="switchSeason">На лето
          </li>
          <li class="nav-item"
              @click="switchSeason">На зиму
          </li>
        </ul>
      </div>
      <div class="nav__center">
        <div class="logo">
          <NuxtLink to="/">
            <img :src="logo" alt="logo"/>
          </NuxtLink>
        </div>
      </div>
      <div class="nav__right">
        <div class="account">
          <div class="account_block">
            <img :src="accountCircle" alt="account circle">
          </div>
          <div class="account_block">
            <NuxtLink to="/login">Войти</NuxtLink>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import logo from 'assets/icons/logo 1.svg'
import accountCircle from '/assets/icons/Account circle.svg'

export default {
  name: "Header",
  data() {
    return {
      logo: logo,
      accountCircle: accountCircle
    }

  },
  methods: {
    switchSeason() {
      this.$emit('switch')
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat+Alternates:wght@300;400;500;600;700;800&display=swap');

*, *::before, *::after {
  margin: 0;
  padding: 0;
  border: none;
  box-sizing: border-box;
  font-family: 'Montserrat Alternates', sans-serif;
}

a {
  text-decoration: none;
  color: unset;
}

.container {
  width: 80%;
  margin: 0 auto;

}

template {
  background: url(assets/img/backgroundsummer.png);
  background-position: center;
  background-size: cover;
  /* background-color: #242b33; */
}

.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: white;
  padding: 0 30px;
  border-radius: 0px 0px 15px 15px;
  box-shadow: 0px 7px 15px rgba(41, 71, 38, 0.6);
}

.nav-list {
  display: flex;
  list-style: none;
}

.nav-item {
  margin-left: 15px;
  font-size: 16px;
  font-weight: 500;
}

.nav-item:first-child {
  margin-left: 0;
}

.account {
  display: flex;
  align-items: center;
}

.account_block {
  margin-left: 18px;
}

.account_block:first-child {
  margin-left: 0;
}

.hero__title {
  color: #2C4F22;
  font-size: 36px;
  text-align: center;
  margin-top: 130px;
  font-weight: 800;
}

.hero__search_block {
  display: flex;
  justify-content: center;
  margin-top: 40px;
  border-radius: 10px;
}

.search_block__button button {
  width: 200px;
  height: 38px;
  display: flex;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
  background-color: #2C4F22;;
  color: #fff;
  border-radius: 7px;

}

.sport__equip {
  margin: 230px;
  display: flex;
  justify-content: center;
  text-align: center;
  padding-bottom: 10px;
}

.equip_title {
  margin-top: 35px;
  font-weight: 500;
  font-size: 18px;
  margin-bottom: 45px;
}

.sport__equip_card {
  background-color: #fff;
  width: 300px;
  height: 350px;
  margin-left: 30px;
  box-shadow: 0px 7px 15px rgba(41, 71, 38, 0.6);
  border-radius: 7px;
}

.sport__equip_card:first-child {
  margin-left: 0;
}

.sport__equip_card img {
  width: 300px;
  height: auto;
}

.qualities__block {
  display: flex;
  justify-content: space-evenly;
}

.qualities__block_card {
  width: 250px;
  margin-left: 180px;
}

.qualities__block_card:first-child {
  margin-left: 0;
}

.card__icon {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 120px;
  height: 120px;
  background-color: #2C4F22;
  border-radius: 50%;
}

.card__title {
  margin-top: 32px;
  font-size: 18px;
  font-weight: 600;

}

.card__subtitle {
  margin-top: 12px;
  font-size: 16px;
  font-weight: 400;
}


.action__block {
  margin-top: 115px;
}

.action__block__content {
  margin-top: 15px;
}

.collapsible {
  width: 410px;
  height: 70px;
  color: #fff;
  background-color: #2C4F22;
  font-weight: 700;
  font-size: 24px;
  border-radius: 8px;
  text-align: center;
}

.active,
.collapsible:hover {
  background-color: gray;
}

/* .contents{
    display: none;
} */
.contents img {
  margin-top: 20px;
}

.contents h2 {
  font-weight: 700;
  font-size: 48px;
}

.contents p {
  font-weight: 400;
  font-size: 20px;
}

.support__block {
  background-color: #2C4F22;
  border-radius: 15px;
  color: white;
  padding-top: 35px;
  margin-top: 70px;
}

.support__title {
  text-align: center;
  font-weight: 700;
  font-size: 48px;
}

.support__blocks {
  display: flex;
  justify-content: center;
  padding: 0 40px;
}

.support__block_text {
  margin-top: 70px;
  font-weight: 400;
  font-size: 18px;
}

.support__block_form {
  margin-top: 50px;
  font-weight: 400;
  font-size: 14px;
}

.contact__content {
  background-color: #2C4F22;
  /* border-radius: 15px; */
  height: 40px;
}

.contact__content input {
  border-radius: 5px;
}

.contact__input textarea {
  border-radius: 5px;
}

.contact__input button {
  margin-left: 30px;
  color: #2C4F22;
  background-color: #fff;
  font-weight: 500;
  font-size: 16px;
  border-radius: 7px;
  padding: 1px;
}

.partner__block {
  margin-top: 118px;
}

.partner__block h2 {
  font-weight: 700;
  font-size: 48px;
  align-items: center;
  text-align: center;
  margin-bottom: 60px;
}

.directions {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  margin: 0 40px;
}

.directions img {
  cursor: pointer;
}

footer {
  margin-top: 100px;
  background-color: #2C4F22;
}

.footer__blocks {
  display: flex;
  justify-content: space-between;
  padding-top: 46px;
  padding-bottom: 45px;
}

.footer__block p {
  color: #A59292;
  font-weight: 400;
  font-size: 16px;
}

.footer__block span {
  font-weight: 600;
  font-size: 16px;
  color: #fff;
}

.footer__block:nth-child(2) {
  color: #fff;
}

.footer__block_social {
  display: flex;
  flex-direction: column;
}

.footer__block_social img {
  margin: 10px;
}
</style>
