package com.mvp.restaurant;

import android.app.Application;

import com.mvp.restaurant.data.models.RestaurantModelImpl;

public class RestaurantApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RestaurantModelImpl.InitializeRestaurantModel(getApplicationContext());
    }
}
