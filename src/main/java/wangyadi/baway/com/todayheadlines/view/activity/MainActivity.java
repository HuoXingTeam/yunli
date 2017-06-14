package wangyadi.baway.com.todayheadlines.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Night_Utils.Night_styleutils;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/12
 * 作者：王亚迪
 */

public class MainActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main1);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent=new Intent(MainActivity.this,Second_Activity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
