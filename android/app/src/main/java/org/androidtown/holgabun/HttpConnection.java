package org.androidtown.holgabun;

import android.os.AsyncTask;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;


import org.json.JSONException;

import org.json.JSONObject;


import java.io.BufferedInputStream;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;


/**
 * Created by terry on 2015. 8. 27..
 * <p>
 * 목표
 * <p>
 * 1. AsyncTask와 HTTPURLConnection을 이용한 간단한 HTTP 호출 만들기
 * <p>
 * 2. 리턴된 JSON을 파싱하는 방법을 통하여, JSON 객체 다루는 법 습득하기
 * <p>
 * 3. Phone Location (GPS) API 사용 방법 파악하기
 * <p>
 * <p>
 * <p>
 * 참고 자료 : http://developer.android.com/training/basics/network-ops/connecting.html
 */

public class HttpConnection extends AsyncTask<String, Void, String>

{
    final static String openWeatherURL = "http://211.237.50.150:7080/openapi/abf160159dcc1880ee2a7c68af142681cc72667378a51204b6d47167fd28add6/json/Grid_20171122000000000552_1/1/5";
    @Override
    public String doInBackground(String... params) {

        /* url통신 규칙 String 첫번째 :무슨 통신인지 명시 ex)경기도 전체이면 ->AREA_LCD


*/



        String urlString = openWeatherURL;
        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();





        try {

            // call API by using HTTPURLConnection
            if(params[0].equals("Search")) {
                urlString = urlString + "?AREA_LNM=" + URLEncoder.encode(params[1], "UTF-8");
                if(!params.equals("없음"))
                    urlString=urlString+"&AREA_MNM="+URLEncoder.encode(params[2], "UTF-8");
            }else if(params[0].equals("Garden"))
            {
                urlString=urlString+"?FARM_NM="+URLEncoder.encode(params[1], "UTF-8");
            }

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection.setRequestProperty("charset","utf-8");

//            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);

//            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);


            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {

                sb.append(line);

            }


            // parse JSON


        } catch (MalformedURLException e) {

            System.err.println("Malformed URL");

            e.printStackTrace();


        } catch (IOException e) {

            System.err.println("URL Connection failed");

            e.printStackTrace();
            return null;

        }finally {

            if (br != null) {

                try {

                    br.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }Log.d(TAG, "서버에서 응답한 Body:" + sb.toString());

        // set Weather Object
        return sb.toString();



    }


}


