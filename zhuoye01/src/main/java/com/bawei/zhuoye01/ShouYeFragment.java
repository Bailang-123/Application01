package com.bawei.zhuoye01;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.zhuoye01.base.BaseFragment;
import com.bawei.zhuoye01.base.BasePersenter;
import com.bawei.zhuoye01.persenter.MyPersenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouYeFragment extends BaseFragment {

    private ImageView imageView;
    private EditText editText;
    private Button button;

    @Override
    protected void initData() {

    }

    @Override
    protected BasePersenter getPersenter() {
        return new MyPersenter();
    }

    @Override
    protected void initView(View inflate) {
        imageView = inflate.findViewById(R.id.shouye_imageview);
        editText = inflate.findViewById(R.id.edit_text01);
        button = inflate.findViewById(R.id.shouye_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = editText.getText().toString().trim();
                if(trim.isEmpty()){
                    Toast.makeText(getActivity(), "不能为null", Toast.LENGTH_SHORT).show();
                }else{
                    Bitmap image = CodeUtils.createImage(trim, 200, 200, null);
                    imageView.setImageBitmap(image);
                }
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_shou_ye;
    }

    @Override
    public void OnSuccess(String url) {

    }

    @Override
    public void OnError(String error) {

    }
}
