package com.example.dell.attendancesystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class student extends AppCompatActivity {
    public final static String EXTRA_MESSAGE="com.example.dell.attendancesystem.MESSAGE";

    private EditText usn;
    private Button submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String roll;
    String [] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        usn = (EditText) findViewById(R.id.usn);
        submit=(Button) findViewById(R.id.submit);
        data=new String[100];
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addValueEventListener(new ValueEventListener() {
            int i=0,counter=0;
            String usn1=usn.getText().toString();


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                breakloop:
                for (DataSnapshot postSnapshot : dataSnapshot.child("StudentDetails").getChildren()) {
                    roll = postSnapshot.getKey();
                    data[counter] = roll;
                    counter++;


                    if (usn1.equalsIgnoreCase(data[i])) {
                        Toast.makeText(student.this,"Verified",Toast.LENGTH_SHORT).show();
                        Intent next=new Intent(student.this,shome.class);
                        next.putExtra(EXTRA_MESSAGE,usn1);
                        startActivity(next);
                        break breakloop;}


//                    } else if(!usn1.equalsIgnoreCase(data[i])){
//                        Toast.makeText(student.this,"Not Valid",Toast.LENGTH_SHORT).show();
//
////                        AlertDialog.Builder dlgAlert=new AlertDialog.Builder(student.this);
////                        dlgAlert.setMessage("Invalid usn");
////                        dlgAlert.setTitle("Error Message..");
////                        dlgAlert.setPositiveButton("OK",null);
////                        dlgAlert.setCancelable(true);
////                        dlgAlert.create().show();
////
////                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////
////                            }
////                        });
//                    }

                    i++;
                }
                if(!usn1.equalsIgnoreCase(data[i]))
                Toast.makeText(student.this,"Not Valid",Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        }
);


            }
        });

    }
}
