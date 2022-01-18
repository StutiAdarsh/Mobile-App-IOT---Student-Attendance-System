package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class studentpresent extends AppCompatActivity {
   // TextView u,u1,u2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String roll;
    String [] data;
    int counter=0,counter1;

    ArrayList<String> arrayList=new ArrayList<>();

    ArrayAdapter<String> adapter;
    String branch,sem,sec,subcode,selectedy,y1,m1,d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpresent);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        data=new String[100];
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        final ListView listView=(ListView)findViewById(R.id.usnlist);
        listView.setAdapter(adapter);


        Intent intent=getIntent();
         branch=intent.getStringExtra(homefragment.EXTRA_MESSAGE6);
         sem=intent.getStringExtra(homefragment.EXTRA_MESSAGE7);
         sec=intent.getStringExtra(homefragment.EXTRA_MESSAGE8);
        subcode=intent.getStringExtra(homefragment.EXTRA_MESSAGE9);
       y1=intent.getStringExtra(homefragment.EXTRA_MESSAGE45);
         m1=intent.getStringExtra(homefragment.EXTRA_MESSAGE46);
         d1=intent.getStringExtra(homefragment.EXTRA_MESSAGE47);
//        sub1=selected.substring(0,4);
//        sub2=selected.substring(5,7);
//        sub3=selected.substring(8,10);
//        for(counter1=0;counter1<=8;counter1++){
//            if(sub2.equals(store[counter1])){
//            sub2="0"+sub2;
//            break;

//        else if(sub3.equals(store[counter1])){
//                sub3="0"+sub3;
//                break;
//            }



//        new1=sub1+sub2+sub3;
//          Toast.makeText(studentpresent.this,new1,Toast.LENGTH_LONG).show();
//        Toast.makeText(studentpresent.this,sub2,Toast.LENGTH_LONG).show();

        databaseReference.addValueEventListener(new ValueEventListener() {

        int counter=0;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               // if(dataSnapshot.child()){}


                for (DataSnapshot postSnapshot : dataSnapshot.child("usn_date").child(branch).child(sem).child(sec).child(subcode).child(y1).child(m1).child(d1).getChildren()) {
                    roll = postSnapshot.getKey();
                    data[counter]=roll;
                    counter++;


                    //  adapter.notifyDataSetChanged();
                }
                for(int i=0;i<counter;i++) {
                    arrayList.add(data[i]);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
