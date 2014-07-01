package com.lish.helloworld.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class EmailActivity extends ActionBarActivity {
    private static final String tag="EmailActivity";

    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        sendBtn=(Button)findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/html");
                emailIntent.putExtra(Intent.EXTRA_TITLE,"My Email Title");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"My Email Subject");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"lish516@gmail.com","706537610@qq.com"});

                emailIntent.putExtra(Intent.EXTRA_TEXT,getString(R.string.email_content));

                startActivityForResult(emailIntent, 2);
            }
        });
    }

    //转跳的回调函数
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i("邮件发送结果回调：", requestCode + " " + resultCode);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
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
