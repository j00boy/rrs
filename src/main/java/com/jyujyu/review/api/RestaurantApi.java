package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.response.RestaurantDetailView;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable("restaurantId") Long restaurantId
    ) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    // 생성 API에서는 응답값이 별로 필요없음 -> void
    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.createRestaurant(request);
    }

    // 수정 API에서는 응답값이 별로 필요없음 -> void
    @PutMapping("restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    // 삭제 API에서는 응답값이 별로 필요없음 -> void
    @DeleteMapping("restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable("restaurantId") Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
