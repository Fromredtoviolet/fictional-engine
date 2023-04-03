import {
    REQUEST_CART_ITEM_TO_SPRING,
} from "./mutation-types"

export default { 
    [REQUEST_CART_ITEM_TO_SPRING](state, passingData) {
        state.cartItem = passingData
    }
}