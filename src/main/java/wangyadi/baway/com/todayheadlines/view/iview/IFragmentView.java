package wangyadi.baway.com.todayheadlines.view.iview;

/**
 * 类的作用：
 * 类的思路：
 * 时间：2017/5/12
 * 作者：王亚迪
 */

public interface IFragmentView<T> extends IMvpView{
     void callBack(T t);
}
