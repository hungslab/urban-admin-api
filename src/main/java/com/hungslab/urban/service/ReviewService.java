package com.hungslab.urban.service;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.pojo.Review;

/**
 * @author hungs
 * @date 2024-04-15
 * @Description
 */

public interface ReviewService {
    AjaxResult updateReview(Review review);

    AjaxResult deleteReviewById(Long id);

    AjaxResult selectReviewList(Review review);

    AjaxResult insertReview(Review review);
}
