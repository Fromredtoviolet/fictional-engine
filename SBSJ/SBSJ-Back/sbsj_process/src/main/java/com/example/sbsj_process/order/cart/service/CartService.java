package com.example.sbsj_process.order.cart.service;

import com.example.sbsj_process.account.entity.Member;
import com.example.sbsj_process.order.cart.dto.request.AddCartRequest;
import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;
import com.example.sbsj_process.product.entity.ProductInfo;

public interface CartService {

    public void addCartItem(AddCartRequest addCartRequest);
    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest);







}
