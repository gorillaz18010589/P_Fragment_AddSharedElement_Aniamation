package com.example.p_fragment_addsharedelement_aniamation.newloging;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.p_fragment_addsharedelement_aniamation.R;


public class BFragment extends Fragment {
    private ConstraintLayout container;
    private FrameLayout conBottom;
    private FrameLayout conTop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }


    private void init() {
        container = getView().findViewById(R.id.container);
        conBottom = getView().findViewById(R.id.conBottom);
        conTop = getView().findViewById(R.id.conTop);

        conBottom.setOnClickListener(onClickListener);
        conTop.setOnClickListener(onClickListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_register2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setAnimation();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.conTop:
                    getFragmentManager().popBackStack();
                    break;
            }
        }
    };

    @SuppressLint("NewApi")
    private void setAnimation() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(container);
        constraintSet.constrainPercentHeight(R.id.conBottom, 0.9f);
        constraintSet.setVerticalBias(R.id.conBottom, 0);
        constraintSet.constrainPercentHeight(R.id.conTop, 0.1f);
        constraintSet.setVerticalBias(R.id.conTop, 1);
        constraintSet.applyTo(container);
        TransitionManager.beginDelayedTransition(container);
    }
}
