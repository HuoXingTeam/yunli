package wangyadi.baway.com.todayheadlines.view.adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wangyadi.baway.com.todayheadlines.R;
import wangyadi.baway.com.todayheadlines.model.Bean.FragmentBean;
import wangyadi.baway.com.todayheadlines.presenter.FragmentPresenter;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class XlistViewAda extends BaseAdapter{
    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;
    private Context context;
    private FragmentPresenter mfragmentpresenter;
    private List<FragmentBean.ResultBean.DataBean> list=new ArrayList<>();
    public XlistViewAda(Context context)
    {
        this.context=context;
    }

    public void setData(List<FragmentBean.ResultBean.DataBean> list)
    {
        if(list!=null)
        {
            this.list.addAll(list);
        }
    }

    public void addMore(List<FragmentBean.ResultBean.DataBean> lists,boolean isResult)
    {
        for (FragmentBean.ResultBean.DataBean data:lists)
        {
            if (isResult)
            {
                list.add(0,data);
            }else{
                list.add(data);
            }
       }
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getThumbnail_pic_s03()==null)
        {
            return TYPE_1;
        }else{
            return TYPE_2;
        }
     }

    public void setFragmentPreseter(FragmentPresenter fragmentpresenter)
    {
        this.mfragmentpresenter=fragmentpresenter;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public FragmentBean.ResultBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        ViewHolder1 viewholder1;
        int type = getItemViewType(position);
        switch (type)
        {
            case TYPE_2:
                if (convertView==null)
                {
                    viewholder=new ViewHolder();
                    convertView=convertView.inflate(context,R.layout.xlistview_item1,null);
                    viewholder.xlist1_text1= (TextView) convertView.findViewById(R.id.xlist1_text1);
                    viewholder.xlist1_image1= (ImageView) convertView.findViewById(R.id.xlist1_image1);
                    viewholder.xlist1_image2= (ImageView) convertView.findViewById(R.id.xlist1_image2);
                    viewholder.xlist1_image3= (ImageView) convertView.findViewById(R.id.xlist1_image3);
                    convertView.setTag(viewholder);
                }else{
                    viewholder= (ViewHolder) convertView.getTag();
                }
                viewholder.xlist1_text1.setText(list.get(position).getTitle());
                mfragmentpresenter.getImageFromServer(viewholder.xlist1_image1,list.get(position).getThumbnail_pic_s());
                mfragmentpresenter.getImageFromServer(viewholder.xlist1_image2,list.get(position).getThumbnail_pic_s02());
                mfragmentpresenter.getImageFromServer(viewholder.xlist1_image3,list.get(position).getThumbnail_pic_s03());
                break;
            case TYPE_1:
                if(convertView==null)
                {
                    viewholder1=new ViewHolder1();
                    convertView=convertView.inflate(context,R.layout.xlistview_item2,null);
                    viewholder1.xlist2_text1= (TextView) convertView.findViewById(R.id.xlist2_text1);
                    viewholder1.xlist2_image1= (ImageView) convertView.findViewById(R.id.xlist2_image1);
                    convertView.setTag(viewholder1);
                }else{
                    viewholder1= (ViewHolder1) convertView.getTag();
                }
                viewholder1.xlist2_text1.setText(list.get(position).getTitle());
                mfragmentpresenter.getImageFromServer(viewholder1.xlist2_image1,list.get(position).getThumbnail_pic_s());
                break;
        }
        return convertView;
    }

    static class ViewHolder
    {
        TextView xlist1_text1;
        ImageView xlist1_image1;
        ImageView xlist1_image2;
        ImageView xlist1_image3;
    }

    static class ViewHolder1
    {
        TextView xlist2_text1;
        ImageView xlist2_image1;
    }
}
