package ca.hjtaki.listview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//리니어 레이아웃을 상속 받아야 한다
public class singeritemView extends LinearLayout {
    TextView textView1;
    TextView textView2;
    ImageView imageView;


    //뷰를 생성할때는 생성자가 2개 필요하다 ??


    public singeritemView(Context context) {
        super(context);
        init(context);
    }

    public singeritemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }


    // 초기화를 위한 메소드를 만들고 위 각 생성자가 아래 메소드를 부르게한다.
private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
// 단말에서 서비스를 돌리는데 LayoutInflater가 있으니 갖다가 쓰겠다 /?

    inflater.inflate(R.layout.singeritem,this,true);
            //  우리가 만든 파일을쓰는데, singeritem의 최상위가 리니어 이므로,
            // 이렇게 인플레이션 해준다.

     textView1 = findViewById(R.id.textView);
     textView2 = findViewById(R.id.textView2);
     imageView = findViewById(R.id.imgeView);
}



    public void setName(String name){
            textView1.setText(name);
    }

    public void setMobile(String mobile){
            textView2.setText(mobile);
    }

    public void setImageView(int resId){
        imageView.setImageResource(resId);
    }


}
