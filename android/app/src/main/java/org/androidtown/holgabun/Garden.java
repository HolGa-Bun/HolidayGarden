package org.androidtown.holgabun;

import org.androidtown.holgabun.R;

public class Garden {
    String name;
    int imgno;
    String address;
    final static int imalist[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    public Garden (String name, int imgno, String address){
        this.name=name;
        this.imgno = imgno;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getImgno(){
        return imgno;
    }

    public void setImgno(int imgno){
        this.imgno = imgno;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}