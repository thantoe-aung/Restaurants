package com.mvp.restaurant.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mvp.restaurant.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>,W> extends RecyclerView.Adapter<BaseViewHolder> {

    List<W> mData;

    BaseRecyclerAdapter(){
        mData=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.bindData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData=data;
        notifyDataSetChanged();
    }

    public void setData(W data){
        mData.clear();
        mData.add(data);
        notifyDataSetChanged();
    }
}
