package com.krazy.thomasharris.appkaraoke;

//Hàm main
//test
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SQLDatabaseSource db;
    List<Song> list;
    ListView lvHienThi;
    CustomListView adapter;
    String _dau_karaoke = "ZSONG_ARIRANG";

    public static String chuoiTimKiem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvHienThi = (ListView) findViewById(R.id.lvHienThi);
        list = new ArrayList<Song>();
        db = new SQLDatabaseSource(this);
        list = db.LayDanhSachBaiHat(_dau_karaoke);
        MenuTopBar();
        setAdapterListView(list);
    }

    public void MenuTopBar(){
        final ImageView imgda = (ImageView) findViewById(R.id.imgDatabase);
        imgda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogDatabase = new Dialog(MainActivity.this);
                dialogDatabase.setTitle("Chọn đầu karaoke");
                dialogDatabase.setCancelable(true);
                dialogDatabase.setContentView(R.layout.custom_dialog_database);
                TextView tvAriang = (TextView) dialogDatabase.findViewById(R.id.arirang);
                TextView tvMusicCore = (TextView) dialogDatabase.findViewById(R.id.musiccore);
                TextView tvCalifornia = (TextView) dialogDatabase.findViewById(R.id.california);
                TextView tvVietKTV = (TextView) dialogDatabase.findViewById(R.id.vietktv);

                tvAriang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_ARIRANG";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        dialogDatabase.cancel();
                    }
                });

                tvMusicCore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_MUSICCORE";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        dialogDatabase.cancel();
                    }
                });

                tvCalifornia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_CALIFORNIA";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        dialogDatabase.cancel();
                    }
                });

                tvVietKTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_VIETKTV";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        dialogDatabase.cancel();
                    }
                });

                dialogDatabase.show();
                setAdapterListView(list);

            }
        });

        ImageView imgVol = (ImageView) findViewById(R.id.imgVol);
        imgVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"vol",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imgAll = (ImageView) findViewById(R.id.imgAll);
        imgAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "all", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imgSearch = (ImageView) findViewById(R.id.imgSearch);
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapterListView(List<Song> list) {
        adapter = new CustomListView(this, R.layout.custom_layout_listview, list);
        lvHienThi.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView serachView = (SearchView) item.getActionView();
        serachView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    //Sự kiện: thay đổi trên khung tìm kiếm -> hiển thị bài hát cần tìm kiếm
    public boolean onQueryTextChange(String tenbaihat) {

//        list = db.LayDanhSachBaiHatTheoMa(tenbaihat.toLowerCase().toString());
        list = db.LayDanhSachBaiHatTheoMa(_dau_karaoke, tenbaihat);

        setAdapterListView(list);
        adapter.notifyDataSetChanged();
        chuoiTimKiem = tenbaihat;
        return true;
    }
}
