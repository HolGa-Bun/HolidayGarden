package org.androidtown.holgabun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
        DbOpenHelper h=new DbOpenHelper(this);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        h.open();

        if (h.returnOnOff() == 2)
            h.logOut();
        else if (h.returnOnOff() == -1) {
            Intent intent = new Intent(SplashActivity.this, TutorialActivity.class);
            startActivity(intent);
            finish();
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
