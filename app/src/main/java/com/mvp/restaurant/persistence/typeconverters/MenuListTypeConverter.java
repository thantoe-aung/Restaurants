package com.mvp.restaurant.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mvp.restaurant.data.vos.MenuVO;

import java.lang.reflect.Type;
import java.util.List;

public class MenuListTypeConverter {

    @TypeConverter
    public static String MenuListToJson(List<MenuVO> menuVOList){
        Type type=new TypeToken<List<MenuVO>>(){}.getType();
        return new Gson().toJson(menuVOList,type);
    }

    @TypeConverter
    public static List<MenuVO> JsonToMenuList(String jsonString){
        Type type=new TypeToken<List<MenuVO>>(){}.getType();
        return new Gson().fromJson(jsonString,type);
    }
}
