package com.example.sbsj_process.order.controller;

import com.example.sbsj_process.order.controller.form.PaymentRegisterForm;
import com.example.sbsj_process.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    final OrderService service;

    @PostMapping("/register")
    public Boolean orderRegister(@RequestBody PaymentRegisterForm paymentRegisterForm){
        System.out.println("프론트에서 잘 받았나: " + paymentRegisterForm);

        return service.registerOrderInfo(paymentRegisterForm.toOrderRegisterRequest());
    }



//
//    @PostMapping("/kakaoPay")
//    public String kakaoPay() {
//
//        try {
//            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Authorization", "KakaoAK c8f1bb4cc49e916f23f0662b33b3ea01");
//            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//            connection.setDoOutput(true);
//
//            String params = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=좋은약&quantity=1" +
//                    "&total_amount=5000&vat_amount=500&tax_free_amount=0&approval_url=http://localhost:8080/purchase-success" +
//                    "&cancel_url=http://localhost:8080/purchase-cancel&fail_url=http://localhost:8080/purchase-fail";
//            OutputStream os = connection.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
//            dos.writeBytes(params);
//            dos.close();
//
//            int responseCode = connection.getResponseCode();
//
//            InputStream is;
//            if(responseCode == 200) {
//                is = connection.getInputStream();
//            } else {
//                is = connection.getErrorStream();
//            }
//
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String result = br.readLine();
//
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "(\"result\":\"NO\")";
//    }
}
