package com.lish.helloworld.app;

import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Service;
import android.widget.Toast;

public class ServiceActivity extends ActionBarActivity {

	private Button startBtn;
	private Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

	    final Intent intent=new Intent(this, TrackService.class);


	    startBtn=(Button)findViewById(R.id.startBtn);
	    startBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    startService(intent);
			    Toast.makeText(ServiceActivity.this,"服务已启动",Toast.LENGTH_LONG).show();

		    }
	    });

	    stopBtn=(Button)findViewById(R.id.stopBtn);
	    stopBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    stopService(intent);
			    Toast.makeText(ServiceActivity.this,"服务已停止",Toast.LENGTH_LONG).show();

		    }
	    });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data_transfer, menu);
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
