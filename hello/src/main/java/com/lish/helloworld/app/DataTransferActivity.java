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
import android.widget.TextView;


public class DataTransferActivity extends ActionBarActivity {

	private Button jumpBtn;
	private TextView textView;
	private Button returnBtn;

	public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer);

	    //显示的TextView;
	    textView= (TextView)findViewById(R.id.textView);
	    textView.setText("Nothing to display!");

	    jumpBtn=(Button)findViewById(R.id.jumpBtn);
	    jumpBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    Intent intent=new Intent(DataTransferActivity.this,DataTransferSubActivity.class);
			    intent.putExtra("msg","This is just a message");
			    startActivity(intent);
		    }
	    });

	    //有返回的按钮
	    returnBtn=(Button)findViewById(R.id.returnBtn);
	    returnBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    Intent intent=new Intent(DataTransferActivity.this,DataTransferReturnActivity.class);
			    startActivityForResult(intent,REQUEST_CODE);
		    }
	    });
    }

	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent pData){
		if(requestCode==REQUEST_CODE){
			if (resultCode == Activity.RESULT_OK )
			{
				final String msg = pData.getExtras().getString("msg");

				textView.setText(msg);

				return;
			}
		}

		textView.setText("No return!"+" Request Code:"+requestCode+"resultCode:"+resultCode);


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
