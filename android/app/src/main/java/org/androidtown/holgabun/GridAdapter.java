package org.androidtown.holgabun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter{
    Context context;
    ArrayList<Garden> garden = new ArrayList<>();
    private LayoutInflater mInflater;

    public GridAdapter(Context context, ArrayList<Garden> garden){
        this.context = context;
        this.garden = garden;
        this.mInflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){return garden.size();}

    @Override
    public Object getItem(int position) {
        return garden.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridItem holder;
        if(convertView == null) {

            convertView = mInflater.inflate(R.layout.activity_grid_item,parent,false);

            holder=new GridItem();

            holder.tv = (TextView)convertView.findViewById(R.id.tv1);
            holder.tv2 = (TextView)convertView.findViewById(R.id.tv2);
            holder.iv = (ImageView)convertView.findViewById(R.id.img1);

            convertView.setTag(holder);
        }
        else{
            holder=(GridItem)convertView.getTag();
        }

        
        holder.tv.setText(garden.get(position).getName());
        holder.tv2.setText(garden.get(position).getAddress());
        holder.iv.setImageResource(garden.get(position).getImgno());

        return convertView;
    }
    static class GridItem{
        public TextView tv;
        public ImageView iv;
        public TextView tv2;
    }
}