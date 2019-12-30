package com.example.bailang20191206.util;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bailang20191206.app.MyApp;

public class NetUtil {
    private RequestQueue requestQueue;
    public NetUtil(){
        requestQueue = Volley.newRequestQueue(MyApp.context);
    }
    public static class Util{
        private static final NetUtil NET_UTIL = new NetUtil();
    }

    public static NetUtil getInstance() {
        return Util.NET_UTIL;
    }

    public void doGet(String url, final SetSuccess success){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                success.OnSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                success.OnError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface SetSuccess{
        void OnSuccess(String url);
        void OnError(String error);
    }
}
