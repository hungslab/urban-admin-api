package com.hungslab.urban.mapper;

import com.hungslab.urban.pojo.Order;
import com.hungslab.urban.pojo.Payway;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Hong
* @description 针对表【sys_order(订单表)】的数据库操作Mapper
* @createDate 2024-04-15 20:11:34
* @Entity com.hungslab.urban.pojo.Order
*/
@Mapper
public interface OrderMapper {

    Order selectOrderById(Long id);

    int deleteOrderById(Long id);

    int deleteOrderByIds(String[] ids);

    int insertOrder(Order order);

    int updateOrder(Order order);

    List<Order> selectOrderList(Order order);

}
