package com.example.sbsj_process.order.cart.repository;

import com.example.sbsj_process.order.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
