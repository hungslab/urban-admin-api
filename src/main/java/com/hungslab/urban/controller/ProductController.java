package com.hungslab.urban.controller;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Product;
import com.hungslab.urban.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */
@RestController
@CrossOrigin
@Tag(name = "商品管理相关接口")
@RequestMapping("/system/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    /**
     * 创建商品
     * @param product
     * @return
     */
    @PostMapping("/add")
    public AjaxResult insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    /**
     * 获取商品信息
     * @param product
     * @return
     */
    @PostMapping("/list")
    public AjaxResult getAllProducts(@RequestBody Product product) {
        return productService.selectProductList(product);
    }


    /**
     * 更新商品信息
     * @param product
     * @return
     */
    @PostMapping("/edit")
    AjaxResult updateProduct(@RequestBody @Validated Product product) {
        return productService.updateProduct(product);
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @DeleteMapping("/delete")
    AjaxResult deleteProduct(@Validated Long productId) {
        return productService.deleteProductById(productId);
    }
}
