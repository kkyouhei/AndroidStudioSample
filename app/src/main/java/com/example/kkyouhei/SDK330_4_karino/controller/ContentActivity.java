package com.example.kkyouhei.SDK330_4_karino.controller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kkyouhei.SDK330_4_karino.R;

import jp.basicinc.gamefeat.android.sdk.controller.GameFeatAppController;
import jp.basicinc.gamefeat.android.sdk.view.GameFeatIconView;


public class ContentActivity extends ActionBarActivity {
    final GameFeatAppController gfAppController = new GameFeatAppController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent i = getIntent();
        Log.d("debug", "title value : " + i.getStringExtra("title"));
        Log.d("debug", "content value : " + i.getStringExtra("content"));

        // アイコン広告の自動更新間隔（秒）指定：標準で30秒
        gfAppController.setRefreshInterval(30);
        // 広告設定初期化
        gfAppController.init(ContentActivity.this);

        ((GameFeatIconView) findViewById(R.id.gf_icon1)).addLoader(gfAppController);
        ((GameFeatIconView) findViewById(R.id.gf_icon2)).addLoader(gfAppController);
        ((GameFeatIconView) findViewById(R.id.gf_icon3)).addLoader(gfAppController);
        ((GameFeatIconView) findViewById(R.id.gf_icon4)).addLoader(gfAppController);

        // 全画面
        gfAppController.setPopupProbability(1);
        gfAppController.showPopupAdDialog(ContentActivity.this);
    }

    @Override
    public void onStart(){
        super.onStart();
        gfAppController.activateGF(ContentActivity.this, false, true, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content, menu);
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

    @Override
    public void onResume() {
        super.onResume();
        // アイコン広告の自動更新開始
        gfAppController.startIconAd();
    }

    @Override
    public void onStop() {
        super.onStop();
        // アイコン広告の自動更新停止
        gfAppController.stopIconAd();
    }
}
