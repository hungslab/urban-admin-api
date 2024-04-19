package com.hungslab.urban.mapper;

import com.hungslab.urban.pojo.Payway;
import com.hungslab.urban.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Hong
* @description 针对表【sys_payway(支付方式表)】的数据库操作Mapper
* @createDate 2024-04-15 20:12:07
* @Entity com.hungslab.urban.pojo.Payway
*/
@Mapper
public interface PaywayMapper {

    int deletePayWayById(Long id);

    int deletePayWayByIds(String[] ids);

    int insertPayWay(Payway payway);

    Payway selectPayWayById(Long id);

    List<Payway> selectPayWayList(Payway payway);

    int updatePayWay(Payway payway);

}
