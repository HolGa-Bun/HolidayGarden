package org.androidtown.holgabun;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter adapter;
    private Spinner spinner;
    private static final String TAG = "TestActivity";
    private HttpConnection httpConn = HttpConnection.getInstance();
    AutoScrollViewPager autoViewPager;
    Button button;
    EditText editText;
    int check;
    ArrayList<Garden> Garden = new ArrayList<>();

    org.androidtown.holgabun.GridAdapter adapter;
    GridView gridView;

    final int imglist[]={R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

    private static final String TAG = "TestActivity";
    private HttpConnection httpConn = HttpConnection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Garden Information");

        gridView = (GridView)findViewById(R.id.grid);
        adapter = new GridAdapter(this, Garden);
        gridView.setAdapter(adapter);

        Garden.add(new Garden("아보카도",imglist[0],"1000원"));
        Garden.add(new Garden("수박",imglist[1],"1000원"));
        Garden.add(new Garden("오렌지",imglist[2],"1000원"));
        Garden.add(new Garden("바나나",imglist[3],"1000원"));

        ArrayList<Integer> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add(R.drawable.t1);
        data.add(R.drawable.t2);
        data.add(R.drawable.t3);



        autoViewPager = (AutoScrollViewPager)findViewById(R.id.view_pager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(5000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

        spinner = (Spinner) findViewById(R.id.si);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                check=position;
                switch (position)
                {
                    case 8:
                        spinner = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                        break;
                    default:
                        spinner = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button =(Button)findViewById(R.id.search_bun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Search.class);
                intent.putExtra("si",check);
                editText=(EditText)findViewById(R.id.tutname);
                try {
                    intent.putExtra("name", editText.getText().toString());
                }
                catch(NullPointerException e){

                }
                startActivity(intent);
            }
        });



    }

    private void sendData() {
// 네트워크 통신하는 작업은 무조건 작업스레드를 생성해서 호출 해줄 것!!
        new Thread() {
            public void run() {
// 파라미터 2개와 미리정의해논 콜백함수를 매개변수로 전달하여 호출
                httpConn.requestWebServer("10","데이터2", callback);
            }
        }.start();    }

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d(TAG, "콜백오류:" + e.getMessage());
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string();
            Log.d(TAG, "서버에서 응답한 Body:" + body);
        }
    };


}