package com.example.sbsj_process.order.cart.entity;

import com.example.sbsj_process.product.entity.ProductInfo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @Getter
    @Column(length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo; // product로 수정 생각해보기

    @Column(length = 16)
    private Long count;
    // 상품 개수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartItem createCartItem(Cart cart, ProductInfo productInfo, Long count) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProductInfo(productInfo);
        cartItem.setCount(count);
        return cartItem;
    }

    // 이미 담겨있는 물건 또 담을 경우 수량 증가
    public void addCount(Long count) {
        this.count += count;
    }
}
