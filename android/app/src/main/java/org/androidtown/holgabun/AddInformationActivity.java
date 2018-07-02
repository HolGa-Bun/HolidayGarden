package org.androidtown.holgabun;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidtown.holgabun.R;
import org.w3c.dom.Text;

public class AddInformationActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Spinner spinner;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);

        spinner = (Spinner) findViewById(R.id.si_doSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClickedToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    //버튼
    public void onClickedPop(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
                //어디에 넣을지 모르겠어서 그냥 Toast로 할게요
                Toast.makeText(AddInformationActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }

}


