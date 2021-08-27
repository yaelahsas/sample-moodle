package com.example.moodle.activity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moodle.Adapter.AdapterQuiz;
import com.example.moodle.config.BASE_URL;
import com.example.moodle.databinding.ActivityMengerjakanSoalBinding;
import com.example.moodle.model.ModelQuiz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MengerjakanSoal extends AppCompatActivity {

    ActivityMengerjakanSoalBinding binding;
    AdapterQuiz adapterQuiz;
    List<ModelQuiz> quizs = new ArrayList<>();
    int nextpage = 1;
    int page = 0;
    boolean masih = true;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMengerjakanSoalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        queue = Volley.newRequestQueue(this);
        getSoal(page, 7);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (masih) {
                    page++;
                    getSoal(page, 7);
                } else {
                    binding.btnNext.setVisibility(View.GONE);
                    binding.btnFinish.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void getSoal(int nomor, int attemptid) {
        quizs.clear();
        StringRequest request = new StringRequest(Request.Method.GET, BASE_URL.URL + "webservice/rest/server.php?moodlewsrestformat=json&wstoken=c59f58978da246f7577e60fd9ce177c3&wsfunction=mod_quiz_get_attempt_data&attemptid=" + attemptid + "&page=" + nomor, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    nextpage = object.getInt("nextpage");
                    if (nextpage < 0) {
                        masih = false;
                        return;
                    }

                    JSONArray array = object.getJSONArray("questions");

                    String data = array.getJSONObject(0).getString("html");
                    for (int i = 0; i < array.length(); i++) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            String str = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY).toString();
                            String a = str.replace(",", "").replace("\n", ",");
                            String[] separated = a.split(",");
//                        Log.d("SPLITNYA", Arrays.toString(separated));
                            for (int j = 0; j < separated.length; j++) {
                                Log.d("SPLITNYA" + i, separated[i]);

                            }

                            binding.judulSoal.setText(separated[10]);
                            quizs.add(new ModelQuiz(false, separated[14]));
                            quizs.add(new ModelQuiz(false, separated[18]));
                            quizs.add(new ModelQuiz(false, separated[22]));
                            quizs.add(new ModelQuiz(false, separated[26]));

                        } else {
                            String str = Html.fromHtml(data).toString();
                            String[] separated = str.split("\n");
                            Log.d("HTMLNYA2", Arrays.toString(separated));
                        }
                    }

                    adapterQuiz = new AdapterQuiz((ArrayList<ModelQuiz>) quizs, MengerjakanSoal.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MengerjakanSoal.this, LinearLayoutManager.VERTICAL, false);
                    binding.listPilihan.setLayoutManager(linearLayoutManager);
                    binding.listPilihan.setAdapter(adapterQuiz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }
}