package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class datewiseusn extends AppCompatActivity {
    TextView u,u1,u2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String roll,roll1;
    String [] data,data1;
   ArrayList<String> arrayList=new ArrayList<>();

   ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datewiseusn);
         adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        final ListView listView=(ListView)findViewById(R.id.usnlist);
        listView.setAdapter(adapter);

        //listView.setAdapter(adapter);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        data=new String[100];
        data1=new String[100];


        databaseReference.addValueEventListener(new ValueEventListener() {
            Intent intent=getIntent();
            String branch=intent.getStringExtra(fhome.EXTRA_MESSAGE11);
            String sem=intent.getStringExtra(fhome.EXTRA_MESSAGE12);
            String sec=intent.getStringExtra(fhome.EXTRA_MESSAGE13);
            String sub1code=intent.getStringExtra(fhome.EXTRA_MESSAGE14);
            String year=intent.getStringExtra(fhome.EXTRA_MESSAGE15);
            String month=intent.getStringExtra(fhome.EXTRA_MESSAGE16);
            String day=intent.getStringExtra(fhome.EXTRA_MESSAGE17);

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               int counter=0;

                for (DataSnapshot postSnapshot : dataSnapshot.child("usn_date").child(branch).child(sem).child(sec).child(sub1code).child(year).child(month).child(day).getChildren()) {
                    roll = postSnapshot.getKey();
                    data[counter]=roll;
                    counter++;


                 //  adapter.notifyDataSetChanged();
                }
                for(int i=0;i<counter;i++) {
                    arrayList.add(data[i]);
                    adapter.notifyDataSetChanged();

                }
//                arrayList.add(data[1]);


//u1.setText(data[0]);
//                u2.setText(data[1]);

                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
