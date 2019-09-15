package com.mvp.restaurant.data.models;

import com.mvp.restaurant.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantModel {
    void getRestaurants(GetRestaurantsFromDataDelegate dataDelegate);
    RestaurantVO getRestaurantById(int restaurantId);
    List<RestaurantVO> getRestaurantFromDB();


    interface GetRestaurantsFromDataDelegate{
        void onSuccess(List<RestaurantVO> restaurantList);
        void onFailure(String errorMessage);
    }
}
