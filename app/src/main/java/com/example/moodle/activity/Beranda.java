package com.example.moodle.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.moodle.Adapter.AdapterCourse;
import com.example.moodle.config.BASE_URL;
import com.example.moodle.config.SessionManager;
import com.example.moodle.databinding.ActivityBerandaBinding;
import com.example.moodle.model.ModelUserCourse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Beranda extends AppCompatActivity {

    ActivityBerandaBinding binding;
    AdapterCourse adapterCourse;
    RequestQueue queue;
    List<ModelUserCourse> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBerandaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        queue = Volley.newRequestQueue(this);
        Log.d("userid", SessionManager.getId(Beranda.this));
        getCourse(SessionManager.getKey_token(Beranda.this), Integer.parseInt(SessionManager.getId(Beranda.this)));
    }

    void getCourse(String token, int userid) {
        String url = BASE_URL.URL + "webservice/rest/server.php?moodlewsrestformat=json&wstoken=" + token + "&wsfunction=core_enrol_get_users_courses&userid=" + userid;
        Log.d("url", url);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {

            try {
                for (int i = 0; i < response.length(); i++) {
                    ModelUserCourse course = new ModelUserCourse();
                    JSONObject object = response.getJSONObject(i);
                    course.setFullname(object.getString("fullname"));
                    course.setId(object.getInt("id"));
                    courseList.add(course);
                }

                adapterCourse = new AdapterCourse((ArrayList<ModelUserCourse>) courseList, Beranda.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Beranda.this, LinearLayoutManager.VERTICAL, false);
                binding.listCourse.setLayoutManager(linearLayoutManager);
                binding.listCourse.setAdapter(adapterCourse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }
}