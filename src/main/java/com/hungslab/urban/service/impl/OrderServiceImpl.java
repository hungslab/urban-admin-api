package com.hungslab.urban.service.impl;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.mapper.OrderMapper;
import com.hungslab.urban.pojo.Order;
import com.hungslab.urban.pojo.Product;
import com.hungslab.urban.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public AjaxResult updateOrder(Order order) {
        orderMapper.updateOrder(order);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult deleteOrderById(Long id) {
        orderMapper.deleteOrderById(id);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectOrderList(Order order) {
        List<Order> list = orderMapper.selectOrderList(order);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult insertOrder(Order order) {
        orderMapper.insertOrder(order);
        return AjaxResult.success();
    }
}
