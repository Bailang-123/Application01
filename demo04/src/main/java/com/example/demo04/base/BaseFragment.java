package com.example.demo04.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo04.contract.IContarct;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IContarct.IView {
    public P mpresenter;
    private EventBus eventBus;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        bind = ButterKnife.bind(getActivity());
        eventBus = EventBus.getDefault();
        mpresenter = getPresenter();
        mpresenter.onAttch(this);
        return inflate;
    }

    public void EvetBusDefelt(){
        eventBus.register(this);
    }

    protected abstract void startCompry();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract P getPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();
}
