package com.example.sbsj_process.order.cart.service;

import com.example.sbsj_process.order.cart.dto.request.AddCartRequest;
import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;

public interface CartService {

    public void addCartItem(AddCartRequest addCartRequest);
    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest);







}
