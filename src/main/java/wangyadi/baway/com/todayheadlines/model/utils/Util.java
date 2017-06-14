package wangyadi.baway.com.todayheadlines.model.utils;

import android.util.Log;

import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;

import javax.security.auth.callback.Callback;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class Util {
    public static<T> void getTextData(String url, HashMap<String,String> hashMap, final CallUtils callUtils, final Class<T> clazz)
    {
        RequestParams requestParams = new RequestParams();
        requestParams.setUri(url);
        if(hashMap!=null)
        {
            Iterator<String> iterator=hashMap.keySet().iterator();
            while (iterator.hasNext())
            {
                String key = iterator.next();
                String value = hashMap.get(key);
                requestParams.addQueryStringParameter(key,value);
            }
        }
        x.http().get(requestParams, new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                T t = gson.fromJson(result, clazz);
                callUtils.callutils(t);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public interface CallUtils<T>
    {
        void callutils(T t);
    }
}
