package com.jyujyu.review.repository;

import com.jyujyu.review.model.QTestEntity;
import com.jyujyu.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity)  // QueryDSL을 추가하면 나오는 Q클래스
                .where(QTestEntity.testEntity.name.eq(name)) // 이름으로 필터링
                .fetch();
    }
}
