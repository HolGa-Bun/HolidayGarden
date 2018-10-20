package org.androidtown.holgabun;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class another_profile extends AppCompatActivity {

    ListView listView;
<<<<<<< HEAD
    ArrayList<Bitmap> please;
=======

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    String feed_id;
    String id;
    Button b;
    DbOpenHelper h;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_profile);

        listView=(ListView)findViewById(R.id.anotherfeed);
        Intent intent=getIntent();
        feed_id=intent.getStringExtra("name");
        b=(Button)findViewById(R.id.follow);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b.getText().toString().equals("Follow"))
                {
                    follow("");
                    b.setText("unFollow");
                }
                else {
                    follow("un");
                    b.setText("Follow");
                }

            }
        });
        h=new DbOpenHelper(this);
        h.open();
        t=(TextView)findViewById(R.id.nickname_anotherprofile);
        t.setText(feed_id);

        follow("is");
<<<<<<< HEAD
=======
        List();
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
    }
    private void follow(String request){
        class Follow extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(another_profile.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Log.d("THIS",s);



                try{
                    JSONObject j = new JSONObject(s);

                    if(j.getString("result").equals("true"))
                    {
                        b.setText("UnFollow");
                    }
                    else{
                        b.setText("Follow");
                    }




                }catch(JSONException e){
                    e.printStackTrace();
                }


            }

            @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();


                data.put("ID",h.returnId());
                data.put("anther_ID",feed_id);

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/"+params[0]+"follow.php",data);



                return result;
            }
        }

        Follow ui = new Follow();
        ui.execute(request);
    }

    private void List(){
        class ListSaw extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();
<<<<<<< HEAD
=======
            FeedAdapter feedAdapter=new FeedAdapter();

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(another_profile.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
<<<<<<< HEAD
                Log.d("THIS",s);



                try{
                    JSONArray jsonArray = new JSONArray(s);

                    FeedAdapter feedAdapter=new FeedAdapter();


                    for (int i = 0; i < jsonArray.length(); i++) {
                        // Array 에서 하나의 JSONObject 를 추출
                        JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                        // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                        feedAdapter.addItem(BitmapFactory.decodeResource(getResources(),R.drawable.icon),dataJsonObject.getString("id"),please.get(i),dataJsonObject.getString("text"),
                                dataJsonObject.getString("bolderNum"),dataJsonObject.getString("time"));

                    }
                    listView.setAdapter(feedAdapter);


                }catch(JSONException e){
                    e.printStackTrace();
                }
=======






                listView.setAdapter(feedAdapter);

>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a


            }

            @Override
            protected String doInBackground(String... params) {



<<<<<<< HEAD
=======


>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                HashMap<String,String> data = new HashMap<>();


                data.put("ID",feed_id);


<<<<<<< HEAD
                String res = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/getID.php",data);

                try{
                    JSONObject J=new JSONObject(res);
                    id=J.getString("id");

                }catch (JSONException e){
                    e.printStackTrace();
                }

                data.clear();
                data.put("ID",id);

                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/MyBolder.php",data);


                try {
                    JSONArray j = new JSONArray(result);

                    please=new ArrayList<Bitmap>();
                    for (int i = 0; i < j.length(); i++) {

                        // Array 에서 하나의 JSONObject 를 추출
                        JSONObject dataJsonObject = j.getJSONObject(i);
                        // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시
                        URL url=new URL(dataJsonObject.getString("image").replace("\\",""));

                        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                        conn.setDoInput(true);
                        conn.connect();
                        InputStream is=conn.getInputStream();

                        please.add(BitmapFactory.decodeStream(is));


=======
                    String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/AnoBolder.php",data);

                    try {
                        JSONArray j = new JSONArray(result);


                        for (int i = 0; i < j.length(); i++) {

                            // Array 에서 하나의 JSONObject 를 추출
                            JSONObject dataJsonObject = j.getJSONObject(i);
                            // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                            URL url=new URL(dataJsonObject.getString("image").replace("\\",""));

                            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                            conn.setDoInput(true);
                            conn.connect();
                            InputStream is=conn.getInputStream();
                            // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                            feedAdapter.addItem(dataJsonObject.getString("id"),BitmapFactory.decodeStream(is),dataJsonObject.getString("text"),
                                    dataJsonObject.getString("bolderNum"),dataJsonObject.getString("time"));

                        }


                            return result;


                    }catch(JSONException e)
                    {
                        e.printStackTrace();
                    }catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }catch(IOException e)
                    {
                        e.printStackTrace();
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
                    }




<<<<<<< HEAD
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
                return result;
=======

         return null;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a
            }
        }

        ListSaw ui = new ListSaw();
        ui.execute("");
    }
}
