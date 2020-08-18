package com.example.p_fragment_addsharedelement_aniamation.newloging;
//交錯感的切換
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.p_fragment_addsharedelement_aniamation.R;

public class StartActivity extends AppCompatActivity {
    AFragment aFragment = new AFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fContainer,aFragment).commit();
    }
}
