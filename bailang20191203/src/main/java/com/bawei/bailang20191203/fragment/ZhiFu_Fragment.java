package com.bawei.bailang20191203.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.bailang20191203.R;
import com.bawei.bailang20191203.base.BaseFragment;
import com.bawei.bailang20191203.base.BasePresenter;
import com.bawei.bailang20191203.persenter.MyPersneter;
import com.uuzuche.lib_zxing.activity.CodeUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiFu_Fragment extends BaseFragment {

    private EditText editText;
    private ImageView imageView;
    private Button button;
    @Override
    protected void initDatas() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPersneter();
    }

    @Override
    protected void initView(View inflate) {
        editText = inflate.findViewById(R.id.edit_text01);
        imageView = inflate.findViewById(R.id.image_view01);
        button = inflate.findViewById(R.id.button01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = editText.getText().toString().trim();
                Log.e("text",trim);
                if(trim.isEmpty()){
                    Toast.makeText(getActivity(), "你没写数据", Toast.LENGTH_SHORT).show();
                }else {
                    Bitmap bitmap = CodeUtils.createImage(trim,200,200,null);
                    imageView.setImageBitmap(bitmap);
                }
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_zhi_fu_;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(String url) {

    }
}
