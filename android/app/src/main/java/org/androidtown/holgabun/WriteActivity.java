package org.androidtown.holgabun;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> ddd2025... 색변경
=======
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> d7162a6... 0719 jiyoon
import java.util.HashMap;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int SELECT_PICTURE = 1;
    TextView textView;
    private String selectedImagePath;
    private Bitmap bitmap;
    private Uri selectedImageUri;
    private ImageView image;
    private Button RequestURL;
    private Button TimelineButton;
    private EditText edittext;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    DbOpenHelper h;
    String sql_id;
=======

>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
    DbOpenHelper h;
    String sql_id;
>>>>>>> ddd2025... 색변경
=======
    DbOpenHelper h;
    String sql_id;
>>>>>>> d7162a6... 0719 jiyoon

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
        DbOpenHelper h=new DbOpenHelper(this);
        h.open();

        sql_id=h.returnId();

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
        RequestURL=(Button)findViewById(R.id.checkButton);
        TimelineButton=(Button)findViewById(R.id.timeline_img);
        findViewById(R.id.browsePictureButton)
                .setOnClickListener(new View.OnClickListener() {

                    public void onClick(View arg0) {
                        // 사진 선택
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent,
                                "Select Picture"), SELECT_PICTURE);
                    }
                });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        edittext=(EditText)findViewById(R.id.edittext);
=======

        edittext=(EditText)findViewById(R.id.write);
>>>>>>> 85cc7df... 내부 sql 정비 게시글 올리기 성공
        image=(ImageView)findViewById(R.id.img_date2);
        RequestURL.setOnClickListener(this);
=======
        final EditText edittext=(EditText)findViewById(R.id.edittext);
        Button button=(Button)findViewById(R.id.checkButton);
        textView=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(edittext.getText());
            }
        });
>>>>>>> 301d1f1... 0713 [feature/android]생성



=======

        edittext=(EditText)findViewById(R.id.write);
        image=(ImageView)findViewById(R.id.img_date2);
        RequestURL.setOnClickListener(this);




>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======

        edittext=(EditText)findViewById(R.id.write);
        image=(ImageView)findViewById(R.id.img_date2);
        RequestURL.setOnClickListener(this);




>>>>>>> d7162a6... 0719 jiyoon
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {//선택한 사진 가져오기
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE&&resultCode==RESULT_OK&&data !=null&&data.getData() !=null) {

                selectedImageUri = data.getData();
                try{
                    bitmap =MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImageUri);
                    image.setImageBitmap(bitmap);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

 public String getStringImage(Bitmap bmp){
     ByteArrayOutputStream baos=new ByteArrayOutputStream();
     bmp.compress(Bitmap.CompressFormat.JPEG,100,baos);
     byte[] imageBytes =baos.toByteArray();
     String encodedImage = Base64.encodeToString(imageBytes,Base64.DEFAULT);
     return encodedImage;
 }



    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
               loading = ProgressDialog.show(WriteActivity.this, "Uploading...", null,true,true);
=======
                loading = ProgressDialog.show(WriteActivity.this, "Uploading...", null,true,true);
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
               loading = ProgressDialog.show(WriteActivity.this, "Uploading...", null,true,true);
>>>>>>> ddd2025... 색변경
=======
               loading = ProgressDialog.show(WriteActivity.this, "Uploading...", null,true,true);
>>>>>>> d7162a6... 0719 jiyoon
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                finish();
=======
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
                finish();
>>>>>>> ddd2025... 색변경
=======
                finish();
>>>>>>> d7162a6... 0719 jiyoon
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);
<<<<<<< HEAD
<<<<<<< HEAD

                HashMap<String,String> data = new HashMap<>();

                data.put("image", uploadImage);//php에서 POST값으로 들어감
               data.put("text",edittext.getText().toString());

               try{
                   data.put("id",sql_id);
               }catch (NullPointerException e)
               {
                   data.put("id","test");
                   e.printStackTrace();

               }

               long now=System.currentTimeMillis();
               Date date=new Date(now);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

                data.put("time",sdf.format(date));
                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/upload.php",data);
=======
=======
>>>>>>> d7162a6... 0719 jiyoon

                HashMap<String,String> data = new HashMap<>();

                data.put("image", uploadImage);//php에서 POST값으로 들어감
<<<<<<< HEAD
<<<<<<< HEAD
                data.put("mean",edittext.getText().toString());
                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/PhotoUpload/upload.php",data);
>>>>>>> 9b40e82... 0716 [feature/android/Main 수정]
=======
=======
>>>>>>> d7162a6... 0719 jiyoon
               data.put("text",edittext.getText().toString());

               try{
                   data.put("id",sql_id);
               }catch (NullPointerException e)
               {
                   data.put("id","test");
                   e.printStackTrace();

               }

               long now=System.currentTimeMillis();
               Date date=new Date(now);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

                data.put("time",sdf.format(date));
<<<<<<< HEAD
                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/upload.php",data);
<<<<<<< HEAD
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
=======
                String result = rh.sendPostRequest("http://ec2-13-209-35-109.ap-northeast-2.compute.amazonaws.com/upload.php",data);
>>>>>>> b7837f6... 마침표2

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }




    public void MainClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickedBackPopup(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, BackPopupActivity.class);
        intent.putExtra("data", "돌아가면 내용이 지워집니다. 그래도 돌아가시겠습니까?");
        startActivityForResult(intent, 1);

    }

    @Override
    public void onClick(View v)
    {
        if(v==RequestURL)
        {
            uploadImage();
        }
        else if(v==TimelineButton)
        {
            Intent intent = new Intent(this, TimeLine.class);
            startActivity(intent);
        }
    }

}