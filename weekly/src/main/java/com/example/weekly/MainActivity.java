package com.example.weekly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weekly.base.BaseActivity;
import com.example.weekly.base.BasePresenter;
import com.example.weekly.bean.PhoneBean;
import com.example.weekly.presenter.MyPresenter;
import com.example.weekly.url.MyUrls;
import com.example.weekly.util.NetUtils;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity  {

    private EditText edit_name;
    private EditText edit_password;
    private Button button01;
    private Map<String, Object> map;
    private SharedPreferences msp;

    @Override
    protected void startComptry() {
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                String password = edit_password.getText().toString().trim();
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                map = new HashMap<>();
                Log.e("MyMessage","phone"+name+"    pwd"+password);
                map.put("phone",name);
                map.put("pwd",password);
                mpresenter.postPresenterInfo(MyUrls.LOGIN, PhoneBean.class,map);
            }
        });


    }

    @Override
    protected void initView() {
        edit_name = findViewById(R.id.edit_name);
        edit_password = findViewById(R.id.edit_password);
        button01 = findViewById(R.id.button01);
        msp = getSharedPreferences("bailang",MODE_PRIVATE);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof PhoneBean && ((PhoneBean)o).getStatus().equals("0000")){
            msp.edit().putString("userId",((PhoneBean) o).getResult().getUserId()+"").commit();
            msp.edit().putString("sessionId",((PhoneBean) o).getResult().getSessionId()+"").commit();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }else{
            Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(String error) {

    }

}
