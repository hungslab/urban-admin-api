package com.hungslab.urban.mapper;


import com.hungslab.urban.pojo.*;
import com.hungslab.urban.pojo.Echarts.FourVO;
import com.hungslab.urban.pojo.Echarts.OneVO;
import com.hungslab.urban.pojo.Echarts.ThreeVO;
import com.hungslab.urban.pojo.Echarts.TwoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Hong
* @description 针对表【sys_product(商品表)】的数据库操作Mapper
* @createDate 2024-04-15 20:11:10
* @Entity com.hungslab.urban.pojo.Product
*/
@Mapper
public interface ProductMapper {

    int deleteProductById(Long id);

    int deleteProductByIds(String[] ids);

    int insertSelective(Product product);

    Product selectProductById(Long id);

    int updateProduct(Product product);

    List<Product> selectProductList(Product product);

    @Select("SELECT GROUP_CONCAT(number) AS number,  GROUP_CONCAT(riqi) AS riqi  from  \n" +
            "(\n" +
            "SELECT\n" +
            "\tSUM( product_sale_count ) AS number,\n" +
            "\tdate_format( product_create_time, '%Y-%m' ) AS riqi \n" +
            "FROM\n" +
            "\tsys_product \n" +
            "WHERE\n" +
            "\tdate_format( product_create_time, '%Y' )=#{date} \n" +
            "GROUP BY\n" +
            "\tdate_format( product_create_time, '%Y-%m' )\n" +
            "\n" +
            "ORDER BY \n" +
            "   date_format( product_create_time, '%Y-%m' )"+
            ") a\n")
    OneVO selectOne(String date);




    @Select("\n" +
            "\n" +
            "SELECT\n" +
            "\tcount(*) AS value,\n" +
            "\tdate_format( create_time, '%Y-%m' ) AS name \n" +
            "FROM\n" +
            "\tsys_order \n" +
            "WHERE\n" +
            "\tdate_format( create_time, '%Y' )= #{date} \n" +
            "GROUP BY\n" +
            "\tdate_format( create_time, '%Y-%m' ) ORDER BY date_format( create_time, '%Y-%m' ) \n")
    List<TwoVO> selectTwo(String date);



    @Select("\n" +
            "SELECT\n" +
            "GROUP_CONCAT(riqi) as riqi,\n" +
            "GROUP_CONCAT(lr) as lr,\n" +
            "GROUP_CONCAT(ys) as ys,\n" +
            "GROUP_CONCAT(hblr) as hblr,\n" +
            "GROUP_CONCAT(bbys) as bbys\n" +
            "FROM\n" +
            "( (\n" +
            "SELECT\n" +
            "    t.riqi,\n" +
            "    t.lr,\n" +
            "\t  t.ys,\n" +
            "    ((t.lr - LAG(t.lr) OVER (ORDER BY t.riqi)) / LAG(t.lr) OVER (ORDER BY t.riqi)) * 100 AS hblr,\n" +
            "\t\t    ((t.ys - LAG(t.ys) OVER (ORDER BY t.riqi)) / LAG(t.ys) OVER (ORDER BY t.riqi)) * 100 AS bbys\n" +
            "FROM (\n" +
            "    SELECT\n" +
            "\t\t\t  SUM( product_price*product_sale_count ) AS ys,\n" +
            "        SUM(product_sale_count * (product_price - product_cb)) AS lr,\n" +
            "        date_format(product_create_time, '%Y-%m') AS riqi\n" +
            "    FROM\n" +
            "        sys_product\n" +
            "    WHERE\n" +
            "        date_format(product_create_time, '%Y') = #{date}\n" +
            "    GROUP BY\n" +
            "        date_format(product_create_time, '%Y-%m')\n" +
            ") t\n" +
            "ORDER BY\n" +
            "    t.riqi\n" +
            "\t\t)\n" +
            "\t\t\n" +
            ") q")
    ThreeVO selectThree(String date);




    @Select("SELECT GROUP_CONCAT(xxl) as xxl ,GROUP_CONCAT(xse) as xse ,GROUP_CONCAT(names) as names from (\n" +
            "SELECT  SUM(product_sale_count) as xxl, SUM(product_sale_count*product_price) as xse ,product_type as names FROM\n" +
            "        sys_product\n" +
            "GROUP BY product_type \n" +
            ") a")
    FourVO selectFour();





}
