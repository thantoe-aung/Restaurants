package com.mvp.restaurant.network.dataagents;

import com.google.gson.Gson;
import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.network.RestaurantsApi;
import com.mvp.restaurant.network.responses.GetRestaurantResponse;
import com.mvp.restaurant.utils.RestaurantConstans;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements RestaurantDataAgent {
    private static RetrofitDataAgentImpl objInstance;
    private RestaurantsApi mApi;

    private RetrofitDataAgentImpl(){
        OkHttpClient mHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RestaurantConstans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(mHttpClient)
                .build();
        mApi=retrofit.create(RestaurantsApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance==null)
            objInstance=new RetrofitDataAgentImpl();
        return objInstance;
    }

    @Override
    public void getRestaurants(final GetRestaurantsFromNetworkDelegate networkDelegate) {
        Call<GetRestaurantResponse> call=mApi.getRestaurants();
        call.enqueue(new Callback<GetRestaurantResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantResponse> call, Response<GetRestaurantResponse> response) {
                if(!response.isSuccessful()){
                 networkDelegate.onFailure(response.message());
                 return;
                }

                networkDelegate.onSuccess(response.body().getRestaurantVOList());
//                try {
//                    GetRestaurantResponse getRestaurantResponse=new Gson().fromJson(response.errorBody().string(),GetRestaurantResponse.class);
//                    networkDelegate.onSuccess(getRestaurantResponse.getRestaurantVOList());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }

            @Override
            public void onFailure(Call<GetRestaurantResponse> call, Throwable t) {
                networkDelegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
