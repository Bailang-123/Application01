package com.example.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.edit_input_box)
    TextView editInputBox;
    @BindView(R.id.button_click)
    Button buttonClick;
    @BindView(R.id.button_chuan)
    Button buttonChuan;
    @BindView(R.id.button_camera)
    Button buttonCamera;
    @BindView(R.id.button_photos)
    Button buttonPhotos;
    @BindView(R.id.image_view)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(Main2Activity.this, ""+editInputBox.getText().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @OnClick({R.id.button_click, R.id.button_chuan, R.id.button_camera, R.id.button_photos, R.id.image_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_click:
                String s = editInputBox.getText().toString();
                Bitmap image = CodeUtils.createImage(s, 200, 200, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageView.setImageBitmap(image);
                break;
            case R.id.button_chuan:
                EventBusInfo();
                break;
            case R.id.button_camera:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.button_photos:
                CodeUtils.analyzeByPhotos(this);
                break;
            case R.id.image_view:
                CodeUtils.analyzeByImageView(imageView, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, ""+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(Main2Activity.this, "成功" + result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void EventBussss(String str){
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
    }
    public void EventBusInfo(){
        EventBus.getDefault().post("123123");
    }
}
