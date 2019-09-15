package com.mvp.restaurant.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.mvp.restaurant.R;
import com.mvp.restaurant.adapters.RestaurantRecyclerAdaper;
import com.mvp.restaurant.adapters.RestaurantSearchAdapter;
import com.mvp.restaurant.data.models.RestaurantModel;
import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.delegates.RestaurantItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.restaurantListRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.completeTxtSearch)
    AppCompatAutoCompleteTextView txtCompleteSearch;

    @BindView(R.id.ivCancel)
    ImageView ivCancel;

    private RestaurantRecyclerAdaper adaper;

    ArrayList<RestaurantVO> restaurantArrayList;
    private RestaurantSearchAdapter restaurantSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        restaurantArrayList = new ArrayList<>();

        ivCancel.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adaper = new RestaurantRecyclerAdaper(new RestaurantItemDelegate() {
            @Override
            public void onItemClick(int restaurantId) {
                startActivity(DetailActivity.newIntent(MainActivity.this,restaurantId));
            }
        });
        recyclerView.setAdapter(adaper);

        mRestaurantModel.getRestaurants(new RestaurantModel.GetRestaurantsFromDataDelegate() {
            @Override
            public void onSuccess(List<RestaurantVO> restaurantList) {
                adaper.setNewData(restaurantList);
                implementSearchView();
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivCancel:
                txtCompleteSearch.setText("");
                if (getCurrentFocus() != null)
                    hideKeyboard(MainActivity.this);
                clearFilter();
                break;
        }
    }

    private void implementSearchView() {
        for (RestaurantVO restaurant : mRestaurantModel.getRestaurantFromDB()) {
            restaurantArrayList.add(restaurant);
        }
        restaurantSearchAdapter = new RestaurantSearchAdapter(MainActivity.this, R.layout.custorm_search_row, restaurantArrayList);
        txtCompleteSearch.setThreshold(1);
        txtCompleteSearch.setAdapter(restaurantSearchAdapter);

        txtCompleteSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RestaurantVO selectedHouse = (RestaurantVO) parent.getItemAtPosition(position);
                adaper.setData(selectedHouse);
            }
        });
    }

    private void clearFilter() {
        adaper.setNewData(mRestaurantModel.getRestaurantFromDB());
        adaper.notifyDataSetChanged();
    }

    private void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
