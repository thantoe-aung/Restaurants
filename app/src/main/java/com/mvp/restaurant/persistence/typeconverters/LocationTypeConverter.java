package com.mvp.restaurant.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.mvp.restaurant.data.vos.LocationVO;

public class LocationTypeConverter {

    @TypeConverter
    public static String locationToJson(LocationVO locationVO){
        return new Gson().toJson(locationVO);
    }

    @TypeConverter
    public static LocationVO jsonToLocationVO(String jsonLocationString){
        return new Gson().fromJson(jsonLocationString,LocationVO.class);
    }
}
