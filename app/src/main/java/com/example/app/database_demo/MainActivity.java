package com.example.app.database_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn1,btn2,btn3;
    String data;
    DatabaseReference db=FirebaseDatabase.getInstance().getReference().child("lucky");
    //DatabaseReference sec=db.child("lucky");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textone);
        btn1=(Button)findViewById(R.id.btn1_id);
        btn2=(Button)findViewById(R.id.btn2_id);
        btn3=(Button)findViewById(R.id.btn3_id);

    }

    @Override
    protected void onStart() {
        super.onStart();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                data=dataSnapshot.getValue(String.class);
                tv.setText(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            db.setValue("lucky");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setValue("hemant");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setValue("hemant roy");
            }
        });
   }
}
