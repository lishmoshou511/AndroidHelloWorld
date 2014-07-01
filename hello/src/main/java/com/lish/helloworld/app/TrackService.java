package com.lish.helloworld.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by lishuang on 2014/7/1.
 */
public class TrackService extends Service
{

	private boolean isRunning;

	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		isRunning=true;
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				int i=0;
				while(isRunning){
					Log.i("CountService:"," " + i++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		return START_NOT_STICKY;
	}

	@Override
	public void onDestroy(){
		Log.i(this.getClass().getName(),"停止了服务");
		isRunning=false;
	}



	@Override
	public boolean onUnbind(Intent intent){
		Log.i(this.getClass().getName(),"解除绑定Service");
		isRunning=false;
		return super.onUnbind(intent);
	}


	@Override
	public IBinder onBind(Intent intent) {
		Log.i(this.getClass().getName(),"开始绑定Service");
		return null;
	}
}