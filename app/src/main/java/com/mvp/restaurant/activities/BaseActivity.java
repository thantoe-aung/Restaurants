package com.mvp.restaurant.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mvp.restaurant.data.models.RestaurantModel;
import com.mvp.restaurant.data.models.RestaurantModelImpl;

public abstract class BaseActivity extends AppCompatActivity {
    protected RestaurantModel mRestaurantModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestaurantModel= RestaurantModelImpl.getObjInstance();
    }
}
