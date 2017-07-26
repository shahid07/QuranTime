package com.shahid.qurantime.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shahid.qurantime.R;
import com.shahid.qurantime.database.TinyDB;
import com.shahid.qurantime.model.AddPlaylistItems;

/**
 * Created by Habeeb on 3/17/2017.
 */

public class DialogActivity extends Activity {
    TinyDB tydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        final EditText et_playlist = (EditText)findViewById(R.id.et_playList);
        et_playlist.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        Button btn_cancle =(Button)findViewById(R.id.btn_cancel);
        Button btn_add =(Button)findViewById(R.id.btn_addList);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playListName = et_playlist.getText().toString().trim();
                if(playListName.equals("")){
                    et_playlist.setError("EnterValidName");

                }
                else{
                    AddPlaylistItems listItems = new AddPlaylistItems(playListName);
                    try {
                        Intent i = new Intent(DialogActivity.this, AddPlaylistDialog.class);
                        tydb = new TinyDB(DialogActivity.this);
                        tydb.putString("PlayListName",playListName);
                        startActivity(i);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });


    }

}
