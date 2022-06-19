package com.example.myapplication.HR.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Company;
import com.example.myapplication.Model.CompanyHR;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ComanyAdapter extends BaseAdapter {
    ArrayList<CompanyHR> arrayCompanyCreated;
    private LayoutInflater mInflater;

    public ComanyAdapter(ArrayList<CompanyHR> arrayCompanyCreated, Context fragment) {
        this.arrayCompanyCreated = arrayCompanyCreated;
        this.mInflater = LayoutInflater.from(fragment);
    }

    @Override
    public int getCount() {
        return arrayCompanyCreated.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayCompanyCreated.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        ImageView logoCompany;
        TextView nameCompany, address, email, phone, url, amountJobcreated;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComanyAdapter.ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ComanyAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.company_adapter, null);
            viewHolder.logoCompany = (ImageView) convertView.findViewById(R.id.logoCompany);
            viewHolder.nameCompany = (TextView) convertView.findViewById(R.id.tv_namecompany);
            viewHolder.address = (TextView) convertView.findViewById(R.id.tv_addresscompany);
            viewHolder.email = (TextView) convertView.findViewById(R.id.tv_emailcom);
            viewHolder.phone = (TextView) convertView.findViewById(R.id.tv_phonecom);
            viewHolder.url = (TextView) convertView.findViewById(R.id.tv_url);
            viewHolder.amountJobcreated = (TextView) convertView.findViewById(R.id.tv_amountJobcreated);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ComanyAdapter.ViewHolder) convertView.getTag();
        }
        CompanyHR Cty = (CompanyHR) getItem(position);
        Picasso.get().load(Cty.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(viewHolder.logoCompany);
        viewHolder.nameCompany.setText(Cty.getTen());
        viewHolder.address.setText("Địa chỉ: "+ Cty.getDiachi());
        viewHolder.email.setText("Email " + Cty.getEmail());
        viewHolder.phone.setText("Số điện thoại: " + Cty.getDienthoai());
        viewHolder.url.setText("Số lượng tuyển dụng: " + Cty.getUrlWebsite());
        viewHolder.amountJobcreated.setText("Đã tạo " + Cty.getAmountJobCreated() +" Job");
        return convertView;
    }
}
