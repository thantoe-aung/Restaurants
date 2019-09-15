package com.mvp.restaurant.data.models;

import android.content.Context;

import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.network.dataagents.RestaurantDataAgent;
import com.mvp.restaurant.persistence.RestaurantDatabase;
import com.mvp.restaurant.utils.RestaurantConstans;

import java.util.List;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {
    private static RestaurantModelImpl objInstance;

    private RestaurantModelImpl(Context context) {
        super(context);
    }

    public static void InitializeRestaurantModel(Context context) {
        objInstance = new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance() {
        if (objInstance == null)
            throw new RuntimeException(RestaurantConstans.EM_RESTAURANT_MODEL_NOT_INTTIALIZED);
        return objInstance;
    }


    @Override
    public void getRestaurants(final GetRestaurantsFromDataDelegate dataDelegate) {
        if (mDatatabase.areRestaurantsExistInDB()) {
            dataDelegate.onSuccess(mDatatabase.restaurantDao().getRestaurantsList());
        } else {
            mDataAgent.getRestaurants(new RestaurantDataAgent.GetRestaurantsFromNetworkDelegate() {
                @Override
                public void onSuccess(List<RestaurantVO> restaurantList) {
                    mDatatabase.restaurantDao().insertRestaurants(restaurantList);
                    dataDelegate.onSuccess(restaurantList);
                }

                @Override
                public void onFailure(String errorMessage) {
                    dataDelegate.onFailure(errorMessage);
                }
            });
        }

    }

    @Override
    public RestaurantVO getRestaurantById(int restaurantId) {
        return mDatatabase.restaurantDao().getEventById(restaurantId);
    }

    @Override
    public List<RestaurantVO> getRestaurantFromDB() {
        return mDatatabase.restaurantDao().getRestaurantsList();
    }
}
