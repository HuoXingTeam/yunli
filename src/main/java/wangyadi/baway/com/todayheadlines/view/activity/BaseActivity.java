package wangyadi.baway.com.todayheadlines.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Night_Utils.Night_styleutils;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/13
 * 作者：王亚迪
 */

public class BaseActivity extends AppCompatActivity {
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Night_styleutils.changeStyle(this, theme, savedInstanceState);
        super.onCreate(savedInstanceState);
    }
}
