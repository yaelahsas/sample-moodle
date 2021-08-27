package com.example.moodle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhimas Panji Sastra on
 * Copyright (c)  . All rights reserved.
 * Last modified $file.lastModified
 * Made With ❤ for U
 */
public class ModelSoal {

    String pertanyaan;
    List<ModelQuiz> pilihannya = new ArrayList<>();

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public List<ModelQuiz> getPilihannya() {
        return pilihannya;
    }

    public void setPilihannya(List<ModelQuiz> pilihannya) {
        this.pilihannya = pilihannya;
    }
}
