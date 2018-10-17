package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidtown.holgabun.SignupActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class SignupActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button;
    Spinner spinner;
    private ArrayAdapter adapter;
    private static final String TAG = "TestActivity";
    TextView passwordcorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button = (Button) findViewById(R.id.Signup);
        editText = (EditText) findViewById(R.id.ids);
        editText2 =(EditText) findViewById(R.id.pw_1);
        editText3=(EditText)findViewById(R.id.pw_2);
        passwordcorrect=(TextView) findViewById(R.id.passwordcorrect);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singupFunc();
            }
        });

        spinner=(Spinner)findViewById(R.id.Question);
        adapter = ArrayAdapter.createFromResource(this, R.array.Question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        editText3.addTextChangedListener(new TextWatcher() {



            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // 입력되는 텍스트에 변화가 있을 때

            }



            @Override

            public void afterTextChanged(Editable arg0) {

                if(!editText2.getText().toString().equals("")&&!editText2.getText().toString().equals(editText3.getText().toString()))
                    passwordcorrect.setVisibility(View.VISIBLE);
                else if(editText2.getText().toString().equals(editText3.getText().toString()))
                    passwordcorrect.setVisibility(View.GONE);
            }



            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // 입력하기 전에

            }

        });

    }


    private void singupFunc(){
        class SingupAsync extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d("login",s);
                loading.dismiss();
               if(s.equals("login success!"))
               {
                    Intent intent =new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
               }
               else {
                   Toast.makeText(SignupActivity.this,"아이디나 닉네임이 동일한 유저가 존재합니다.",Toast.LENGTH_LONG).show();
               }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                    editText = (EditText) findViewById(R.id.pw_1);
                    data.put("PWD", editText.getText().toString());
                editText=(EditText)findViewById(R.id.nickname);
                data.put("NAME",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.answer);
                data.put("ASW",editText.getText().toString());

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/requestLogin.php",data);

                return result;
            }
        }

        SingupAsync ui = new SingupAsync();
        ui.execute("");
    }
}



