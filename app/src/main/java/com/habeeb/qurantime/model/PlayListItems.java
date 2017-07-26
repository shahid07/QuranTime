package com.habeeb.qurantime.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Habeeb on 3/17/2017.
 */

public class PlayListItems implements Parcelable {

    String englishName;
    String arabicName;
    String audio;
    String playListName;
    String surahNo;

    public String getSurahNo() {
        return surahNo;
    }

    public void setSurahNo(String surahNo) {
        this.surahNo = surahNo;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public PlayListItems() {
    }

    public PlayListItems(String englishName, String arabicName, String audio) {
        this.englishName = englishName;
        this.arabicName = arabicName;
        this.audio = audio;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static Creator<PlayListItems> CREATOR = new Creator<PlayListItems>() {

        @Override
        public PlayListItems createFromParcel(Parcel source) {
            return new PlayListItems(source);
        }

        @Override
        public PlayListItems[] newArray(int size) {
            return new PlayListItems[size];
        }

    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(surahNo);
        dest.writeString(englishName);
        dest.writeString(arabicName);
        dest.writeString(playListName);
        dest.writeString(audio);
    }
    public PlayListItems (Parcel parcel) {
        this.surahNo = parcel.readString();
        this.playListName = parcel.readString();
        this.englishName = parcel.readString();
        this.arabicName = parcel.readString();
        this.audio = parcel.readString();
    }

}
