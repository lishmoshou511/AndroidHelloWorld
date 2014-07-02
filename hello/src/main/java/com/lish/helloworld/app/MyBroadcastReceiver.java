package com.lish.helloworld.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by lishuang on 2014/7/2.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    private String name;
    public MyBroadcastReceiver(){
        super();
    }
    public MyBroadcastReceiver(String name){
        this.name=name;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String content="广播内容：" + extras.getString("msg");
            if(name!=null){
                content+=" 名称："+name;
            }
            Log.i(this.getClass().getName(),content);
        }
    }
}
