package com.jyujyu.review.api;

import com.jyujyu.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is getRestaurants";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return "This is getRestaurant " + restaurantId;
    }

    @PostMapping("/restaurant")
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ) {
        return "This is createRestaurant, name=" + request.getName() + ", address=" + request.getAddress()
                + ", menu[0].name=" + request.getMenus().get(0).getName() + ", menu[0].price=" + request.getMenus().get(0).getPrice();
    }

    @PutMapping("restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is editRestaurant, " + restaurantId + ", name=" + request.getName() + ", address=" + request.getAddress();
    }

    @DeleteMapping("restaurant/{restaurantId}")

    public String deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return "This is deleteRestaurant " + restaurantId;
    }
}
