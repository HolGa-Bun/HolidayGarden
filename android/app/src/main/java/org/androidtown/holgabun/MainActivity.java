package org.androidtown.holgabun;


import android.content.Intent;
import android.graphics.BitmapFactory;
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
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter adapter;
    private Spinner spinner;
    private static final String TAG = "TestActivity";
<<<<<<< HEAD

=======
>>>>>>> 94887fb... 0713[feature/android]
    AutoScrollViewPager autoViewPager;
    Button button;
    EditText editText;
    int check;
    ArrayList<Garden> Garden = new ArrayList<>();

    org.androidtown.holgabun.GridAdapter adapter2;
    GridView gridView;

<<<<<<< HEAD
<<<<<<< HEAD
    final int imglist[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
=======
    final int imglist[]={R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
>>>>>>> 490ec72... 0709[feature/android] Search_Account, Change_Password
=======

>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Garden Information");

<<<<<<< HEAD
<<<<<<< HEAD
        gridView = (GridView)findViewById(R.id.grid);
        adapter2 = new GridAdapter(this, Garden);

        Garden.add(new Garden("아보카도",imglist[0],"1000원"));
        Garden.add(new Garden("수박",imglist[1],"1000원"));
        Garden.add(new Garden("오렌지",imglist[2],"1000원"));
        Garden.add(new Garden("바나나",imglist[3],"1000원"));
<<<<<<< HEAD
<<<<<<< HEAD
=======
        gridView = (GridView) findViewById(R.id.grid);
        adapter2 = new GridAdapter(this, Garden);

        //Garden.add(new Garden("아보카도",imglist[0],"1000원"));
        //Garden.add(new Garden("수박",imglist[1],"1000원"));
        //Garden.add(new Garden("오렌지",imglist[2],"1000원"));
        //Garden.add(new Garden("바나나",imglist[3],"1000원"));
        gridView.setAdapter(adapter2);
>>>>>>> 3202c5d... 통신 미구현
=======
        gridView.setAdapter(adapter2);
>>>>>>> ebc2413... 0709 [feature/android/writeButton] ProfileFragment.java onCreateView method에 onClick method 생성
=======
=======

        gridView = (GridView)findViewById(R.id.grid);
        adapter2 = new GridAdapter(this, Garden);


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

>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현
        gridView.setAdapter(adapter2);
>>>>>>> 490ec72... 0709[feature/android] Search_Account, Change_Password

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Garden item = (Garden) parent.getItemAtPosition(position) ;

                Intent Serch_i=new Intent(MainActivity.this,Garden_IM.class);
                Serch_i.putExtra("name",item.getName());
                startActivity(Serch_i);
            }
        });

        ArrayList<Integer> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add(R.drawable.t1);
        data.add(R.drawable.t2);
        data.add(R.drawable.t3);


        autoViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
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
                check = position;
                switch (position) {
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

        button = (Button) findViewById(R.id.search_bun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("si", check);
                editText = (EditText) findViewById(R.id.tutname);
                try {
                    intent.putExtra("name", editText.getText().toString());
                } catch (NullPointerException e) {
                    intent.putExtra("name", "없음");
                }
                startActivity(intent);
            }
        });


    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    public void onClickedTimeLine(View v) {
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }
>>>>>>> 3202c5d... 통신 미구현
=======
=======
>>>>>>> 490ec72... 0709[feature/android] Search_Account, Change_Password
=======

>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현
    public void onClickedTimeLine(View v){
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ebc2413... 0709 [feature/android/writeButton] ProfileFragment.java onCreateView method에 onClick method 생성
=======
>>>>>>> 490ec72... 0709[feature/android] Search_Account, Change_Password
=======

    public void onClickedLogin(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현

    public void sendtoData() {

        HttpConnection h = new HttpConnection();
        String body = null;

        try {
            int markerId = NMapPOIflagType.PIN;
            body = h.execute("Random").get();
            // String 으로 들어온 값 JSONObject 로 1차 파싱
            JSONObject wrapObject = new JSONObject(body);
            wrapObject = new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG, body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));


            // set POI data

            for (int i = 0; i <4; i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                Garden.add(new Garden(dataJsonObject.getString("FARM_NM"), BitmapFactory.decodeResource(getResources(),R.drawable.icon),dataJsonObject.getString("ADDRESS1")));

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }



}
