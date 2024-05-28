package com.hungslab.urban.controller;

import cn.hutool.core.util.ObjectUtil;
import com.hungslab.urban.core.annotation.OperationLogging;
import com.hungslab.urban.core.constant.OperLogType;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.mapper.ProductMapper;
import com.hungslab.urban.pojo.*;
import com.hungslab.urban.pojo.Echarts.FourVO;
import com.hungslab.urban.pojo.Echarts.OneVO;
import com.hungslab.urban.pojo.Echarts.ThreeVO;
import com.hungslab.urban.pojo.Echarts.TwoVO;
import com.hungslab.urban.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


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

    @Autowired
    ProductMapper productMapper;

    /**
     * 创建商品
     * @param product
     * @return
     */
    @OperationLogging(value= "新增商品", type = OperLogType.INSERT)
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
    @PutMapping("/edit")
    AjaxResult updateProduct(@RequestBody @Validated Product product) {
        return productService.updateProduct(product);
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @OperationLogging(value= "删除商品", type = OperLogType.DELETE)
    @DeleteMapping("/delete")
    AjaxResult deleteProduct(@Validated Long productId) {
        return productService.deleteProductById(productId);
    }

    @GetMapping("/one")
    AjaxResult one(String date) {
        OneVO oneVO = productMapper.selectOne(date);

        if (ObjectUtil.isEmpty(oneVO)){
            return AjaxResult.error("没有数据");
        }
        ArrayList<String>   numnerString= new ArrayList<>(Arrays.asList(  oneVO.getNumber().split(",")));

        ArrayList<String> riqiString = new ArrayList<>(Arrays.asList(oneVO.getRiqi().split(",")));

        List<Double> numnerDouble= new ArrayList<>();

        List<Double> riqiDouble= new ArrayList<>();


        numnerString.forEach(nu ->{
            numnerDouble.add(Double.valueOf(nu));
        });

//        riqiString.forEach(ri ->{
//
//            riqiDouble.add(Double.valueOf(ri));
//        });
//
//        HashMap<String, List> map = new HashMap<>();
//        map.put("riqi",riqiString);
//        map.put("number",numnerDouble);
        ArrayList<List> objectArrayList = new ArrayList<>();
        objectArrayList.add(riqiString);

        objectArrayList.add(numnerDouble);

        return AjaxResult.success(objectArrayList);

    }


    /**
     * 删除商品
     * @param productId
     * @return
     */
    @GetMapping("/two")
    AjaxResult two(String date) {


        List<TwoVO> twoVOS = productMapper.selectTwo(date);



//        HashMap<String, List> map = new HashMap<>();
//        map.put("twoVOS",twoVOS);

        return AjaxResult.success(twoVOS);
    }


    /**
     * 删除商品
     * @param productId
     * @return
     */
    @GetMapping("/three")
    AjaxResult three(String date) {


        ThreeVO threeVO = productMapper.selectThree(date);

        if (ObjectUtil.isEmpty(threeVO)){
            return AjaxResult.error("没有数据");
        }

        ArrayList<String>  ysString= new ArrayList<>(Arrays.asList(  threeVO.getYs().split(",")));


        ArrayList<String>  lrString= new ArrayList<>(Arrays.asList(  threeVO.getLr().split(",")));


        ArrayList<String>  hblrString= new ArrayList<>(Arrays.asList(  threeVO.getHblr().split(",")));


        ArrayList<String>  bbysString= new ArrayList<>(Arrays.asList(  threeVO.getBbys().split(",")));

        ArrayList<String> riqiString = new ArrayList<>(Arrays.asList(threeVO.getRiqi().split(",")));

        List<Double> ysDouble= new ArrayList<>();

        List<Double> lrDouble= new ArrayList<>();


        List<Double> hblrDouble= new ArrayList<>();

        List<Double> hbysDouble= new ArrayList<>();


        ysString.forEach(nu ->{
            ysDouble.add(Double.valueOf(nu)/10000);
        });

        lrString.forEach(ri ->{

            lrDouble.add(Double.valueOf(ri)/10000);
        });

        bbysString.forEach(nu ->{
            hbysDouble.add(Double.valueOf(nu));
        });

        hblrString.forEach(ri ->{

            hblrDouble.add(Double.valueOf(ri));
        });


        HashMap<String, List> map = new HashMap<>();
        map.put("ye",ysDouble);
        map.put("lr",lrDouble);
        map.put("hbye",hbysDouble);
        map.put("hblr",hblrDouble);
        map.put("riqi",riqiString);


        ArrayList<List> objectArrayList = new ArrayList<>();
        objectArrayList.add(ysDouble);
        objectArrayList.add(lrDouble);

        objectArrayList.add(hbysDouble);


        objectArrayList.add(hblrDouble);
        objectArrayList.add(riqiString);
        return AjaxResult.successList(objectArrayList);
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @GetMapping("/four")
    AjaxResult four() {
        FourVO fourVO = productMapper.selectFour();
        if (ObjectUtil.isEmpty(fourVO)){
            return AjaxResult.error("没有数据");
        }
        ArrayList<String>  xxlString= new ArrayList<>(Arrays.asList(  fourVO.getXxl().split(",")));


        ArrayList<String>  xseString= new ArrayList<>(Arrays.asList(  fourVO.getXse().split(",")));

        ArrayList<String> riqiString = new ArrayList<>(Arrays.asList(fourVO.getNames().split(",")));


        List<Double> xxlDouble= new ArrayList<>();

        List<Double> xseDouble= new ArrayList<>();



        xxlString.forEach(nu ->{
            xxlDouble.add(Double.valueOf(nu));
        });

        xseString.forEach(ri ->{

            xseDouble.add(Double.valueOf(ri)/10);
        });




        HashMap<String, List> map = new HashMap<>();
        map.put("xsl",xxlDouble);
        map.put("xse",xseDouble);
        map.put("riqi",riqiString);



        ArrayList<List> objectArrayList = new ArrayList<>();
        objectArrayList.add(xseDouble);
        objectArrayList.add(xxlDouble);

        objectArrayList.add(riqiString);
        return AjaxResult.successList(objectArrayList);

    }
}
