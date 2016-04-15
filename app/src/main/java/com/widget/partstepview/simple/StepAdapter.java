package com.widget.partstepview.simple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.widget.partstepview.PartStepView;
import com.widget.partstepview.Step;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by GISirFive on 2016-4-14.
 */
public class StepAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private List<String> mList;

    public StepAdapter(Context context, List<String> list) {
        this.mInflater = LayoutInflater.from(context);
        if (list == null)
            list = new ArrayList<>();
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == 0) {
            holder.mPartStepView.setChecked(true);
            holder.mPartStepView.setStep(Step.START);
        } else if (position == (getCount() - 1)) {
            holder.mPartStepView.setChecked(false);
            holder.mPartStepView.setStep(Step.END);
        } else {
            holder.mPartStepView.setChecked(false);
            holder.mPartStepView.setStep(Step.MIDDLE);
        }

        holder.mStatus.setText(getItem(position));
        holder.mContent.setText("这里显示步骤提示内容");

        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.mPartStepView)
        PartStepView mPartStepView;
        @Bind(R.id.mStatus)
        TextView mStatus;
        @Bind(R.id.mContent)
        TextView mContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
