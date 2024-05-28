package com.hungslab.urban.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hungslab.urban.core.Config.AlipayConfig;
import com.hungslab.urban.pojo.AlipayOrderVO;
import org.springframework.stereotype.Service;


/**
 * @author hungs
 * @date 2024-05-06
 * @Description
 */
@Service
public class PayService {
    public String saveOrderInfo(AlipayOrderVO alipayOrderVO) {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type
        );
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent(JSON.toJSONString(alipayOrderVO));
            //请求
            String result = alipayClient.pageExecute(alipayRequest, "GET").getBody();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void finishPayment(String out_trade_no, double total_amount) {

    }
}
