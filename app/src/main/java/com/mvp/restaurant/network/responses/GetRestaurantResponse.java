package com.mvp.restaurant.network.responses;

import com.google.gson.annotations.SerializedName;
import com.mvp.restaurant.data.vos.RestaurantVO;

import java.util.List;

public class GetRestaurantResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    List<RestaurantVO> restaurantVOList;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantVO> getRestaurantVOList() {
        return restaurantVOList;
    }

    public void setRestaurantVOList(List<RestaurantVO> restaurantVOList) {
        this.restaurantVOList = restaurantVOList;
    }
}
