package com.bawei.bailang20191216;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.bailang20191216.base.BaseActivity;
import com.bawei.bailang20191216.base.BasePresenter;
import com.bawei.bailang20191216.bean.PhoneBean;
import com.bawei.bailang20191216.presenter.MyPresenter;
import com.bawei.bailang20191216.url.MyUrls;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private SharedPreferences preferences;
    private EditText edit_name;
    private EditText edit_pwd;
    private Button dl_button;

    @Override
    protected void startEormay() {
        dl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(MainActivity.this, "输入的账号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd = edit_pwd.getText().toString().trim();
                if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity.this, "输入的密码不能为空", Toast.LENGTH_SHORT).show();
                }
                Map<String,Object> map = new HashMap<>();
                map.put("phone",name);
                map.put("pwd",pwd);
                mpresenter.postPresenterInfo(MyUrls.PHONEWEI,map, PhoneBean.class);
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        preferences = getSharedPreferences("bailang", MODE_PRIVATE);
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        dl_button = findViewById(R.id.dl_button);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof PhoneBean&&((PhoneBean) o).getStatus().equals("0000")){
            PhoneBean.ResultBean  resultBean = new PhoneBean.ResultBean();
            preferences.edit().putString("userId",resultBean.getUserId()+"").commit();
            preferences.edit().putString("sessionId",resultBean.getSessionId()+"").commit();
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
