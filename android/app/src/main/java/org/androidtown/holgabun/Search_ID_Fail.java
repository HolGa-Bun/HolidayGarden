package org.androidtown.holgabun;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Search_ID_Fail extends AppCompatActivity {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
    public void onClickedMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
<<<<<<< HEAD
=======
>>>>>>> dadf8b2... test
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_id_fail);

    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

    public void onClickedMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onClickedSearchID(View v) {
        Intent intent = new Intent(this,Tab_fragment1_Search_Account.class);
        startActivity(intent);
    }
>>>>>>> dadf8b2... test
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
}
