package com.hungslab.urban.service;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Order;
import org.springframework.stereotype.Service;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */

public interface OrderService {

    AjaxResult deleteOrderById(Long orderid);

    AjaxResult updateOrder(Order order);

    AjaxResult insertOrder(Order order);

    AjaxResult selectOrderList(Order order);
}
