package com.shahid.qurantime.dialogs;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.shahid.qurantime.R;
import com.shahid.qurantime.adapter.DialogAdapter;
import com.shahid.qurantime.database.DatabaseAccess;

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
