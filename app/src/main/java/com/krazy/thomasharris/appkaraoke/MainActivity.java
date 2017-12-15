package com.krazy.thomasharris.appkaraoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
        setAdapterListView(list);
    }

    private void setAdapterListView(List<Song> list) {
        adapter = new CustomListView(this, R.layout.custom_layout_listview, list);
        lvHienThi.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
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
    public boolean onQueryTextChange(String s) {
        //list = db.LayDanhSachBaiHatTheoMa(s.toLowerCase().toString());
        list = db.LayDanhSachBaiHatTheoMa(s);
        setAdapterListView(list);
        adapter.notifyDataSetChanged();
        chuoiTimKiem = s;
        return true;
    }
}
