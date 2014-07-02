package com.lish.helloworld.app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ContactActivity extends ActionBarActivity {

    private Button pickBtn;
    private TextView textView;

    private final static int CODE=221;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        textView=(TextView)findViewById(R.id.textView);

        pickBtn=(Button)findViewById(R.id.pickBtn);
        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= ContactsContract.Contacts.CONTENT_URI;
                Log.i(this.getClass().getName(), "链接地址："+uri);
                Intent intent=new Intent(Intent.ACTION_PICK,uri);
                startActivityForResult(intent,CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==CODE){
            switch (resultCode){
                case Activity.RESULT_OK:
                    Uri resultUri = data.getData();
                    textView.setText(" "+resultUri);
                    Log.i(this.getClass().getName(),"获取到的链接："+resultUri);

                    if(resultUri!=null){
                        Cursor cont = getContentResolver().query(resultUri, null, null, null, null);

                        if(cont!=null){
                            for(cont.moveToFirst();!cont.isAfterLast();cont.moveToNext())
                            {
                                //获取联系人的ID
                                String contactId = cont.getString(cont.getColumnIndex(ContactsContract.Contacts._ID));
                                //获取联系人的姓名 萌萌
                                String name = cont.getString(cont.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                                Log.i(this.getClass().getName(),"获取到的内容："+contactId+" "+name);
                                textView.setText("编号："+contactId+" 姓名:"+name);
                            }


                        }

                    }
                    break;


                default:
                    Log.i(this.getClass().getName(),"没有获取到联系人！"+resultCode);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contact, menu);
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
