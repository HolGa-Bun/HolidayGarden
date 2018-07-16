package org.androidtown.holgabun;

<<<<<<< HEAD
        import android.provider.BaseColumns;
=======
import android.provider.BaseColumns;
>>>>>>> dadf8b2... test

public final class DataBase {

    public static final class CreateDB implements BaseColumns{
        public static final String _TABLENAME = "Log";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +"id"+" Text primary key, "
                        +"password"+" Text"
                        +"onoff"+"integer"
                        +");";
    }
}