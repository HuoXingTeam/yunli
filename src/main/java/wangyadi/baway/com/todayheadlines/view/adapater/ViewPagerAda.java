package wangyadi.baway.com.todayheadlines.view.adapater;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wangyadi.baway.com.todayheadlines.model.Bean.HomeBean;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/12
 * 作者：王亚迪
 */

public class ViewPagerAda extends FragmentPagerAdapter{
    private List<Fragment> flist=new ArrayList<>();

    public void setList(List<Fragment> list)
    {
        this.flist=list;
    }

    public ViewPagerAda(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }
}
