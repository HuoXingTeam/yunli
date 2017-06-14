package wangyadi.baway.com.todayheadlines.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.limxing.xlistview.view.XListView;

import java.util.List;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Bean.FragmentBean;
import wangyadi.baway.com.todayheadlines.presenter.FragmentPresenter;
import wangyadi.baway.com.todayheadlines.view.activity.Share_Activty;
import wangyadi.baway.com.todayheadlines.view.adapater.XlistViewAda;
import wangyadi.baway.com.todayheadlines.view.iview.IFragmentView;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/12
 * 作者：王亚迪
 */

public class IFragment extends Fragment implements IFragmentView<FragmentBean> ,XListView.IXListViewListener{

    private XListView xlist_view;
    private FragmentPresenter fpresenter;
    private String url;
    private int index=0;
    private boolean isResult;
    private XlistViewAda ada;

    public IFragment(String url)
    {
        this.url=url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        xlist_view.setPullLoadEnable(true);
        xlist_view.setRefreshTime("11:26:36");
        xlist_view.setXListViewListener(this);
    }

    private void initData() {
        fpresenter = new FragmentPresenter();
        fpresenter.getDataFromServer(FragmentBean.class,url);
        ada = new XlistViewAda(getContext());
        ada.setFragmentPreseter(fpresenter);
        fpresenter.attachView(this);
        xlist_view.setAdapter(ada);
    }

    private void initView() {
        xlist_view = (XListView) getView().findViewById(R.id.xlist_view);
    }

    @Override
    public void callBack(final FragmentBean fragmentBean) {
        ada.addMore(fragmentBean.getResult().getData(),isResult);
        ada.setData(fragmentBean.getResult().getData());
        ada.notifyDataSetChanged();
        xlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<FragmentBean.ResultBean.DataBean> data = fragmentBean.getResult().getData();
                String url = data.get(position-1).getUrl();
                Intent intent=new Intent(getContext(),Share_Activty.class);
                Intent name = intent.putExtra("name", url);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRefresh() {
        isResult=true;
        ++index;
        initData();
        xlist_view.stopRefresh(true);
    }

    @Override
    public void onLoadMore() {
        isResult=false;
        ++index;
        initData();
        xlist_view.stopLoadMore();
    }
}
