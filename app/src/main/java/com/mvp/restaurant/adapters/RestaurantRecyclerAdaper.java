package com.mvp.restaurant.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.restaurant.R;
import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.delegates.RestaurantItemDelegate;
import com.mvp.restaurant.views.holders.BaseViewHolder;
import com.mvp.restaurant.views.holders.RestaurantItemViewHolder;

public class RestaurantRecyclerAdaper extends BaseRecyclerAdapter<RestaurantItemViewHolder, RestaurantVO> {

    private RestaurantItemDelegate mDelegate;

    public RestaurantRecyclerAdaper(RestaurantItemDelegate delegate){
        this.mDelegate=delegate;
    }

    @NonNull
    @Override
    public RestaurantItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_layout,viewGroup,false);
        return new RestaurantItemViewHolder(view,mDelegate);
    }
}
