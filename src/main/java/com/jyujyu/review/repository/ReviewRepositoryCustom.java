package com.jyujyu.review.repository;

import com.jyujyu.review.model.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewRepositoryCustom {

    Double getAvgScoreByRestaurantId(Long restaurantId);

    /*
    Slice: 페이징 기법에 사용하는 인터페이스 중 하나
    - 이것을 사용하기 위해서는 Pageable이라는 Parameter를 함께 받아야 함!
     */
    Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable pageable);
}
