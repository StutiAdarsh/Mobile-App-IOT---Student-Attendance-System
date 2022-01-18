package com.example.dell.attendancesystem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class usnwise extends AppCompatActivity {
    //    TableLayout tb1;
//    TableRow tr;
    TextView atd1,atd2,atd3,atd4,atd5,atd6,atd7,atd8;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String data,data1;
    String [] values,values1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnwise);

//        TableLayout tb1=(TableLayout)findViewById(R.id.tl);
//        TableRow tr=new TableRow(this);
//        tr.addView(new TextView(this));
//        tb1.addView(tr);
        values=new String[100];
        values1=new String[100];
        atd1=findViewById(R.id.atd1);
        atd2=findViewById(R.id.atd2);
        atd3=findViewById(R.id.atd3);
        atd4=findViewById(R.id.atd4);
        atd5=findViewById(R.id.atd5);
        atd6=findViewById(R.id.atd6);
        atd7=findViewById(R.id.atd7);
        atd8=findViewById(R.id.atd8);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            int counter=0,counter1=0;
            Intent intent=getIntent();
            String usn1=intent.getStringExtra(homefragment.EXTRA_MESSAGE1);
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.child("StudentDetails").child(usn1).child("Attendance").getChildren())
                {
                    data=postSnapshot.getValue().toString();
                    data1=postSnapshot.getKey();
                    values[counter]=data;
                    values1[counter1]=data1;
                    counter++;
                    counter1++;

                    atd1.setText(values1[0]);
                    atd2.setText(values[0]);
                    atd3.setText(values1[1]);
                    atd4.setText(values[1]);
                    atd5.setText(values1[2]);
                    atd6.setText(values[2]);
                    atd7.setText(values1[3]);
                    atd8.setText(values[3]);

                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
