package ca.hjtaki.fragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {

    MainActivity activity;

    //메인에 메소드를 만들고
    // 프레그먼트가 액티비티에 올라온 순간
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       activity = (MainActivity) getActivity();
    }

    //오버라이드 해서 아래처럼 수정
    // fragment_list와 연결하는 과정
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_list,container,false);

        //rootView안에 있는 버튼들 부르기
        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button3 = rootView.findViewById(R.id.button3);

        //버튼을 눌렀을때 뷰터이미지의 이미지를 바꾼다.
        //바로 접근을 할수가 없어서 메인에 메소드를 만들어야한다.

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //위에 액티비티정의 해놨고 메소드는 메인에 정의 해놈
                activity.onImageChange(0);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageChange(1);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageChange(2);


            }
        });






        return rootView;
    }


}
