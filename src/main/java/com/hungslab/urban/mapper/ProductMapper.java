package com.hungslab.urban.mapper;

import com.hungslab.urban.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

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
}
