package wangyadi.baway.com.todayheadlines.view.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Night_Utils.Night_styleutils;
import wangyadi.baway.com.todayheadlines.view.fragment.Fragment1;
import wangyadi.baway.com.todayheadlines.view.fragment.Fragment2;
import wangyadi.baway.com.todayheadlines.view.fragment.Fragment3;
import wangyadi.baway.com.todayheadlines.view.fragment.Fragment4;

public class Second_Activity extends BaseActivity {
    private int mindex=0;
    private RadioGroup radio_group;
    private ArrayList<Fragment> list;
    private RadioButton radio_shouye;
    private RadioButton radio_shipin;
    private RadioButton radio_guanzhu;
    private RadioButton radio_denglu;
    private Fragment[] mFragments;
    private FrameLayout frame_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second);
        initView();
        initData();
        rGOnClick();
       // initState();
    }

    //沉浸模式
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明头部
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }
    }

    private void rGOnClick() {
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radio_shouye:
                        setIndexSelector(0);
                        break;
                    case R.id.radio_shipin:
                        setIndexSelector(1);
                        break;
                    case R.id.radio_guanzhu:
                        setIndexSelector(2);
                        break;
                    case R.id.radio_denglu:
                        setIndexSelector(3);
                        break;
                }
            }
        });
    }

    private void initData() {
        Fragment1 fragment1=new Fragment1();
        Fragment2 fragment2=new Fragment2();
        Fragment3 fragment3=new Fragment3();
        Fragment4 fragment4=new Fragment4();
        mFragments = new Fragment[]{fragment1,fragment2,fragment3,fragment4};
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_layout,fragment1);
        setIndexSelector(0);
    }

    public void setIndexSelector(int index)
    {
        if(mindex==index){
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(mFragments[mindex]);
        if(!mFragments[index].isAdded()){
            ft.add(R.id.frame_layout,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }
        ft.commit();
        mindex=index;
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        radio_shouye = (RadioButton) findViewById(R.id.radio_shouye);
        radio_shipin = (RadioButton) findViewById(R.id.radio_shipin);
        radio_guanzhu = (RadioButton) findViewById(R.id.radio_guanzhu);
        radio_denglu = (RadioButton) findViewById(R.id.radio_denglu);
    }

    //夜间模式切换
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);//进入动画
        finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        startActivity(intent);
    }
}
