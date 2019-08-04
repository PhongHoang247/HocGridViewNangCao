package com.phong.hocgridviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.adapter.SanPhamAdapter;
import com.phong.model.SanPham;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    GridView gvSanPham;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        gvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy sản phẩm ra:
                SanPham sp = sanPhamAdapter.getItem(i);
                //Hiển thị chi tiết:
                HienThiChiTiet(sp);
            }
        });
    }

    private void HienThiChiTiet(SanPham sp) {
        //Thay thế màn hình hiện tại GridView thành màn hình SoloItem:
        setContentView(R.layout.soloitem);
        TextView txtTen = (TextView) findViewById(R.id.txtTen);
        ImageView imgHinh = (ImageView) findViewById(R.id.imgHinh);
        final Button btnBack = (Button) findViewById(R.id.btnBack);
        //Show lên:
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                addControls();
                addEvents();
            }
        });
    }

    private void addControls() {
        gvSanPham = findViewById(R.id.gvHinh);
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);
        gvSanPham.setAdapter(sanPhamAdapter);
        sanPhamAdapter.add(new SanPham(R.drawable.h1,"Mega man 1"));
        sanPhamAdapter.add(new SanPham(R.drawable.h2,"Mega man 2"));
        sanPhamAdapter.add(new SanPham(R.drawable.h3,"Mega man 3"));
        sanPhamAdapter.add(new SanPham(R.drawable.h4,"Mega man 4"));
        sanPhamAdapter.add(new SanPham(R.drawable.h5,"Mega man 5"));
        sanPhamAdapter.add(new SanPham(R.drawable.h6,"Mega man 6"));
        sanPhamAdapter.add(new SanPham(R.drawable.h7,"Mega man 7"));
        sanPhamAdapter.add(new SanPham(R.drawable.h8,"Mega man 8"));
        sanPhamAdapter.add(new SanPham(R.drawable.h9,"Mega man 9"));
        sanPhamAdapter.add(new SanPham(R.drawable.h10,"Mega man 10"));

    }
}
