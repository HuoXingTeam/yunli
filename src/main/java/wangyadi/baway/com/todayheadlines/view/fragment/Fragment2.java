package wangyadi.baway.com.todayheadlines.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.view.adapater.Frgment2MyAda;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class Fragment2 extends Fragment{

    private ListView fragment2_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        fragment2_list = (ListView) getView().findViewById(R.id.fragment2_list);
    }

    private void initData() {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            list.add("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=221"+i
                    +"1&editionType=default&source=ucloud");
        }
        Frgment2MyAda ada=new Frgment2MyAda(getContext(),list);
        fragment2_list.setAdapter(ada);
        ada.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
