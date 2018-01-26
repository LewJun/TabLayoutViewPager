package com.example.tablayoutviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 已晨检
 *
 * @author LewJun
 * @date 2018/01/26
 */
public class MorningCheckedFragment extends Fragment {
    public static final String MORNINGCHECKEDCHILDREN = "MORNINGCHECKEDCHILDREN";

    private Context mContext;

    private ArrayList<Children> mMorningCheckedChildren;

    private MyChildrenAdapter mAdapter;

    private OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            if(!PreventFastClickUtils.isFastClick()) {
                Toast.makeText(mContext, mMorningCheckedChildren.get(position).name + "已刷卡", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public static MorningCheckedFragment newInstance(ArrayList<Children> morningCheckedChildren) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MORNINGCHECKEDCHILDREN, morningCheckedChildren);

        MorningCheckedFragment fragment = new MorningCheckedFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMorningCheckedChildren = (ArrayList<Children>) getArguments().getSerializable(MORNINGCHECKEDCHILDREN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_morning_checked, container, false);
        if (mContext == null) {
            mContext = view.getContext();
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        int spanCount = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), spanCount));
        recyclerView.addItemDecoration(new SpaceItemDecoration(4, spanCount));
        mAdapter = new MyChildrenAdapter(mMorningCheckedChildren, mListener);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void setMorningCheckedChildren(ArrayList<Children> morningCheckedChildren) {
        mMorningCheckedChildren = morningCheckedChildren;
        mAdapter.notifyDataSetChanged();
    }
}
