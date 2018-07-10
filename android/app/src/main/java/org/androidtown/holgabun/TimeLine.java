package org.androidtown.holgabun;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.support.v4.view.ViewCompat.setBackground;

public class TimeLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
<<<<<<< HEAD
        final Button feedButton = (Button) findViewById(R.id.feedButton);
        final Button likeButton = (Button) findViewById(R.id.likeButton);
        final Button profileButton = (Button) findViewById(R.id.profileButton);
        final LinearLayout notice =(LinearLayout) findViewById(R.id.notice);
=======
        feedButton = (Button) findViewById(R.id.feedButton);
        likeButton = (Button) findViewById(R.id.likeButton);
        profileButton = (Button) findViewById(R.id.profileButton);
         notice =(LinearLayout) findViewById(R.id.notice);
        notice.setVisibility(View.GONE);
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new FeedFragment());
        fragmentTransaction.commit();


>>>>>>> 3202c5d... 통신 미구현

        feedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new FeedFragment());
                fragmentTransaction.commit();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new LikeFragment());
                fragmentTransaction.commit();
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new ProfileFragment());
                fragmentTransaction.commit();
            }
        });
    }



    public void MainClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onButtonFeed(View v){ //feed 페이지로 이동
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }

}
