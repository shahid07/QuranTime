package com.habeeb.qurantime;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.habeeb.qurantime.adapter.AyahAdapter;
import com.habeeb.qurantime.database.DatabaseAccess;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class SurahActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    ListView lv_ayaa_items;
    AyahAdapter mAyahAdapter;
    ToggleButton btn_play_pause;
    ImageButton btn_previous,btn_next;
    int surah_count, surah_number;
    String surahName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle(null);
        String language = "EN";
        surahName = "Surah"+surah_number+".mp3";
        int author_id =10;
        surah_number = getIntent().getExtras().getInt("SurahNumber");
        surah_count = getIntent().getExtras().getInt("SurahCount");
        Log.e("SurahCount",""+surah_count);
        Log.e("SurahNumber",""+surah_number);
        lv_ayaa_items = (ListView)findViewById(R.id.lv_ayah_items);
        btn_play_pause = (ToggleButton)findViewById(R.id.btn_play_pause);
        btn_play_pause.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startDownload();
                }
                else{
                    Toast.makeText(SurahActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_next = (ImageButton)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        btn_previous = (ImageButton)findViewById(R.id.btn_previous);
        btn_previous.setOnClickListener(this);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Cursor cursor  = databaseAccess.getAyahList(surah_number,language,author_id);
        databaseAccess.close();
        mAyahAdapter = new AyahAdapter(this,cursor);
        lv_ayaa_items.setAdapter(mAyahAdapter);
        mAyahAdapter.changeCursor(cursor);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_next :
                int pos = surah_number+1;
               if(pos<surah_count){
                   Intent i = new Intent(this, SurahActivity.class);
                   i.putExtra("SurahNumber",pos);
                   i.putExtra("SurahCount",surah_count);
                   overridePendingTransition( 0, 0);
                   startActivity(i);
                   overridePendingTransition( 0, 0);
                   this.finish();
               }
                else{
                   Toast.makeText(this, "No Surah Available", Toast.LENGTH_SHORT).show();
               }
                break;

            case R.id.btn_previous :
                int pos2 = surah_number-1;
                Log.e("Pos2",""+pos2);
                if(pos2>0){
                    Intent i = new Intent(this, SurahActivity.class);
                    i.putExtra("SurahNumber",pos2);
                    i.putExtra("SurahCount",surah_count);
                    overridePendingTransition( 0, 0);
                    startActivity(i);
                    overridePendingTransition( 0, 0);
                    this.finish();
                }
                else{

                }
                break;

        }
    }

    private void startDownload() {
        String url = "http://sultanete.com/FileServerWeb2/FileService?surahId="+surah_number+".mp3&deviceId=12312312312";
        new DownloadFileAsync().execute(url);
    }

    class DownloadFileAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... aurl) {
            int count;
            try {
                URL url = new URL(aurl[0]);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                int lenghtOfFile = conexion.getContentLength();
                Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+"/QuranTime"+"/"+surahName);
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress(""+(int)((total*100)/lenghtOfFile));
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {}
            return null;
        }

        protected void onProgressUpdate(String... progress) {
            Log.d("ANDRO_ASYNC",progress[0]);
        }

        @Override
        protected void onPostExecute(String unused) {
            Toast.makeText(SurahActivity.this, ""+unused, Toast.LENGTH_SHORT).show();
        }
    }
}
