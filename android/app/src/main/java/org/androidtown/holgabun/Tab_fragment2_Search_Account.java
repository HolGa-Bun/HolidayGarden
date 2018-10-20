package org.androidtown.holgabun;

<<<<<<< HEAD

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ResourceBundle;


public class Tab_fragment2_Search_Account extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        {
            return inflater.inflate(R.layout.activity_tab_fragment2_search_account, container, false);

        }
    }
}


=======
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Tab_fragment2_Search_Account extends AppCompatActivity {


    DbOpenHelper h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment1_search_account);

        DbOpenHelper h=new  DbOpenHelper(this);
        h.open();

    }


}
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
