package com.bawei.zhuoye01.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.zhuoye01.contart.MyContart;

public abstract class BaseFragment <P extends BasePersenter> extends Fragment implements MyContart.IView {
    private P mpersenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(LayoutId(), container, false);
        initView(inflate);
        mpersenter = getPersenter();
        mpersenter.OnAttchView(this);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract P getPersenter();

    protected abstract void initView(View inflate);

    protected abstract int LayoutId();
}
