package ca.hjtaki.findname;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "MainActivity";
    private HashMap<String, String> namesMap;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Intent : put data from menu
        Intent intent = getIntent(); //returns intent
        String passed = intent.getStringExtra("secret"); // when input was String
//        intent.getIntExtra()
        toast(passed);


        setContentView(R.layout.activity_main);
        namesMap = new HashMap<>();
        readContentsFromFile();
        getQuestion();
    }

    private void getQuestion() {
        //map to array
        ArrayList<String> firstnames = new ArrayList<>(namesMap.keySet());
        ArrayList<String> lastnames = new ArrayList<>(namesMap.values());

        int rand = (int) (Math.random() * firstnames.size());
        String fn = firstnames.get(rand);
        String ln = namesMap.get(fn);

        lastnames.remove(ln);
        Collections.shuffle(lastnames);

        ArrayList<String> options = new ArrayList<>(lastnames.subList(0, 4));
        options.add(ln);

        Collections.shuffle(options);

        mTextView = findViewById(R.id.firstName_tv);
        mTextView.setText(fn);
        ListView lv = findViewById(R.id.lastName_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // check answer
        String question = mTextView.getText().toString();
        String answer = namesMap.get(question);
        String selected = parent.getItemAtPosition(position).toString();

        Log.d(TAG, "onItemClick: " + selected);
        if (answer.equals(selected)) {
            toast("Right!");
            getQuestion();
        } else {
            toast("Wrong!");
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void readContentsFromFile(Scanner scan) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] fullname = line.split("\t");
            namesMap.put(fullname[0], fullname[1]);
        }
        scan.close();
    }

    private void readContentsFromFile() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.names));
        readContentsFromFile(scan);

        try {
            Scanner scan2 = new Scanner(openFileInput("new_names.txt"));
            readContentsFromFile(scan2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}