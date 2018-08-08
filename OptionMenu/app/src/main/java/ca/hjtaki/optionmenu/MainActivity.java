package ca.hjtaki.optionmenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        //액션바 숨기기
//        ActionBar abar = getSupportActionBar();
//        abar.hide();;


    }

    //불러오기 레이아웃 일플레이션 해서 붙이기

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

//옵션이 선택 되었을때 콜
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId(); // 세개의 아이디 값
        switch (curId){
            case R.id.menu_refresh:
                Toast.makeText(this,"새로고침 메뉴 선택됨",Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_search:
                Toast.makeText(this,"검색 메뉴 선택됨",Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_setting:
                Toast.makeText(this,"설정 메뉴 선택됨",Toast.LENGTH_LONG).show();
                break;

                default:
                    break;
        }

        return super.onOptionsItemSelected(item);
    }
}
