<template>
  <v-app>
    <header/> <!-- 건호씨가 만든 상단 내비 바 자리-->
    <v-content> <!-- 바디 -->
      <router-view/>
    </v-content>
    <Footer/>
  </v-app>
</template>

<script>
// import Header from ~~ 내비 바 임포트
import Footer from '@/views/layoutForm/Footer.vue';

export default {
  name: 'App',

  data: () => ({
    //
  }),
  components: {
    Footer
  }
};
</script>
