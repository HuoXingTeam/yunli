package wangyadi.baway.com.todayheadlines.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Bean.HomeBean;
import wangyadi.baway.com.todayheadlines.presenter.HomePresenter;
import wangyadi.baway.com.todayheadlines.view.adapater.ViewPagerAda;
import wangyadi.baway.com.todayheadlines.view.iview.IHomeView;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class Fragment1 extends Fragment implements IHomeView<HomeBean>{

    private HomePresenter homePresenter;
    private TextView text_view1;
    private LinearLayout fr_linear;
    private LayoutInflater layoutInflater;
    private ViewPager fr1_view_pager;
    private TabLayout tab;
    private ViewPagerAda vpAda;
    private List<Fragment> vpList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        tab = (TabLayout) getView().findViewById(R.id.tab);
        fr1_view_pager = (ViewPager) getView().findViewById(R.id.fr1_view_pager);
    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.getDataFromServer(HomeBean.class);
        homePresenter.attachView(this);
        vpAda = new ViewPagerAda(getChildFragmentManager());
        fr1_view_pager.setAdapter(vpAda);
        tab.setupWithViewPager(fr1_view_pager,false);
    }

    @Override
    public void callBack(HomeBean homeBean) {
        vpList = new ArrayList<>();
        List<HomeBean.ResultBean.DateBean> date = homeBean.getResult().getDate();
        for (int i = 0; i < date.size(); i++) {
            tab.addTab(tab.newTab().setText(date.get(i).getTitle()));
            String uri = date.get(i).getUri();
            vpList.add(new IFragment(uri));
        }
        vpAda.setList(vpList);
        vpAda.notifyDataSetChanged();
    }
}
