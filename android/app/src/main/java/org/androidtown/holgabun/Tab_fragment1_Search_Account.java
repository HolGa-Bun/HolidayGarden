package org.androidtown.holgabun;

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

public class Tab_fragment1_Search_Account extends AppCompatActivity {


    DbOpenHelper h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment1_search_account);

        DbOpenHelper h=new  DbOpenHelper(this);
        h.open();

        TextView t=(TextView)findViewById(R.id.real_ID);
        t.setText("최근 로그인한 계정의 ID는 "+h.returnId()+"입니다");

        Button b=(Button)findViewById(R.id.a);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Tab_fragment1_Search_Account.this,Tab_fragment2_Search_Account.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
