package com.example.p_fragment_addsharedelement_aniamation.contraintset;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_fragment_addsharedelement_aniamation.R;


public class TwoFragment extends Fragment {
    private ConstraintLayout constraintLayout;
    private Handler handler = new Handler();
    private ConstraintLayout conBottomMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setConstraintSetAnimation();
            }
        },200);

    }

    private void init(View view) {
        constraintLayout = view.findViewById(R.id.container);
        conBottomMsg = view.findViewById(R.id.conBottomMsg);
        conBottomMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

    private void setConstraintSetAnimation(){
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.constrainPercentHeight(R.id.conTop,0.9f);
        constraintSet.constrainPercentHeight(R.id.conBottom,0.1f);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(constraintLayout);
            constraintSet.applyTo(constraintLayout);
        }



    }
}
