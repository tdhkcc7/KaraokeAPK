package com.krazy.thomasharris.appkaraoke;

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

/**
 * Created by Thomas Harris on 10/27/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATASE_NAME= "SongDB.sqlite";
    public static final String TABLE_SONG = "song";

    public static final String SONG_ID = "_id";
    public static final String SONG_NAME = "song_name";
    public static final String SONG_NAME2 = "song_name2";
    public static final String SONG_LYRIC = "song_lyric";
    public static final String SONG_LYRIC2 = "song_lyric2";
    public static final String SONG_ARTIST = "song_artist";
    public static final String SONG_ARTIST2 = "song_artist2";

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
            Log.d("KetNoi", "Đã có database");
            Toast.makeText(context, "Đã có database", Toast.LENGTH_SHORT).show();
        } else {
            this.getWritableDatabase();
            copyDatabase();
            Toast.makeText(context, "Chưa có database. Đã thêm", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean KiemTraDB() {
        SQLiteDatabase kiemTraDB = null;
//        boolean kiemtraketnoi = false;
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
