package com.jxd.olartifact;

import android.accessibilityservice.AccessibilityService;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.id.tabs;

/**
 * Created by Administrator on 2017/8/3.
 */
public class TryAccessibilityService extends AccessibilityService {
    public  static String TAG = TryAccessibilityService.class.getName();
    String tryTime1="10:00:00";
    String tryTime2="20:00:00";
    private String splashActivity="com.olquanapp.ttds.android.ui.SplashActivity";
    private String mainActivity = "com.olquanapp.ttds.android.ui.MainActivity";
    private String updateActivity="com.umeng.update.UpdateDialogActivity";//升级提示框
    private String oneTrialActivity="com.olquanapp.ttds.android.ui.index.IndexOnTrialActivity";//试用中心页面
    private String collectionActivity ="com.olquanapp.ttds.android.ui.mine.CollectionActivity";//收藏夹界面
    private String productDetailActivity="com.olquanapp.ttds.android.ui.product.ProductDetailActivity";
    private String youWantTryGoods = "阿尔皮纳袋鼠时尚超短";
    private static Handler handler;
    private int clickDelay = 100;
    private boolean isFindGoods = false;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

    }

    public static Handler getHandler(){
        if(handler==null){
            handler = new android.os.Handler();
        }
        return handler;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try{
            AccessibilityNodeInfo rootNode = this.getRootInActiveWindow();
            if ( rootNode == null) return;

            int eventType = accessibilityEvent.getEventType();
            Log.i( TAG , "classname="+ accessibilityEvent.getClassName()
                    + " packagename="+accessibilityEvent.getPackageName()
                    +" eventtype = "+ accessibilityEvent.getEventType());
            String className= accessibilityEvent.getClassName().toString();

            //if(!checkTryTime()) return;
            isUpdateUI(rootNode,className);
            isInMainUI(rootNode, className);
            isInMyUI(rootNode);
            isInCollectionUI(rootNode,className);
        }
        catch (Exception ex){

        }
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /***
     *  判断当前时间是否在试用点
     * @return
     */
    private boolean checkTryTime(){
        Date currentDate = new Date( System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String currentDateStr =  simpleDateFormat.format(currentDate);
        return  (currentDateStr.equals( tryTime1 ) || currentDateStr.equals(tryTime2));
    }

    /***
     * 检测是否主界面
     */
    private boolean isInMainUI(AccessibilityNodeInfo rootNode , String className ){
            if(!className.equals(mainActivity)) return false;

        List<AccessibilityNodeInfo> nodes = rootNode.findAccessibilityNodeInfosByText("我的");
        if(nodes==null|| nodes.isEmpty()|| nodes.size()<1) return false;
        delayPerformClick(nodes);

        //isInIndexTabPage(rootNode);

        return true;
    }

    /**
     * 检测是否在首页的Tab选项卡。
     * @param node
     * @return
     */
    private boolean isInIndexTabPage(AccessibilityNodeInfo node ) {
        List<AccessibilityNodeInfo> nodes = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/tab_layout");
        if (nodes == null || nodes.size() < 1) return false;
        nodes = nodes.get(0).findAccessibilityNodeInfosByText("首页");
        if (nodes == null || nodes.size() < 1) return false;
        performClick(nodes);
        return true;
    }

    /**
     * 检测升级提示框，如果事，则点击 "以后再说" 按钮，不升级
     * @param rootNode
     * @param className
     * @return
     */
    private boolean isUpdateUI(AccessibilityNodeInfo rootNode , String className){
        if(!className.equals(updateActivity)) return false;

        List<AccessibilityNodeInfo> nodes =  rootNode.findAccessibilityNodeInfosByText("以后再说");
        if(nodes==null|| nodes.isEmpty()|| nodes.size()<1) return false;
        delayPerformClick(nodes);
        return true;
    }

    /**
     * 检测是否在"我的"选项卡页面,如果是，则点击"我的收藏"按钮
     * @param node
     * @return
     */
    private boolean isInMyUI(AccessibilityNodeInfo node  ) {
        List<AccessibilityNodeInfo> nodes = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/index_image");
        if(nodes!=null&& nodes.size()>0) return false;

        List<AccessibilityNodeInfo> parentNodes = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/layout");
        if(parentNodes==null || parentNodes.size()<1) return  false;
        nodes = node.findAccessibilityNodeInfosByText("客服电话");
        if (nodes == null || nodes.size() < 1) return false;
        nodes = node.findAccessibilityNodeInfosByText("帮助中心");
        if (nodes == null || nodes.size() < 1) return false;
        nodes =node.findAccessibilityNodeInfosByText("个人中心");
        if (nodes == null || nodes.size() < 1) return false;
        nodes = node.findAccessibilityNodeInfosByText("我的收藏");
        if (nodes == null || nodes.size() < 1) return false;
        performClick(nodes);
        return true;
    }

    /**
     * 检测是否在 收藏界面
     * @param node
     * @return
     */
    private boolean isInCollectionUI(AccessibilityNodeInfo node , String className){
        if(  !className.equals( collectionActivity)) return false;

        if(isFindGoods) return true;

        List<AccessibilityNodeInfo> tabs = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/tab_layout");
        if( tabs ==null || tabs.size()<1) return false;
        List<AccessibilityNodeInfo> tabNode = tabs.get(0).findAccessibilityNodeInfosByText("产品");
        if( tabNode==null||tabNode.size()<1) return false;
        performClick(tabNode);

        AccessibilityNodeInfo recycleView = findNodeByClassName( node , "android.support.v7.widget.RecyclerView");

        if( recycleView ==null )return false;

        int count = recycleView.getChildCount();

        for (int i = 0; i < count; i++) {
            AccessibilityNodeInfo item = recycleView.getChild(i);
           List<AccessibilityNodeInfo> item_name = item.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/name");
            if( item_name ==null || item_name.size() <1  ) continue;
            String goodsName = item_name.get(0).getText().toString();
            if( !goodsName.equals( youWantTryGoods )) continue;
            isFindGoods = true;
            delayPerformClick( item_name );
        }
        if(!isFindGoods && scrollRecycleView(recycleView)){
            //滚动recycleview
        }

        return  true;
    }

    /***
     * 滚动当前RecycleView控件
     * @param node
     * @return
     */
    boolean scrollRecycleView(AccessibilityNodeInfo node){
        if( node !=null && node.isScrollable()){
            node.performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
            return true;
        }else{
            return false;
        }
    }

    /***
     * 递归查找指定类名的节点
     * @param node
     * @param className
     * @return
     */
    public AccessibilityNodeInfo findNodeByClassName(AccessibilityNodeInfo node , String className){
        if( node ==null) return null;
        String nodeClassName = node.getClassName().toString();
        if( nodeClassName.equals( className ) ){
            return node;
        }
        int count = node.getChildCount();
        if( count==0) return null;
        for(int i=0;i<count;i++){
            AccessibilityNodeInfo item = node.getChild(i);
            AccessibilityNodeInfo find = findNodeByClassName( item , className);
            if( find == null ) continue;
            return  find;
        }
        return null;
    }

    private void performClick(List<AccessibilityNodeInfo> nodes  ){
        for(int i=0;i< nodes.size();i++) {
            AccessibilityNodeInfo view = nodes.get(i);
            if ( view.isVisibleToUser() && view.isClickable()) {
                view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }else{
                AccessibilityNodeInfo parent = view.getParent();
                if( view.isVisibleToUser() && parent.isClickable()){
                    view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }

    }

    private void delayPerformClick(final List<AccessibilityNodeInfo> nodes ){
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 performClick(nodes);
            }
        }, clickDelay);
    }
}
