package org.androidtown.holgabun;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void onButtonFeed(View v) { //feed 페이지로 이동
        Intent intent = new Intent(this, FeedFragment.class);
        startActivity(intent);
    }

    public static class GridItem extends LinearLayout {

        TextView tv;
        ImageView iv;
        TextView tv2;

        public GridItem(Context context) {
            super(context);
            init(context);
        }

        public void init(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_grid_item, this);
            tv = (TextView) findViewById(R.id.tv1);
            tv2 = (TextView) findViewById(R.id.tv2);
            iv = (ImageView) findViewById(R.id.img1);
        }

        public void setData(Garden one) {
            tv.setText(one.getName());
            tv2.setText(one.getAddress());
            iv.setImageResource(one.getImgno());
        }
    }
}
