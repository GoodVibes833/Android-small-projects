package ca.hjtaki.mytoast;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"위치가 바뀐 토스트 ",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.LEFT,100,100);
                toast.show();


            }});

//layout inflation을 이용해 객체화
        // xml 파일 이용해 토스트 모양 바꾸기

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastboarder,(ViewGroup)findViewById(R.id.toast_layout_root));
                // 레이아웃 이름 ,최상위 레이아웃 id

                TextView text = (TextView)layout.findViewById(R.id.text);
                text.setText("모양을 바꾼 토스트");


                //이 레이아웃을 만든 걸 토스트로 쓰곘다 .
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER,0,-100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();





            }});



        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "스낵바입니다 ",Snackbar.LENGTH_LONG).show();
                //얘는 계속 띄울수 있는게 토스트보다 낫다,











            }});

    }
}
