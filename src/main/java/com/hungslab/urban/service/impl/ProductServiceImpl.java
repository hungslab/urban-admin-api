package com.hungslab.urban.service.impl;

import cn.hutool.core.convert.Convert;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.mapper.ProductMapper;
import com.hungslab.urban.pojo.Product;
import com.hungslab.urban.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description 商品相关 Api
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public AjaxResult updateProduct(Product product) {
        productMapper.updateProduct(product);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult deleteProductById(Long id) {
        productMapper.deleteProductById(id);
        return AjaxResult.success();
    }

    @Override
    public int deleteProductByIds(String ids)
    {
        return productMapper.deleteProductByIds(Convert.toStrArray(ids));
    }

    @Override
    public AjaxResult selectProductList(Product product) {
        List<Product> list = productMapper.selectProductList(product);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult insertProduct(Product product) {
        productMapper.insertSelective(product);
        return AjaxResult.success();
    }
}
