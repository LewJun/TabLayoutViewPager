package com.example.tablayoutviewpager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LewJun on 2018/01/17.
 */
public class MyChildrenAdapter extends RecyclerView.Adapter<MyChildrenAdapter.VH> {
    private List<Children> mChildrens = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener mListener;

    public MyChildrenAdapter(List<Children> children, OnItemClickListener listener) {
        mChildrens = children;
        mListener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_child, null);
        return new VH(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Children child = mChildrens.get(position);
        holder.mTextView.setText(child.name);
    }

    @Override
    public int getItemCount() {
        return mChildrens.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView mTextView;

        public VH(View itemView, OnItemClickListener listener) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text1);

            itemView.setOnClickListener((v) -> {
                if (listener != null) {
                    listener.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}