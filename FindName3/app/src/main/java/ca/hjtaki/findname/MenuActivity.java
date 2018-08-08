package ca.hjtaki.findname;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private static final int RED_CODE_ADD_NAME = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void PlayButtonClicked(View view){
        // change activity(from, to)
        Intent intent = new Intent(this, MainActivity.class);

        //passing data
        intent.putExtra("secret","yeah"); //id -> data , it takes all type of data
        startActivity(intent);

    }


    public void addNameClicked(View view) {

        // start activity, but come back later when you are done

        Intent intent = new Intent(this, addNewName.class);
        startActivityForResult(intent, RED_CODE_ADD_NAME); // any number

    }

    // I deed to overide to use startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1111){
            if(resultCode == RESULT_OK){
                String newName = data.getStringExtra("newName");
//                String[] names = newName.split(" ");
                toast(newName + " is added");

            }else{
                toast("name is not added");
            }
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
