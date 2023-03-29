package com.example.sbsj_process.order.cart.controller;

import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CartController {

    @PostMapping("/addItem")
    public void addCartItem() {
        log.info("회원 카트에 새로운 상품이 추가");

    }


    @PostMapping("/deleteItem")
    public void deleteCartItem(@RequestBody SelectCartItemRequest selectCartItemRequest) {
        log.info("회원 카트에서 선택된 아이템 삭제");
        //cartService.deleteCartItem(selectCartItemRequest);
    }

}
