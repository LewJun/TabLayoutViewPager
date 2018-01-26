package com.example.tablayoutviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private MainFragmentPagerAdapter mMainFragmentPagerAdapter;
    private List<String> mTabTitles = new ArrayList<>();
    private ArrayList<Children> mMorningCheckedChildren = new ArrayList<>();
    private ArrayList<Children> mMorningUnCheckChildren = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initMorningCheckedChildren();
        initMorningUnCheckChildren();

        initTabTitles();

        mMainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager()
                , mTabTitles
                , mMorningCheckedChildren
                , mMorningUnCheckChildren
        );

        mViewPager.setAdapter(mMainFragmentPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void initTabTitles() {
        mTabTitles.clear();
        mTabTitles.add(0, "未晨检 (" + mMorningUnCheckChildren.size() + ")");
        mTabTitles.add(1, "已晨检 (" + mMorningCheckedChildren.size() + ")");
    }

    private void initMorningCheckedChildren() {
        for (int i = 0; i < 100; i++) {
            mMorningCheckedChildren.add(new Children(i + 1, "张三" + i));
        }
    }

    private void initMorningUnCheckChildren() {
        for (int i = 0; i < 150; i++) {
            mMorningUnCheckChildren.add(new Children(i + 1, "李四" + i));
        }
    }

    public void updateData(int pos) {
        mMorningCheckedChildren.add(mMorningUnCheckChildren.get(pos));
        mMorningUnCheckChildren.remove(pos);
        initTabTitles();
        mMainFragmentPagerAdapter.notifyDataSetChanged();
    }
}
