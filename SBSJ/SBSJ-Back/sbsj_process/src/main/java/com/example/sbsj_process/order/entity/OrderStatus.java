package com.example.sbsj_process.order.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PAYMENT_COMPLETE("결제 완료"),
    DELIVERY_PREPARING("배송 준비중"),
    DELIVERING("배송중"),
    DELIVERED("배송 완료"),
    CANCEL("주문 취소"),
    EXCHANGE("교환"),
    REFUND("환불");

    private final String orderStatus;
}
