package wangyadi.baway.com.todayheadlines.presenter;

import android.util.Log;

import java.util.HashMap;

import wangyadi.baway.com.todayheadlines.model.utils.Util;
import wangyadi.baway.com.todayheadlines.view.iview.IHomeView;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class HomePresenter extends BasePresenter<IHomeView>{

    private String url="http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news";
    private HashMap<String,String> hashMap=new HashMap<>();

    public<T> void getDataFromServer(Class<T> t)
    {
        Util.getTextData(url, hashMap, new Util.CallUtils<T>() {
            @Override
            public void callutils(T t) {
                getMvpView().callBack(t);
            }
        },t);
    }
}
