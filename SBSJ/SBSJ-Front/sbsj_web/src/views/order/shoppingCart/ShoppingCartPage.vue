<template>
  <div>
    <shopping-cart-form :cartItem="cartItem"/>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import ShoppingCartForm from '@/components/order/ShoppingCartForm.vue'

const orderModule = 'orderModule'

export default {
    name: "ShoppingCartPage",
    components: { ShoppingCartForm },
    computed: {
        ...mapState(
            orderModule, ['cartItem'] 
        ),
    },
    methods:{
        ...mapActions(orderModule, [
            'reqCartItemToSpring'
        ]),
    },
    async created () { 
        this.cartItem = {}; // cartItem 초기화
        await this.reqCartItemToSpring(); 
    }    
}
</script>

<style scoped>

</style>