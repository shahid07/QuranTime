package com.shahid.qurantime;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.shahid.qurantime.adapter.SurahListAdapter;
import com.shahid.qurantime.database.DatabaseAccess;
import com.shahid.qurantime.model.SurahItems;

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
