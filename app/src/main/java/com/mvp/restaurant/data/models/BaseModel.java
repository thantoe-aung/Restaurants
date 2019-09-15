package com.mvp.restaurant.data.models;

import android.content.Context;

import com.mvp.restaurant.network.dataagents.RestaurantDataAgent;
import com.mvp.restaurant.network.dataagents.RetrofitDataAgentImpl;
import com.mvp.restaurant.persistence.RestaurantDatabase;

public abstract class BaseModel {
    protected RestaurantDataAgent mDataAgent;
    protected RestaurantDatabase mDatatabase;

    BaseModel(Context context){
        mDataAgent=RetrofitDataAgentImpl.getObjInstance();
        mDatatabase=RestaurantDatabase.getObjInstance(context);
    }

}
