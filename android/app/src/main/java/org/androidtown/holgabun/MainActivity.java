package org.androidtown.holgabun;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter adapter;
    private Spinner spinner_gu;
    private Spinner spinner_si;
    private static final String TAG = "TestActivity";

    AutoScrollViewPager autoViewPager;
    Button button;
    EditText editText;
    int check_si;
    int check_gu;
    LinearLayout l;
    ArrayList<Garden> Garden = new ArrayList<>();

    org.androidtown.holgabun.GridAdapter adapter2;
    GridView gridView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Garden Information");


        gridView = (GridView)findViewById(R.id.grid);
        adapter2 = new GridAdapter(this, Garden);
        l=(LinearLayout)findViewById(R.id.test);



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

        gridView.setAdapter(adapter2);

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
        data.add(R.drawable.main_image1);
        data.add(R.drawable.main_image2);
        data.add(R.drawable.main_image3);


        autoViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(5000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작



        spinner_si = (Spinner) findViewById(R.id.si);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner_si.setAdapter(adapter);
        spinner_gu=(Spinner)findViewById(R.id.gu);
        spinner_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                check_si = position;
                switch (position) {
                    case 0:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Seo_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 1:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Bu_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 2:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Degu_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 3:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Inchean_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 4:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Kang_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 5:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.De_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 6:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Ul_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 7:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Se_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 8:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 9:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Gang_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 10:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.ChungBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 11:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.ChungNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;

                    case 12:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.JunlabUK_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 13:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.JunlaNAM_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 14:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.GuengBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 15:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.GuengNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;

                    default:
                        spinner_gu = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                check_si=0;
            }
        });

        spinner_gu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                check_gu=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                check_gu=0;
            }
        });

        button = (Button) findViewById(R.id.search_bun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("si", check_si);
                intent.putExtra("gu",check_gu);
                editText = (EditText) findViewById(R.id.tutname);
                try {
                    intent.putExtra("name", editText.getText().toString());
                } catch (NullPointerException e) {
                    intent.putExtra("name", "없음");
                }
                startActivity(intent);
                finish();
            }
        });


    }


    public void onClickedTimeLine(View v){

        DbOpenHelper h=new DbOpenHelper(this);
        h.open();

        if(h.returnOnOff()==1 ||h.returnOnOff()==2) {
            Intent intent = new Intent(this, TimeLine.class);
            startActivity(intent);
        }
        else{
            show();
        }
    }

    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("주의");
        builder.setMessage("SNS를 사용하시려면 로그인이 필요합니다. 로그인 하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }


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
