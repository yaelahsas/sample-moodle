package com.example.moodle.model;

/**
 * Created by Dhimas Panji Sastra on
 * Copyright (c)  . All rights reserved.
 * Last modified $file.lastModified
 * Made With ❤ for U
 */
public class ModelQuiz {
    boolean isSelected = false;
    String soal;

    public ModelQuiz(boolean isSelected, String soal) {
        this.isSelected = isSelected;
        this.soal = soal;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
}
