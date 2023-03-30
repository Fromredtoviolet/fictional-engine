import {
    
} from "./mutation-types";

import axios from "axios";

export default { 

    reqDeleteCartItemFromSpring({}, payload) {
        const selectCartItemId = payload

        return axios.post(`http://localhost:7777/cart/deleteCartItem`,
            { selectCartItemId })
            .then(() => {
                alert("장바구니에서 삭제되었습니다.")
            })
    },

    reqAddCartToSpring({}, payload) {
        const { memberNo, productId, count } = payload;

        return axios.post(`http://localhost:7777/cart/addCartItem`,
        { memberNo, productId, count })
        .then(() => {
            alert("장바구니에 추가되었습니다.")
        })
        .catch(() => {
            alert("문제가 발생하여 장바구니에 추가되지 않았습니다.")
        });
    }
}