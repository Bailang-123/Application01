package com.example.demo04;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo04.adapter.MyAdapter;
import com.example.demo04.base.BaseActivity;
import com.example.demo04.base.BasePresenter;
import com.example.demo04.bean.MyData;
import com.example.demo04.presenter.PresenterImpl;
import com.example.demo04.url.MyUrls;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MyAdapter myAdapter;
      private RecyclerView recyclerView;
//    @BindView(R.id.quanxuan_checkbox)
//    CheckBox checkBox;
//    @BindView(R.id.zongjia_text)
//    TextView zongjia_text;
//    @BindView(R.id.suliang_text)
//    TextView suliang_text;
    private List<MyData.OrderDataBean> list = new ArrayList<>();
//    @BindView(R.id.view_pager01)
//    ViewPager viewPager;
//    @BindView(R.id.radio_group01)
//    RadioGroup radioGroup;
//    List<Fragment> list = new ArrayList<>();


    @Override
    protected void startCoding() {

        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);
        mPresenter.startGetNoParamsRequest(MyUrls.JD_ShOPPING, MyData.class);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new PresenterImpl();
    }
    @Override
    protected void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        list.add(new SYFragment());
//        list.add(new PYQFragment());
//        list.add(new GWCFragment());
//        list.add(new DDFragment());
//        list.add(new WDFragment());
//        initView();
    }

    private void initView() {
//        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @NonNull
//            @Override
//            public Fragment getItem(int position) {
//                return list.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//        });
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                radioGroup.check(radioGroup.getChildAt(position).getId());
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        viewPager.setCurrentItem(0);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.radio_button01:viewPager.setCurrentItem(0);break;
//                    case R.id.radio_button02:viewPager.setCurrentItem(1);break;
//                    case R.id.radio_button03:viewPager.setCurrentItem(2);break;
//                    case R.id.radio_button04:viewPager.setCurrentItem(3);break;
//                    case R.id.radio_button05:viewPager.setCurrentItem(4);break;
//                }
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof MyData) {
            list.addAll(((MyData) o).getOrderData());
        }
    }

    @Override
    public void onError(String error) {
    }
}
