package com.example.sbsj_process.order.cart.service;

import com.example.sbsj_process.account.entity.Member;
import com.example.sbsj_process.account.repository.MemberRepository;
import com.example.sbsj_process.order.cart.dto.request.AddCartRequest;
import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;
import com.example.sbsj_process.order.cart.entity.Cart;
import com.example.sbsj_process.order.cart.entity.CartItem;
import com.example.sbsj_process.order.cart.repository.CartItemRepository;
import com.example.sbsj_process.order.cart.repository.CartRepository;
import com.example.sbsj_process.product.entity.Product;
import com.example.sbsj_process.product.entity.ProductInfo;
import com.example.sbsj_process.product.repository.ProductInfoRepository;
import com.example.sbsj_process.product.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Setter
@Getter
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ProductInfoRepository productInfoRepository;


    @Override
    public void addCartItem(AddCartRequest addCartRequest) {

        Long memberNo = addCartRequest.getMemberNo();
        Long productId = addCartRequest.getProductId();
        Long count = addCartRequest.getCount();

        Optional<Cart> maybeCart = cartRepository.findByMemberNo(memberNo);

        // 카트가 생성되어 있지 않다면
        if(maybeCart.isEmpty()){
            Optional<Member> maybeMember = memberRepository.findByMemberNo(memberNo);
            Member member = maybeMember.get();

            Cart cart = Cart.builder() // 빌더 (@Builder) 참고
                    .member(member)
                    .totalCount(0L)
                    .build();

            cartRepository.save(cart);
        }

        // 카트에 아이템 추가할 때
        maybeCart = cartRepository.findByMemberNo(memberNo);
        Cart cart = maybeCart.get();

            //Optional<Product> maybeProduct = productRepository.findByProductId(productId);
        Optional<ProductInfo> maybeProductInfo = productInfoRepository.findByProductId(productId);

            //Product product = maybeProduct.get();
        ProductInfo productInfo = maybeProductInfo.get();

        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .productInfo(productInfo)
                .count(count)
                .build();

        cart.setTotalCount(cart.getTotalCount() + 1);
        cartRepository.save(cart);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest){
        List<Long> deleteCartItemId = selectCartItemRequest.getSelectCartItemId();

        for (int i = 0; i < deleteCartItemId.size() ; i++) {
            cartItemRepository.deleteById(deleteCartItemId.get(i));
        }

    }
}
