package com.jyujyu.review.model;

import jakarta.persistence.*;
import lombok.Getter;

/*
 JPA에서는 @Entity를 만들어줘야 한다.
 // hibernates는 우리가 Entity를 생성해주어서, h2 데이터베이스가 생성될 때마다 실행되면서 테이블을 만들어 주고 있음
 */

@Getter
@Table(name = "test")
@Entity
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public TestEntity() {}

    public void changeNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
