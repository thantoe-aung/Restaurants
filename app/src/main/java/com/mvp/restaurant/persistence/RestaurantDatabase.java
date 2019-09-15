package com.mvp.restaurant.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.persistence.daos.RestaurantDao;
import com.mvp.restaurant.persistence.typeconverters.LocationTypeConverter;
import com.mvp.restaurant.persistence.typeconverters.MenuListTypeConverter;
import com.mvp.restaurant.persistence.typeconverters.MenuTypeConverter;
import com.mvp.restaurant.persistence.typeconverters.OpeningClosingTypeConverter;
import com.mvp.restaurant.utils.RestaurantConstans;

@Database(entities = {RestaurantVO.class},version = 2)
@TypeConverters({LocationTypeConverter.class, MenuListTypeConverter.class, MenuTypeConverter.class, OpeningClosingTypeConverter.class})
public abstract class RestaurantDatabase extends RoomDatabase {

    private static RestaurantDatabase objInstance;

    public static RestaurantDatabase getObjInstance(Context context){
        if(objInstance==null){
            objInstance= Room.databaseBuilder(context,RestaurantDatabase.class, RestaurantConstans.RESTAURANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return objInstance;
    }

    public abstract RestaurantDao restaurantDao();

    public boolean areRestaurantsExistInDB(){
       return !restaurantDao().getRestaurantsList().isEmpty();
    }
}
