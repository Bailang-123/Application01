package com.bawei.bailang.volley;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.bailang.app.MyApp;

public class MyVolley {
    private RequestQueue requestQueue;
    public MyVolley(){
        requestQueue = Volley.newRequestQueue(MyApp.context);
    }
    public static class Volleys {
        public static final MyVolley myvolley = new MyVolley();
    }

    public static MyVolley getInstance() {
        return Volleys.myvolley;
    }

    public void doGet(final String url, final setSuccess success){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                success.onSuccess(url);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                success.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public  interface setSuccess{
        void onSuccess(String url);
        void onError(String error);
    }
}
