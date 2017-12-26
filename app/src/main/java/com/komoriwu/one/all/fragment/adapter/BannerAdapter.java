package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private Context mContext;
    private List<ItemListBean> itemList;

    BannerAdapter(Context mContext, List<ItemListBean> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public int getItemViewType(int position) {
        return Constants.ALL_VIEW_TAPE;
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_banner_card, parent,
                false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        ItemListBean itemListBean = itemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getImage(), holder.ivCard);
        if (itemListBean.getData().getLabel() != null) {
            if (TextUtils.isEmpty(itemListBean.getData().getLabel().getText())) {
                holder.tvAd.setVisibility(View.GONE);
            } else {
                holder.tvAd.setVisibility(View.VISIBLE);
                holder.tvAd.setText(itemListBean.getData().getLabel().getText());
            }
        } else {
            holder.tvAd.setVisibility(View.GONE);
        }
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.item_alpha);
        animation.setFillAfter(true);
        holder.ivCard.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_ad)
        TextView tvAd;

        BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
