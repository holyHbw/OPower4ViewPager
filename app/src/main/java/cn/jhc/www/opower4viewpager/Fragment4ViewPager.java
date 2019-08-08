package cn.jhc.www.opower4viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * (^_^) (0_0)
 * Created by hbw on 2019/8/7.
 */
public class Fragment4ViewPager extends Fragment {

    private View mView;

    public Fragment4ViewPager setLayout(View view)
    {
        mView = view;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return mView;
    }
}
