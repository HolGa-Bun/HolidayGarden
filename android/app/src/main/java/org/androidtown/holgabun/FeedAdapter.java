package org.androidtown.holgabun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FeedAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<FeedItem> FeedItemList = new ArrayList<FeedItem>() ;

    // ListViewAdapter의 생성자
    public FeedAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return FeedItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        GridItem holder;

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.feed, parent, false);


            holder=new GridItem();


            holder.feed_id = (TextView)convertView.findViewById(R.id.bolder_id);
            holder.feed_image = (ImageView)convertView.findViewById(R.id.bolder_img);
            holder.feed_text = (TextView)convertView.findViewById(R.id.bolder_text);
            holder.feed_time=(TextView)convertView.findViewById(R.id.bolder_time);


            convertView.setTag(holder);
        }
        else{
            holder=(GridItem)convertView.getTag();
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        FeedItem FeedItem = FeedItemList.get(position);


        // 아이템 내 각 위젯에 데이터 반영

        holder.feed_id.setText(FeedItem.getFeedId());
        holder.feed_image.setImageBitmap(FeedItem.getFeedImage());
        holder.feed_text.setText(FeedItem.getFeedText());
        holder.feed_time.setText(FeedItem.getFeedTime());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return FeedItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String feed_id,Bitmap feed_image, String feed_text,String boldernum,String feedtime){
        FeedItem ITEM=new FeedItem(feed_id,feed_image,feed_text,boldernum,feedtime);
        FeedItemList.add(ITEM);
    }



    static class GridItem{

        public TextView feed_id;
        public ImageView feed_image;
        public TextView feed_text;
        public TextView feed_time;

    }
}


