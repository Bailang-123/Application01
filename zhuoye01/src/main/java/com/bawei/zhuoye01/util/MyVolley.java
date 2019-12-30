package com.bawei.zhuoye01.util;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhuoye01.app.MyApp;

import java.util.PriorityQueue;

public class MyVolley {
    private RequestQueue requestQueue;
    public MyVolley(){
        requestQueue= Volley.newRequestQueue(MyApp.context);
    }

    public  static  class  myVolley{
        public static final MyVolley volley = new MyVolley();
    }

    public static MyVolley getInstance() {
        return myVolley.volley;
    }

    public  void  doGet(String url, final setSuccess setSuccess){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                setSuccess.OnSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setSuccess.OnError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface setSuccess{
        void OnSuccess(String url);
        void OnError(String error);
    }
}
