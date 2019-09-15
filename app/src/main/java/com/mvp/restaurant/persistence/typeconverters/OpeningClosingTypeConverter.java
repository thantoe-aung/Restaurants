package com.mvp.restaurant.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.mvp.restaurant.data.vos.OpeningClosingVO;

public class OpeningClosingTypeConverter {

    @TypeConverter
    public static String openingClosingTimeToJson(OpeningClosingVO openingClosingVO){
        return new Gson().toJson(openingClosingVO);
    }

    @TypeConverter
    public static OpeningClosingVO jsonToOpeningClosingVo(String jsonString){
        return new Gson().fromJson(jsonString,OpeningClosingVO.class);
    }
}
