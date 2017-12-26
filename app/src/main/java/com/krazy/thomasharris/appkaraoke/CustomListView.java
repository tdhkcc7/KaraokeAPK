package com.krazy.thomasharris.appkaraoke;

//Hiển Thị danh sách bài hát tìm kiếm
//Tô màu khi tìm kiếm

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListView extends ArrayAdapter<Song> {

    Context context;
    int resource;
    List<Song> objects;

    public CustomListView(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    private class ViewHolder {
        TextView tvId, tvTenBaiHat, tvLoiBaiHat;
    }

    private int LayViTriBatDau(String chuoi, String chuoitimkiem) {
        int vitri = 0;
        vitri = chuoi.indexOf(chuoitimkiem);
        return vitri;
    }

        @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context,resource,null);
            holder.tvId         = convertView.findViewById(R.id.tvID);
            holder.tvTenBaiHat  = convertView.findViewById(R.id.tvTenBaiHat);
            holder.tvLoiBaiHat  = convertView.findViewById(R.id.tvLoi);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song item = objects.get(position);
        holder.tvId.setText(item.getRowid().toString());
        holder.tvTenBaiHat.setText(item.getName().toString());
        holder.tvLoiBaiHat.setText(item.getLyric().toString());

        if (MainActivity.chuoiTimKiem != null) {
            SpannableString textspan = new SpannableString(item.getNameclean());
            int vitribatdau = LayViTriBatDau(item.getNameclean(), MainActivity.chuoiTimKiem);
            int vitriketthuc = MainActivity.chuoiTimKiem.length();
            textspan.setSpan(new BackgroundColorSpan(Color.WHITE), vitribatdau,vitribatdau + vitriketthuc, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE );
            holder.tvTenBaiHat.setText(textspan);
        } else {
            holder.tvTenBaiHat.setText(item.getName());
        }
          return convertView;
    }
}
