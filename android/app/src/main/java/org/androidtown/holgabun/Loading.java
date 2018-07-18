package org.androidtown.holgabun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Loading extends AppCompatActivity {

    DbOpenHelper h=new DbOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        h.open();

        if (h.returnOnOff() == 2)
            h.logOut();
        else if (h.returnOnOff() == -1) {
            Intent intent = new Intent(Loading.this, TutorialActivity.class);
            startActivity(intent);
            finish();
        }
            Intent intent = new Intent(Loading.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
