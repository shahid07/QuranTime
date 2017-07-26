package com.habeeb.qurantime.model;

/**
 * Created by Habeeb on 3/17/2017.
 */

public class SurahItems {
    int id;
    String name_english;
    String name_arabic;
    String audio;

    public SurahItems() {
    }

    public SurahItems(int id, String name_english, String name_arabic) {
        this.id = id;
        this.name_english = name_english;
        this.name_arabic = name_arabic;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_english() {
        return name_english;
    }

    public void setName_english(String name_english) {
        this.name_english = name_english;
    }

    public String getName_arabic() {
        return name_arabic;
    }

    public void setName_arabic(String name_arabic) {
        this.name_arabic = name_arabic;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
