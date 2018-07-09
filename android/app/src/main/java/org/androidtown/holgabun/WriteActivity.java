package org.androidtown.holgabun;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

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
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
            }
        }
    }

    /**
     * 사진의 URI 경로를 받는 메소드
     */
    public String getPath(Uri uri) {
        // uri가 null일경우 null반환
        if( uri == null ) {
            return null;
        }
        // 미디어스토어에서 유저가 선택한 사진의 URI를 받아온다.
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // URI경로를 반환한다.
        return uri.getPath();
    }

    public void onButtonFeed(View v) { //feed 페이지로 이동
        Intent intent = new Intent(this, FeedFragment.class);
        startActivity(intent);
    }

    public static class GridItem extends LinearLayout {

        TextView tv;
        ImageView iv;
        TextView tv2;

        public GridItem(Context context) {
            super(context);
            init(context);
        }

        public void init(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_grid_item, this);
            tv = (TextView) findViewById(R.id.tv1);
            tv2 = (TextView) findViewById(R.id.tv2);
            iv = (ImageView) findViewById(R.id.img1);
        }

        public void setData(Garden one) {
            tv.setText(one.getName());
            tv2.setText(one.getAddress());
            iv.setImageResource(one.getImgno());
        }
    }
    public void MainClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void TimeLineClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }
    public void onClickedBackPopup(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, BackPopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);

    }

}
