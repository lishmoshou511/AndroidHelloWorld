package com.lish.helloworld.app;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BroadcastSubActivity extends ActionBarActivity {

    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_sub);

        startBtn=(Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyBroadcastReceiver.class.getName());
                intent.putExtra("msg","This is a simple broadcast");
                BroadcastSubActivity.this.sendBroadcast(intent);
            }
        });

        //这里处理接受广播的事件
        MyBroadcastReceiver receiver=new MyBroadcastReceiver("子页面");
        IntentFilter filter=new IntentFilter(MyBroadcastReceiver.class.getName());
        this.registerReceiver(receiver,filter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.broadcast_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
