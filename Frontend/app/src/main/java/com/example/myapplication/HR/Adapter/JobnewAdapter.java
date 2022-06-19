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
    ArrayList<Jobnew> arrayJobToApplicant;
    private LayoutInflater mInflater;

    public JobnewAdapter(ArrayList<Jobnew> arrJobCreated, Context Applicant_Fragment_main ) {
        this.arrayJobToApplicant = arrJobCreated;
        this.mInflater = LayoutInflater.from(Applicant_Fragment_main);
    }

    @Override
    public int getCount() {
        return arrayJobToApplicant.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayJobToApplicant.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ImageView logoCompany;
        TextView nameCompany, nameJob, soluongCVapplied, salary, amount, styleJob, status ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JobnewAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new JobnewAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter,null);
            viewHolder.logoCompany = (ImageView) convertView.findViewById(R.id.logoCompany);
            viewHolder.nameCompany = (TextView) convertView.findViewById(R.id.tv_namecompany);
            viewHolder.nameJob = (TextView) convertView.findViewById(R.id.tv_namejob);
            viewHolder.soluongCVapplied = (TextView) convertView.findViewById(R.id.tv_amountCVapplied);
            viewHolder.salary = (TextView) convertView.findViewById(R.id.tv_salary);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.tv_soluongtuyendung);
            viewHolder.styleJob = (TextView) convertView.findViewById(R.id.tv_timework);
            viewHolder.status = (TextView) convertView.findViewById(R.id.trangthaiCV);

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
        viewHolder.soluongCVapplied.setText("Đã có "+ congviec.getAmountCVApplied() +"CV ứng tuyển");
        viewHolder.salary.setText("Lương: "+ congviec.getMinsalary() + " - " + congviec.getMaxsalary());
        viewHolder.amount.setText("Số lượng tuyển dụng: "+ congviec.getSoluongtuyendung());
        viewHolder.styleJob.setText("Loại hình cv: "+ congviec.getTenloaihinhcv());
        if (congviec.getTrangthai() == 0){
            viewHolder.styleJob.setText("Đã hết hạn");
        }
        if (congviec.getTrangthai() == 1){
            viewHolder.styleJob.setText("Còn hạn");
        }
        return convertView;
    }
}
