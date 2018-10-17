package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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



public class LoginActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    private static final String TAG = "TestActivity";
    DbOpenHelper h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.su);
        editText = (EditText) findViewById(R.id.login);

        h=new DbOpenHelper(this);
        h.open();

        if(h.returnIDSAVE()==1)
        {
            editText.setText(h.returnId());
        }


        findViewById(R.id.auto_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                ((CheckBox) findViewById(R.id.id_save)).setChecked(false);

            }
        });

        findViewById(R.id.id_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    ((CheckBox) findViewById(R.id.auto_login)).setChecked(false);
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            loginFunc();

            }
        });
    }

    public void Checked()
    {

        CheckBox option1=(CheckBox)findViewById(R.id.id_save);
        String result;

        CheckBox option2=(CheckBox)findViewById(R.id.auto_login);

        if(option2.isChecked()) {

            h.automaticLogin();
        }
        if(option1.isChecked())
        {
            h.ID_Save();
        }
        else{
            h.N_ID_Save();
        }
        h.close();

        h.close();

    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void onClickedAdd(View v) {
        Intent intent = new Intent(this, Tab_fragment1_Search_Account.class);
        startActivity(intent);
    }
    private void loginFunc(){
        class LoginAsync extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivity.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();



                    if(s.equals("true")) {
                        String p;
                        editText=(EditText)findViewById(R.id.login);
                        p=editText.getText().toString();
                        editText=(EditText)findViewById(R.id.pw);
                        h.login(p,editText.getText().toString());



                        Checked();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_LONG).show();
                    }

            }

            @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.login);
                data.put("ID",editText.getText().toString());
                editText=(EditText)findViewById(R.id.pw);
                data.put("PWD",editText.getText().toString());


                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/logincheck.php",data);

                Log.d(TAG,result);

                try{
                    JSONObject j=new JSONObject(result);

                    return j.getString("result");


                }catch(JSONException e){
                    e.printStackTrace();
                    return "";
                }


            }
        }

        LoginAsync ui = new LoginAsync();
        ui.execute("");
    }


}