<template>
  <div>
    <shopping-cart-form/>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import ShoppingCartForm from '@/components/order/ShoppingCartForm.vue'

export default {
    name: "ShoppingCartPage",
    components: { ShoppingCartForm },
    methods:{
      ...mapActions([
        'reqMyCartListFromSpring',
      ]),
    },
    mounted() {
      
    },
}
</script>

<style scoped>

</style>