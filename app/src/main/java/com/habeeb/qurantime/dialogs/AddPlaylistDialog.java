package com.habeeb.qurantime.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.habeeb.qurantime.R;
import com.habeeb.qurantime.adapter.DialogAdapter;
import com.habeeb.qurantime.adapter.SurahListAdapter;
import com.habeeb.qurantime.database.DatabaseAccess;
import com.habeeb.qurantime.database.TinyDB;

import java.util.ArrayList;

public class AddPlaylistDialog extends Activity {

    ListView lv_addPlayList;
    Button btn_done;
    DialogAdapter mDialogAdapter;
    DatabaseAccess database;
    ArrayList<String> playListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_playlist_dialog);
        lv_addPlayList = (ListView)findViewById(R.id.lv_dialog);
        database = DatabaseAccess.getInstance(this);
        database.open();
        Cursor cursor  = database.getAllSurah();
        database.close();
        btn_done = (Button)findViewById(R.id.done);
        mDialogAdapter = new DialogAdapter(this,cursor);
        lv_addPlayList.setAdapter(mDialogAdapter);
        mDialogAdapter.changeCursor(cursor);

    }
}
