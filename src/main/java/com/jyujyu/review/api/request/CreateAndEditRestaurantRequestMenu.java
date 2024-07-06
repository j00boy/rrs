package com.jyujyu.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
    private final String name;
    private final Integer price;
}
