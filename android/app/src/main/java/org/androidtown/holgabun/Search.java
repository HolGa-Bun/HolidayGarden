package org.androidtown.holgabun;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapItemizedOverlay;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapResourceProvider;

import
        org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Search extends NMapActivity {


    private NMapResourceProvider nMapResourceProvider;
    private NMapOverlayManager mapOverlayManager;


    Spinner spinner_si;
    Spinner spinner_gu;
    private ArrayAdapter adapter;
    Intent intent;
    EditText editText;
    private NMapView mMapView;// 지도 화면 View
    private final String CLIENT_ID = "eE9eLsg6dk9r3z8mqjKr";
    private NMapController mMapController;
    private static final String TAG = "TestActivity";
    private HttpConnection httpConn = HttpConnection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mMapView = new NMapView(this);
        FrameLayout f = (FrameLayout) findViewById(R.id.mipmap);
        f.addView(mMapView);
        mMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 값 설정
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapController = mMapView.getMapController();


        nMapResourceProvider = new NMapViewerResourceProvider(this);
        mapOverlayManager = new NMapOverlayManager(this, mMapView, nMapResourceProvider);


        // -------검색 값 받기-------------------------
        intent = getIntent();
        editText = (EditText) findViewById(R.id.search_tutname);
        editText.setText(intent.getStringExtra("name"));
        spinner_si = (Spinner) findViewById(R.id.search_si);
        spinner_gu = (Spinner) findViewById(R.id.search_gu);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner_si.setAdapter(adapter);
        spinner_si.setSelection(intent.getIntExtra("si", 0));
        if(intent.getIntExtra("si", 0)==8)
        { adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
            spinner_gu.setAdapter(adapter);
            spinner_gu.setSelection(intent.getIntExtra("gu",0));

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

        sendtoData();
    }//oncrete

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d(TAG, "콜백오류:" + e.getMessage());
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string();
            Log.d(TAG, "서버에서 응답한 Body:" + body);

            try {
                // String 으로 들어온 값 JSONObject 로 1차 파싱
                JSONObject wrapObject = new JSONObject(body);

                // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
                JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));
                int markerId = NMapPOIflagType.PIN;

                // set POI data
                NMapPOIdata poiData = new NMapPOIdata(2, nMapResourceProvider);
                poiData.beginPOIdata(2);
                for (int i = 0; i < jsonArray.length(); i++) {
                    // Array 에서 하나의 JSONObject 를 추출
                    JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                    // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시


                    poiData.addPOIitem(Double.parseDouble(dataJsonObject.get("POSLAT").toString()),Double.parseDouble(dataJsonObject.get("POSLNG").toString()),dataJsonObject.get("FARM_NM").toString(), markerId, 0);



                }
                poiData.endPOIdata();

                // create POI data overlay
                NMapPOIdataOverlay poiDataOverlay = mapOverlayManager.createPOIdataOverlay(poiData, null);
                poiDataOverlay.showAllPOIdata(0);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    };

    public void sendtoData() {
        new Thread() {
            public void run() {
// 파라미터 2개와 미리정의해논 콜백함수를 매개변수로 전달하여 호출

                httpConn.requestWebServer(spinner_si.getSelectedItem().toString(), spinner_gu.getSelectedItem().toString(), editText.getText().toString(), callback);
            }
        }.start();


    }







}