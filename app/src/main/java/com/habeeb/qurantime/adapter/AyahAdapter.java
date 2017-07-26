package com.habeeb.qurantime.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.habeeb.qurantime.R;

/**
 * Created by Habeeb on 12/14/2016.
 */

public class AyahAdapter extends CursorAdapter {


    public AyahAdapter(Context context, Cursor c) {
        super(context, c);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_ayah_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final int count = cursor.getPosition();
        Log.e("Counts",""+count);
      // TextView tv_id = (TextView)view.findViewById(R.id.tv_ayah_number);
        TextView tv_name_arabic = (TextView)view.findViewById(R.id.tv_arabic_ayah);
        TextView tv_name_english =(TextView)view.findViewById(R.id.tv_name_english);
      // tv_id.setText(String.valueOf(count+1));
        tv_name_english.setText(String.valueOf(count+1)+"."+cursor.getString(cursor.getColumnIndexOrThrow("ayah_translation")));
                tv_name_arabic.setText(cursor.getString(cursor.getColumnIndexOrThrow("ayah_text_arabic")));
                cursor.moveToNext();
    }

    @Override
    public int getCount() {
        return getCursor().getCount();
    }

}
