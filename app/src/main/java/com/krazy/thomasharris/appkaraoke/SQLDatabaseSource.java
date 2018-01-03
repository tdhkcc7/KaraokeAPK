package com.krazy.thomasharris.appkaraoke;

//Kết nối truy vấn cơ sở dữ liêu sqlite

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SQLDatabaseSource {
    public  static  SQLiteDatabase db;
    DatabaseHelper helper;
    //private MainActivity context;

    public SQLDatabaseSource(Context context) {
        helper = new DatabaseHelper(context);
        helper.createDatabase();
        db = helper.openDatabase();
    }

    public List<Song> LayDanhSachBaiHatTheoMa(String dau_karaoke, String tenbaihat) {
        List<Song> list = new ArrayList<Song>();

        //String[] column = {DatabaseHelper.SONG_ID, DatabaseHelper.SONG_NAME, DatabaseHelper.SONG_NAME2, DatabaseHelper.SONG_LYRIC};

        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };

        String truyvan = "Select * From "
                + dau_karaoke + " Where (("
                + DatabaseHelper.ZSNAMECLEAN + " LIKE '%" + tenbaihat.toLowerCase() + "%' )" + " or (" + DatabaseHelper.ZSABBR
                + " LIKE '%" + tenbaihat.toLowerCase() + "%' ))"
                + " Order by " + DatabaseHelper.ZSLANGUAGE + " desc," + DatabaseHelper.ZSNAME + " asc ";
        Cursor c = db.rawQuery(truyvan, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));

            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));

            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));


            list.add(item);
            c.moveToNext();
        }

        return list;
    }

    public List<Song> LayDanhSachBaiHat(String dau_karaoke) {
        List<Song> list = new ArrayList<Song>();

        //String[] column = {DatabaseHelper.SONG_ID, DatabaseHelper.SONG_NAME, DatabaseHelper.SONG_NAME2, DatabaseHelper.SONG_LYRIC};

        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };
//        Cursor c = db.query(DatabaseHelper.TABLE_SONG, column, null, null, null, null, DatabaseHelper.ZSLANGUAGE);

        String truyvan = "Select " + column[0] + ", " + column[1] + ", "
                + column[2] + ", " + column[3] + ", " + column[4] + ", "
                + column[5] + ", " + column[6]+ ", " + column[7] + ", "
                + column[8] + ", " + column[9]+ ", " + column[10] + ", "
                + column[11] + ", " + column[12]+ ", " + column[13] + ", "
                + column[14] +  " From " + dau_karaoke
                + " Order by " + DatabaseHelper.ZSLANGUAGE + " desc," + DatabaseHelper.ZSNAME + " asc";
        Cursor c = db.rawQuery(truyvan, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));

            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));

            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));

            list.add(item);
            c.moveToNext();

        }
        // Toast.makeText(, "Đã có database", Toast.LENGTH_SHORT).show();
        //Log.d("KetQua", list.get(0).getLyric().toString());
        return list;
    }

    public List<Song> LayDanhSachBaiHatTheoVol(String dau_karaoke, String vol) {
        List<Song> list = new ArrayList<Song>();
        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };
        String truyvan = "Select " + column[0] + ", " + column[1] + ", "
                + column[2] + ", " + column[3] + ", " + column[4] + ", "
                + column[5] + ", " + column[6]+ ", " + column[7] + ", "
                + column[8] + ", " + column[9]+ ", " + column[10] + ", "
                + column[11] + ", " + column[12]+ ", " + column[13] + ", "
                + column[14] +  " From " + dau_karaoke + " Where ZSVOL = " + vol
                + " Order by " + DatabaseHelper.ZSLANGUAGE + " desc," + DatabaseHelper.ZSNAME + " asc";
        Cursor c = db.rawQuery(truyvan, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));
            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));
            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));
            list.add(item);
            c.moveToNext();
        }
        return list;
    }
    public List<Song> LayDanhSachBaiHatTheoChuCai(String dau_karaoke, String chuCai)
    {
        List<Song> list = new ArrayList<Song>();
        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };
        String truyvan = "Select " + column[0] + ", " + column[1] + ", "
                + column[2] + ", " + column[3] + ", " + column[4] + ", "
                + column[5] + ", " + column[6]+ ", " + column[7] + ", "
                + column[8] + ", " + column[9]+ ", " + column[10] + ", "
                + column[11] + ", " + column[12]+ ", " + column[13] + ", "
                + column[14] +  " From " + dau_karaoke + " Where "
                + DatabaseHelper.ZSNAMECLEAN + " LIKE '" + chuCai.toLowerCase() + "%' "

                + " Order by " + DatabaseHelper.ZSLANGUAGE + " desc," + DatabaseHelper.ZSNAME + " asc";
        Cursor c = db.rawQuery(truyvan, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));
            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));
            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));
            list.add(item);
            c.moveToNext();
        }
        return list;
    }

    public List<Song> LayDanhSachBaiHatUaThich(String dau_karaoke)
    {
        List<Song> list = new ArrayList<Song>();
        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };
        String truyvan = "Select " + column[0] + ", " + column[1] + ", "
                + column[2] + ", " + column[3] + ", " + column[4] + ", "
                + column[5] + ", " + column[6]+ ", " + column[7] + ", "
                + column[8] + ", " + column[9]+ ", " + column[10] + ", "
                + column[11] + ", " + column[12]+ ", " + column[13] + ", "
                + column[14] +  " From "
                + dau_karaoke + " Where "
                + DatabaseHelper.Z_OPT + " LIKE '0' ";
        // +  " Order by " + DatabaseHelper.ZSLANGUAGE + " desc," + DatabaseHelper.ZSNAME + " asc";
        Cursor c = db.rawQuery(truyvan, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));

            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));

            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));


            list.add(item);
            c.moveToNext();
        }


        return list;
    }

    public List<Song> LayDanhSachBaiHatTheoNgonNgu(String dau_karaoke, String language) {
        List<Song> list = new ArrayList<Song>();
        String[] column = {DatabaseHelper.Z_PK, DatabaseHelper.Z_ENT, DatabaseHelper.Z_OPT,
                DatabaseHelper.ZROWID, DatabaseHelper.ZSVOL, DatabaseHelper.ZSABBR,
                DatabaseHelper.ZSLANGUAGE, DatabaseHelper.ZSLYRIC, DatabaseHelper.ZSLYRICCLEAN,
                DatabaseHelper.ZSMANUFACTURE, DatabaseHelper.ZSMETA, DatabaseHelper.ZSMETACLEAN,
                DatabaseHelper.ZSNAME, DatabaseHelper.ZSNAMECLEAN, DatabaseHelper.ZYOUTUBE };
        String truyvan = "Select " + column[0] + ", " + column[1] + ", "
                + column[2] + ", " + column[3] + ", " + column[4] + ", "
                + column[5] + ", " + column[6]+ ", " + column[7] + ", "
                + column[8] + ", " + column[9]+ ", " + column[10] + ", "
                + column[11] + ", " + column[12]+ ", " + column[13] + ", "
                + column[14] +  " From " + dau_karaoke + " Where ZSLANGUAGE = '" + language +"' "
                + " Order by " + DatabaseHelper.ZSNAME + " asc";
        Cursor c = db.rawQuery(truyvan, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song item = new Song();
            item.setPk(c.getString(0));
            item.setEnt((c.getString(1)));
            item.setOpt(c.getString(2));
            item.setRowid(c.getString(3));
            item.setVol(c.getString(4));
            item.setAbbr((c.getString(5)));
            item.setLanguage(c.getString(6));
            item.setLyric(c.getString(7));
            item.setLyricclean(c.getString(8));
            item.setManufacture((c.getString(9)));
            item.setMeta(c.getString(10));
            item.setMetaclean(c.getString(11));
            item.setName(c.getString(12));
            item.setNameclean((c.getString(13)));
            item.setYoutube(c.getString(14));
            list.add(item);
            c.moveToNext();
        }
        return list;
    }
    public static void  CapNhat2(String dau_karaoke,  String Primary, String state)
    {
        ContentValues cv=new ContentValues();
        cv.put(DatabaseHelper.Z_OPT, state);
        db.update(dau_karaoke, cv, DatabaseHelper.Z_PK + " = " +Primary, null);
    }
}

