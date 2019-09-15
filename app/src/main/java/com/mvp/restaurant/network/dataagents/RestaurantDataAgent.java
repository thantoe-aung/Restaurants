package com.mvp.restaurant.network.dataagents;

import com.mvp.restaurant.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantDataAgent {

    void getRestaurants(GetRestaurantsFromNetworkDelegate networkDelegate);

    interface GetRestaurantsFromNetworkDelegate{
        void onSuccess(List<RestaurantVO> restaurantList);
        void onFailure(String errorMessage);
    }
}
