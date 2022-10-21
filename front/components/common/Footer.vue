<template>
  <footer class="footer">
    <div class="container">
      <div class="footer__blocks">
        <div class="footer__block">
          <p>
            Представленная на сайте информация<br>
            носит справочный характер и не является<br>
            публичной офертой
          </p>
          <span>Пользовательское соглашение</span>
        </div>
        <div class="footer__block">
          +996 (555) 555-777<br>
          +996 (777) 555-777<br>
          <br>
          sport.tovar@mail.ru<br>
          sport.vsem@mail.ru
        </div>
        <div class="footer__block">
          <div class="footer__block_social">
            <img :src="facebook" alt="social icons">
            <img :src="vk" alt="social icons">
            <img :src="instagram" alt="social icons">
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
import facebook from 'assets/icons/facebook footer.svg'
import vk from 'assets/icons/vk footer.svg'
import instagram from 'assets/icons/instagram footer.svg'
export default {
  name: "Footer",
  data() {
    return{
      facebook:facebook,
      vk:vk,
      instagram:instagram
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

.container{
  width: 80%;
  margin: 0 auto;

}

footer{
  margin-top: 100px;
  background-color: #2C4F22;
}
.footer__blocks{
  display: flex;
  justify-content: space-between;
  padding-top: 46px;
  padding-bottom: 45px;
}
.footer__block p{
  color:#A59292;
  font-weight: 400;
  font-size: 16px;
}
.footer__block span{
  font-weight: 600;
  font-size: 16px;
  color: #fff;
}
.footer__block:nth-child(2){
  color:#fff;
}
.footer__block_social{
  display: flex;
  flex-direction: column;
}
.footer__block_social img{
  margin: 10px;
}
</style>
