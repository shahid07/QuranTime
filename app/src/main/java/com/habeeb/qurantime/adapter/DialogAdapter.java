package com.habeeb.qurantime.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.habeeb.qurantime.R;
import com.habeeb.qurantime.SurahActivity;
import com.habeeb.qurantime.model.SurahItems;

import java.util.ArrayList;

/**
 * Created by Habeeb on 12/14/2016.
 */

public class DialogAdapter extends CursorAdapter {
    ArrayList<SurahItems>  items = new ArrayList();
    public DialogAdapter(Context context, Cursor c) {
        super(context, c);



    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_dialog_items, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView tv_id = (TextView)view.findViewById(R.id.tv_id_dialog);
        TextView tv_name_english = (TextView)view.findViewById(R.id.tv_english_name_dialog);
        TextView tv_name_arabic = (TextView)view.findViewById(R.id.tv_arabic_name_dialog);
        ToggleButton add_playList = (ToggleButton) view.findViewById(R.id.btn_add_to_playList_dialog);
        final String id = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        final String surah_name = cursor.getString(cursor.getColumnIndexOrThrow("surah_name"));
        final String surah_name_arabic = cursor.getString(cursor.getColumnIndexOrThrow("surah_name_arabic"));
                tv_id.setText(id);
                tv_name_english.setText(surah_name);
                tv_name_arabic.setText(surah_name_arabic);
               /* cursor.moveToNext();*/
            final int postion  = cursor.getPosition();

          add_playList.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if(isChecked){

                      SurahItems si = new SurahItems();
                      si.setId(Integer.parseInt(id));
                      si.setName_english(surah_name);
                      si.setName_arabic(surah_name_arabic);
                      items.add(si);
                      Toast.makeText(context, ""+items.get(postion).getId()+" "+items.get(postion).getName_english()+" "+items.get(postion).getName_arabic(), Toast.LENGTH_SHORT).show();
                      Toast.makeText(context, ""+postion, Toast.LENGTH_SHORT).show();
                  }
                  else{
                    /*  si.setId(Integer.parseInt(id));
                      si.setName_english(surah_name);
                      si.setName_arabic(surah_name_arabic);*/
                      //items.remove(si);
/*
                      Toast.makeText(context, ""+items.get(postion).getId()+" "+items.get(postion).getName_english()+" "+items.get(postion).getName_arabic(), Toast.LENGTH_SHORT).show();
*/
                  }
              }
          });

    }
}
