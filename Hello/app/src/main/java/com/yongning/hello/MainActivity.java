package com.yongning.hello;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yongning.hello.fragment.home_fragment;
import com.yongning.hello.fragment.message_fragment;
import com.yongning.hello.fragment.person_fragment;
import com.yongning.hello.fragment.pond_fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager View_Pager;
    private LinearLayout home_layout_view;
    private LinearLayout message_layout_view;
    private LinearLayout pond_layout_view;
    private LinearLayout person_layout_view;
    private ImageView home_image_view;
    private ImageView message_image_view;
    private ImageView pond_image_view;
    private ImageView person_image_view;

    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            initView();
            initEvent();
            SetSelect(0);   //首启动打开的界面为home_layout_view
    }

    private void initView() {
        View_Pager = (ViewPager) findViewById(R.id.View_Pager);
        home_layout_view = (LinearLayout) findViewById(R.id.home_layout_view);
        message_layout_view = (LinearLayout) findViewById(R.id.message_layout_view);
        pond_layout_view = (LinearLayout) findViewById(R.id.pond_layout_view);
        person_layout_view = (LinearLayout) findViewById(R.id.person_layout_view);
        home_image_view = (ImageView) findViewById(R.id.home_image_view);
        message_image_view = (ImageView) findViewById(R.id.message_image_view);
        pond_image_view = (ImageView) findViewById(R.id.pond_image_view);
        person_image_view = (ImageView) findViewById(R.id.person_image_view);

        //新建滑动的4个数据源 fragments数据集中
        fragments = new ArrayList<>();
        Fragment home = new home_fragment();
        Fragment message = new message_fragment();
        Fragment pond = new pond_fragment();
        Fragment person = new person_fragment();
        fragments.add(home);
        fragments.add(message);
        fragments.add(pond);
        fragments.add(person);

        //新建一个适配器
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        //Viewpager传值
        View_Pager.setAdapter(fragmentPagerAdapter);

        //View_Pager和itemMenu进行联动效果
        View_Pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ReSetimg();
               int Currentitem = View_Pager.getCurrentItem();
                /**
                 *  文件进行索引调用 (Alt+Shift+m)
                 */
                Switch_Tab(Currentitem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //添加菜单点击事件
    private void initEvent() {
        home_layout_view.setOnClickListener(this);
        message_layout_view.setOnClickListener(this);
        pond_layout_view.setOnClickListener(this);
        person_layout_view.setOnClickListener(this);
    }
    //点击后的相关操作
    @Override
    public void onClick(View v) {
        ReSetimg();
        switch (v.getId()) {
            case R.id.home_layout_view :
                SetSelect(0);
                break;
            case R.id.message_layout_view :
                SetSelect(1);
                break;
            case R.id.pond_layout_view :
                SetSelect(2);
                break;
            case R.id.person_layout_view :
                SetSelect(3);
                break;
            default:
                break;
        }
    }

    private void SetSelect(int a) {
        ReSetimg();
        Switch_Tab(a);
    }

    //设置点击菜单后当前图片变亮,同时View_Pager滑动到指定的界面
    private void Switch_Tab(int a) {
        switch (a) {
            case 0 :
                View_Pager.setCurrentItem(0);
                home_image_view.setImageResource(R.drawable.comui_tab_home_selected);
                break;
            case 1 :
                View_Pager.setCurrentItem(1);
                message_image_view.setImageResource(R.drawable.comui_tab_message_selected);
                break;
            case 2 :
                View_Pager.setCurrentItem(2);
                pond_image_view.setImageResource(R.drawable.comui_tab_pond_selected);
                break;
            case 3 :
                View_Pager.setCurrentItem(3);
                person_image_view.setImageResource(R.drawable.comui_tab_person_selected);
                break;
                default:
                    break;
        }
    }
    //设置所有图片的颜色为暗色
    private void ReSetimg() {
        home_image_view.setImageResource(R.drawable.comui_tab_home);
        message_image_view.setImageResource(R.drawable.comui_tab_message);
        pond_image_view.setImageResource(R.drawable.comui_tab_pond);
        person_image_view.setImageResource(R.drawable.comui_tab_person);
    }
}