package com.example.sbsj_process.order.service.response;

import com.example.sbsj_process.order.entity.OrderInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class OrderListResponse {

    // 프론트에 '주문 내역 목록' 조회를 위해 반환해줄 것들
    // 대표 상품명, 주문상품이 몇 종인지, 구매한 상품 갯수, 배송비 포함 총 결제액, 주문번호, 주문날짜

    private Long orderId;
    // pk (오더인포)

    private String orderNo;
    // 주문 번호 (오더인포)

    private Date orderDate;
    // 주문 날짜 (오더인포)

    private Long orderTotalCount;
    // 주문 하나당 주문상품 몇 종인지

    private Long amount;
    // 총 가격 (페이먼트)

    private String productName;
    // 대표상품명


    public OrderListResponse(OrderInfo orderInfo, Long amount, String productName) {
        this.orderId = orderInfo.getOrderId();
        this.orderNo = orderInfo.getOrderNo();
        this.orderDate = orderInfo.getOrderDate();
        this.orderTotalCount = orderInfo.getOrderTotalCount();
        this.amount = amount;
        this.productName = productName;
    }

}
