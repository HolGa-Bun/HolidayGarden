package org.androidtown.holgabun;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TutorialActivity extends AppCompatActivity {
    Button image1;
    Button image2;
    Button image3;
    Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        arrayList = new ArrayList();
        image1 = (Button) findViewById(R.id.image1);
        image2 = (Button) findViewById(R.id.image2);
        image3 = (Button) findViewById(R.id.image3);
        buttonMain= (Button) findViewById(R.id.buttonMain);

        for (int i = 0; i < 3; i++) {
            arrayList.add(R.drawable.t1 + i);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new org.androidtown.holgabun.ViewPagerAdapter(getLayoutInflater(), arrayList);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0) {
                    image1.setBackgroundColor(getResources().getColor(R.color.colorMain));
                    image2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    image3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }else if(position==1) {
                    image1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    image2.setBackgroundColor(getResources().getColor(R.color.colorMain));
                    image3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }else if(position==2){
                    image1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    image2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    image3.setBackgroundColor(getResources().getColor(R.color.colorMain));
                    buttonMain.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    ViewPager viewPager;
    org.androidtown.holgabun.ViewPagerAdapter viewPagerAdapter;
    ArrayList arrayList; // viewPager에서보여줄 item

    public void onClickedMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
