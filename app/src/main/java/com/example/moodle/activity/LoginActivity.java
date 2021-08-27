package com.example.moodle.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moodle.config.BASE_URL;
import com.example.moodle.config.SessionManager;
import com.example.moodle.databinding.ActivityLoginBinding;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    RequestQueue queue;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        queue = Volley.newRequestQueue(this);
        binding.btnLogin.setOnClickListener(v -> Login(binding.username.getText().toString(), binding.password.getText().toString()));
    }

    private void Login(String username, String password) {
        String url = BASE_URL.URL + "login/token.php?username=" + username + "&password=" + password + "&service=moodle_mobile_app";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    if (!object.has("error")) {

                        getProfil(object.getString("token"));
                        Toast.makeText(LoginActivity.this, object.getString("token"), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();

                    }
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

    private void getProfil(String token) {
        String url = BASE_URL.URL + "webservice/rest/server.php?moodlewsrestformat=json&wstoken=" + token + "&wsfunction=core_webservice_get_site_info";
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject object = new JSONObject(response);
                Log.d("Response", object.toString());
                SessionManager.setid(LoginActivity.this, String.valueOf(object.getInt("userid")));
                SessionManager.setKey_nama(LoginActivity.this, object.getString("fullname"));
                SessionManager.setLogin(LoginActivity.this, true);
                SessionManager.setKey_token(LoginActivity.this, token);
                startActivity(new Intent(LoginActivity.this, Beranda.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }
}