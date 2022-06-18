package com.example.myapplication.HR.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CandidateAdapter extends BaseAdapter {

    ArrayList<UserAcc> arrayCandidate;
    private LayoutInflater mInflater;

    public CandidateAdapter(ArrayList<UserAcc> arrayCandidate, Context HR_Fragment_main ) {
        this.arrayCandidate = arrayCandidate;
        this.mInflater = LayoutInflater.from(HR_Fragment_main);
    }

    @Override
    public int getCount() {
        return arrayCandidate.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayCandidate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ImageView avater;
        TextView name, age, email, phone, trinhdohocvan ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CandidateAdapter.ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new CandidateAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.candidate_adapter,null);
            viewHolder.avater = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.age = (TextView) convertView.findViewById(R.id.tv_age);
            viewHolder.email = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.phone = (TextView) convertView.findViewById(R.id.tv_phoneCandidate);
            viewHolder.trinhdohocvan = (TextView) convertView.findViewById(R.id.tv_trinhdohocvan);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (CandidateAdapter.ViewHolder) convertView.getTag();
        }
        UserAcc userAcc = (UserAcc) getItem(position);
        Picasso.get().load(userAcc.getAnh())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(viewHolder.avater);
        viewHolder.name.setText(userAcc.getHoten());
        viewHolder.age.setText(userAcc.getTuoi().toString());
        viewHolder.email.setText(userAcc.getEmail());
        viewHolder.phone.setText(userAcc.getDienthoai());
        viewHolder.trinhdohocvan.setText(userAcc.getTentrinhdo());
        return convertView;
    }

}
