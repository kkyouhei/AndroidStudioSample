package com.example.kkyouhei.SDK330_4_karino.controller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.kkyouhei.SDK330_4_karino.R;
import com.example.kkyouhei.SDK330_4_karino.model.AppModel;
import com.example.kkyouhei.SDK330_4_karino.model.Model;
import com.example.kkyouhei.SDK330_4_karino.model.News;
import com.example.kkyouhei.SDK330_4_karino.model.Qiita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// GAME FEAT
import jp.basicinc.gamefeat.android.sdk.controller.GameFeatAppController;

public class MainActivity extends ActionBarActivity{
    final GameFeatAppController gfAppController = new GameFeatAppController();

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
        Qiita qiita = new Qiita(new Model() {
            public void onPreExecute() {
                // do something
            }
            public void onProgressUpdate(int progress) {
                // do something
            }
            public void onPostExecute(String result) {
                // do something
                Log.d("onPostExecute", result);
            }
            public void onCancelled() {
                // do something
            }
        });
        qiita.getPublicTimeline();
    }

    @Override
    public void onStart(){
        super.onStart();
        gfAppController.activateGF(MainActivity.this, false, true, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        News news = new News();
        ArrayList <Map<String, String>>list = news.getNews();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"main", "sub"},
                new int[]{android.R.id.text1, android.R.id.text2});

                ListView listView = (ListView)findViewById(R.id.contents);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("debug", "click is content item");

                HashMap<String,String> value = (HashMap<String, String>)parent.getItemAtPosition(position);
                if(value.get("is_ad").equals("1")) {
                    gfAppController.show(MainActivity.this);
                    return;
                }
                Intent i = new Intent(getApplicationContext(), ContentActivity.class);
                i.putExtra("title", value.get("main"));
                i.putExtra("content", value.get("sub"));
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
