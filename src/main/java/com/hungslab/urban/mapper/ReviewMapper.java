package com.hungslab.urban.mapper;

import com.hungslab.urban.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Hong
* @description 针对表【sys_review(商品评论表)】的数据库操作Mapper
* @createDate 2024-04-15 20:11:56
* @Entity com.hungslab.urban.pojo.Review
*/
@Mapper
public interface ReviewMapper {

    int deleteReviewById(Long id);

    int deleteReviewByIds(String[] ids);

    int insertReview(Review review);

    Review selectReviewById(Long id);

    List<Review> selectReviewList(Review review);

    int updateReview(Review review);
}
