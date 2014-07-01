package com.lish.helloworld.app;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startBtn;
    private TextView textView1;
    private TextView textView2;
    private final long startTime=50*1000;
    private final long interval = 1000;



    //转跳的按钮
    private Button jumpBtn;

    //访问网页按钮
    private Button visitBtn;

    //数据传输页面按钮
    private Button jumpDataBtn;

	private Button serviceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("onCreate","应用onCreate");
        setContentView(R.layout.activity_main);

        startBtn=(Button)this.findViewById(R.id.button);
        startBtn.setOnClickListener(this);

        textView1=(TextView)this.findViewById(R.id.textView1);
        textView2=(TextView)this.findViewById(R.id.textView2);

        textView1.setText("Ready go!"+startTime);

        //CountDownTimer本是一个抽象类，这里用匿名类的方式来实现
        countDownTimer =  new CountDownTimer(startTime,interval) {
            @Override
            public void onTick(long l) {
                textView1.setText("Time remain:"+l);
                timeElapsed = startTime - l;
                textView2.setText("Time Elapsed:"+timeElapsed);
            }

            @Override
            public void onFinish() {
                textView1.setText("Time's up!");
                textView2.setText("Time Elapsed:"+startTime);
            }
        };

        //转跳相关的东东
        jumpBtn=(Button)findViewById(R.id.jumpBtn);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EmailActivity.class);
                startActivity(intent);
            }
        });

        //访问网页相关的东东
        //这里就是典型的用其他应用打开一个网页。
        visitBtn=(Button)findViewById(R.id.visitBtn);
        visitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                //不关心结果的方式打开一个网页
                //startActivity(intent);

                //关心结果的方式打开网页。
                startActivityForResult(intent,1);


            }
        });

        //数据传输页面
        jumpDataBtn=(Button)findViewById(R.id.jumpDataBtn);
        jumpDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DataTransferActivity.class);
                startActivity(intent);
            }
        });

	    //转跳到Service页面
	    serviceBtn=(Button)findViewById(R.id.serviceBtn);
	    serviceBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    Intent intent=new Intent(MainActivity.this,ServiceActivity.class);
			    startActivity(intent);
		    }
	    });



    }

    //转跳的回调函数
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i("结果回调：",requestCode+" "+resultCode);

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("onCreateOptionsMenu","应用onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("onOptionsItemSelected","应用onOptionsItemSelected");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Test by lish
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("onStart","应用onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("onResume","应用onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("onRestart","应用onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("onPause","应用onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i("onStop","应用onStop");
    }


    @Override
    protected void onDestroy(){
        Log.i("onDestroy","应用onDestroy");
        super.onDestroy();

    }


    //按钮点击事件
    @Override
    public void onClick(View view) {
        if(timerHasStarted){
            countDownTimer.cancel();
            timerHasStarted=false;
            startBtn.setText(this.getString(R.string.reset));

        }else{
            countDownTimer.start();
            timerHasStarted=true;
            startBtn.setText(this.getString(R.string.stop));
        }
    }
}
