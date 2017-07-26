package com.habeeb.qurantime.database;

/**
 * Created by Habeeb on 3/21/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.habeeb.qurantime.adapter.SurahListAdapter;
import com.habeeb.qurantime.model.PlayListItems;
import com.habeeb.qurantime.model.SurahItems;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public Cursor getAllSurah() {
        Cursor cursor = database.rawQuery("SELECT surah_num as _id, surah_name, surah_name_arabic FROM surah", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor getAyahList(int surahNo,String lang,int author_id){
        Log.e("SurahNoLang",""+surahNo+lang);
        Cursor cursor = database.rawQuery("SELECT ayah.ayah_id as _id, ayah.ayah_text_arabic,ayah.ayah_id, ayah.surah_num, ayah_translation.ayah_translation FROM ayah JOIN ayah_translation ON ayah.ayah_id = ayah_translation.ayah_id WHERE ayah_translation_language LIKE "+"'"+lang+"'"+" and surah_num LIKE "+surahNo+" and ayah_translation_author LIKE "+author_id, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
