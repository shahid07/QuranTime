package com.habeeb.qurantime;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.habeeb.qurantime.R;
import com.habeeb.qurantime.adapter.SurahListAdapter;
import com.habeeb.qurantime.database.DatabaseAccess;
import com.habeeb.qurantime.model.SurahItems;

import java.util.ArrayList;
import java.util.List;

public class AllSurahs extends AppCompatActivity {

    Toolbar toolbar;
    List<SurahItems> surahItems;
    ListView lv_surahlist;
    SurahListAdapter sa;
    String playlistname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_surahs);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        lv_surahlist = (ListView)findViewById(R.id.lv_surahList);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle(null);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Cursor cursor  = databaseAccess.getAllSurah();
        databaseAccess.close();
        sa = new SurahListAdapter(this,cursor);
        lv_surahlist.setAdapter(sa);

    }

}
