package com.example.p_fragment_addsharedelement_aniamation.newloging;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.p_fragment_addsharedelement_aniamation.R;


public class AFragment extends Fragment {
    private FrameLayout conBottom,conTop;
    private BFragment bFragment = new BFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(@NonNull View view) {
        conBottom = view.findViewById(R.id.conBottom);
        conTop = view.findViewById(R.id.conTop);

        conBottom.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.conBottom:
                    setConstraintSetAnimation();
                    break;
            }
        }
    };
    private void setConstraintSetAnimation() {
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(conTop, ViewCompat.getTransitionName(conTop))
                .addSharedElement(conBottom,ViewCompat.getTransitionName(conBottom))
                .replace(R.id.fContainer,bFragment)
                .addToBackStack("log")
                .commit();

    }

}
