package com.lish.helloworld.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ListViewActivity extends ActionBarActivity {

    private ListView listView;

    //static String[] words = {"第一行", "第二行", "第三行"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View view;
                if(convertView==null){
                    view =inflater.inflate(R.layout.list_row,null);

                    //Log.i(this.getClass().getName(),"我们新建一个View:"+view);
                }else{
                    view=convertView;
                    TextView textView1=(TextView)view.findViewById(R.id.textView);
                    //Log.i(this.getClass().getName(),"我们用以前的View:"+" "+textView1.getText());
                }




                TextView textView=(TextView)view.findViewById(R.id.textView);

                textView.setText("这里是第"+position+"行！");

                return view;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView1=(TextView)view.findViewById(R.id.textView);
                String str="标题："+textView1.getText()+"参数1："+i+" 参数2："+l;
                Log.i(this.getClass().getName(),str);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
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
