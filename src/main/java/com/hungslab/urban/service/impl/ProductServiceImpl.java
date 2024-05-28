package com.hungslab.urban.service.impl;

import cn.hutool.core.convert.Convert;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        String text = SensitiveWordHelper.replace(product.getProductName());
        product.setProductName(text);
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
        PageHelper.startPage(product.getCurrent(),product.getSize());
        List<Product> list = productMapper.selectProductList(product);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    @Override
    public AjaxResult insertProduct(Product product) {
        String text = SensitiveWordHelper.replace(product.getProductName());
        product.setProductName(text);
        productMapper.insertSelective(product);
        return AjaxResult.success();
    }
}
