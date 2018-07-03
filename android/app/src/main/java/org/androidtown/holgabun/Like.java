package org.androidtown.holgabun;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Like extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
    }
    public void onButton1Clicked(View v){ //메인페이지로 이동
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
