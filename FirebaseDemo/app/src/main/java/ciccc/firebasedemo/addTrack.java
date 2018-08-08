package ciccc.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class addTrack extends AppCompatActivity {
    private TextView nameInTrack;
    private SeekBar seekbarInTrack;
    private static TextView textView1_rating;
    private EditText titleInTrack;
    private ListView listView;
    private DatabaseReference ref_tracks;
    private String artist_name;
    private ArrayList<Track> mTracks;
    private ArrayAdapter<Track> mTrackArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__track);
        nameInTrack = findViewById(R.id.nameInTrack);
        seekbarInTrack = findViewById(R.id.seekbarInTrack);
        textView1_rating = findViewById(R.id.rating);
        titleInTrack = findViewById(R.id.titleInTrack);
        listView = findViewById(R.id.listView);
        mTracks = new ArrayList<>();

        seekbarInTrack.setMax(5);
        seekbarInTrack.setProgress(1);

        // intent
        Intent intent = getIntent();
        artist_name = intent.getStringExtra("name");
        nameInTrack.setText(artist_name);

        //DB
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref_tracks = database.getReference("tracks");

        seekbarInTrack.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView1_rating.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        ref_tracks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                mTracks.clear();

                for(DataSnapshot trackSnapShot: dataSnapshot.getChildren()){
                    Track track = trackSnapShot.getValue(Track.class);
                    mTracks.add(track);
                    }
                mTrackArrayAdapter = new ArrayAdapter<>(
                        addTrack.this,
                        android.R.layout.simple_list_item_1,
                        mTracks
                );
                listView.setAdapter(mTrackArrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                if(databaseError != null) {
                    Toast.makeText(addTrack.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
                }}
        });

    }

    public void addTrack(View view) {

        String track_name = String.valueOf(titleInTrack.getText());
        String rating = String.valueOf(textView1_rating.getText());

        if(!TextUtils.isEmpty(track_name)) {

            // 1. generate unique id key.
            String id = ref_tracks.push().getKey();

            // 2. create an Track object using the id.
            Track track = new Track(id, track_name, artist_name, rating);

            // 3. add the track as a child of "ref_artists"
            ref_tracks.child(artist_name).setValue(track);
            mTracks.add(track);
            mTrackArrayAdapter.notifyDataSetChanged();
            titleInTrack.setText("");

        }else{
            Toast.makeText(this,"Please enter Artist name",Toast.LENGTH_LONG).show();
        }

    }
}
