package com.example.p_fragment_addsharedelement_aniamation.animation;
//這頁展示Fragment的滑動翻頁效果左右滑動效果

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.p_fragment_addsharedelement_aniamation.R;

public class AnimationActivity extends AppCompatActivity {
    private FirstFragment firstFragment = new FirstFragment();
    private SecondFragment secondFragment = new SecondFragment();
    private Button btnBack,btnNext;
    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        init();
        initFragment();
    }

    private void init() {
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        container = findViewById(R.id.container);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toNext();
            }
        });

        //返回上一頁
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStack();
            }
        });
    }

    //初始在第二頁
    private void initFragment() {
       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
       fragmentTransaction.add(R.id.container,firstFragment);
       fragmentTransaction.commit();
    }

    /*
    @param @AnimatorRes @AnimRes int enter   //1.到下一頁的進入效果
    @param @AnimatorRes @AnimRes int exit    //2.到下一頁的離開效果
    @param @AnimatorRes @AnimRes int popEnter//3..返回上一頁的進入效果
    @param @AnimatorRes @AnimRes int popExit//4..返回上一頁的離開效果
    FragmentTransaction FragmentTransaction.setCustomAnimations://設定Fragment間的轉自訂轉場效果
    */

    //到下一頁
    private void toNext(){
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_right_in,
                        R.anim.slide_left_out,
                        R.anim.slide_left_in,
                        R.anim.slide_right_out
                ).addToBackStack("log")
                .replace(R.id.container,secondFragment)
                .commit();
    }
}
