import {
    REQUEST_COMPLETE_ORDER_LIST_TO_SPRING,
    REQUEST_COMPLETE_ORDER_TO_SPRING
} from "./mutation-types";

export default { 
    [REQUEST_COMPLETE_ORDER_LIST_TO_SPRING](state, passingData) {
        state.completeOrderList = passingData
    },
    [REQUEST_COMPLETE_ORDER_TO_SPRING](state, passingData) {
        state.selectOrder = passingData
    }
}