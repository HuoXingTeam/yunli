package wangyadi.baway.com.todayheadlines.view.adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wangyadi.baway.com.todayheadlines.R;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/6/1
 * 作者：王亚迪
 */

public class Frgment2MyAda extends BaseAdapter{
    private Context context;
    private List<String> list;
    private JCVideoPlayerStandard player;

    public Frgment2MyAda(Context context, List<String> list)
    {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView=convertView.inflate(context, R.layout.fragment2_item,null);
            player = (JCVideoPlayerStandard) convertView.findViewById(R.id.player_list_video);
        }
        boolean setUp = player.setUp("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=221"+position
                +"1&editionType=default&source=ucloud", JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(context).load("http://img.juhe.cn/cookbook/s/1/92_1630281ff0350105.jpg").into(player.thumbImageView);
        }
        return convertView;
    }
}
