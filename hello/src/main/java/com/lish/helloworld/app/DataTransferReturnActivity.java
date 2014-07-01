package com.lish.helloworld.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class DataTransferReturnActivity extends ActionBarActivity {

	private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer_return);

	    backBtn=(Button)findViewById(R.id.backBtn);
	    backBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    back();

		    }
	    });
    }

	private void back(){
		Intent intent=new Intent();
		intent.putExtra("msg","HAHA,I'am back now!");
		setResult(Activity.RESULT_OK,intent);
		finish();
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data_transfer_return, menu);
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

	@Override
	protected void onStop(){

		Log.i("DataTransferReturnActivity", "DataTransferReturnActivity停止");


		super.onStop();



	}
}
