package com.example.p_fragment_addsharedelement_aniamation.contraintset;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.p_fragment_addsharedelement_aniamation.R;

import javax.net.ssl.TrustManager;


public class OneFragment extends Fragment {
    private FrameLayout fraTop,fraBottom;
    private TwoFragment twoFragment = new TwoFragment();
    private ConstraintLayout container,conTopMsg;
    private Handler handler = new Handler();
    private int i = 0;
    private TextView tvTitle,tvMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        i++;
    }

    private void init(View view) {
        fraTop = view.findViewById(R.id.conTop);
        fraBottom = view.findViewById(R.id.conBottom);
        container = view.findViewById(R.id.container);
        conTopMsg = view.findViewById(R.id.conTopMsg);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvMsg = view.findViewById(R.id.tvMsg);

        if(i > 0){
            Log.v("hank","i等於:" + i);
            initConstraintSet();
        }


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setConstraintSetAnimation2();
            }
        }, 300);
        conTopMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setAnimation();
                setConstraintSetAnimation();
            }
        });

    }

    private void setAnimation() {
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(fraTop, ViewCompat.getTransitionName(fraTop))
                .addSharedElement(fraBottom, ViewCompat.getTransitionName(fraBottom))
                .replace(R.id.fContainer, twoFragment)
                .addToBackStack("log")
                .commit();

    }

    private void initConstraintSet() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(container);

        constraintSet.constrainPercentHeight(R.id.conTop, 0.9f);
        constraintSet.constrainPercentHeight(R.id.conBottom, 0.1f);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(container);
            constraintSet.applyTo(container);
        }

    }

    private void setConstraintSetAnimation2() {

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(container);

        constraintSet.constrainPercentHeight(R.id.conTop, 0.1f);
        constraintSet.constrainPercentHeight(R.id.conBottom, 0.9f);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(container);
            constraintSet.applyTo(container);
        }
    }


    private void setConstraintSetAnimation() {
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(tvTitle,ViewCompat.getTransitionName(tvTitle))
                .addSharedElement(tvMsg,ViewCompat.getTransitionName(tvMsg))
                .replace(R.id.fContainer, twoFragment)
                .addToBackStack("log")
                .commit();

    }
}
