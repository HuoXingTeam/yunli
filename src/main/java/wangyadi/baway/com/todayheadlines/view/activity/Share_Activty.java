package wangyadi.baway.com.todayheadlines.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import wangyadi.baway.com.todayheadlines.R;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/16
 * 作者：王亚迪
 */

public class Share_Activty extends Activity{

    private String url;
    private WebView web_view;
    private ImageView webfenxiang;

    //分享
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);
            Toast.makeText(Share_Activty.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(Share_Activty.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(Share_Activty.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xwebview);
        initView();
        //取值
        Intent intent = getIntent();
        url = intent.getStringExtra("name");
        web_view.loadUrl(url);
        FenXiangOnclick();
    }

    private void initView() {
        web_view= (WebView) findViewById(R.id.web_view);
        webfenxiang = (ImageView) findViewById(R.id.webfenxiang);
    }

    private void FenXiangOnclick() {
        webfenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb web = new UMWeb(url);
                web.setTitle("This is music title");//标题
                web.setDescription("my description");//描述

                new ShareAction(Share_Activty.this).setPlatform(SHARE_MEDIA.QQ)
                        .withText("hello")
                        .withMedia(web)
                        .setCallback(umShareListener)
                        .share();
            }
        });
    }

    //分享
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
