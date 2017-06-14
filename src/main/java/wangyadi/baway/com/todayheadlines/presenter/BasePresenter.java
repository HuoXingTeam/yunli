package wangyadi.baway.com.todayheadlines.presenter;

import wangyadi.baway.com.todayheadlines.view.iview.IMvpView;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/11
 * 作者：王亚迪
 */

public class BasePresenter<T extends IMvpView>{

    private T t1;
    public void attachView(T t)
    {
        this.t1=t;
    }

    public T getMvpView()
    {
        return t1;
    }
}
