package com.mvp.restaurant.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.mvp.restaurant.R;
import com.mvp.restaurant.data.vos.RestaurantVO;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearchAdapter extends ArrayAdapter<RestaurantVO> {
    private Context context;
    private int resourceId;
    private List<RestaurantVO> items, tempItems, suggestions;

    public RestaurantSearchAdapter( Context context, int resourceId, List<RestaurantVO> items) {
        super(context,resourceId,items);
        this.context = context;
        this.resourceId = resourceId;
        this.items = items;
        tempItems = new ArrayList<>(items);
        suggestions = new ArrayList<>();
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(resourceId, parent, false);
        }
        RestaurantVO restaurant = getItem(position);
        TextView name = view.findViewById(R.id.txtItemName);
        name.setText(restaurant.getName());
        return view;
    }

    @Nullable
    @Override
    public RestaurantVO getItem(int position) {
        return items.get(position);
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public Filter getFilter() {
        return fruitFilter;
    }

    private Filter fruitFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            RestaurantVO restaurant= (RestaurantVO) resultValue;
            return restaurant.getName();
        }
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                suggestions.clear();
                for (RestaurantVO restaurant: tempItems) {
                    if (restaurant.getName().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        suggestions.add(restaurant);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ArrayList<RestaurantVO> tempValues = (ArrayList<RestaurantVO>) filterResults.values;
            if (filterResults != null && filterResults.count > 0) {
                clear();
                for (RestaurantVO restaurant : tempValues) {
                    add(restaurant);
                    notifyDataSetChanged();
                }
            } else {
                clear();
                notifyDataSetChanged();
            }
        }
    };


}
