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
            db.execSQL("CREATE TABLE Log (id Text PRIMARY KEY, password Text,onOff integer);");
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

    public int returnOnOff()d
    {
        Cursor cursor= mDB.rawQuery("select onoff from Log",null);

        while(cursor.moveToNext()){
                return cursor.getInt(0);
        }
        return -1;
    }

    public void automaticLogin()
    {
         mDB.execSQL("UPDATE Log set onOff=" + 1 + ";");
    }

    public void logOut()
    {
        mDB.execSQL("UPDATE Log set onOff=" + 0 + ";");
    }

    public String returnId() {
        Cursor cursor = mDB.rawQuery("select id from Log", null);

        while (cursor.moveToNext()) {
            return cursor.getString(0);
        }
        return "";
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
