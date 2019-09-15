package com.mvp.restaurant.views.holders;

import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvp.restaurant.R;
import com.mvp.restaurant.data.vos.RestaurantVO;
import com.mvp.restaurant.delegates.RestaurantItemDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantItemViewHolder extends BaseViewHolder<RestaurantVO> {
    private RestaurantItemDelegate mDelegate;

    @BindView(R.id.ivFood)
    ImageView ivFood;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvFoodDetail)
    TextView tvFoodDetail;

    @BindView(R.id.tvRating)
    TextView tvRating;

    @BindView(R.id.rating_bar)
    RatingBar ratingBar;

    public RestaurantItemViewHolder(@NonNull View itemView,RestaurantItemDelegate delegate) {
        super(itemView);
        mDelegate=delegate;
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onItemClick(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RestaurantVO Data) {
        mData=Data;
        tvName.setText(mData.getName());
        tvRating.setText(String.valueOf(mData.getRating()));

        tvFoodDetail.setText(mData.getDescription());
        tvFoodDetail.setMovementMethod(new ScrollingMovementMethod());

        Glide.with(ivFood).load(mData.getImageUrl()).into(ivFood);

        String rating=String.valueOf(mData.getRating());
        ratingBar.setRating(Float.valueOf(rating));
    }
}
