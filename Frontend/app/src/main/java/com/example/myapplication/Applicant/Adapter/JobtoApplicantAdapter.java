package com.example.myapplication.Applicant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.Job;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobtoApplicantAdapter extends BaseAdapter {

    ArrayList<Job> arrayJobToApplicant;
    private LayoutInflater mInflater;

    public JobtoApplicantAdapter(ArrayList<Job> arrayDanhmucnganhnghe, Context Applicant_Fragment_main ) {
        this.arrayJobToApplicant = arrayDanhmucnganhnghe;
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
        TextView nameCompany, nameJob, address, salary, amount, styleJob ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JobtoApplicantAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new JobtoApplicantAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.danhmucnganhnghe_adapter,null);
            viewHolder.logoCompany = (ImageView) convertView.findViewById(R.id.logoCompany);
            viewHolder.nameCompany = (TextView) convertView.findViewById(R.id.tv_namecompany);
            viewHolder.nameJob = (TextView) convertView.findViewById(R.id.tv_namejob);
            viewHolder.address = (TextView) convertView.findViewById(R.id.tv_addresscompany);
            viewHolder.salary = (TextView) convertView.findViewById(R.id.tv_salary);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.tv_soluongtuyendung);
            viewHolder.styleJob = (TextView) convertView.findViewById(R.id.tv_timework);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (JobtoApplicantAdapter.ViewHolder) convertView.getTag();
        }
        Job congviec = (Job) getItem(position);
        Picasso.get().load(congviec.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(viewHolder.logoCompany);
        viewHolder.nameCompany.setText(congviec.getTencty());
        viewHolder.nameJob.setText(congviec.getTenjob());
        viewHolder.address.setText(congviec.getDiachicty());
        viewHolder.salary.setText(congviec.getMinsalary() + " - " + congviec.getMaxsalary());
        viewHolder.amount.setText(congviec.getSoluongtuyendung());
        viewHolder.styleJob.setText(congviec.getTenloaihinhcv());
        return convertView;
    }
}
