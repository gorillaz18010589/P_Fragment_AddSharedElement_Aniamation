package com.example.p_fragment_addsharedelement_aniamation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.p_fragment_addsharedelement_aniamation.animation.AnimationActivity;

public class MainActivity extends AppCompatActivity {
    private LoginFragment loginFragment = new LoginFragment();
    private RegisterFragment fragment = new RegisterFragment();
    private LinearLayout linBottom;
    private View view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        view1 = findViewById(R.id.view1);
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,loginFragment).commit();
    }

    public void toAnimationActivity(View view) {
        startActivity(new Intent(MainActivity.this, AnimationActivity.class));
    }
}
