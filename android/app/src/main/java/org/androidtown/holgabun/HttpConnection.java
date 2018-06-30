package org.androidtown.holgabun;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class HttpConnection {

    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection();
    public static HttpConnection getInstance() {
        return instance;
    }

    private HttpConnection(){ this.client = new OkHttpClient(); }


    /** 웹 서버로 요청을 한다. */
    public void requestWebServer(String parameter, String parameter2, Callback callback) {
        RequestBody body = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url("http://211.237.50.150:7080/openapi/abf160159dcc1880ee2a7c68af142681cc72667378a51204b6d47167fd28add6/xml/Grid_20171122000000000552_1/1/100?AREA_LCD=10")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

}