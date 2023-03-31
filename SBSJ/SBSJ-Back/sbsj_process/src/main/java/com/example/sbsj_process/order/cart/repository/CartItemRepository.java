package com.example.sbsj_process.order.cart.repository;

import com.example.sbsj_process.order.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


}
