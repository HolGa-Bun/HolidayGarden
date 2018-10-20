package org.androidtown.holgabun;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> ddd2025... 색변경
        import android.provider.BaseColumns;
=======
import android.provider.BaseColumns;
>>>>>>> dadf8b2... test
=======

        import android.provider.BaseColumns;
>>>>>>> d7162a6... 0719 jiyoon
=======

        import android.provider.BaseColumns;
>>>>>>> d1dfbf9238f85c1096f89daad4c6cefac028047a


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