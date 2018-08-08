package ca.hjtaki.fragment2;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment1;
    ViewerFragment viewerFragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인에서 각각 레이아웃을 찾아야한다. 사용하기 위해
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        // 매니져+ 아이디값을 통해 찾는다.
        listFragment1 = (ListFragment) manager.findFragmentById(R.id.ListFragment11);
        viewerFragment1 = (ViewerFragment) manager.findFragmentById(R.id.ViewerFragment11);

    }

    public void onImageChange(int index){
        viewerFragment1.setImage(index);
        // 이 메소드는 뷰이미지에 정의 되어있음

    }
}
