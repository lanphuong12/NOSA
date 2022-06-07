package com.example.myapplication.Applicant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;

public class NganhngheAdapter extends BaseAdapter {

    ArrayList<Nganhnghe> arrayNganhnghe;
    Context context;

    public NganhngheAdapter(ArrayList<Nganhnghe> arrayNganhnghe, Context context) {
        this.arrayNganhnghe = arrayNganhnghe;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayNganhnghe.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayNganhnghe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tennganhnghe ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NganhngheAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new NganhngheAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.danhmucnganhnghe_adapter,null);
            viewHolder.tennganhnghe = (CheckBox) convertView.findViewById(R.id.checkbox_nganhnghe);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (NganhngheAdapter.ViewHolder) convertView.getTag();
        }
        Nganhnghe sach = (Nganhnghe) getItem(position);
        viewHolder.tennganhnghe.setText(sach.getTennganh());
        return convertView;
    }
}
