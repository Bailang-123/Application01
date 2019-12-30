package com.bawei.bailang20191203;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.bailang20191203.base.BaseActivity;
import com.bawei.bailang20191203.base.BasePresenter;
import com.bawei.bailang20191203.fragment.FuKuan_Fragment;
import com.bawei.bailang20191203.fragment.KaGuanLi_Fragment;
import com.bawei.bailang20191203.fragment.ShouKuan_Fragment;
import com.bawei.bailang20191203.fragment.ZhiFu_Fragment;
import com.bawei.bailang20191203.persenter.MyPersneter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {
    Unbinder unbinder;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment>list = new ArrayList<>();

    @Override
    protected void startPersenter() {
    }

    @Override
    protected BasePresenter getPersenter() {
        return new MyPersneter();
    }

    @Override
    protected void initView() {
        unbinder  = ButterKnife.bind(this);
        viewPager = findViewById(R.id.view_Pager01);
        radioGroup = findViewById(R.id.radio_group01);
        list.add(new ZhiFu_Fragment());
        list.add(new ShouKuan_Fragment());
        list.add(new FuKuan_Fragment());
        list.add(new KaGuanLi_Fragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fk_button:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.sk_button:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.sys_button:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.kgl_button:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(String url) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
