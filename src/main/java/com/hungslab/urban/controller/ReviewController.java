package com.hungslab.urban.controller;

import com.hungslab.urban.core.annotation.OperationLogging;
import com.hungslab.urban.core.constant.OperLogType;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Review;
import com.hungslab.urban.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author hungs
 * @date 2024-04-17
 * @Description
 */
@RestController
@Tag(name = "评论管理相关接口")
@RequestMapping("/system/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    /**
     * 创建评论
     * @param review
     * @return
     */
    @OperationLogging(value= "新增评论", type = OperLogType.INSERT)
    @PostMapping("/add")
    public AjaxResult insertProduct(@RequestBody Review review) {
        return reviewService.insertReview(review);
    }

    /**
     * 获取评论信息
     * @param review
     * @return
     */
    @PostMapping("/list")
    public AjaxResult getAllProducts(@RequestBody Review review) {
        return reviewService.selectReviewList(review);
    }


    /**
     * 更新评论信息
     * @param review
     * @return
     */
    @PutMapping("/edit")
    AjaxResult updateProduct(@RequestBody @Validated Review review) {
        return reviewService.updateReview(review);
    }

    /**
     * 删除评论
     * @param reviewId
     * @return
     */
    @OperationLogging(value= "删除评论", type = OperLogType.DELETE)
    @DeleteMapping("/delete")
    AjaxResult deleteProduct(@Validated Long reviewId) {
        return reviewService.deleteReviewById(reviewId);
    }
}
