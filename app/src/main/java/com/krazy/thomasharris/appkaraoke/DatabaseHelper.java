package com.krazy.thomasharris.appkaraoke;

//Kiểm tra đã có database chưa
//Chưa -> Thêm vào
//fix2

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATASE_NAME= "SongDB.sqlite";
    public static final String TABLE_SONG = "ZSONG_ARIRANG";
    public static final String TABLE_CALIFORNIA = "ZSONG_CALIFORNIA";

    public static final String Z_PK = "Z_PK";
    public static final String Z_ENT = "Z_ENT";
    public static final String Z_OPT = "Z_OPT";
    public static final String ZROWID = "ZROWID";
    public static final String ZSVOL = "ZSVOL";
    public static final String ZSABBR = "ZSABBR";
    public static final String ZSLANGUAGE = "ZSLANGUAGE";
    public static final String ZSLYRIC = "ZSLYRIC";
    public static final String ZSLYRICCLEAN = "ZSLYRICCLEAN";
    public static final String ZSMANUFACTURE = "ZSMANUFACTURE";
    public static final String ZSMETA = "ZSMETA";
    public static final String ZSMETACLEAN = "ZSMETACLEAN";
    public static final String ZSNAME = "ZSNAME";
    public static final String ZSNAMECLEAN = "ZSNAMECLEAN";
    public static final String ZYOUTUBE = "ZYOUTUBE";


    Context context;
    String duongDanDatabase = "";
    //private MainActivity context;

    public DatabaseHelper(Context context) {
        super(context, DATASE_NAME, null, 1);
        this.context = context;
        duongDanDatabase = context.getFilesDir().getParent() + "/databases/" + DATASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public SQLiteDatabase openDatabase() {
        return SQLiteDatabase.openDatabase(duongDanDatabase, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void copyDatabase() {
        try {
            InputStream is = context.getAssets().open(DATASE_NAME);
            OutputStream os = new FileOutputStream(duongDanDatabase);
            byte[] buffer = new byte[1024];
            int lenght = 0;
            while ((lenght = is.read(buffer)) > 0) {
                os.write(buffer,0, lenght);
            }

            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createDatabase() {
        boolean kt = KiemTraDB();
        if (kt) {
            //Toast.makeText(context, "Đã có database", Toast.LENGTH_SHORT).show();
        } else {
            this.getWritableDatabase();
            copyDatabase();
            Toast.makeText(context, "Chưa có database. Đã thêm", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean KiemTraDB() {
        SQLiteDatabase kiemTraDB = null;
        try {
            kiemTraDB = SQLiteDatabase.openDatabase(duongDanDatabase, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (kiemTraDB != null) {
            kiemTraDB.close();
        }

        return kiemTraDB != null ? true : false;
    }
}
