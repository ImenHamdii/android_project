package com.example.hellogridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GalerieAdapter extends BaseAdapter {
    private Context cnt;
    public Integer[] TabImages={R.drawable.im1,R.drawable.im2,R.drawable.im3,R.drawable.im4,R.drawable.im5,
                                R.drawable.im6,R.drawable.im7,R.drawable.im8,R.drawable.im9};
    public GalerieAdapter(Context cnt){
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return TabImages.length;
    }

    @Override
    public Object getItem(int position) {
        return TabImages[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView =new ImageView(cnt);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        imageView.setImageResource(TabImages[position]);
        return imageView;
    }
}
