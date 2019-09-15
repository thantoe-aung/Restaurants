package com.mvp.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvp.restaurant.R;
import com.mvp.restaurant.data.vos.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    public static final String RESTAURANT_ID_EXTRA="restaurantId";

    @BindView(R.id.ivDetail)
    ImageView ivDetail;

    @BindView(R.id.tvRestaurantName)
    TextView tvRestaurantName;

    @BindView(R.id.tvOpeningClosingTime)
    TextView tvOpeningTime;

    @BindView(R.id.tvFullDetail)
    TextView tvFullDetail;

    public static Intent newIntent(Context context, int houseId){
        Intent intent=new Intent(context,DetailActivity.class);
        intent.putExtra(RESTAURANT_ID_EXTRA,houseId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        int id=getIntent().getIntExtra(RESTAURANT_ID_EXTRA,0);

        RestaurantVO restaurant=mRestaurantModel.getRestaurantById(id);
        BindData(restaurant);
    }

    public void BindData(RestaurantVO restaurant){
        Glide.with(ivDetail).load(restaurant.getImageUrl()).into(ivDetail);
        tvRestaurantName.setText(restaurant.getName());
        tvFullDetail.setText(restaurant.getDescription());
        tvFullDetail.setMovementMethod(new ScrollingMovementMethod());
        tvOpeningTime.setText(restaurant.getOpeningClosingTimes().getOpeningTime()+"-"+restaurant.getOpeningClosingTimes().getClosingTime());
    }
}
