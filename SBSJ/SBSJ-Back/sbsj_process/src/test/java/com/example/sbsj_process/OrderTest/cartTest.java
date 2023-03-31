package com.example.sbsj_process.OrderTest;

import com.example.sbsj_process.order.cart.dto.request.AddCartRequest;
import com.example.sbsj_process.order.cart.repository.CartItemRepository;
import com.example.sbsj_process.order.cart.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class cartTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartService cartService;

    @Test
    public void 장바구니에_상품_추가_테스트 () {
        AddCartRequest addCartRequest =
                new AddCartRequest(1L, 1L, 10000L);

        cartService.addCartItem(addCartRequest);

        System.out.println("장바구니 아이템 추가 테스트 완료");
    }

    @Test
    public void 장바구니에서_상품_삭제_테스트 () {
        cartItemRepository.deleteById(1L);

        System.out.println("장바구니 아이템 삭제 테스트 완료");
    }
}
