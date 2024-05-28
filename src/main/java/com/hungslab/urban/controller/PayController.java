package com.hungslab.urban.controller;

/**
 * @author hungs
 * @date 2024-05-06
 * @Description 外接支付控制器
 */

import cn.hutool.core.lang.UUID;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.AlipayOrderVO;
import com.hungslab.urban.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PayController {
    @Resource
    private PayService payService;

    /**
     * 接受订单信息
     * @param alipayOrderVO：订单信息
     * @return
     */
    @RequestMapping("/alipay/pay")
    @ResponseBody
    public AjaxResult payByAlipay(@RequestBody AlipayOrderVO alipayOrderVO) {
        // 商户网站唯一订单号
        String out_trade_no = UUID.randomUUID().toString();
        alipayOrderVO.setOut_trade_no(out_trade_no);
        String redirect=payService.saveOrderInfo(alipayOrderVO);
        if (redirect!=null){
            return AjaxResult.success(redirect);
        }
        else {
            return AjaxResult.error("支付参数错误");
        }
    }

    /**
     * 用户支付成功后，支付宝调用回调信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/alipay/notifyUrl")
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        String out_trade_no=null;
        double price = 0;
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String s : parameterMap.keySet()) {
            String[] strings = parameterMap.get(s);
            for (int i = 0; i < strings.length; i++) {
                if (s.equals("out_trade_no")){
                    out_trade_no=strings[i];
                }
                if (s.equals("total_amount")){
                    price= Double.parseDouble(strings[i]);
                }
            }
        }
        payService.finishPayment(out_trade_no,price);
    }

    /**
     * 支付成功后重定向页面：关闭当前页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/alipay/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) {
        return "<script>" +
                "window.opener = null;" +
                "window.open(\"\", \"_self\");" +
                "window.close();" +
                "</script>";
    }



}