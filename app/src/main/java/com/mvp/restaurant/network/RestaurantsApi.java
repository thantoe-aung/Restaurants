package com.mvp.restaurant.network;


import com.mvp.restaurant.network.responses.GetRestaurantResponse;
import com.mvp.restaurant.utils.RestaurantConstans;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestaurantsApi {

    @Headers("Content-Type:application/json; charset=utf-8")
//    @FormUrlEncoded
    @GET(RestaurantConstans.GET_RESTAURANT)
    Call<GetRestaurantResponse> getRestaurants();
//    Call<GetRestaurantResponse> getRestaurants(@Field("access_token")String access_token);
}
