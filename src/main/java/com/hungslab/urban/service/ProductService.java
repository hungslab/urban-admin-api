package com.hungslab.urban.service;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Product;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */
public interface ProductService {

    AjaxResult updateProduct(Product product);

    AjaxResult deleteProductById(Long id);

    /**
     * 批量删除系统操作日志
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteProductByIds(String ids);

    AjaxResult selectProductList(Product product);

    AjaxResult insertProduct(Product product);
}
