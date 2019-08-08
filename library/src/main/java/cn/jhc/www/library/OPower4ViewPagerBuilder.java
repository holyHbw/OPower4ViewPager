package cn.jhc.www.library;

import android.app.Activity;
import android.app.FragmentBreadCrumbs;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * (^_^) (0_0)
 * Created by hbw on 2019/8/7.
 */
public class OPower4ViewPagerBuilder extends RelativeLayout {

    private int mPageCount;
    private List<Fragment> mFragments;
    private Context mContext;
    private ViewPager mViewPager;
    private ViewGroup mViewGroup;
    private Boolean NEED_INDICATE_DOTS = true;
    private RadioGroup mRadioGroup;

    public void setFragmentLayout(List<View> layoutViews)
    {
        mPageCount = layoutViews.size();
        mFragments = new ArrayList<>();
        for (int i = 0; i < mPageCount; i++) {
            Fragment4ViewPager fragment = new Fragment4ViewPager();
            fragment.setLayout(layoutViews.get(i));
            mFragments.add(fragment);
        }
    }

    public void needIndicateDots(Boolean b)
    {
        if (b)
        {
            //init the dots
        }else{
            //do not init dots, set dots gone
            mViewGroup.setVisibility(GONE);
        }
    }

    public void needBottomNavibar(Boolean b)
    {
        if (b)
        {
            //init the dots
        }else {
            //do not init bottom, set bar gone
            mRadioGroup.setVisibility(GONE);
        }
    }

    public void onlyLocalImages(int[] resIds)
    {

    }

    public void onlyWebImages(List<String> urls)
    {
    }

    private void init(Context context) {
        mContext = context;

        initView();
        initViewPager();
    }


    private void initView() {

        mViewPager = findViewById(R.id.viewpager);
        mViewGroup = (ViewGroup) findViewById(R.id.dot_group);
        mRadioGroup = (RadioGroup) findViewById(R.id.bottom_navibar);
    }

    private void initViewPager() {
        mViewPager.setAdapter(new FragmentPagerAdapter(((AppCompatActivity)mContext).getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {

                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
    }

    /**
     * no need to invoke manually
     * @param context
     */

    public OPower4ViewPagerBuilder(Context context) {
        super(context);

    }

    public OPower4ViewPagerBuilder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OPower4ViewPagerBuilder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OPower4ViewPagerBuilder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
