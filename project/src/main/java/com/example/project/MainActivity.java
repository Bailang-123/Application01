package com.example.project;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.project.base.BaseActivity;
import com.example.project.base.BasePersenter;
import com.example.project.fragmet.Friends_Fragment;
import com.example.project.fragmet.Home_Page_Fragment;
import com.example.project.fragmet.MyFragment;
import com.example.project.fragmet.OrderFragment;
import com.example.project.fragmet.ShoppingFragment;
import com.example.project.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> list = new ArrayList<>();


    @Override
    protected void startCompy() {

    }

    @Override
    protected BasePersenter getPersenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        radioGroup = findViewById(R.id.radio_group01);
        viewPager = findViewById(R.id.ViewPager01);
        Friends_Fragment friends_fragment = new Friends_Fragment();
        list.add(friends_fragment);
        Home_Page_Fragment home_page_fragment = new Home_Page_Fragment();
        list.add(home_page_fragment);
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        list.add(shoppingFragment);
        OrderFragment orderFragment = new OrderFragment();
        list.add(orderFragment);
        MyFragment myFragment = new MyFragment();
        list.add(myFragment);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.shouye_button:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.pengyouquan_button:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.gouwuche_button:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.dingdan_button:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.wode_button:
                        viewPager.setCurrentItem(4);
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
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }

}
