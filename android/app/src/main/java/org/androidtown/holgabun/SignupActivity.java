package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.text.Editable;
import android.text.TextWatcher;
>>>>>>> d7162a6... 0719 jiyoon
=======
import android.text.Editable;
import android.text.TextWatcher;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.widget.TextView;
>>>>>>> d7162a6... 0719 jiyoon
=======
import android.widget.TextView;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    EditText editText2;
    EditText editText3;
>>>>>>> d7162a6... 0719 jiyoon
=======
    EditText editText2;
    EditText editText3;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    Button button;
    Spinner spinner;
    private ArrayAdapter adapter;
    private static final String TAG = "TestActivity";
<<<<<<< HEAD
<<<<<<< HEAD

=======
    TextView passwordcorrect;
>>>>>>> d7162a6... 0719 jiyoon
=======
    TextView passwordcorrect;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button = (Button) findViewById(R.id.Signup);
<<<<<<< HEAD
        editText = (EditText) findViewById(R.id.id);
<<<<<<< HEAD
=======
        editText2 =(EditText) findViewById(R.id.pw_1);
        editText3=(EditText)findViewById(R.id.pw_2);
        passwordcorrect=(TextView) findViewById(R.id.passwordcorrect);
>>>>>>> d7162a6... 0719 jiyoon
=======
        editText = (EditText) findViewById(R.id.ids);
        editText2 =(EditText) findViewById(R.id.pw_1);
        editText3=(EditText)findViewById(R.id.pw_2);
        passwordcorrect=(TextView) findViewById(R.id.passwordcorrect);
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                singupFunc();
=======
                String su = editText.getText().toString();
                singup();


>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
                singupFunc();
>>>>>>> ddd2025... 색변경
=======
                singupFunc();
>>>>>>> d7162a6... 0719 jiyoon
=======
                singupFunc();
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            }
        });

        spinner=(Spinner)findViewById(R.id.Question);
        adapter = ArrayAdapter.createFromResource(this, R.array.Question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

<<<<<<< HEAD
<<<<<<< HEAD
    }


<<<<<<< HEAD
<<<<<<< HEAD
    private void singupFunc(){
        class SingupAsync extends AsyncTask<String,Void,String> {
=======
    private void singup(){
        class UploadImage extends AsyncTask<String,Void,String> {
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
    private void singupFunc(){
        class SingupAsync extends AsyncTask<String,Void,String> {
>>>>>>> ddd2025... 색변경
=======
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

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
<<<<<<< HEAD
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
=======
                loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> ddd2025... 색변경
=======
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> d7162a6... 0719 jiyoon
=======
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d("login",s);
                loading.dismiss();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
               if(s.equals("login success!"))
               {
                    Intent intent =new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
               }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
               else {
                   Toast.makeText(SignupActivity.this,"아이디나 닉네임이 동일한 유저가 존재합니다.",Toast.LENGTH_LONG).show();
               }
>>>>>>> 32fdcbc... ㅜㅜ
=======
               else {
                   Toast.makeText(SignupActivity.this,"아이디나 닉네임이 동일한 유저가 존재합니다.",Toast.LENGTH_LONG).show();
               }
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            }

            @Override
            protected String doInBackground(String... params) {
<<<<<<< HEAD
<<<<<<< HEAD


<<<<<<< HEAD
<<<<<<< HEAD

                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw_1);
                data.put("PWD",editText.getText().toString());
=======
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                    editText = (EditText) findViewById(R.id.pw_1);
                    data.put("PWD", editText.getText().toString());
<<<<<<< HEAD
>>>>>>> d7162a6... 0719 jiyoon
                editText=(EditText)findViewById(R.id.nickname);
                data.put("NAME",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.answer);
                data.put("ASW",editText.getText().toString());
<<<<<<< HEAD
=======
                HashMap<String,String> data = new HashMap<>();

>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======

                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw_1);
                data.put("PWD",editText.getText().toString());
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                editText=(EditText)findViewById(R.id.nickname);
                data.put("NAME",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.answer);
                data.put("ASW",editText.getText().toString());
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/requestLogin.php",data);

                return result;
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        SingupAsync ui = new SingupAsync();
=======
        UploadImage ui = new UploadImage();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
        SingupAsync ui = new SingupAsync();
>>>>>>> ddd2025... 색변경
=======
        SingupAsync ui = new SingupAsync();
>>>>>>> d7162a6... 0719 jiyoon
=======
        SingupAsync ui = new SingupAsync();
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        ui.execute("");
    }
}



