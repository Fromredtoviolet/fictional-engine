<template>
    <div class="mt-10 mx-5">
        <div v-if="!deliveryList || (Array.isArray(deliveryList) && deliveryList.length === 0)">
            <div class="d-flex justify-end mb-5">
                <my-page-register-address-form @submit="onSubmit"/>
            </div>
            <div class="d-flex justify-center">
                <h1 class="mt-10">아무것도 없음</h1>
            </div>
        </div>
        <div v-else>
            <div class="d-flex justify-end mb-5">
                <my-page-register-address-form @submit="onSubmit"/>
            </div>
            <v-card v-for="delivery in deliveryList" :key="delivery.addressId" class="mb-5 rounded-xl">
                <v-card-title style="font-size: 20px;">
                    <strong>[{{ delivery.addressType }}]&nbsp;{{ delivery.addressName }}</strong> <br>
                </v-card-title>
                <div v-if="delivery.defaultAddress" style="font-size: 15px;">
                    <span class="ms-4 p-1 border border-1 border-secondary rounded-pill w-10">기본배송지</span>
                </div>
                
                <v-card-text style="font-size: 18px;">
                    <div class="mb-1">수령인: {{ delivery.recipientName }}</div>
                    <div class="mb-1">{{ delivery.city }} {{ delivery.street }} {{ delivery.addressDetail }} {{ delivery.zipcode }}</div>
                    <div class="mb-1">{{ delivery.phoneNumber }}</div>
                </v-card-text>
                <v-card-actions class="ms-2 pb-5 pt-0">
                    <v-btn class="w-10"
                    @click="modify($event.target)">수정</v-btn>
                </v-card-actions>
            </v-card>
        </div>
    </div>
</template>
  
<script>
import MyPageRegisterAddressForm from "@/components/mypage/MyPageRegisterAddressForm.vue"
import {mapActions, mapState} from "vuex";

const orderModule = 'orderModule'

export default {
    name: "MyPageDeliveryForm",
    components: { MyPageRegisterAddressForm },
    data(){
        return{
        
        }
    },
    computed : {
        ...mapState(orderModule, ['deliveryList'])
    },
    mounted() {
        // 로그인 체크
    },
    methods:{
        ...mapActions(orderModule, ['reqMyPageRegisterDeliveryToSpring']),

        onSubmit(payload) {
            this.reqMyPageRegisterDeliveryToSpring(payload);
        }
    },
}
</script>

<style scoped>

</style>