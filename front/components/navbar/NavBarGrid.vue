<template>
  <div >
    <div class="hero">
      <h1 class="hero__title">Сейчас самое идеальное время для занятие спортом!</h1>
      <div class="hero__search_block">
        <select class="form-select" aria-label="Default select example">
          <option selected>Велосипед</option>
          <option value="1">Самокат</option>
          <option value="2">Скутер</option>
          <option value="3">Ролики</option>
          <option value="4">Сноуборд</option>
          <option value="5">Лыжи</option>
        </select>
        <select class="form-select" aria-label="Default select example">
          <option selected>Размер</option>
          <option value="1">36</option>
          <option value="2">37</option>
          <option value="3">38</option>
          <option value="4">39</option>
          <option value="5">40</option>
          <option value="6">41</option>
          <option value="7">42</option>
          <option value="8">43</option>
          <option value="9">44</option>
        </select>
        <select class="form-select" aria-label="Default select example">
          <option selected>Модель</option>
          <option value="1">2020</option>
          <option value="2">2021</option>
          <option value="3">2022</option>
        </select>
        <select class="form-select" aria-label="Default select example">
          <option selected>Цвет</option>
          <option value="1">Белый</option>
          <option value="2">Чёрный</option>
          <option value="3">Синий</option>
        </select>

        <div class="search_block__button">
          <NuxtLink to="/catalog">
            <button>Поиск</button>
          </NuxtLink>


        </div>
      </div>
      <div class="sport__equip">
        <category-card :title="'Велосипед'"
                       :image="bicycle1"
                       :link="'/catalog/bicycles'"/>
        <category-card :title="'Сноуборд'"
                       :image="snowboard"
                       :link="'/catalog/snowboards'"/>
        <category-card :title="'Лыжи'"
                       :image="ski"
                       :link="'/catalog/skies'"/>
        <category-card :title="'Велосипед'"
                       :image="bicycle2"
                       :link="'/catalog/bicycles'"/>
      </div>
    </div>
    <main class="main">
      <div class="container">
        <div class="qualities__block">
          <div class="qualities__block_card">
            <div class="card__icon">
              <img :src="clock" alt="clock">
            </div>
            <div class="card__title">Быстро</div>
            <div class="card__subtitle">Благодоря нам вы можете сэкономить время на поиск нужных вам товаров</div>
          </div>
          <div class="qualities__block_card">
            <div class="card__icon">
              <img :src="couch" alt="clock">
            </div>
            <div class="card__title">Удобно</div>
            <div class="card__subtitle">Теперь вам не нужно объезжать целый город в поисках какого-либо товара</div>
          </div>
          <div class="qualities__block_card">
            <div class="card__icon">
              <img :src="money" alt="clock">
            </div>
            <div class="card__title">Экономно</div>
            <div class="card__subtitle">Закажи через нас и получи приятную скидку</div>
          </div>
        </div>
        <div class="action__block">
          <div class="action__block__content">
            <button class="collapsible">Акции дня</button>
            <div class="contents">
              <img :src="action" alt="">
              <h2>Акционные товары</h2>
              <p>Сегодня проходят акции на товары велосипед от магазина”Gerger Sport”. Вся продукция будет со скидкой 70%.
                Успей забронировавть для поездки со своими друзьями
              </p>
            </div>
          </div>
          <div class="action__block__content">
            <button class="collapsible">Панорама</button>
            <div class="contents">
              <img :src="panorama" alt="">
              <h2>Панорама</h2>
              <p>Сегодня будет фестиваль велосипедистов. Протяженность дороги составит 20 км. Начинается с Магистрали/ Аламатинка до панорама.
                Обязательно приходите и уаствуйте, будет много интересного и обязательно подарки)
              </p>
            </div>
          </div>
          <div class="action__block__content">
            <button class="collapsible">Новости жизни</button>
            <div class="contents">
              <img :src="news" alt="">
              <h2>Новости жизни</h2>
              <p>Сегодня идеальная погода для занятие спортом. Наши власти сделали велодоржки на илицах Советкая, Разакова и парк Дружбы
                Бронируйте велосипеды и протестируйте новые дороги
              </p>
            </div>
          </div>
        </div>
        <div class="support__block">
          <h2 class="support__title">Тех поддержка</h2>
          <div class="support__blocks">
            <div class="support__block_content">
              <div class="support__block_text">
                Если у вас есть какие проблемы или вопросы, то вы можете напиать нам в тех. поддержку и мы вам с радостью поможем
              </div>
              <div class="support__block_form">
                <div class="contact__inputs">
                  <div class="contact__content">
                    <label  class="contact__label"></label>
                    <input type="text" class="contact__input" placeholder="Имя">
                  </div>
                  <div class="contact__content">
                    <label  class="contact__label"></label>
                    <input type="email" class="contact__input"  placeholder="Email">
                  </div>
                  <div class="contact__content">
                    <label  class="contact__label"></label>
                    <input type="tel" maxlength="10" class="contact__input" placeholder="Номер телефона">
                  </div>
                </div>
                <div class="contact__input">
                  <textarea name="" id="text" cols="30" rows="7">Напиши чем вам помочь?</textarea>
                  <button class="contact__input_btn">Отправить</button>
                </div>
              </div>
            </div>
            <div class="support__block_content">
              <div class="support__block_img">
                <img :src="support" alt="photo">
              </div>
            </div>
          </div>
        </div>
        <div class="partner__block">
          <h2 class="pertner__title">Наши партнеры</h2>
          <div class="direction__block">
            <div class="directions">
              <img :src="urban" class="d-block w-280" alt="photo">
              <img :src="shyn" class="d-block w-280" alt="photo">
              <img :src="krafiki" class="d-block w-280" alt="photo">
              <img :src="nike" class="d-block w-280" alt="photo">
              <img :src="knicks" class="d-block w-280" alt="photo">
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import CategoryCard from "@/components/navbar/CategoryCard";
import bicycle1 from 'assets/img/bicycle1.png'
import bicycle2 from 'assets/img/bicycle2.png'
import ski from 'assets/img/ski.png'
import snowboard from 'assets/img/snowboard.png'
import shyn from 'assets/img/partner_shyn.png'
import krafiki from 'assets/img/partner_krafiki.png'
import nike from 'assets/img/partner_nike.png'
import knicks from 'assets/img/partner_knicks.png'
import urban from 'assets/img/partner_urban.png'
import news from 'assets/img/live news.png'
import clock from 'assets/icons/clock.svg'
import couch from 'assets/icons/couch_furniture_armchair.svg'
import money from 'assets/icons/Money-bag-euro.svg'
import action from 'assets/img/Actionphoto.png'
import panorama from 'assets/img/Panoramaphoto.png'
import support from 'assets/img/support.png'


export default {
  name: "NavBarGrid",
  components: {CategoryCard},
  data() {
    return {
      bicycle1: bicycle1,
      bicycle2: bicycle2,
      ski: ski,
      snowboard: snowboard,
      shyn:shyn,
      krafiki:krafiki,
      knicks:knicks,
      nike: nike,
      urban:urban,
      news:news,
      clock:clock,
      couch:couch,
      money:money,
      action:action,
      panorama:panorama,
      support:support,
      categories: ['Велосипед', 'Самокат', 'Лыжи', 'Скутер', 'Ролики', 'Сноуборд']
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

.hero__title {
  color: #2C4F22;
  font-size: 36px;
  text-align: center;
  margin-top: 130px;
  font-weight: 800;
}

.hero__search_block{
  display: flex;
  justify-content: center;
  margin-top: 40px;
  border-radius: 10px;
}

.search_block__button button{
  width: 200px;
  height: 38px;
  display: flex;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
  background-color:#2C4F22;
;
  color:#fff;
  border-radius: 7px;

}

.sport__equip {
  margin: 230px;
  display: flex;
  justify-content: center;
  text-align: center;
  padding-bottom: 10px;
}
.card__icon{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 120px;
  height: 120px;
  background-color: #2C4F22;
  border-radius: 50%;
}
.card__title{
  margin-top: 32px;
  font-size: 18px;
  font-weight: 600;

}
.card__subtitle{
  margin-top: 12px;
  font-size: 16px;
  font-weight: 400;
}
.action__block{
  margin-top: 115px;
}
.action__block__content{
  margin-top: 15px;
}
.qualities__block{
  display: flex;
  justify-content: space-evenly;
}
.qualities__block_card{
  width: 250px;
  margin-left: 180px;
}
.qualities__block_card:first-child{
  margin-left: 0;
}
.collapsible{
  width: 410px;
  height: 70px;
  color: #fff;
  background-color:#2C4F22;
  font-weight: 700;
  font-size: 24px;
  border-radius: 8px;
  text-align: center;
}
.active,
.collapsible:hover {
  background-color:gray;
}
/* .contents{
    display: none;
} */
.contents img {
  margin-top: 20px;
}
.contents h2{
  font-weight: 700;
  font-size: 48px;
}
.contents p{
  font-weight: 400;
  font-size: 20px;
}

.support__block{
  background-color:#2C4F22;
  border-radius: 15px;
  color: white;
  padding-top: 35px;
  margin-top: 70px;
}
.support__title{
  text-align: center;
  font-weight: 700;
  font-size: 48px;
}
.support__blocks{
  display: flex;
  justify-content: center;
  padding: 0 40px;
}
.support__block_text{
  margin-top: 70px;
  font-weight: 400;
  font-size: 18px;
}
.support__block_form{
  margin-top: 50px;
  font-weight: 400;
  font-size: 14px;
}
.contact__content{
  background-color: #2C4F22;
  /* border-radius: 15px; */
  height: 40px;
}
.contact__content input{
  border-radius: 5px;
}
.contact__input textarea{
  border-radius: 5px;
}
.contact__input button{
  margin-left: 30px;
  color:#2C4F22;
  background-color: #fff;
  font-weight: 500;
  font-size: 16px;
  border-radius: 7px;
  padding: 1px;
}

.partner__block{
  margin-top: 118px;
}
.partner__block h2{
  font-weight: 700;
  font-size: 48px;
  align-items: center;
  text-align: center;
  margin-bottom: 60px;
}

.directions{
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  margin: 0 40px;
}
.directions img{
  cursor: pointer;
}
</style>
