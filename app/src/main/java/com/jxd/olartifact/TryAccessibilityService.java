package com.jxd.olartifact;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public class TryAccessibilityService extends AccessibilityService {
    public  static String TAG = TryAccessibilityService.class.getName();
    String tryTime1="10:00:00";
    String tryTime2="20:00:00";
    //private String splashActivity="com.olquanapp.ttds.android.ui.SplashActivity";
    //private String mainActivity = "com.olquanapp.ttds.android.ui.MainActivity";
    //private String updateActivity="com.umeng.update.UpdateDialogActivity";//升级提示框
    //private String oneTrialActivity="com.olquanapp.ttds.android.ui.index.IndexOnTrialActivity";//试用中心页面
    //private String collectionActivity ="com.olquanapp.ttds.android.ui.mine.CollectionActivity";//收藏夹界面
    //private String productDetailActivity="com.olquanapp.ttds.android.ui.product.ProductDetailActivity";
    private String youWantTryGoods = "侨家家纺 欧式简约高端款床笠六件";//"阿尔皮纳袋鼠时尚超短";
    //private static Handler handler;
    private int clickDelay = 100;
    private boolean isFindGoods = false;
    private UIActivityEnum currentUI = UIActivityEnum.None;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i(TAG,"onServiceConnected");

    }

//    public static Handler getHandler(){
//        if(handler==null){
//            handler = new android.os.Handler();
//        }
//        return handler;
//    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try{
            AccessibilityNodeInfo rootNode = this.getRootInActiveWindow();
            if ( rootNode == null) return;

            //int eventType = accessibilityEvent.getEventType();
            Log.i( TAG , "classname="+ accessibilityEvent.getClassName()
                    + " packagename="+accessibilityEvent.getPackageName()
                    +" eventtype = "+ accessibilityEvent.getEventType()
                    +" source = " + accessibilityEvent.getSource()
                    + " text = "+ accessibilityEvent.getText()
                    +" action = "+ accessibilityEvent.getAction());

            String className= accessibilityEvent.getClassName().toString();

            setCurrentUI(className);

            //if(!checkTryTime()) return;
            isUpdateUI(rootNode,className);
            isInMainUI(rootNode, className);
            isInMyUI(rootNode, accessibilityEvent.getSource() );
            isInCollectionUI(rootNode,className);
            isInProductDetailUI(rootNode);
        }
        catch (Exception ex){

        }
    }

    @Override
    public void onInterrupt() {
        Log.i(TAG, "onInterrupt");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG,"onLowMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG , "onDestroy");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG,"onTrimMemory");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG,"onRebind");
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

    /**
     * 检测当前在哪个UI
     * @param className
     */
    private void setCurrentUI(String className ){
        UIActivityEnum ui = UIActivityEnum.getByName( className);
        if( ui !=null ){
            currentUI = ui;
        }
    }

    /***
     * 检测是否主界面
     */
    private boolean isInMainUI(AccessibilityNodeInfo rootNode , String className ){
        //    if(!className.equals(mainActivity)) return false;
        if( !UIActivityEnum.MainUI.equals( currentUI ) ) return false;


        List<AccessibilityNodeInfo> nodes = rootNode.findAccessibilityNodeInfosByText("我的");
        if(nodes==null|| nodes.isEmpty()|| nodes.size()<1) return false;
        performClick(nodes);

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
        if( !UIActivityEnum.UpdateUI.equals( currentUI ) ) return false;

        List<AccessibilityNodeInfo> nodes =  rootNode.findAccessibilityNodeInfosByText("以后再说");
        if(nodes==null|| nodes.isEmpty()|| nodes.size()<1) return false;
        performClick(nodes);
        return true;
    }

    /**
     * 检测是否在"我的"选项卡页面,如果是，则点击"我的收藏"按钮
     * @param node
     * @return
     */
    private boolean isInMyUI(AccessibilityNodeInfo node ,AccessibilityNodeInfo source ) {
        List<AccessibilityNodeInfo> nodes = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/index_image");
        if(nodes!=null&& nodes.size()>0) return false;

        if(source==null) return false;


        List<AccessibilityNodeInfo> parentNodes = source.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/layout");
        if(parentNodes==null || parentNodes.size()<1) return  false;
        nodes = source.findAccessibilityNodeInfosByText("客服电话");
        if (nodes == null || nodes.size() < 1) return false;
        nodes = source.findAccessibilityNodeInfosByText("帮助中心");
        if (nodes == null || nodes.size() < 1) return false;
        nodes =source.findAccessibilityNodeInfosByText("个人中心");
        if (nodes == null || nodes.size() < 1) return false;
        nodes = source.findAccessibilityNodeInfosByText("我的收藏");
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
        //if(  !className.equals( collectionActivity)) return false;
        if(!UIActivityEnum.ColectionUI.equals(currentUI)) return false;

        if(isFindGoods) return true;

        //List<AccessibilityNodeInfo> tabs = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/tab_layout");
        //if( tabs ==null || tabs.size()<1) return false;
        //List<AccessibilityNodeInfo> tabNode = tabs.get(0).findAccessibilityNodeInfosByText("产品");
        //if( tabNode==null||tabNode.size()<1) return false;
        //performClick(tabNode);

        AccessibilityNodeInfo recycleView = findNodeByClassName( node , "android.support.v7.widget.RecyclerView");

        if( recycleView ==null )return false;

        int count = recycleView.getChildCount();

        for (int i = 0; i < count; i++) {
            AccessibilityNodeInfo item = recycleView.getChild(i);
           List<AccessibilityNodeInfo> item_name = item.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/name");
            if( item_name ==null || item_name.size() <1  ) continue;
            String goodsName = item_name.get(0).getText().toString();
            if( !goodsName.contains( youWantTryGoods )) continue;
            isFindGoods = true;
            performClick( item );
            break;
        }
        if(!isFindGoods && scrollRecycleView(recycleView)){
            //滚动recycleview
        }

        return  true;
    }

    /***
     * 检查是否在 商品详情界面
     * @param node
     * @return
     */
    private boolean isInProductDetailUI(AccessibilityNodeInfo node ){
        if( !UIActivityEnum.ProductDetailUI.equals( currentUI ) ) return false;

        isFindGoods=false;

        //先查找底部的工具栏控件
        List<AccessibilityNodeInfo> bottonNodes = node.findAccessibilityNodeInfosByViewId("com.olquanapp.ttds.android:id/bottom_view");
        if(bottonNodes==null|| bottonNodes.size()<1) return  false;
        //在查找“立即试用”控件
        String txtid = "com.olquanapp.ttds.android:id/btn_buy";
        List<AccessibilityNodeInfo> nodes1 = node.findAccessibilityNodeInfosByViewId(txtid);

        String txt ="立即试用";
        List<AccessibilityNodeInfo> nodes2 = bottonNodes.get(0).findAccessibilityNodeInfosByText(txt);
        if(nodes2==null||nodes2.size()<1) return false;

        performClick(nodes2);
        return true;
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
            performClick( nodes.get(i));
        }

    }

    private void performClick(AccessibilityNodeInfo view ){
        if(view==null) return;
        if ( view.isVisibleToUser() && view.isClickable()) {
            view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }else{
            AccessibilityNodeInfo parent = view.getParent();
            if( view.isVisibleToUser() && parent.isClickable()){
                view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

//    private void delayPerformClick(final List<AccessibilityNodeInfo> nodes ){
//        getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                 performClick(nodes);
//            }
//        }, clickDelay);
//    }
}
