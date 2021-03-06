package com.example.myapplication.Applicant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;

public class DanhmucnganhngheAdapter extends BaseAdapter {

    ArrayList<Danhmucnganhnghe> arrayDanhmucnganhnghe;
    Context context;

    public DanhmucnganhngheAdapter(ArrayList<Danhmucnganhnghe> arrayDanhmucnganhnghe, Context context) {
        this.arrayDanhmucnganhnghe = arrayDanhmucnganhnghe;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayDanhmucnganhnghe.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayDanhmucnganhnghe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tendanhmuc ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.danhmucnganhnghe_adapter,null);
            viewHolder.tendanhmuc = (TextView) convertView.findViewById(R.id.tv_danhmucnganhnghe);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Danhmucnganhnghe sach = (Danhmucnganhnghe) getItem(position);
        viewHolder.tendanhmuc.setText(sach.getTendanhmuc());
        return convertView;
    }
}
