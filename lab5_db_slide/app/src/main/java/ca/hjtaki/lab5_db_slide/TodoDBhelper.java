package ca.hjtaki.lab5_db_slide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.util.ArrayList;
import java.util.List;

public class TodoDBhelper extends SQLiteOpenHelper {

    public static class TodoEntry implements BaseColumns{
        public static final String TABLE_NAME = "todos";
        public static final String COLUMN_NAME_TODO = "todo";
    }
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todo.db";
    private static TodoDBhelper mTodoDBGHelper;
    public static synchronized TodoDBhelper getInstance(Context context){
        // if no instace yet -> make one, else use the one already created
        // synchronized
        if(mTodoDBGHelper == null){
            mTodoDBGHelper = new TodoDBhelper(context.getApplicationContext());
        }
        return mTodoDBGHelper;
    }



    public TodoDBhelper(Context context){
        // we need only one instance of TodoDBHelper
        //singleton pattern : class that has only one instance
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table c
        db.execSQL("CREATE TABLE " + TodoEntry.TABLE_NAME
                + "(" +TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoEntry.COLUMN_NAME_TODO + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop the table
        db.execSQL("DROP TABLE IF EXISTS " + TodoEntry.TABLE_NAME);
        onCreate(db);
    }

//add

    public void addTodo(Todo todo){
        SQLiteDatabase db = getWritableDatabase();
        //it helps with performance and ensures consistency of db
        db.beginTransaction();
        try {
            //map
            ContentValues values = new ContentValues();
            values.put(TodoEntry.COLUMN_NAME_TODO, todo.todo);
            long id = db.insertOrThrow(TodoEntry.TABLE_NAME, null,values);
            // is the same as "INSERT INTO + todoEntry.TABLE_NAME + VALUE ("study android");
            todo._id = id;
            db.setTransactionSuccessful();

            //INSERT INTO todos VALUES(todo = 'do something')
        }catch (Exception e){
            //error
        }finally {
            db.endTransaction();
        }
    }

    //read - read all todos from the table
    public List<Todo> getAllTodos(){
        //create an arrayList
        List<Todo> todos= new ArrayList<>();
        // get al ldata from the database
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TodoEntry.TABLE_NAME, null);
        //add each row(data) to the arrayList and return
        try {
            if(cursor.moveToFirst()){
                //there is data
                do {
                    Todo todo = new Todo();
                    todo.todo = cursor.getString(cursor.getColumnIndex(TodoEntry.COLUMN_NAME_TODO));
                    todo._id = cursor.getLong(0);
                    todos.add(todo);

                }while (cursor.moveToNext());

            }

        }catch (Exception e){

        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
        return todos;
    }


    //update
    public void updateTodo(Todo todo){
        SQLiteDatabase db = getWritableDatabase();
        //it helps with performance and ensures consistency of db
        db.beginTransaction();
        try {
            //map
            ContentValues values = new ContentValues();
            values.put(TodoEntry.COLUMN_NAME_TODO, todo.todo);
            // UPDATE todos SET todo_ = new_todo WHERE condition
            String[] args = {String.valueOf(todo._id),"%Android"};
            db.update(TodoEntry.TABLE_NAME,values,"_id=? todo LIKE ?", args);
            db.setTransactionSuccessful();


        }catch (Exception e){
            //error
        }finally {
            db.endTransaction();
        }
    }

//delete

    public void deleteTodo(Todo todo){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            String[] args = {String.valueOf(todo._id)};
            db.delete(TodoEntry.TABLE_NAME,"_id=?", args);
            db.setTransactionSuccessful();

        }catch (Exception e){
            //error
        }finally {
            db.endTransaction();
        }
    }



}