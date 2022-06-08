package com.example.myapplication.Applicant.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;

public class NganhngheAdapter extends BaseAdapter {

    private ArrayList<Nganhnghe> listViewItemDtoList = null;
    private Context ctx = null;
    public NganhngheAdapter(Context ctx, ArrayList<Nganhnghe> listViewItemDtoList) {
        this.ctx = ctx;
        this.listViewItemDtoList = listViewItemDtoList;
    }
    @Override
    public int getCount() {
        int ret = 0;
        if(listViewItemDtoList!=null)
        {
            ret = listViewItemDtoList.size();
        }
        return ret;
    }
    @Override
    public Object getItem(int itemIndex) {
        Object ret = null;
        if(listViewItemDtoList!=null) {
            ret = listViewItemDtoList.get(itemIndex);
        }
        return ret;
    }
    @Override
    public long getItemId(int itemIndex) {
        return itemIndex;
    }
    @Override
    public View getView(int itemIndex, View convertView, ViewGroup viewGroup) {
        ListViewItemViewHolder viewHolder = null;
        if(convertView!=null)
        {
            viewHolder = (ListViewItemViewHolder) convertView.getTag();
        }else
        {
            convertView = View.inflate(ctx, R.layout.nganhnghe_adapter, null);
            CheckBox listItemCheckbox = (CheckBox) convertView.findViewById(R.id.list_view_item_checkbox);
            TextView listItemText = (TextView) convertView.findViewById(R.id.list_view_item_text);
            viewHolder = new ListViewItemViewHolder(convertView);
            viewHolder.setItemCheckbox(listItemCheckbox);
            viewHolder.setItemTextView(listItemText);
            convertView.setTag(viewHolder);
        }
        Nganhnghe listViewItemDto = listViewItemDtoList.get(itemIndex);
        viewHolder.getItemCheckbox().setChecked(listViewItemDto.isChecked());
        viewHolder.getItemTextView().setText(listViewItemDto.getIdNganh() + " - " + listViewItemDto.getTennganh());
        return convertView;
    }

    public class ListViewItemViewHolder extends RecyclerView.ViewHolder {
        private CheckBox itemCheckbox;
        private TextView itemTextView;
        public ListViewItemViewHolder(View itemView) {
            super(itemView);
        }
        public CheckBox getItemCheckbox() {
            return itemCheckbox;
        }
        public void setItemCheckbox(CheckBox itemCheckbox) {
            this.itemCheckbox = itemCheckbox;
        }
        public TextView getItemTextView() {
            return itemTextView;
        }
        public void setItemTextView(TextView itemTextView) {
            this.itemTextView = itemTextView;
        }
    }
}
