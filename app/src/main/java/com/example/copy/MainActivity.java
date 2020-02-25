package com.example.copy;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.example.copy.fragment.ClassifFragment;
import com.example.copy.fragment.HomeFragment;
import com.example.copy.fragment.MyFragment;
import com.example.copy.fragment.ShoppingCartFragment;
import com.example.copy.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mTbr;
    private FrameLayout mVp;
    /**
     * 首页
     */
    private RadioButton mHomeBtn;
    /**
     * 专题
     */
    private RadioButton mSubjectBtn;
    /**
     * 分类
     */
    private RadioButton mClassifBtn;
    /**
     * 购物车
     */
    private RadioButton mShoppingcartBtn;
    /**
     * 我的
     */
    private RadioButton mMyBtn;
    private FragmentTransaction beginTransaction;
    private List<RadioButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTbr = (Toolbar) findViewById(R.id.tbr);
        mVp = (FrameLayout) findViewById(R.id.vp);
        setSupportActionBar(mTbr);
        mHomeBtn = (RadioButton) findViewById(R.id.home_btn);
        mSubjectBtn = (RadioButton) findViewById(R.id.subject_btn);
        mClassifBtn = (RadioButton) findViewById(R.id.classif_btn);
        mShoppingcartBtn = (RadioButton) findViewById(R.id.shoppingcart_btn);
        mMyBtn = (RadioButton) findViewById(R.id.my_btn);
        mHomeBtn.setOnClickListener(this);
        mSubjectBtn.setOnClickListener(this);
        mClassifBtn.setOnClickListener(this);
        mShoppingcartBtn.setOnClickListener(this);
        mMyBtn.setOnClickListener(this);
        list=new ArrayList<>();
        list.add(mHomeBtn);
        list.add(mSubjectBtn);
        list.add(mClassifBtn);
        list.add(mShoppingcartBtn);
        list.add(mMyBtn);
        beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.vp, new HomeFragment());
        beginTransaction.commit();
        mHomeBtn.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.home_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.vp,new HomeFragment()).commit();
                getSelect(R.id.home_btn);
                break;
            case R.id.subject_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.vp,new SpecialFragment()).commit();
                getSelect(R.id.subject_btn);
                break;
            case R.id.classif_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.vp,new ClassifFragment()).commit();
                getSelect(R.id.classif_btn);
                break;
            case R.id.shoppingcart_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.vp,new ShoppingCartFragment()).commit();
                getSelect(R.id.shoppingcart_btn);
                break;
            case R.id.my_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.vp,new MyFragment()).commit();
                getSelect(R.id.my_btn);
                break;
        }
    }
    private void getSelect(int btnid) {
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId()==btnid){
                list.get(i).setSelected(true);
            }else {
                list.get(i).setSelected(false);
            }
        }
    }
}
