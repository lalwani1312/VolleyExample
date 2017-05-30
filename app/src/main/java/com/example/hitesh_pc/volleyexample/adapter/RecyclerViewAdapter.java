package com.example.hitesh_pc.volleyexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hitesh_pc.volleyexample.R;
import com.example.hitesh_pc.volleyexample.model.Person;

import java.util.List;

/**
 * Created by Hitesh-PC on 27-08-2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private LayoutInflater mInflater;
    private List<Person> mPersonList;

    public RecyclerViewAdapter(Context context, List<Person> personList) {
        mInflater = LayoutInflater.from(context);
        mPersonList = personList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mPerson = mPersonList.get(position);
        holder.mNameView.setText(holder.mPerson.getName());
        holder.mEmailView.setText(holder.mPerson.getEmail());
        holder.mHomeNumberView.setText(holder.mPerson.getPhone().getHomeNumber());
        holder.mMobileNumberView.setText(holder.mPerson.getPhone().getMobileNumber());
    }

    @Override
    public int getItemCount() {
        return mPersonList != null ? mPersonList.size() : 0;
    }

    public void updateData(List<Person> personList){
        mPersonList = personList;
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        Person mPerson;
        TextView mNameView, mEmailView, mHomeNumberView, mMobileNumberView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mNameView = (TextView) itemView.findViewById(R.id.name);
            mEmailView = (TextView) itemView.findViewById(R.id.email);
            mHomeNumberView = (TextView) itemView.findViewById(R.id.home_number);
            mMobileNumberView = (TextView) itemView.findViewById(R.id.mobile_number);
        }
    }
}
