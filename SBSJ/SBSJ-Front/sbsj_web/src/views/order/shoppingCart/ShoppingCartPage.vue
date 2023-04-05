<template>
  <div>
    <shopping-cart-form/>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import ShoppingCartForm from '@/components/order/ShoppingCartForm.vue'

const orderModule = 'orderModule'
const accountModule = 'accountModule'

export default {
    name: "ShoppingCartPage",
    components: { ShoppingCartForm },
    computed: {
        ...mapState(accountModule, {
            isAuthenticated: state => state.isAuthenticated
        }),
    },
    methods:{
        ...mapActions(orderModule, [
            'reqCartItemListToSpring'
        ]),
    },
    async mounted () { 
        if(this.isAuthenticated === true) {
            let tokenObj = localStorage.getItem('userInfo');
            let token = await tokenObj.token;

            console.log(token);

            this.reqCartItemListToSpring(token)
        }
    },    
}
</script>

<style scoped>

</style>