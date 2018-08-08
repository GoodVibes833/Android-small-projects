package ca.hjtaki.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        Button button = findViewById(R.id.button);



        //어뎁터 클래스 만들기, 객체 만들고, 데이터 관리, 겟뷰 리턴 , 부분화면 만들기 , 리스트에서 갖고오자


        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대","123123123",R.drawable.android));
        adapter.addItem(new SingerItem("소녀시대1","234234",R.drawable.facebook));
        adapter.addItem(new SingerItem("소녀시대2","345345",R.drawable.gmail));
        adapter.addItem(new SingerItem("소녀시대3","345456",R.drawable.instagram));

        //화면에 보여주기
        gridView.setAdapter(adapter);

        //클릭을 했을때 다른 화면 보이기 위해 클릭 한 후
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem)adapter.getItem(position); // 이름 등 정보가 들어있음
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(),Toast.LENGTH_LONG).show();


            }
        });




    }


    //리스트 뷰에서 갖고옴
    class SingerAdapter extends BaseAdapter {
        // 빨간줄 -> 구현해야할 메소드가 있음, 임플러먼트 메소드

//        ArrayList<String> items = new ArrayList<String>();
        // 스트링 형태만 필요하다면 위에꺼만.
        //여기에 데이터를 넣고 빼겠다.
        // 전화번호 등 다른 정보를 넣을것이라면 모든 종류의 데이터를 담는 클래스를 만들자 SingerItem

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        //이렇게 하면 싱어 아이템이 싱어 어댑터에 들어갈수있다


        //아이템을 넣는 함수를 만들다.
        public void addItem(SingerItem item){
            items.add(item);

        }



        // 아이템 개수, 길이
        @Override
        public int getCount() {
            return items.size();
        }

        //몇번쨰 아이템 불러오기
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        //아이디있다면 달라, 없으니까 그냥 포지션 주자 일단
        @Override
        public long getItemId(int position) {
            return position;
        }

        //각 걸그룹을 위해 이미지, 글자, 숫자 등을 보이고 싶다면, 화면에 레이아웃이 필요하고
        //그 레이아웃은 화면에 부분 화면으로 보여준다.
        // 부분화면 = 자바 소스 + xml
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            singeritemView view = new singeritemView(getApplicationContext());
            // 안드로이드에서는 모든 뷰는 컨텍스트를 받는다.


            // 데이터가 엄청많으면 메모리 소모가 크므로 재사용을 한다.
            // 즉 화면에 보이지 않는건 사용 안함
            //아래 처럼 해줌
//            public View getView(int position, View convertView, ViewGroup parent) {
//                singeritemView view = null;
//                if(convertView == null){
//                    view = new singeritemView(getApplicationContext());
//                }else{
//                    view = (singeritemView) convertView;
//                }



            SingerItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImageView(item.getResId());

            return view;
        }
    }
}
