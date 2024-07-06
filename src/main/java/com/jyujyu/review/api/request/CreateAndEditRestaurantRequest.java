package com.jyujyu.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class CreateAndEditRestaurantRequest {
    private final String name;
    private final String address;
    private final List<CreateAndEditRestaurantRequestMenu> menus;
}
