package org.androidtown.holgabun;


import android.app.ProgressDialog;
import android.content.Intent;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.widget.ListAdapter;
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
import android.widget.ListAdapter;
>>>>>>> ddd2025... 색변경
=======
import android.widget.ListAdapter;
>>>>>>> d7162a6... 0719 jiyoon
=======
import android.widget.ListAdapter;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
import android.widget.ListView;
import android.widget.Spinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.concurrent.ExecutionException;


public class Search extends AppCompatActivity {



    Spinner spinner_si;
    Spinner spinner_gu;
    private ArrayAdapter adapter;
    Intent intent;
    EditText editText;

    private final String CLIENT_ID = "eE9eLsg6dk9r3z8mqjKr";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d7162a6... 0719 jiyoon
    Button button;


    private static final String TAG = "TestActivity";
    ListView listview ;
<<<<<<< HEAD
=======

    private static final String TAG = "TestActivity";
    ListView listview ;
    ListViewAdapter adapter1;



>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    Button button;


    private static final String TAG = "TestActivity";
    ListView listview ;
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.List_garden);

<<<<<<< HEAD
<<<<<<< HEAD
=======
        adapter1 = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.List_garden);
        listview.setAdapter(adapter1);
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.List_garden);

>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                Garden item = (Garden) parent.getItemAtPosition(position) ;

                Intent Serch_i=new Intent(Search.this,Garden_IM.class);
                Serch_i.putExtra("name",item.getName());
                startActivity(Serch_i);


                // TODO : use item data.
            }
        }) ;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        button=(Button)findViewById(R.id.gotoHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button=(Button)findViewById(R.id.gotoTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,TimeLine.class);
                startActivity(intent);
                finish();
            }
        });


        button=(Button)findViewById(R.id.search_bun);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                sendtoData();
                            }
                        });
                    }
                }).start();
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
=======
        new Thread(new Runnable() {
=======
        button=(Button)findViewById(R.id.gotoHome);
        button.setOnClickListener(new View.OnClickListener() {
>>>>>>> ddd2025... 색변경
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button=(Button)findViewById(R.id.gotoTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,TimeLine.class);
                startActivity(intent);
                finish();
            }
        });


        button=(Button)findViewById(R.id.search_bun);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                sendtoData();
                            }
                        });
                    }
                }).start();
            }
<<<<<<< HEAD
        }).start();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
        });
>>>>>>> ddd2025... 색변경
=======

>>>>>>> d7162a6... 0719 jiyoon
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a







<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
        // -------검색 값 받기-------------------------
=======
        // / -------검색 값 받기-------------------------
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
        // / -------검색 값 받기-------------------------
>>>>>>> d7162a6... 0719 jiyoon
=======
        // / -------검색 값 받기-------------------------
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        intent = getIntent();
        editText = (EditText) findViewById(R.id.search_tutname);
        editText.setText(intent.getStringExtra("name"));
        spinner_si = (Spinner) findViewById(R.id.search_si);
        spinner_gu = (Spinner) findViewById(R.id.search_gu);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner_si.setAdapter(adapter);
        spinner_si.setSelection(intent.getIntExtra("si", 0));
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


        switch (intent.getIntExtra("gu",16)) {
            case 0:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Seo_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 1:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Bu_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 2:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Degu_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 3:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Inchean_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 4:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Kang_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 5:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.De_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 6:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Ul_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 7:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Se_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 8:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 9:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gang_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 10:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungBuk_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 11:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungNam_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;

            case 12:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlabUK_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 13:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlaNAM_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 14:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengBuk_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;
            case 15:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengNam_si, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);
                break;

            default:
                spinner_gu = (Spinner) findViewById(R.id.search_gu);
                adapter = ArrayAdapter.createFromResource(Search.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                spinner_gu.setAdapter(adapter);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        }


=======
        if (intent.getIntExtra("si", 0) == 8) {
            adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
            spinner_gu.setAdapter(adapter);
            spinner_gu.setSelection(intent.getIntExtra("gu", 0));

        }
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        }


<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======

        }


>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
        spinner_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
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
                    case 0:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Seo_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 1:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Bu_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 2:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Degu_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 3:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Inchean_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 4:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Kang_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 5:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.De_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 6:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Ul_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 7:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Se_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    case 8:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 9:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gang_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 10:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 11:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
=======
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                    case 8:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
                        break;

                    case 12:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlabUK_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 13:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlaNAM_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 14:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 15:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
<<<<<<< HEAD

                    default:
<<<<<<< HEAD
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
=======

>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
                        break;
>>>>>>> d7162a6... 0719 jiyoon
=======
                        break;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                    case 9:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gang_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 10:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 11:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.ChungNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;

                    case 12:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlabUK_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 13:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.JunlaNAM_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 14:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengBuk_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    case 15:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.GuengNam_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;

                    default:
                        spinner_gu = (Spinner) findViewById(R.id.search_gu);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //-----------------위치 검색

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
        Runnable a=new Runnable() {
            @Override
            public void run() {
                sendtoData();
            }
        };

        a.run();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

    }//oncrete


    public void sendtoData() {

        HttpConnection h=new HttpConnection();
        String body = null;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        try {

            if(editText.getText().toString().equals(""))
            {
                body = h.execute("Search",spinner_si.getSelectedItem().toString(),spinner_gu.getSelectedItem().toString()).get();}
            else{
                body=h.execute("Garden",editText.getText().toString()).get();
            }
=======
        try {
            body = h.execute("Search",spinner_si.getSelectedItem().toString(),spinner_gu.getSelectedItem().toString()).get();
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

        try {

            if(editText.getText().toString().equals(""))
            {
                body = h.execute("Search",spinner_si.getSelectedItem().toString(),spinner_gu.getSelectedItem().toString()).get();}
            else{
                body=h.execute("Garden",editText.getText().toString()).get();
            }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            // String 으로 들어온 값 JSONObject 로 1차 파싱
            JSONObject wrapObject = new JSONObject(body);
            wrapObject= new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG,body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));

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
            listview.setAdapter(null);

            ListViewAdapter reload =new ListViewAdapter();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

            // set POI data

            for (int i = 0; i < jsonArray.length(); i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    reload.addItem(BitmapFactory.decodeResource(getResources(),R.drawable.icon),
                            dataJsonObject.getString("FARM_NM"), dataJsonObject.getString("ADDRESS1")) ;

            }
            listview.setAdapter(reload);

=======
                    adapter1.addItem(BitmapFactory.decodeResource(getResources(),R.drawable.icon),
                            dataJsonObject.getString("FARM_NM"), dataJsonObject.getString("ADDRESS1")) ;

            }
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                    reload.addItem(BitmapFactory.decodeResource(getResources(),R.drawable.icon),
                            dataJsonObject.getString("FARM_NM"), dataJsonObject.getString("ADDRESS1")) ;

            }
            listview.setAdapter(reload);

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a


          // NMapPOIdata poiData = new NMapPOIdata(test.size(), nMapResourceProvider);
            //poiData.beginPOIdata(test.size());
            //for(int i=0;i<5;i++) {

              //  poiData.addPOIitem(Double.parseDouble(test.get(i)),Double.parseDouble(test.get(i+1)),"", markerId, 0);
           // }
         /*   poiData.endPOIdata();

            // create POI data overlay
            NMapPOIdataOverlay poiDataOverlay = mapOverlayManager.createPOIdataOverlay(poiData, null);
            poiDataOverlay.showAllPOIdata(0);
            */

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch(
                JSONException e)
        {
            e.printStackTrace();
        }catch(
                NumberFormatException e){
            e.printStackTrace();
        }
    }
}