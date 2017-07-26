package com.habeeb.qurantime.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.habeeb.qurantime.AllSurahs;
import com.habeeb.qurantime.R;
import com.habeeb.qurantime.SurahActivity;
import com.habeeb.qurantime.model.PlayListItems;
import com.habeeb.qurantime.model.SurahItems;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Habeeb on 12/14/2016.
 */

public class SurahListAdapter extends CursorAdapter {

    public SurahListAdapter(Context context, Cursor c) {
        super(context, c);



    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_playlist, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        view.setClickable(true);
        view.setFocusable(true);

        TextView tv_id = (TextView)view.findViewById(R.id.tv_id1);
        TextView tv_name_english = (TextView)view.findViewById(R.id.tv_english_name1);
        TextView tv_name_arabic = (TextView)view.findViewById(R.id.tv_arabic_name1);
                tv_id.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
                tv_name_english.setText(cursor.getString(cursor.getColumnIndexOrThrow("surah_name")));
                tv_name_arabic.setText(cursor.getString(cursor.getColumnIndexOrThrow("surah_name_arabic")));
               /* cursor.moveToNext();*/
           final int postion  = cursor.getPosition();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,SurahActivity.class);
                i.putExtra("SurahNumber",postion+1);
                i.putExtra("SurahCount",cursor.getCount());
                context.startActivity(i);
            }
        });
    }
}
