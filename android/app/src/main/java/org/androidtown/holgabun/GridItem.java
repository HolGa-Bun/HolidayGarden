package org.androidtown.holgabun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridItem extends LinearLayout {

    TextView tv;
    ImageView iv;
    TextView tv2;

    public GridItem(Context context){
        super(context);
        init(context);
    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_grid_item, this);
        tv = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        iv = (ImageView)findViewById(R.id.img1);
    }

    public void setData(Garden one){
        tv.setText(one.getName());
        tv2.setText(one.getAddress());
        iv.setImageResource(one.getImgno());
    }
}