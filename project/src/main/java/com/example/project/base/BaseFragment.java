package com.example.project.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project.contrat.IContrat;

public abstract class BaseFragment<P extends BasePersenter> extends Fragment implements IContrat.IView {
    public P mpresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        mpresenter = getPresenter();
        if (mpresenter != null) {
            mpresenter.onAttchView(this);
        }
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.onDreaAttchView();
        }
    }

    protected abstract void initData();

    protected abstract P getPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();
}
