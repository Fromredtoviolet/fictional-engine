package com.example.sbsj_process.order.cart.controller;

import com.example.sbsj_process.account.entity.Member;
import com.example.sbsj_process.order.cart.dto.request.AddCartRequest;
import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;
import com.example.sbsj_process.order.cart.service.CartService;
import com.example.sbsj_process.product.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CartController {

    private CartService cartService;

    @PostMapping("/deleteCartItem")
    public void deleteCartItem(@RequestBody SelectCartItemRequest selectCartItemRequest) {
        log.info("회원 카트에서 선택된 아이템 삭제");
        cartService.deleteCartItem(selectCartItemRequest);
    }

    @PostMapping("/addCartItem")
    public void addCartItem(@RequestBody AddCartRequest addCartRequest) {
        log.info("회원 카트에 아이템 추가" + addCartRequest.toString());
        cartService.addCartItem(addCartRequest.toAddCartRequest());

    }






}
