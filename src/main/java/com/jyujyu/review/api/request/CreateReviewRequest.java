package com.jyujyu.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
@AllArgsConstructor
public class CreateReviewRequest {

    private final Long restaurantId;
    private final String content;
    private final Double score;

}
