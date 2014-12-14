package com.example.kkyouhei.sampleapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup group = (ViewGroup)findViewById(R.id.header_container);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("debug", "header button is click");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        News news = new News();
        final ArrayList <Map<String, String>>list = news.getNews();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                news.getNews(),
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"main", "sub"},
                new int[]{android.R.id.text1, android.R.id.text2});

        ListView listView = (ListView)findViewById(R.id.contents);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("debug", "click is content item");
                Intent i = new Intent(getApplicationContext(), ContentActivity.class);
                Map <String, String>news = list.get(position);
                i.putExtra("title", news.get("main"));
                i.putExtra("content", news.get("sub"));
                startActivity(i);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
