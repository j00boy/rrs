package com.jyujyu.review.repository;

import com.jyujyu.review.model.QReviewEntity;
import com.jyujyu.review.model.ReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    // QueryDSL을 사용하기 위해 property를 추가 !!
    private final JPAQueryFactory queryFactory;

    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) {
        // ReviewEntity의 점수들의 평균을 낸다.
        return queryFactory.select(QReviewEntity.reviewEntity.score.avg())
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))    // 우리가 알고 싶은 맛집
                .fetchFirst();
    }

    @Override
    public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {
        /*
         페이징에서 사용하는 query에는 offset과 limit이 있음 !
         - offset: 시작 지점
         - limit: 몇 개를 가져오는지
         */
        List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .offset((long) page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize() + 1)  // slice 인터페이스를 return할 때에는 limit에다가 +1 을 해준다. Why? 클라이언트에게 다음 요청 시 가져올 게 있을지 없을지 전달하는 역할
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize() // hasNext(): 10개를 가져오라고 했는데 11개를 가져왔다면 다음 요청도 가능하다는 이야기 !!!
        );
    }
}
