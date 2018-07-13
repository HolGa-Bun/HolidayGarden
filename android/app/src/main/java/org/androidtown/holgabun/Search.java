package org.androidtown.holgabun;

import android.content.Intent;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

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

    private static final String TAG = "TestActivity";
    ListView listview ;
    ListViewAdapter adapter1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        adapter1 = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.List_garden);
        listview.setAdapter(adapter1);

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








        // -------검색 값 받기-------------------------
        intent = getIntent();
        editText = (EditText) findViewById(R.id.search_tutname);
        editText.setText(intent.getStringExtra("name"));
        spinner_si = (Spinner) findViewById(R.id.search_si);
        spinner_gu = (Spinner) findViewById(R.id.search_gu);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner_si.setAdapter(adapter);
        spinner_si.setSelection(intent.getIntExtra("si", 0));
        if (intent.getIntExtra("si", 0) == 8) {
            adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
            spinner_gu.setAdapter(adapter);
            spinner_gu.setSelection(intent.getIntExtra("gu", 0));

        }
        spinner_si.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 8:

                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);
                        break;
                    default:

                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner_gu.setAdapter(adapter);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //-----------------위치 검색


    }//oncrete


    public void sendtoData() {

        HttpConnection h=new HttpConnection();
        String body = null;

        try {
            body = h.execute("Search",spinner_si.getSelectedItem().toString(),spinner_gu.getSelectedItem().toString()).get();
            // String 으로 들어온 값 JSONObject 로 1차 파싱
            JSONObject wrapObject = new JSONObject(body);
            wrapObject= new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG,body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));


            // set POI data

            for (int i = 0; i < jsonArray.length(); i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                    adapter1.addItem(BitmapFactory.decodeResource(getResources(),R.drawable.icon),
                            dataJsonObject.getString("FARM_NM"), dataJsonObject.getString("ADDRESS1")) ;

            }


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