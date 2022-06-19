package com.example.myapplication.HR.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobnewAdapter extends BaseAdapter {
    ArrayList<Jobnew> arrayJobCreated;
    private LayoutInflater mInflater;

    public JobnewAdapter(ArrayList<Jobnew> arrJobCreated, Context fragment ) {
        this.arrayJobCreated = arrJobCreated;
        this.mInflater = LayoutInflater.from(fragment);
    }

    @Override
    public int getCount() {
        return arrayJobCreated.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayJobCreated.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ImageView logoCompany;
        TextView nameCompany, nameJob, soluongCVapplied, salary, amount, styleJob, status, dateexpery ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JobnewAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new JobnewAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter,null);
            viewHolder.logoCompany = (ImageView) convertView.findViewById(R.id.imgv_logocompany);
            viewHolder.nameCompany = (TextView) convertView.findViewById(R.id.tv_namecompany);
            viewHolder.nameJob = (TextView) convertView.findViewById(R.id.tv_namejob);
            viewHolder.soluongCVapplied = (TextView) convertView.findViewById(R.id.tv_amountCVapplied);
            viewHolder.salary = (TextView) convertView.findViewById(R.id.tv_salary);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.tv_soluongtuyendung);
            viewHolder.styleJob = (TextView) convertView.findViewById(R.id.tv_timework);
            viewHolder.status = (TextView) convertView.findViewById(R.id.trangthaiCV);
            viewHolder.dateexpery = (TextView) convertView.findViewById(R.id.tv_experidate);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (JobnewAdapter.ViewHolder) convertView.getTag();
        }
        Jobnew congviec = (Jobnew) getItem(position);
        Picasso.get().load(congviec.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(viewHolder.logoCompany);
        viewHolder.nameCompany.setText(congviec.getTencty());
        viewHolder.nameJob.setText(congviec.getTenjob());
        viewHolder.soluongCVapplied.setText("Đã có "+ congviec.getAmountCVApplied() +" CV ứng tuyển");
        viewHolder.salary.setText("Lương: "+ congviec.getMinsalary() + " - " + congviec.getMaxsalary());
        viewHolder.amount.setText("Số lượng tuyển dụng: "+ congviec.getSoluongtuyendung());
        viewHolder.styleJob.setText("Loại hình cv: "+ congviec.getTenloaihinhcv());
        viewHolder.styleJob.setText("Loại hình cv: "+ congviec.getTenloaihinhcv());
        viewHolder.dateexpery.setText("Ngày hết hạn: "+ congviec.getNgayhethan());
        if (congviec.getTrangthai() == 0){
            viewHolder.status.setText("Đã hết hạn");
        }
        if (congviec.getTrangthai() == 1){
            viewHolder.status.setText("Còn hạn");
        }
        return convertView;
    }
}
