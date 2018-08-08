package ca.hjtaki.myorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //돌렸을때 이어지는게 아니라 새로운 액티비티가 실행되는것을 볼수있다 데이터를 잃는다 .
    // onsave instance!!

    // 입력한 값을 이 변수에 할당을 할것이다 .
    EditText editText;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"onCreate 호출 됨 ",Toast.LENGTH_LONG).show();



        //데이터 이어지게 해보자
        editText = (EditText) findViewById(R.id.editText) ;

        Button button = (Button)findViewById(R.id.button);

        if(button!=null) {


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = editText.getText().toString(); // 입력한 값이 나옴 할당함 .
                    Toast.makeText(getApplicationContext(), " 입력한 값을 네임에 할당함 ", Toast.LENGTH_LONG).show();


                }
            });
        }

        if(savedInstanceState!=null){
            savedInstanceState.getString("name");
            if(editText !=null){
                editText.setText("복원된 이름 "+name); // 여기에 네임 넣기 복원된값
                Toast.makeText(getApplicationContext(), " 이름이 복원됨  ",Toast.LENGTH_LONG).show();

            }

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name",name); //네임이라는 이름으로 네임에 저장
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"oncreated 호출 됨 ",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop 호출 됨 ",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy 호출 됨 ",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause 호출 됨 ",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume 호출 됨 ",Toast.LENGTH_LONG).show();

    }
}
