package com.example.sbsj_process.order.service;

import com.example.sbsj_process.order.service.request.PaymentRegisterRequest;

public interface OrderService {

    public Boolean registerOrderInfo(PaymentRegisterRequest paymentRegisterRequest);
}
