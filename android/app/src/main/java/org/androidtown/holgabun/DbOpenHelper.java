package org.androidtown.holgabun;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

/**
 * Created by jaery on 2018-05-04.
 */

public class DbOpenHelper {

    private static final String DATABASE_NAME = "Log.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        // 생성자
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE Log (id Text PRIMARY KEY, password Text,onOff INTEGER,idSave INTEGER);");
        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBase.CreateDB._TABLENAME);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public int returnOnOff()d
=======
=======
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon


    public void login(String id,String pwd)
    {

        try {
            mDB.execSQL("DELETE FROM Log;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
            mDB.execSQL("INSERT INTO Log VALUES('"+id+"','"+pwd+"',"+2+","+0+");");


    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9418ce1... Main Search 수정
    public int returnOnOff()
>>>>>>> dadf8b2... test
=======
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon

    public int returnIDSAVE(){
        try {
            Cursor cursor = mDB.rawQuery("select idSave from Log", null);

            while (cursor.moveToNext()) {

                return cursor.getInt(0);

            }
            return -1;
        }catch (NullPointerException e)
        {
            return -1;
        }
    }
    public int returnOnOff()
<<<<<<< HEAD
>>>>>>> 15adacd... feature/내부sql구현 메인이미지
    {
        try {
            Cursor cursor = mDB.rawQuery("select onoff from Log", null);
<<<<<<< HEAD

<<<<<<< HEAD
        while(cursor.moveToNext()){
<<<<<<< HEAD
                return cursor.getInt(0);
=======
            return cursor.getInt(0);
>>>>>>> dadf8b2... test
=======
            while (cursor.moveToNext()) {

                return cursor.getInt(0);
=======

            while (cursor.moveToNext()) {

                return cursor.getInt(0);
>>>>>>> ddd2025... 색변경
=======
    {
        try {
            Cursor cursor = mDB.rawQuery("select onoff from Log", null);

            while (cursor.moveToNext()) {

                return cursor.getInt(0);
>>>>>>> d7162a6... 0719 jiyoon

            }
            return -1;
        }catch (NullPointerException e)
        {
            return -1;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 15adacd... feature/내부sql구현 메인이미지
=======
>>>>>>> ddd2025... 색변경
=======
>>>>>>> d7162a6... 0719 jiyoon
        }
    }

    public void automaticLogin()
    {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
         mDB.execSQL("UPDATE Log set onOff=" + 1 + ";");
=======
        mDB.execSQL("UPDATE Log set onOff=" + 1 + ";");
>>>>>>> dadf8b2... test
=======

        mDB.execSQL("UPDATE Log set onOff=" + 1 + ";");

>>>>>>> ddd2025... 색변경
=======

        mDB.execSQL("UPDATE Log set onOff=" + 1 + ";");

>>>>>>> d7162a6... 0719 jiyoon
    }

    public void logOut()
    {
        mDB.execSQL("UPDATE Log set onOff=" + 0 + ";");
    }

    public void ID_Save(){
        mDB.execSQL("UPDATE Log set idSave="+1+";");
    }

    public void N_ID_Save(){
        mDB.execSQL("UPDATE Log set idSave="+0+";");
    }


    public String returnId() {

        try {
            Cursor cursor = mDB.rawQuery("select * from Log", null);

          while (cursor.moveToNext()) {
                return cursor.getString(0);
            }

            return "a";
        }catch(NullPointerException e){
            return "not";
        }
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        mDB.close();
    }

}
