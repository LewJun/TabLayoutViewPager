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
 * 未晨检
 *
 * @author LewJun
 * @date 2018/01/26
 */
public class MorningUnCheckFragment extends Fragment {
    private static final String MORNINGUNCHECKCHILDREN = "MORNINGUNCHECKCHILDREN";

    private MyChildrenAdapter mAdapter;

    private ArrayList<Children> mMorningUnCheckChildren;

    private Context mContext;

    private OnItemClickListener mListener = new OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(mContext, mMorningUnCheckChildren.get(position).name + "已刷卡", Toast.LENGTH_SHORT).show();
            ((MainActivity)getActivity()).updateData(position);
        }
    };

    public static Fragment newInstance(ArrayList<Children> morningUnCheckChildren) {
        MorningUnCheckFragment fragment = new MorningUnCheckFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MORNINGUNCHECKCHILDREN, morningUnCheckChildren);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMorningUnCheckChildren = (ArrayList<Children>) getArguments().getSerializable(MORNINGUNCHECKCHILDREN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_morning_uncheck, container, false);
        if (mContext == null) {
            mContext = view.getContext();
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        int spanCount = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), spanCount));
        recyclerView.addItemDecoration(new SpaceItemDecoration(4, spanCount));
        mAdapter = new MyChildrenAdapter(mMorningUnCheckChildren, mListener);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void setMorningUnCheckChildren(ArrayList<Children> morningUnCheckChildren) {
        mMorningUnCheckChildren = morningUnCheckChildren;
        mAdapter.notifyDataSetChanged();
    }
}
