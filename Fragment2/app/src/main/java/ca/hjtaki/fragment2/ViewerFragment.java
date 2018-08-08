package ca.hjtaki.fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ViewerFragment extends Fragment {
    ImageView imageView;

//오버라이드 해서 아래처럼 수정

    // fragment_list와 연결하는 과정
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_viewer,container,false);

        //rootView안에 있는 이미지 뷰어들 부르기
         imageView = rootView.findViewById(R.id.imageView);


        return rootView;
    }

    public void setImage(int index){

        if(index==0){
            imageView.setImageResource(R.drawable.img01);

        }else if (index==1){
            imageView.setImageResource(R.drawable.img02);

        }else if (index==2){
            imageView.setImageResource(R.drawable.img03);


        }
    }


}
