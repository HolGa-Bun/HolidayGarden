package org.androidtown.holgabun;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter{
    Context context;
    ArrayList<Garden> garden = new ArrayList<>();

    public GridAdapter(Context context, ArrayList<Garden> garden){
        this.context = context;
        this.garden = garden;
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
        if(convertView == null)
            convertView = new GridItem(context);
        ((GridItem)convertView).setData(garden.get(position));
        return convertView;
    }
}