package org.androidtown.holgabun;

import android.graphics.Bitmap;

public class Garden {
    String name;
    Bitmap imgno;
    String address;


    public Garden (String name, Bitmap imgno, String address){
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

    public Bitmap getImgno(){
        return imgno;
    }

    public void setImgno(Bitmap imgno){
        this.imgno = imgno;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}