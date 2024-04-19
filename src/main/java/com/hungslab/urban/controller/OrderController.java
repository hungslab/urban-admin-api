package com.hungslab.urban.controller;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Order;
import com.hungslab.urban.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author hungs
 * @date 2024-04-11
 * @Description 订单管理相关接口
 */
@CrossOrigin
@Tag(name = "订单管理相关接口")
@RequestMapping("/system/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建商品
     * @param order
     * @return
     */
    @PostMapping("/add")
    AjaxResult insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    /**
     * 获取商品信息
     * @param order
     * @return
     */
    @GetMapping("/list")
    AjaxResult list(Order order) {
        return orderService.selectOrderList(order);
    }


    /**
     * 更新商品信息
     * @param order
     * @return
     */
    @PostMapping("/edit")
    AjaxResult updateProduct(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/delete")
    AjaxResult deleteProduct(@Validated Long orderId) {
        return orderService.deleteOrderById(orderId);
    }


}