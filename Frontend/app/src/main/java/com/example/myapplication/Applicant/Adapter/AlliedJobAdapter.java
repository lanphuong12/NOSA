package com.example.myapplication.Applicant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Job;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlliedJobAdapter extends BaseAdapter {

    ArrayList<AppliedJob> arrayAppliedJob;
    private LayoutInflater mInflater;

    public AlliedJobAdapter(ArrayList<AppliedJob> arrayAppliedJob, Context Applicant_Fragment_main ) {
        this.arrayAppliedJob = arrayAppliedJob;
        this.mInflater = LayoutInflater.from(Applicant_Fragment_main);
    }

    @Override
    public int getCount() {
        return arrayAppliedJob.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayAppliedJob.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ImageView logoCompany;
        TextView nameCompany, nameJob, address, salary, date, status ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlliedJobAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new AlliedJobAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.jobapplied_adapter,null);
            viewHolder.logoCompany = (ImageView) convertView.findViewById(R.id.imgv_logocompany);
            viewHolder.nameCompany = (TextView) convertView.findViewById(R.id.tv_namecompany);
            viewHolder.nameJob = (TextView) convertView.findViewById(R.id.tv_namejob);
            viewHolder.address = (TextView) convertView.findViewById(R.id.tv_addresscompany);
            viewHolder.salary = (TextView) convertView.findViewById(R.id.tv_salary);
            viewHolder.date = (TextView) convertView.findViewById(R.id.tv_datesentCV);
            viewHolder.status = (TextView) convertView.findViewById(R.id.trangthaiCV);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (AlliedJobAdapter.ViewHolder) convertView.getTag();
        }
        AppliedJob congviec = (AppliedJob) getItem(position);
        Picasso.get().load(congviec.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(viewHolder.logoCompany);
        viewHolder.nameCompany.setText(congviec.getTencty());
        viewHolder.nameJob.setText(congviec.getTenjob());
        viewHolder.address.setText(congviec.getDiachicty());
        viewHolder.salary.setText(congviec.getMinsalary() + " - " + congviec.getMaxsalary());
        viewHolder.date.setText(congviec.getNgaynopcv());
        if (congviec.getTrangthai() == 0){
            viewHolder.status.setText("Reject");
        }
        if (congviec.getTrangthai() == 1){
            viewHolder.status.setText("Waiting");
        }
        if (congviec.getTrangthai() == 2){
            viewHolder.status.setText("Approved");
        }
        if (congviec.getTrangthai() == 3){
            viewHolder.status.setText("Consider");
        }

        return convertView;
    }

}
