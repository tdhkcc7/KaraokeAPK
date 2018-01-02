package com.krazy.thomasharris.appkaraoke;

//Hàm main

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SQLDatabaseSource db;
    List<Song> list;
    ListView lvHienThi;
    CustomListView adapter;
    public static String chuoiTimKiem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvHienThi = (ListView) findViewById(R.id.lvHienThi);
        list = new ArrayList<Song>();
        db = new SQLDatabaseSource(this);
        list = db.LayDanhSachBaiHat();
        MenuTopBar();
        setAdapterListView(list);
    }

    public void MenuTopBar(){
        final ImageView imgda = (ImageView) findViewById(R.id.imgDatabase);
        imgda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Chọn đầu karaoke");
                



                AlertDialog alertDialog = builder.create();
                alertDialog.show();

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
        list = db.LayDanhSachBaiHatTheoMa(tenbaihat);

        setAdapterListView(list);
        adapter.notifyDataSetChanged();
        chuoiTimKiem = tenbaihat;
        return true;
    }
}
