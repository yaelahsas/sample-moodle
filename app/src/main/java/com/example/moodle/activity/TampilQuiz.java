package com.example.moodle.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moodle.Adapter.AdapterQuizByCourse;
import com.example.moodle.config.BASE_URL;
import com.example.moodle.config.SessionManager;
import com.example.moodle.databinding.ActivityTampilQuizBinding;
import com.example.moodle.model.ModelQuizByCourse;
import com.example.moodle.model.ModelUserCourse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TampilQuiz extends AppCompatActivity {


    ActivityTampilQuizBinding binding;
    List<ModelQuizByCourse> quizByCourses = new ArrayList<>();
    RequestQueue queue;
    AdapterQuizByCourse adapterQuizByCourse;
    ModelUserCourse course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTampilQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        queue = Volley.newRequestQueue(this);

        if (getIntent().hasExtra("course")) {
            course = getIntent().getParcelableExtra("course");
        }
        getQuiz(SessionManager.getKey_token(TampilQuiz.this), course.getId());

    }

    void getQuiz(String token, int course_id) {
        String url = BASE_URL.URL + "webservice/rest/server.php?moodlewsrestformat=json&wstoken=" + token + "&wsfunction=mod_quiz_get_quizzes_by_courses&courseids[0]=" + course_id;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("quizzes");
                    if (array.length() == 0) {
                        Toast.makeText(TampilQuiz.this, "Tidak Ada Quiz", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject data = array.getJSONObject(i);
                        ModelQuizByCourse quizByCourse = new ModelQuizByCourse();
                        quizByCourse.setName(data.getString("name"));
                        quizByCourse.setAttempts(data.getInt("attempts"));
                        quizByCourse.setTimelimit(data.getInt("timelimit"));
                        quizByCourse.setTimeclose(data.getInt("timeclose"));
                        quizByCourses.add(quizByCourse);
                    }
                    adapterQuizByCourse = new AdapterQuizByCourse((ArrayList<ModelQuizByCourse>) quizByCourses, TampilQuiz.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TampilQuiz.this, LinearLayoutManager.VERTICAL, false);
                    binding.listCourseQuiz.setLayoutManager(linearLayoutManager);
                    binding.listCourseQuiz.setAdapter(adapterQuizByCourse);
                } catch (JSONException e) {
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