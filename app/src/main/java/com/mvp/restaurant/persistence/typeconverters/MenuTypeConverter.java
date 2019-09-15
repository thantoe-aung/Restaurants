package com.mvp.restaurant.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.mvp.restaurant.data.vos.MenuVO;

public class MenuTypeConverter {

    @TypeConverter
    public static String menuVoToJson(MenuVO menuVO){
        return new Gson().toJson(menuVO);
    }

    @TypeConverter
    public static MenuVO jsonToMenuVO(String menuVoString){
        return new Gson().fromJson(menuVoString,MenuVO.class);
    }
}
