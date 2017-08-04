package com.jxd.olartifact;

import android.accessibilityservice.AccessibilityService;
import android.content.res.Configuration;
import android.os.Environment;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

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

            if(isInMainUI(rootNode, className));

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
        performClick(nodes);
        return true;
    }

    /**
     * 检测是否在"我的"选项卡页面
     * @param node
     * @param className
     * @return
     */
    private boolean isInMyUI(AccessibilityNodeInfo node , String className ){

        return true;
    }

    private void performClick(List<AccessibilityNodeInfo> nodes  ){
        for(int i=0;i< nodes.size();i++) {
            AccessibilityNodeInfo view = nodes.get(i);
            if (view.isClickable()) {
                view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }else{
                AccessibilityNodeInfo parent = view.getParent();
                if(parent.isClickable()){
                    view.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }

    }
}
