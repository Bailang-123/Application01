package com.bawei.zhuoye01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.zhuoye01.base.BaseActivity;
import com.bawei.zhuoye01.base.BasePersenter;
import com.bawei.zhuoye01.persenter.MyPersenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> list = new ArrayList<>();
    @Override
    protected void startEonder() {

    }

    @Override
    protected BasePersenter getPesenter() {
        return new MyPersenter();
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.view_pager01);
        radioGroup = findViewById(R.id.radio_group01);
        list.add(new ShouYeFragment());
        list.add(new LieBiaoFragment());
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
        viewPager.setCurrentItem(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.shouye_button:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.liebiao_button:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void OnSuccess(String url) {

    }

    @Override
    public void OnError(String error) {

    }
}
