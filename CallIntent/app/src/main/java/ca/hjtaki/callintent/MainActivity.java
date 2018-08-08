package ca.hjtaki.callintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText)findViewById(R.id.editText);

        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               String receiver =  editText.getText().toString();
               Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel : "+receiver));
               startActivity(intent); // 여기서 시스템으로 전달

//                Intent intent2 = new Intent();
//                ComponentName = new ComponentName("ca.hjtaki.callintent","ca.hjtaki.callintent.Mainactitity");

            }
        });
    }
}
