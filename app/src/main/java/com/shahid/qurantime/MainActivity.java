package com.shahid.qurantime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.shahid.qurantime.dialogs.DialogActivity;
import com.shahid.qurantime.model.PlayListItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mtoolbar;
    Button  addPlayList,allSurahs,freeSurahs;
    ArrayList<String> playList1;
    ListView lv_playList;

    ArrayList<PlayListItems> playListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playList1 = new ArrayList<>();
        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
       getSupportActionBar().setTitle(null);
;        addPlayList =(Button)findViewById(R.id.btn_addPlayList);
        allSurahs = (Button)findViewById(R.id.btn_allSurah);

        freeSurahs = (Button)findViewById(R.id.btn_freeSurah);
        lv_playList = (ListView)findViewById(R.id.lv_mainPlayList);
        addPlayList.setOnClickListener(this);
        allSurahs.setOnClickListener(this);
        freeSurahs.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_addPlayList:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.btn_allSurah:
                Intent i = new Intent(this, AllSurahs.class);
                startActivity(i);
                break;
            case R.id.btn_freeSurah:

                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
