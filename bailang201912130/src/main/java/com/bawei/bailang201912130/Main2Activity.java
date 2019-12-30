package com.bawei.bailang201912130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
  private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.text_view01);
        textView.setText("{\"result\":[{\"imageUrl\":\"http://172.17.8.100/images/small/banner/cj.png\",\"jumpUrl\":\"http://172.17.8.100/htm/lottery/index.html\",\"rank\":5,\"title\":\"抽奖\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/hzp.png\",\"jumpUrl\":\"wd://commodity_list?arg=1001007005\",\"rank\":5,\"title\":\"美妆工具\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/lyq.png\",\"jumpUrl\":\"wd://commodity_info?arg=83\",\"rank\":5,\"title\":\"连衣裙\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/px.png\",\"jumpUrl\":\"wd://commodity_info?arg=165\",\"rank\":5,\"title\":\"跑鞋\"},{\"imageUrl\":\"http://172.17.8.100/images/small/banner/wy.png\",\"jumpUrl\":\"wd://commodity_list?arg=1001002004\",\"rank\":5,\"title\":\"卫衣\"}],\"message\":\"查询成功\",\"status\":\"0000\"}");
    }
}
