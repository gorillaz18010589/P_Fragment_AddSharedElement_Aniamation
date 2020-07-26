package com.example.p_fragment_addsharedelement_aniamation;
//Fragment間綁定特效轉換
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LoginFragment extends Fragment {
    private LinearLayout linBottom;
    private View view1;
    private RegisterFragment registerFragment = new RegisterFragment();
    private TextView tv1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
/*
* FragmentTransaction FragmentTransaction.addSharedElement( Fragment特效實現,搭配xml綁定特效元件
*  View sharedElement, //1.要綁定特效的元件view
*  String name         //2.兩個fragment元件互相綁定特效的名字
* )
*
* @param name  要返回特效的名字
 FragmentTransaction FragmentTransaction.addToBackStack(String name) 返回特效的頁面設置,可以回到上一頁
 *
 * String ViewCompat.getTransitionName()://從ViewCompat取取得xml指定的TransitionName(綁定得元件名稱)
* */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linBottom = view.findViewById(R.id.linBottom);
        view1 = view.findViewById(R.id.view1);
        tv1 = view.findViewById(R.id.tv1);

        linBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到下頁並且設定綁定特效
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement( //綁定特效
                                tv1,
                                ViewCompat.getTransitionName(tv1))//從ViewCompat取取得xml指定的TransitionName(綁定得元件名稱)
                        .addSharedElement(view1,ViewCompat.getTransitionName(view1))
                        .addToBackStack("TAG")//做到堆疊效果並且可以回到上一頁
                        .replace(R.id.container, registerFragment)
                        .commit();
            }
        });
    }
}
