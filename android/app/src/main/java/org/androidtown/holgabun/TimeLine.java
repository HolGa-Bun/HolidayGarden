package org.androidtown.holgabun;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TimeLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
    }
    public void MainClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onButton2Clicked(View v){ //feed 페이지로 이동
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }
    public void onButton3Clicked(View v){ //like 페이지로 이동
        Intent intent = new Intent(this, Like.class);
        startActivity(intent);
    }
    public void onButton4Clicked(View v){ //profile 페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
