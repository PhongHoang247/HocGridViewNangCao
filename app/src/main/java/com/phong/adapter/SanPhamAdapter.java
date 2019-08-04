package com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.hocgridviewnangcao.R;
import com.phong.model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource,null);
        //Lấy thông tin ra:
        ImageView imgHinh = (ImageView) customView.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        //Lấy sản phẩm:
        SanPham sp = getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        return customView;
    }
}
