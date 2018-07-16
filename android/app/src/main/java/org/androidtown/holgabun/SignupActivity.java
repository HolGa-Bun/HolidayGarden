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
                singupFunc();
            }
        });

        spinner=(Spinner)findViewById(R.id.Question);
        adapter = ArrayAdapter.createFromResource(this, R.array.Question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw_1);
                data.put("PWD",editText.getText().toString());
                data.put("NAME","min");
                data.put("QUEST","qq");
                data.put("ASW","ww");

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/requestLogin.php",data);

                return result;
            }
        }

        SingupAsync ui = new SingupAsync();
        ui.execute("");
    }
}



