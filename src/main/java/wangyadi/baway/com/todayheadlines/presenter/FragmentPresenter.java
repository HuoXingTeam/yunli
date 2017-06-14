package wangyadi.baway.com.todayheadlines.presenter;

import android.widget.ImageView;

import org.xutils.x;

import java.util.HashMap;

import wangyadi.baway.com.todayheadlines.model.utils.Util;
import wangyadi.baway.com.todayheadlines.view.iview.IFragmentView;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/12
 * 作者：王亚迪
 */

public class FragmentPresenter extends BasePresenter<IFragmentView>{

    public<T> void getDataFromServer(Class<T> t,String uri)
    {
        String url="http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri="+uri;
        HashMap<String,String> hashMap=new HashMap<>();
        Util.getTextData(url, hashMap, new Util.CallUtils<T>() {
            @Override
            public void callutils(T t) {
                getMvpView().callBack(t);
            }
        },t);
    }

    public void getImageFromServer(ImageView image,String url)
    {
        x.image().bind(image,url);
    }
}
