package com.example.sbsj_process.order.cart.service;

import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;

public interface CartService {

    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest);
}
