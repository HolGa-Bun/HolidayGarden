package org.androidtown.holgabun;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapResourceProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

//가든 하나의 정보
public class Garden_IM extends NMapActivity {

    private static final String TAG = ".Garden_IM";
    private NMapView mMapView;// 지도 화면 View
    private final String CLIENT_ID = "eE9eLsg6dk9r3z8mqjKr";// 애플리케이션 클라이언트 아이디 값
    private NMapController mMapController;
    private NMapResourceProvider nMapResourceProvider;
    private NMapOverlayManager mapOverlayManager;
    ViewGroup f;
    String name;
    TextView textView;
    ScrollView myScroll ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden__im);
        myScroll=(ScrollView)findViewById(R.id.scrollview);

        f = findViewById(R.id.mymap);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        mMapView = new NMapView(this);
        f.addView(mMapView);
        mMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 값 설정
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapController = mMapView.getMapController();
        mMapView.setOnMapViewTouchEventListener(mapListener);




        nMapResourceProvider = new NMapViewerResourceProvider(this);
        mapOverlayManager = new NMapOverlayManager(this, mMapView, nMapResourceProvider);


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
    private NMapView.OnMapViewTouchEventListener mapListener = new NMapView.OnMapViewTouchEventListener() {
        @Override
        public void onLongPress(NMapView nMapView, MotionEvent motionEvent) {
            Log.e(TAG, "OnMapViewTouchEventListener onLongPress : ");
        }

        @Override
        public void onLongPressCanceled(NMapView nMapView) {


            Log.e(TAG, "OnMapViewTouchEventListener onLongPressCanceled : ");
        }

        @Override
        public void onTouchDown(NMapView nMapView, MotionEvent motionEvent) {
            Log.e(TAG, "OnMapViewTouchEventListener onTouchDown : ");
            myScroll.setOnTouchListener( new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }

        @Override
        public void onTouchUp(NMapView nMapView, MotionEvent motionEvent) {
            Log.e(TAG, "OnMapViewTouchEventListener onTouchUp : ");
            myScroll.setOnTouchListener(null);

        }

        @Override
        public void onScroll(NMapView nMapView, MotionEvent motionEvent, MotionEvent motionEvent1) {
            Log.e(TAG, "OnMapViewTouchEventListener onScroll : ");
            myScroll.setOnTouchListener( new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }

        @Override
        public void onSingleTapUp(NMapView nMapView, MotionEvent motionEvent) {
            Log.e(TAG, "OnMapViewTouchEventListener onSingleTapUp : ");
        }
    };




    public void sendtoData() {

        HttpConnection h = new HttpConnection();
        String body = null;

        try {
            int markerId = NMapPOIflagType.PIN;
            body = h.execute("Garden", name).get();
            // String 으로 들어온 값 JSONObject 로 1차 파싱
            JSONObject wrapObject = new JSONObject(body);
            wrapObject = new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG, body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));


            // set POI data

            for (int i = 0; i < jsonArray.length(); i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                textView = (TextView) findViewById(R.id.name);
                textView.setText(dataJsonObject.getString("FARM_NM"));
                textView = (TextView) findViewById(R.id.address);
                textView.setText(dataJsonObject.getString("ADDRESS1"));
                textView = (TextView) findViewById(R.id.owner);
                textView.setText(dataJsonObject.getString("FARM_TYPE"));
                textView = (TextView) findViewById(R.id.real_area);
                textView.setText(dataJsonObject.getString("FARM_AREA_INFO"));
                textView = (TextView) findViewById(R.id.sell_area);
                textView.setText(dataJsonObject.getString("SELL_AREA_INFO"));

                textView = (TextView) findViewById(R.id.price);
                textView.setText(dataJsonObject.getString("PRICE"));
                textView = (TextView) findViewById(R.id.apply_time);
                textView.setText(dataJsonObject.getString("COLLEC_PROD"));
                textView = (TextView) findViewById(R.id.price);
                textView.setText(dataJsonObject.getString("PRICE"));
                textView = (TextView) findViewById(R.id.office);
                textView.setText(dataJsonObject.getString("OFF_SITE"));
                textView = (TextView) findViewById(R.id.apply);
                textView.setText(dataJsonObject.getString("APPLY_MTHD"));
                textView = (TextView) findViewById(R.id.howtoapply);
                textView.setText(dataJsonObject.getString("HOMEPAGE"));

                if(!dataJsonObject.getString("POSLNG").equals("")) {
                    NMapPOIdata poiData = new NMapPOIdata(1, nMapResourceProvider);
                    poiData.beginPOIdata(1);

                    poiData.addPOIitem(Double.parseDouble(dataJsonObject.getString("POSLNG")), Double.parseDouble(dataJsonObject.getString("POSLAT")), dataJsonObject.getString("FARM_NM"), markerId, 0);
                    poiData.endPOIdata();
                    // create POI data overlay
                    NMapPOIdataOverlay poiDataOverlay = mapOverlayManager.createPOIdataOverlay(poiData, null);
                    poiDataOverlay.showAllPOIdata(0);
                }
                else
                {
                    Toast.makeText(this,"해당 위치정보가 없습니다.",Toast.LENGTH_LONG).show();
                }






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
