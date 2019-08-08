package cn.jhc.www.opower4viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "HBW";
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private View mView1;
    private View mView2;
    private View mView3;
    private OPower4ViewPagerBuilder mBuilder;
    private List<View> mViews;
    private RadioGroup mGroup;
    private RadioButton mHome;
    private RadioButton mMsg;
    private RadioButton mMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        int[] item_ids = {R.id.home, R.id.msg, R.id.me};

        mBuilder.setDataSrc(this, mViews)
                .needIndicateDots(false)
                .needBottomNavibar(true,mGroup,item_ids)
                .show();


//        int[] ids = {R.drawable.yd1, R.drawable.yd2, R.drawable.yd3};
//        mBuilder.setDataSrc(this,ids)
//                .needBottomNavibar(false)
//                .needIndicateDots(false)
//                .show();

//        String[] urls = {"http://pic39.nipic.com/20140320/12795880_110914420143_2.jpg",
//                "http://pic60.nipic.com/file/20150129/6448355_204110337000_2.jpg",
//                "http://pic44.nipic.com/20140727/2531170_090548134000_2.jpg"};

//        mBuilder.setDataSrc(this,urls)
//                .needBottomNavibar(true,mGroup,ids)
//                .needIndicateDots(false)
//                .show();
    }

    private void initView() {
        mBuilder = findViewById(R.id.viewpager_builder);

        mView1 = LayoutInflater.from(this).inflate(R.layout.test_frag_layout1,null);
        mView2 = LayoutInflater.from(this).inflate(R.layout.test_frag_layout2,null);
        mView3 = LayoutInflater.from(this).inflate(R.layout.test_frag_layout3,null);

        mBtn1 = (Button) mView1.findViewById(R.id.btn1);
        mBtn2 = (Button) mView2.findViewById(R.id.btn2);
        mBtn3 = (Button) mView3.findViewById(R.id.btn3);

        mTv1 = (TextView) mView1.findViewById(R.id.tv1);
        mTv2 = (TextView) mView2.findViewById(R.id.tv2);
        mTv3 = (TextView) mView3.findViewById(R.id.tv3);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);

        mViews = new ArrayList<>();
        mViews.add(mView1);
        mViews.add(mView2);
        mViews.add(mView3);

        mGroup = findViewById(R.id.icon_group);

        mHome = findViewById(R.id.home);
        mMsg = findViewById(R.id.msg);
        mMe = findViewById(R.id.me);

        mHome.setOnClickListener(this);
        mMsg.setOnClickListener(this);
        mMe.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mTv1.setText("btn1 has been clicked");
                break;
            case R.id.btn2:
                mTv2.setText("btn2 has been clicked");
                break;
            case R.id.btn3:
                mTv3.setText("btn3 has been clicked");
                break;
            case R.id.home:
                mBuilder.setCurrentItem(0);
                break;
            case R.id.msg:
                mBuilder.setCurrentItem(1);
                break;
            case R.id.me:
                mBuilder.setCurrentItem(2);
                break;
        }
    }
}
