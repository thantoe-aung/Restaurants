package com.mvp.restaurant.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mvp.restaurant.data.vos.RestaurantVO;

import java.util.List;

@Dao
public interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRestaurants(List<RestaurantVO> restaurantVOList);

    @Query("select * from restaurant")
    List<RestaurantVO> getRestaurantsList();


    @Query("SELECT * FROM restaurant WHERE id=:restaurantId")
     RestaurantVO getEventById(int restaurantId);
}
