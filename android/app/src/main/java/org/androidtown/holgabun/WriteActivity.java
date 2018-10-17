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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    DbOpenHelper h;
    String sql_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        DbOpenHelper h=new DbOpenHelper(this);
        h.open();

        sql_id=h.returnId();

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

        edittext=(EditText)findViewById(R.id.write);
        image=(ImageView)findViewById(R.id.img_date2);
        RequestURL.setOnClickListener(this);




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
               loading = ProgressDialog.show(WriteActivity.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

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