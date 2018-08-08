package ca.hjtaki.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    fragmentmain fragment1;
    fragmentmenu fragment2;
    fragment3 fragment3;
    fragment4 fragment4;
    fragment5 fragment5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new fragmentmain();
        fragment2 = new fragmentmenu();
        fragment3 = new fragment3();
        fragment4 = new fragment4();
        fragment5 = new fragment5();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //방법 2 소스코드에서 추가 하는 방법 fragment manager 이용 - 이게 간단한듯 ??
                //두개면 리플레이스를 이용
//                getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit(); //이 아이디에 넣어라
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); //이 아이디에 넣어라

            }
        });


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //방법 2 소스코드에서 추가 하는 방법 fragment manager 이용

//                fragmentmenu fragment2 = new fragmentmenu();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit(); //이 아이디에 넣어라

            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //방법 2 소스코드에서 추가 하는 방법 fragment manager 이용

//                fragmentmenu fragment3 = new fragmentmenu();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit(); //이 아이디에 넣어라

            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //방법 2 소스코드에서 추가 하는 방법 fragment manager 이용

//                fragmentmenu fragment4 = new fragmentmenu();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment4).commit(); //이 아이디에 넣어라

            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //방법 2 소스코드에서 추가 하는 방법 fragment manager 이용

//                fragmentmenu fragment5 = new fragmentmenu();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit(); //이 아이디에 넣어라

            }
        });






    }


    public void onFragmentChange(int index){
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();

        }else if(index ==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();

        }else if(index ==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment4).commit();

        }else if(index ==4){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit();

        }
    }
}
