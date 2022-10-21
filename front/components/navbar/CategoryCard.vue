<template>
  <v-card class="sport__equip_card"
          align="center"
          @click="$router.push(link)">
    <v-card-title class="equip_title" align="center">{{ title }}</v-card-title>
    <v-card-text>
      <img :src="image" alt="category img">
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: "CategoryCard",
  props: ['image', 'title', 'link']
}
</script>

<style scoped>
.sport__equip_card img{
  width: 250px;
  height: auto;
}
.sport__equip_card{
  background-color: #fff;
  width: 300px;
  height: 400px;
  margin-left: 30px;
  box-shadow: 0px 7px 15px rgba(41, 71, 38, 0.6);
  border-radius: 7px;
}
.equip_title{
  margin-top: 35px;
  font-weight: 500;
  font-size: 18px;
  margin-bottom: 45px;
}
</style>

