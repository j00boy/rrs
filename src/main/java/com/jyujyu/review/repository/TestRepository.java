package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
JpaRepository<1, 2>에서 1에는 테이블 내지 객체, 2에는 @Id로 설정되어 있는 데이터 자료형
 */
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

    // JPA를 이용한 방식
    public List<TestEntity> findAllByName(String name);
}
