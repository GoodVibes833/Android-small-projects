package ca.hjtaki.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//public class fragmentmain extends Fragment {
//
//    //방법1
//    //오버라이드로 메소드 불러오고
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //이 자바파일과 xml을 연결시키자
//        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main,container,false);

//
//        return rootView;
//    }
//
//}

//프레그먼트 안에 버튼을 이용해보자
// 프레그먼트 라이프 사이클

public class fragmentmain extends Fragment {
    MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity=null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //이 자바파일과 xml을 연결시키자
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main,container,false);

        //프레그먼트 안의 버튼 찾가. rootview가 최상위 레이아웃
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티로 요청을 보내야 한다. 시스템이 아니라 인텐트가 아니라
                activity.onFragmentChange(1); // 메인에 만들어줬다.
            }
        });

        return rootView;
    }



}
