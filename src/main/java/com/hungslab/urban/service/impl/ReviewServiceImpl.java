package com.hungslab.urban.service.impl;

import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.mapper.ReviewMapper;
import com.hungslab.urban.pojo.Review;
import com.hungslab.urban.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public AjaxResult updateReview(Review review) {
        String text = SensitiveWordHelper.replace(review.getReviewContent());
        System.out.println(text);
        review.setReviewContent(text);
        reviewMapper.updateReview(review);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult deleteReviewById(Long id) {
        reviewMapper.deleteReviewById(id);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectReviewList(Review review) {
        List<Review> list = reviewMapper.selectReviewList(review);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult insertReview(Review review) {
        String text = SensitiveWordHelper.replace(review.getReviewContent());
        review.setReviewContent(text);
        reviewMapper.insertReview(review);
        return AjaxResult.success();
    }
}
