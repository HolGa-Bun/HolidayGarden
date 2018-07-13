package org.androidtown.holgabun;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.androidtown.holgabun.SignupActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class SignupActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    private static final String TAG = "TestActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        button = (Button) findViewById(R.id.su);
        editText = (EditText) findViewById(R.id.id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String su = editText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                sendtoData();
                            }
                        });
                    }
                }).start();
            }
        });

    }

    public void onButton2Clicked (View v){
        Intent intent = new Intent(this, AddInformationActivity.class);
        startActivity(intent);
    }

    public void sendtoData() {

        HttpConnection h = new HttpConnection();
        String body = null;

        try {

            body = h.execute("suid",editText.getText().toString()).get();

            // String 으로 들어온 값 JSONObject 로 1차 파싱
           /* JSONObject wrapObject = new JSONObject(body);
            wrapObject = new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG, body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));


            // set POI data

            for (int i = 0; i <4; i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시
            }
            */

            Toast.makeText(this,body,Toast.LENGTH_LONG).show();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}



