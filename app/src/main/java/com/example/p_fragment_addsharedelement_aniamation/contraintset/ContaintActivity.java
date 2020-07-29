package com.example.p_fragment_addsharedelement_aniamation.contraintset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.p_fragment_addsharedelement_aniamation.R;

public class ContaintActivity extends AppCompatActivity {
    private FrameLayout fContainer;
    private OneFragment oneFragment = new OneFragment();
    private TwoFragment twoFragment = new TwoFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containt);

        init();
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fContainer,oneFragment)
                .commit();
    }

    private void init() {
        fContainer = findViewById(R.id.fContainer);

    }


}
