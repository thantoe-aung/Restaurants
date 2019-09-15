package com.mvp.restaurant.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant", indices = {@Index(value = "id",unique = true)})
public class RestaurantVO {

    @ColumnInfo(name = "restaurant_id_pk")
    @PrimaryKey(autoGenerate = true)
    private int restaurantIdPK;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    private String imageUrl;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "opening_closing_times")
    @SerializedName("opening_closing_times")
    private OpeningClosingVO openingClosingTimes;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    private double rating;

    @ColumnInfo(name = "restaurant_location")
    @SerializedName("restaurant_location")
    private LocationVO restaurantLocation;

    @ColumnInfo(name = "menus")
    @SerializedName("menus")
    private List<MenuVO> menuList;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpeningClosingVO getOpeningClosingTimes() {
        return openingClosingTimes;
    }

    public void setOpeningClosingTimes(OpeningClosingVO openingClosingTimes) {
        this.openingClosingTimes = openingClosingTimes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocationVO getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(LocationVO restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }
}
