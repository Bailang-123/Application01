package com.example.demo01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Open_Camera;
    private EditText Generate_Text;
    private Button Generate_Btn;
    private ImageView My_Image;
    private TextView Get_Text;
    private final int STATUS_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        Open_Camera = findViewById(R.id.Open_Camera);
        Generate_Text = findViewById(R.id.Generate_Text);
        Generate_Btn = findViewById(R.id.Generate_Btn);
        My_Image = findViewById(R.id.My_Image);
        Get_Text = findViewById(R.id.Get_Text);

        Open_Camera.setOnClickListener(this);
        Generate_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Open_Camera:
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, STATUS_CODE);
                break;
            case R.id.Generate_Btn:
                String content = Generate_Text.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xiao_icon);
                    Bitmap image = CodeUtils.createImage(content, 300, 300, null);
                    My_Image.setImageBitmap(image);
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STATUS_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String type = data.getStringExtra("result_type");
                String result_string = data.getStringExtra("result_string");
                Get_Text.setText(type + result_string + "");
                Log.e("type", type + "");
                Log.e("result_string", result_string + "");
            }

        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
