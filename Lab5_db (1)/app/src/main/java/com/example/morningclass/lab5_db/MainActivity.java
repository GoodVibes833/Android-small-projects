package com.example.morningclass.lab5_db;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity:";
    private SwipeMenuListView mListView;                 //display
    private ArrayAdapter<String> mArrayAdapter; //data
    private ArrayList<String> mTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                //open a dialog to add a todo.
                showDialogToAddTodo();



                SwipeMenuCreator creator = new SwipeMenuCreator() {
                    @Override
                    public void create(SwipeMenu menu) {


                        // create "open" item
                        SwipeMenuItem openItem = new SwipeMenuItem(
                                getApplicationContext());
                        // set item background
                        openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                                0xCE)));
                        // set item width
                        openItem.setWidth(200);
                        // set item title
                        openItem.setTitle("Open");
                        // set item title fontsize
                        openItem.setTitleSize(18);
                        // set item title font color
                        openItem.setTitleColor(Color.WHITE);
                        // add to menu
                        menu.addMenuItem(openItem);




                        // create "delete" item
                        SwipeMenuItem deleteItem = new SwipeMenuItem(
                                getApplicationContext());
                        // set item background
                        deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                                0x3F, 0x25)));
                        // set item width
                        deleteItem.setWidth(200);
                        // set item title
                        deleteItem.setTitle("delete");
                        // set a icon
//                        deleteItem.setIcon(R.drawable.ic_launcher_background);
                        // add to menu
                        menu.addMenuItem(deleteItem);



                    }


                };

                // set creator
                mListView.setMenuCreator(creator);


                mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                        switch (index) {
                            case 0:
                                // open
                                break;
                            case 1:
                                // delete
                                mTodos.remove(2);
                                mArrayAdapter.notifyDataSetChanged();
                                break;
                        }
                        // false : close the menu; true : not close the menu
                        return false;
                    }
                });


            }




        });








        //create arraylist
        mTodos = new ArrayList<>();
        mTodos.add("study android");
        mTodos.add("watch World Cup");
        mTodos.add("Study Web");

        mListView = findViewById(R.id.todo_list);
        mArrayAdapter = new ArrayAdapter<String>( // where, setting, what
                this,
                android.R.layout.simple_list_item_1,
                mTodos);

        mListView.setAdapter(mArrayAdapter);

//        // create db
//        SQLiteDatabase db = openOrCreateDatabase("test1.db",MODE_PRIVATE,null);
//
//        // create table
//
//        String sql = "CREATE TABLE IF NOT EXISTS contacts(id INTEGER PRIMARY KEY," +
//                " name TEXT, phone TEXT, email TEXT);";
//
//        db.execSQL(sql);

        // insert some contacts into the table
//        sql = "INSERT INTO contacts VALUES(0, 'Giada Marconi', '778-456-1234', 'giada@mommy.com');";
//        db.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES(1, 'Minami Munakata', '778-123-4567', 'minami@mommy.com');";
//        db.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES(2, 'Nagisa Kojima', '778-234-5678', 'nagisa@mommy.com');";
//        db.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES(3, 'Marcelo Longen', '778-123-1234', 'marcelo@daddy.com');";
//        db.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES(4, 'Javier Jesus', '778-542-5343', 'javier@daddy.com');";
//        db.execSQL(sql);


//        Cursor query = db.rawQuery("SELECT * FROM contacts WHERE email LIKE '%mo_my%'",null);
//        if(query.moveToFirst()){
//            do{
//                int id = query.getInt(0);
//                String name = query.getString(1);
//                String phone = query.getString(query.getColumnIndex("phone"));
//                String email = query.getString(3);
//
//                Log.d(TAG,"oncreate : " + id + " " + name + " " + phone + " " + email);
//            }
//            while (query.moveToFirst());
//        }
//        query.close();
//        db.close();
    }


    private void showDialogToAddTodo(){
        //1. create a dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.add_menu_title));

        //2. add edittext + add parameter
        final EditText input = new EditText(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10,0,10,0);

        input.setLayoutParams(layoutParams);
        //3. add buttons
        builder.setPositiveButton(R.string.create_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //4. add user input to arraylist
                String todo = input.getText().toString();
                mTodos.add(todo);
                //update adapter
                mArrayAdapter.notifyDataSetChanged();
            }
        });


        //5. show
        AlertDialog dialog = builder.create();
        dialog.setView(input);
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
