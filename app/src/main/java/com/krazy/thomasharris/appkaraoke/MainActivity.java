package com.krazy.thomasharris.appkaraoke;

//Hàm maindsdfdsf
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public static SQLDatabaseSource db;
    public static List<Song> list;
    public static ListView lvHienThi;
    public static CustomListView adapter;
    public static String _dau_karaoke = "ZSONG_ARIRANG";
    public static String _vol = "vol60";
    public static String chuCai="A";
    public static String _casi="ly hai";

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
        MenuBottomBar();
        setAdapterListView(list);
    }

    public void MenuBottomBar() {
        final Button btnList = (Button) findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialogDanhMuc = new Dialog(MainActivity.this);
                dialogDanhMuc.setTitle("Danh mục");
                dialogDanhMuc.setCancelable(true);
                dialogDanhMuc.setContentView(R.layout.layout_danh_muc);
                TextView tvCaSi = (TextView) dialogDanhMuc.findViewById(R.id.danhuc_casi);
                TextView tvTacGia = (TextView) dialogDanhMuc.findViewById(R.id.danhmuc_tacgia);
                TextView tvTrangChu = (TextView) dialogDanhMuc.findViewById(R.id.danhmuc);

                tvTrangChu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });

                tvCaSi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogDanhMuc.setTitle("Danh mục ca sĩ");
                        dialogDanhMuc.setCancelable(true);
                        dialogDanhMuc.setContentView(R.layout.layout_casi);

                        final TextView tv_lyhai = (TextView) dialogDanhMuc.findViewById(R.id.cs_lyhai);
                        TextView tv_hoquanghieu = (TextView) dialogDanhMuc.findViewById(R.id.cs_hoquanghieu);
                        TextView tv_duymanh = (TextView) dialogDanhMuc.findViewById(R.id.cs_duymanh);
                        TextView tv_damvinhhung = (TextView) dialogDanhMuc.findViewById(R.id.cs_damvinhhung);
                        TextView tv_hongocha = (TextView) dialogDanhMuc.findViewById(R.id.cs_hongocha);
                        TextView tv_camly = (TextView) dialogDanhMuc.findViewById(R.id.cs_camly);
                        TextView tv_dantruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_dantruong);
                        TextView tv_bangkieu = (TextView) dialogDanhMuc.findViewById(R.id.cs_bangkieu);
                        TextView tv_bangcuong = (TextView) dialogDanhMuc.findViewById(R.id.cs_bangcuong);
                        TextView tv_hkt = (TextView) dialogDanhMuc.findViewById(R.id.cs_luongbangquang);
                        TextView tv_lamtruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_lamtruong);
                        TextView tv_phamtruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_phamtruong);
                        TextView tv_khanhdon = (TextView) dialogDanhMuc.findViewById(R.id.cs_khanhdon);
                        TextView tv_trantien = (TextView) dialogDanhMuc.findViewById(R.id.cs_trantien);
                        TextView tv_chidan = (TextView) dialogDanhMuc.findViewById(R.id.cs_chidan);
                        TextView tv_trinhthangbinh = (TextView) dialogDanhMuc.findViewById(R.id.cs_trinhthangbinh);

                        tv_lyhai.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "ly hai";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hoquanghieu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "yuki huy nam";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_duymanh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "duy manh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_damvinhhung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "dam vinh hung";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hongocha.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "ho ngoc ha";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_camly.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bao chinh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_dantruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "dan truong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_bangkieu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bang kieu";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_bangcuong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bang cuong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hkt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "luong bang quang";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_lamtruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "lam truong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_phamtruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "pham truong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_khanhdon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "khanh don";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_trantien.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "tran tien";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_chidan.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "chi dan";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_trinhthangbinh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "trinh thang binh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        dialogDanhMuc.show();
                    }
                });

                tvTacGia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogDanhMuc.setTitle("Danh mục Nhạc sĩ");
                        dialogDanhMuc.setCancelable(true);
                        dialogDanhMuc.setContentView(R.layout.layout_tacgia);

                        final TextView tv_lyhai = (TextView) dialogDanhMuc.findViewById(R.id.cs_lyhai);
                        TextView tv_hoquanghieu = (TextView) dialogDanhMuc.findViewById(R.id.cs_hoquanghieu);
                        TextView tv_duymanh = (TextView) dialogDanhMuc.findViewById(R.id.cs_duymanh);
                        TextView tv_damvinhhung = (TextView) dialogDanhMuc.findViewById(R.id.cs_damvinhhung);
                        TextView tv_hongocha = (TextView) dialogDanhMuc.findViewById(R.id.cs_hongocha);
                        TextView tv_camly = (TextView) dialogDanhMuc.findViewById(R.id.cs_camly);
                        TextView tv_dantruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_dantruong);
                        TextView tv_bangkieu = (TextView) dialogDanhMuc.findViewById(R.id.cs_bangkieu);
                        TextView tv_bangcuong = (TextView) dialogDanhMuc.findViewById(R.id.cs_bangcuong);
                        TextView tv_hkt = (TextView) dialogDanhMuc.findViewById(R.id.cs_luongbangquang);
                        TextView tv_lamtruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_lamtruong);
                        TextView tv_phamtruong = (TextView) dialogDanhMuc.findViewById(R.id.cs_phamtruong);
                        TextView tv_khanhdon = (TextView) dialogDanhMuc.findViewById(R.id.cs_khanhdon);
                        TextView tv_trantien = (TextView) dialogDanhMuc.findViewById(R.id.cs_trantien);
                        TextView tv_chidan = (TextView) dialogDanhMuc.findViewById(R.id.cs_chidan);
                        TextView tv_trinhthangbinh = (TextView) dialogDanhMuc.findViewById(R.id.cs_trinhthangbinh);

                        tv_lyhai.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "ly hai";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hoquanghieu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "yuki huy nam";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_duymanh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "duy manh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_damvinhhung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "dam vinh hung";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hongocha.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "ho ngoc ha";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_camly.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bao chinh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_dantruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "sy luan";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_bangkieu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bang kieu";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_bangcuong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "bang cuong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_hkt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "luong bang quang";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_lamtruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "lam truong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_phamtruong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "pham truong";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_khanhdon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "khanh don";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_trantien.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "tran tien";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_chidan.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "chi dan";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        tv_trinhthangbinh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                _casi = "trinh thang binh";
                                list = db.LayDanhSachBaiHatTheoCaSi(_dau_karaoke, _casi);
                                setAdapterListView(list);
                                dialogDanhMuc.cancel();
                            }
                        });

                        dialogDanhMuc.show();
                    }
                });

                dialogDanhMuc.show();
            }
        });

        final Button btnRecord = (Button) findViewById(R.id.btnRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });

        final Button btnfavorite = (Button) findViewById(R.id.btnFavorite);
        btnfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = db.LayDanhSachBaiHatUaThich(_dau_karaoke);
                adapter.notifyDataSetChanged();
                setAdapterListView(list);
            }
        });
    }

    public void MenuTopBar(){
        final Button btnData = (Button) findViewById(R.id.btnDatabase);
        btnData.setOnClickListener(new View.OnClickListener() {
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
                        btnData.setText("Arirang");
                        setAdapterListView(list);
                        dialogDatabase.cancel();
                    }
                });

                tvMusicCore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_MUSICCORE";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        btnData.setText("Music Core");
                        setAdapterListView(list);
                        dialogDatabase.cancel();
                    }
                });

                tvCalifornia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_CALIFORNIA";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        btnData.setText("California");
                        setAdapterListView(list);
                        dialogDatabase.cancel();
                    }
                });

                tvVietKTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _dau_karaoke = "ZSONG_VIETKTV";
                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        btnData.setText("VietKTV");
                        setAdapterListView(list);
                        dialogDatabase.cancel();
                    }
                });

                dialogDatabase.show();
            }
        });

        final Button btnVol = (Button) findViewById(R.id.btnVol);
        btnVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogVol = new Dialog(MainActivity.this);
                dialogVol.setTitle("Chọn đầu karaoke");
                dialogVol.setCancelable(true);
                dialogVol.setContentView(R.layout.custom_dialog_vol);
                TextView tvVol60 = (TextView)    dialogVol.findViewById(R.id.vol60);
                TextView tvVol59 = (TextView)    dialogVol.findViewById(R.id.vol59);
                TextView tvVol58 = (TextView)    dialogVol.findViewById(R.id.vol58);
                TextView tvVol57 = (TextView)    dialogVol.findViewById(R.id.vol57);
                TextView tvVol56 = (TextView)    dialogVol.findViewById(R.id.vol56);
                TextView tvVol55 = (TextView)    dialogVol.findViewById(R.id.vol55);
                TextView tvVol54 = (TextView)    dialogVol.findViewById(R.id.vol54);
                TextView tvVol53 = (TextView)    dialogVol.findViewById(R.id.vol53);
                TextView tvVol52 = (TextView)    dialogVol.findViewById(R.id.vol52);
                TextView tvVol51 = (TextView)    dialogVol.findViewById(R.id.vol51);
                TextView tvVol50 = (TextView)    dialogVol.findViewById(R.id.vol50);
                TextView tvNhacAnh = (TextView)  dialogVol.findViewById(R.id.nhacanh);
                TextView tvNhacViet = (TextView) dialogVol.findViewById(R.id.nhacviet);

                tvVol60.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "58";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 60");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol59.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "57";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 59");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol58.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "56";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 58");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });
                tvVol57.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "55";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 57");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol56.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "54";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 56");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol55.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "53";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 55");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol54.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "52";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 54");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol53.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "51";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 53");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });
                tvVol52.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "50";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 53");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol51.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "49";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 52");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvVol50.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "48";
                        list = db.LayDanhSachBaiHatTheoVol(_dau_karaoke, _vol);
                        btnVol.setText("Vol 51");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvNhacAnh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "en";
                        list = db.LayDanhSachBaiHatTheoNgonNgu(_dau_karaoke, _vol);
                        btnVol.setText("Nhạc Anh");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });

                tvNhacViet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _vol = "vn";
                        list = db.LayDanhSachBaiHatTheoNgonNgu(_dau_karaoke, _vol);
                        btnVol.setText("Nhạc Việt");
                        setAdapterListView(list);
                        dialogVol.cancel();
                    }
                });
                dialogVol.show();
            }
        });

        final Button btnAll = (Button) findViewById(R.id.btnChuCai);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialogChuCai = new Dialog(MainActivity.this);
                dialogChuCai.setTitle("Chọn chữ cái");
                dialogChuCai.setCancelable(true);
                dialogChuCai.setContentView(R.layout.layout_chu_cai);
                TextView tvA = (TextView) dialogChuCai.findViewById(R.id.volA);
                final TextView tvB = (TextView) dialogChuCai.findViewById(R.id.volB);
                final TextView tvC = (TextView) dialogChuCai.findViewById(R.id.volC);
                TextView tvD = (TextView) dialogChuCai.findViewById(R.id.D);
                TextView tvE = (TextView) dialogChuCai.findViewById(R.id.E);
                TextView tvF = (TextView) dialogChuCai.findViewById(R.id.F);
                TextView tvG = (TextView) dialogChuCai.findViewById(R.id.G);
                TextView tvH = (TextView) dialogChuCai.findViewById(R.id.H);
                TextView tvI = (TextView) dialogChuCai.findViewById(R.id.I);
                TextView tvJ = (TextView) dialogChuCai.findViewById(R.id.J);
                TextView tvK = (TextView) dialogChuCai.findViewById(R.id.K);
                TextView tvL = (TextView) dialogChuCai.findViewById(R.id.L);
                TextView tvM = (TextView) dialogChuCai.findViewById(R.id.M);
                TextView tvN = (TextView) dialogChuCai.findViewById(R.id.N);
                TextView tvO = (TextView) dialogChuCai.findViewById(R.id.O);
                TextView tvP = (TextView) dialogChuCai.findViewById(R.id.P);
                TextView tvQ = (TextView) dialogChuCai.findViewById(R.id.Q);
                TextView tvR = (TextView) dialogChuCai.findViewById(R.id.R);
                TextView tvS = (TextView) dialogChuCai.findViewById(R.id.S);
                TextView tvT = (TextView) dialogChuCai.findViewById(R.id.T);
                TextView tvU = (TextView) dialogChuCai.findViewById(R.id.U);
                TextView tvV = (TextView) dialogChuCai.findViewById(R.id.V);
                TextView tvW = (TextView) dialogChuCai.findViewById(R.id.W);
                TextView tvX = (TextView) dialogChuCai.findViewById(R.id.X);
                TextView tvY = (TextView) dialogChuCai.findViewById(R.id.Y);
                TextView tvZ = (TextView) dialogChuCai.findViewById(R.id.Z);
                TextView tvAll=(TextView) dialogChuCai.findViewById(R.id.AllChuCai);
                tvAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="A";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText("A");
                        setAdapterListView(list);
                        dialogChuCai.cancel();
                    }
                });
                tvA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        list = db.LayDanhSachBaiHat(_dau_karaoke);
                        btnAll.setText("Tat ca chu cai");
                        setAdapterListView(list);
                        dialogChuCai.cancel();
                    }
                });
                tvB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="B";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="C";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="D";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="E";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="F";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvG.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="G";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvH.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="H";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvI.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="I";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvJ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="J";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="K";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="L";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="M";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="N";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="O";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="P";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvQ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="Q";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="R";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="S";;
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="T";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvU.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="U";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="V";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvW.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="W";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvX.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="X";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="Y";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });
                tvZ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chuCai="Z";
                        list = db.LayDanhSachBaiHatTheoChuCai(_dau_karaoke, chuCai);
                        btnAll.setText(chuCai);
                        setAdapterListView(list);
                        dialogChuCai.cancel();

                    }
                });

                dialogChuCai.show();

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
