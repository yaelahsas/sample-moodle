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
import com.example.moodle.Adapter.AdapterSoal;
import com.example.moodle.config.BASE_URL;
import com.example.moodle.databinding.ActivityWebViewQuizBinding;
import com.example.moodle.model.ModelQuiz;
import com.example.moodle.model.ModelSoal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class WebViewQuiz extends AppCompatActivity {

    ActivityWebViewQuizBinding binding;
    AdapterSoal adapterQuiz;
    int page = 0;
    int nextpage = 1;
    boolean masih = true;
    RequestQueue queue;
    ArrayList<ModelQuiz> quizs = new ArrayList<>();
    ArrayList<ModelSoal> soals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        queue = Volley.newRequestQueue(this);
        getSoal(page);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (masih) {
                    page++;
                    getSoal(page);

                }
            }
        });
    }

    public void getSoal(int nomor) {
        quizs.clear();
        ArrayList<ModelSoal> simpanSoal = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, BASE_URL.URL + "webservice/rest/server.php?moodlewsrestformat=json&wstoken=c59f58978da246f7577e60fd9ce177c3&wsfunction=mod_quiz_get_attempt_data&attemptid=7&page=" + nomor, new Response.Listener<String>() {
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
                        ModelSoal modelSoal = new ModelSoal();
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            String str = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY).toString();
                            String a = str.replace(",", "").replace("\n", ",");
                            String[] separated = a.split(",");
//                        Log.d("SPLITNYA", Arrays.toString(separated));
                            for (int j = 0; j < separated.length; j++) {
                                Log.d("SPLITNYA" + i, separated[i]);

                            }
                            modelSoal.setPertanyaan(separated[10]);
                            quizs.add(new ModelQuiz(false, separated[14]));
                            quizs.add(new ModelQuiz(false, separated[18]));
                            quizs.add(new ModelQuiz(false, separated[22]));
                            quizs.add(new ModelQuiz(false, separated[26]));
                            modelSoal.setPilihannya(quizs);
                            simpanSoal.add(modelSoal);
                        } else {
                            String str = Html.fromHtml(data).toString();
                            String[] separated = str.split("\n");
                            Log.d("HTMLNYA2", Arrays.toString(separated));
                        }
                    }
                    soals.addAll(simpanSoal);
                    adapterQuiz = new AdapterSoal(soals, WebViewQuiz.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WebViewQuiz.this, LinearLayoutManager.VERTICAL, false);
                    binding.rcSoal.setLayoutManager(linearLayoutManager);
                    binding.rcSoal.setAdapter(adapterQuiz);
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