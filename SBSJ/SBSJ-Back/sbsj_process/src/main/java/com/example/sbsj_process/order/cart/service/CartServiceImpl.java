package com.example.sbsj_process.order.cart.service;

import com.example.sbsj_process.order.cart.dto.request.SelectCartItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest){
        List<Long> deleteCartItemNo = selectCartItemRequest.getSelectCartItemNo();


        }
    }
}
