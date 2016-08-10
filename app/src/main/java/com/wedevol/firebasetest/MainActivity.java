package com.wedevol.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textViewCondition;
    Button buttonFoggy;
    Button buttonSunny;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textViewCondition = (TextView) findViewById(R.id.textViewCondition);
        buttonFoggy = (Button) findViewById(R.id.buttonFoggy);
        buttonSunny = (Button) findViewById(R.id.buttonSunny);
        mRef = new Firebase("https://fir-test-4f0b4.firebaseio.com/condition");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                textViewCondition.setText(data);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        buttonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Foggy");
            }
        });

        buttonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Sunny");
            }
        });
    }
}
