package org.androidtown.holgabun;

<<<<<<< HEAD
import org.androidtown.holgabun.R;
=======
import android.graphics.Bitmap;
>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현

public class Garden {
    String name;
    Bitmap imgno;
    String address;
<<<<<<< HEAD
    final static int imalist[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
=======
>>>>>>> 9837d2f... [7/13]feature/가든 상세정보창 구현


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