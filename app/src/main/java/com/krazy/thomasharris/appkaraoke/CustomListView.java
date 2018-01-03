package com.krazy.thomasharris.appkaraoke;

//Hiển Thị danh sách bài hát tìm kiếm
//Tô màu khi tìm kiếm

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageView imgFavorite;
    }

    private int LayViTriBatDau(String chuoi, String chuoitimkiem) {
        int vitri = 0;
        vitri = chuoi.indexOf(chuoitimkiem);
        return vitri;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context,resource,null);
            holder.tvId         = convertView.findViewById(R.id.tvID);
            holder.tvTenBaiHat  = convertView.findViewById(R.id.tvTenBaiHat);
            holder.tvLoiBaiHat  = convertView.findViewById(R.id.tvLoi);
            holder.imgFavorite =convertView.findViewById(R.id.imgFav);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Song item = objects.get(position);
        holder.tvId.setText(item.getRowid().toString());
        holder.tvTenBaiHat.setText(item.getName().toString());
        holder.tvLoiBaiHat.setText(item.getLyric().toString());
        // if(item.getOpt().toStrinsg()=="1")
        // holder.imgFavorite.setImageResource(R.drawable.heart);
        //if(item.getOpt().toString())
        //fd
        String s = item.getOpt().toString();
        Log.d("giatri", s);

        if(item.getOpt().equals("0")) {

            holder.imgFavorite.setImageResource(R.drawable.icon_redheart);
        }
        if(item.getOpt().equals("1")) {

            holder.imgFavorite.setImageResource((R.drawable.icon_heart));
        }
        final String viTriUpDate= String.valueOf(position+1);
        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.getOpt().equals("1"))
                {

                    item.setOpt("0");
                    SQLDatabaseSource.CapNhat2(MainActivity._dau_karaoke, item.getPk(), "0");
                    holder.imgFavorite.setImageResource(R.drawable.icon_redheart);
                    Toast.makeText(getContext(), "Đã lưu bài hát "+ item.getName() + " vào danh sách ưa thích", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    item.setOpt("1");
                    SQLDatabaseSource.CapNhat2(MainActivity._dau_karaoke, item.getPk(), "1");
                    holder.imgFavorite.setImageResource(R.drawable.icon_heart);
                    Toast.makeText(getContext(), "Đã loại bài hát "+ item.getName() + " khỏi danh sách ưa thích", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        if (MainActivity.chuoiTimKiem != null) {
//            SpannableString textspan = new SpannableString(item.getNameclean());
//            int vitribatdau = LayViTriBatDau(item.getNameclean(), MainActivity.chuoiTimKiem);
//            int vitriketthuc = MainActivity.chuoiTimKiem.length();
//            textspan.setSpan(new BackgroundColorSpan(Color.WHITE), vitribatdau,vitribatdau + vitriketthuc, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE );
//            holder.tvTenBaiHat.setText(textspan);
//        } else {
//            holder.tvTenBaiHat.setText(item.getName());
//        }
        return convertView;
    }
}
