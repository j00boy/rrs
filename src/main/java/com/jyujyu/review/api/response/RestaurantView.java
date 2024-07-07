package com.jyujyu.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

/*
응답을 보여줄  JSON 객체를 만들어 줌
 */

@Getter
@Builder
@AllArgsConstructor
public class RestaurantView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
