package wangyadi.baway.com.todayheadlines.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.x;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Night_Utils.UiUtils;
import wangyadi.baway.com.todayheadlines.view.activity.MainActivity;
import wangyadi.baway.com.todayheadlines.view.activity.QQ_Activity;
import wangyadi.baway.com.todayheadlines.view.activity.Second_Activity;


/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class Fragment4 extends Fragment {

    private ImageView f4image_touxiang;
    private TextView f4text_nicheng;
    private LinearLayout f4linear_title;
    private LinearLayout f4linear_touni;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment4, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        JianTing();
    }

    private void initView() {
        f4image_touxiang = (ImageView) getView().findViewById(R.id.f4image_touxiang);
        f4text_nicheng = (TextView) getView().findViewById(R.id.f4text_nicheng);
        f4linear_title = (LinearLayout) getView().findViewById(R.id.f4linear_title);
        f4linear_touni = (LinearLayout) getView().findViewById(R.id.f4linear_touni);
    }

    private void JianTing() {
        getView().findViewById(R.id.f4_imageQQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f4linear_title.setVisibility(View.GONE);
                f4linear_touni.setVisibility(View.VISIBLE);
                //取值
                SharedPreferences qq = getActivity().getSharedPreferences("QQ", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = qq.edit();
                String nicheng = qq.getString("昵称", "nicheng");
                String touxiang = qq.getString("头像", "touxiang");
                f4text_nicheng.setText(nicheng);
                x.image().bind(f4image_touxiang,touxiang);
                Intent intent = new Intent(getActivity(), QQ_Activity.class);
                startActivity(intent);
            }
        });

        getView().findViewById(R.id.f4_radioNight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.switchAppTheme(getActivity());
                Second_Activity activity = (Second_Activity) getActivity();
                activity.reload();
            }
        });

        getView().findViewById(R.id.shoucang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "133", Toast.LENGTH_LONG).show();
            }
        });

        getView().findViewById(R.id.f4image_Phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        // 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                        }
                    }
                });
                registerPage.show(getContext());
            }
        });
    }
}
