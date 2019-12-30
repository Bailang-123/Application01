package com.bawei.bailang20191203.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.bailang20191203.contart.MyContart;

public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements MyContart.IView {
    public P mPersneter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate( layoutId(),container, false);
        initView(inflate);
        mPersneter = getPresenter();
        mPersneter.onAttchView(this);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPersneter != null) {
            mPersneter.onDreAttchView();
        }
    }

    protected abstract void initDatas();

    protected abstract P getPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();
}
