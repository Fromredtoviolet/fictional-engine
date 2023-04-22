package com.example.sbsj_process.order.service.response;

import com.example.sbsj_process.order.entity.OrderInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class OrderListResponse {

    // 프론트에 '주문 내역 목록' 조회를 위해 반환해줄 것들

    private Long orderId;
    // pk (오더인포)

    private String orderNo;
    // 주문 번호 (오더인포)

    private Date orderDate;
    // 주문 날짜 (오더인포)

    private Long amount;
    // 총 가격 (페이먼트)

    public OrderListResponse(OrderInfo orderInfo, Long amount) {
        this.orderId = orderInfo.getOrderId();
        this.orderNo = orderInfo.getOrderNo();
        this.orderDate = orderInfo.getOrderDate();
        this.amount = amount;
    }

}
