package ca.hjtaki.mytab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    fragment1 fragment1;
    fragment2 fragment2;
    fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();




        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();

        Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //매니져
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs,newTab(),setText("friends"));
        tabs.addTab(tabs,newTab(),setText("chatting"));
        tabs.addTab(tabs,newTab(),setText("setText"));


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
                }else if (position == 1 ){
                    selected =fragment2;

                }else if (position==2){
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
