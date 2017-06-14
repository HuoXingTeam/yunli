package wangyadi.baway.com.todayheadlines.applocation;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.smssdk.SMSSDK;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class MyApplocation extends Application{

    {
         PlatformConfig.setQQZone("1106163166", "a9S4A6MLaJXKckGC");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        UMShareAPI.get(this);
        SMSSDK.initSDK(this, "1ddbd77d56700", "c2d2787eb71110b4927a63cb4b4c6114");
    }
}
