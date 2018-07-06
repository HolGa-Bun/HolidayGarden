package org.androidtown.holgabun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }
    public void onButtonFeed(View v){ //feed 페이지로 이동
        Intent intent = new Intent(this, FeedFragment.class);
        startActivity(intent);
    }
}
