package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    Button button;
    Spinner spinner;
    private ArrayAdapter adapter;
    private static final String TAG = "TestActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button = (Button) findViewById(R.id.Signup);
        editText = (EditText) findViewById(R.id.id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        spinner=(Spinner)findViewById(R.id.Question);
        adapter = ArrayAdapter.createFromResource(this, R.array.Question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
<<<<<<< HEAD
<<<<<<< HEAD
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
=======
                loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
               loading = ProgressDialog.show(SignupActivity.this, "Uploading...", null,true,true);
>>>>>>> ddd2025... 색변경
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ddd2025... 색변경
               if(s.equals("login success!"))
               {
                    Intent intent =new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
               }
<<<<<<< HEAD
=======
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
>>>>>>> ddd2025... 색변경
            }

            @Override
            protected String doInBackground(String... params) {


<<<<<<< HEAD
<<<<<<< HEAD

                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw_1);
                data.put("PWD",editText.getText().toString());
                editText=(EditText)findViewById(R.id.nickname);
                data.put("NAME",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.answer);
                data.put("ASW",editText.getText().toString());
=======
                HashMap<String,String> data = new HashMap<>();

>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======

                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.ids);
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw_1);
                data.put("PWD",editText.getText().toString());
                editText=(EditText)findViewById(R.id.nickname);
                data.put("NAME",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.answer);
                data.put("ASW",editText.getText().toString());
>>>>>>> ddd2025... 색변경

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/requestLogin.php",data);

                return result;
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD
        SingupAsync ui = new SingupAsync();
=======
        UploadImage ui = new UploadImage();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
        SingupAsync ui = new SingupAsync();
>>>>>>> ddd2025... 색변경
        ui.execute("");
    }
}



