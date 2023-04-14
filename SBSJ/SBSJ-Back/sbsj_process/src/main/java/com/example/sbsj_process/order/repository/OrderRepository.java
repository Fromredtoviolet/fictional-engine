package com.example.sbsj_process.order.repository;

import com.example.sbsj_process.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByMember_MemberId(Long memberId);
}
