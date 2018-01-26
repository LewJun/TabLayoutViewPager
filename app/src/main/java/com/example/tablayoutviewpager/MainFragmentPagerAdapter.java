package com.example.tablayoutviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LewJun on 2018/01/26.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<String> mTabTitles;
    private ArrayList<Children> mMorningCheckedChildren;
    private ArrayList<Children> mMorningUnCheckChildren;

    public MainFragmentPagerAdapter(FragmentManager fm,
                                    List<String> tabTitles,
                                    ArrayList<Children> morningCheckedChildren,
                                    ArrayList<Children> morningUnCheckChildren) {
        super(fm);
        mTabTitles = tabTitles;
        mMorningCheckedChildren = morningCheckedChildren;
        mMorningUnCheckChildren = morningUnCheckChildren;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        // 设置第二个tab为已晨检页
        if (position == 1) {
            return MorningCheckedFragment.newInstance(mMorningCheckedChildren);
        } else if (position == 0) {
            return MorningUnCheckFragment.newInstance(mMorningUnCheckChildren);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    /**
     * 覆写getItemPosition使其返POSITION_NONE，
     * 以触发Fragment的销毁和重建。可是这将导致Fragment频繁的销毁和重建，并不是最佳的方法。
     * 而入口参数 object "representing an item", 实际上就是Fragment，
     * 只需要为Fragment提供一个更新view的public方法，然后把入口参数强制转型成自定义的Fragment，调用该Fragment的update方法以完成更新。
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        if (object instanceof MorningCheckedFragment) {
            MorningCheckedFragment fragment = (MorningCheckedFragment) object;
            fragment.setMorningCheckedChildren(mMorningCheckedChildren);
        } else if (object instanceof MorningUnCheckFragment) {
            MorningUnCheckFragment fragment = (MorningUnCheckFragment) object;
            fragment.setMorningUnCheckChildren(mMorningUnCheckChildren);
        }
        return super.getItemPosition(object);
//        return POSITION_NONE;
    }
}
