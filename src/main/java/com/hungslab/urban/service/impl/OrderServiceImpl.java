package com.hungslab.urban.service.impl;

import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.mapper.OrderMapper;
import com.hungslab.urban.pojo.Order;
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
    public AjaxResult deleteOrderById(Long orderId) {
        orderMapper.deleteOrderById(orderId);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectOrderList(Order order) {

        PageHelper.startPage(order.getCurrent(),order.getSize());
        List<Order> list = orderMapper.selectOrderList(order);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    @Override
    public AjaxResult insertOrder(Order order) {
        String text = SensitiveWordHelper.replace(order.getOrderName());
        order.setOrderName(text);
        orderMapper.insertOrder(order);
        return AjaxResult.success();
    }
}
