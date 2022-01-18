package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.System.exit;

public class modification extends AppCompatActivity {


    String[] dept={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    String[] year={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
    String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    EditText sub1code,change,change1;
    Button modify,lgot;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String store,store1;
    String [] dat,dat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        sub1code=findViewById(R.id.subject);
        change=findViewById(R.id.change);
        change1=findViewById(R.id.change1);
        dat=new String[100];
        dat1=new String[100];
        final Spinner spinner=(Spinner) findViewById(R.id.SP);
        final Spinner spinner1=(Spinner)findViewById(R.id.simple);
        final Spinner spinner2=(Spinner)findViewById(R.id.simple1);
        final Spinner spinner3=(Spinner) findViewById(R.id.simple2);
        final Spinner spinner4=(Spinner)findViewById(R.id.simple3);
        final Spinner spinner5=(Spinner)findViewById(R.id.simple4);
        modify=findViewById(R.id.ss6);
        lgot=findViewById(R.id.ss7);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dept);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sec);
        ArrayAdapter<String> d=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,year);
        ArrayAdapter<String> e=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,month);
        ArrayAdapter<String> f=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,day);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        d.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);
        spinner3.setAdapter(d);
        spinner4.setAdapter(e);
        spinner5.setAdapter(f);
        findViewById(R.id.ss7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout=new Intent(modification.this,registration.class);
                startActivity(logout);
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String l1,l2,l3,l4,l5,l6,l7,l8,l9;
                l1= spinner.getSelectedItem().toString();
                l2=spinner1.getSelectedItem().toString();
                l3=spinner2.getSelectedItem().toString();
                l4= sub1code.getText().toString();
                l5=spinner3.getSelectedItem().toString();
                l6= spinner4.getSelectedItem().toString();
                l7= spinner5.getSelectedItem().toString();
                l8= change.getText().toString();
                l9= change1.getText().toString();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    int countr=0,i,countr1=0;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot2:dataSnapshot.child("usn_date").child(l1).child(l2).child(l3).child(l4).child(l5).child(l6).child(l7).getChildren()) {
                            store = postSnapshot2.getKey();
                            store1=postSnapshot2.getValue().toString();
                            dat[countr] = store;
                            dat1[countr1]=store1;
                            countr++;
                            countr1++;
                        }
                            for(i=0;i<=countr;i++)
                            {
                                if(l8.equals(dat[i])){
//                                    databaseReference.child("usn_date").child(l1).child(l2).child(l3).child(l4).child(l5).child(l6).child(l7).child(l8).setValue(l9);
//                                    break;
                                    if(!l9.equals(dat1[i])) {
                                        databaseReference.child("usn_date").child(l1).child(l2).child(l3).child(l4).child(l5).child(l6).child(l7).child(l8).removeValue();
                                        Toast.makeText(modification.this, "Attendance status modified", Toast.LENGTH_LONG).show();
                                     //   return loop;
                                        exit(0);

                                    }
                                    else{
                                        databaseReference.child("usn_date").child(l1).child(l2).child(l3).child(l4).child(l5).child(l6).child(l7).child(l8).setValue(l9);

                                        //Toast.makeText(modification.this,"Attendance status unchanged", Toast.LENGTH_LONG).show();

                                    }

                                }else if(l9.equals("1"))
                                {
                                    databaseReference.child("usn_date").child(l1).child(l2).child(l3).child(l4).child(l5).child(l6).child(l7).child(l8).setValue(l9);
                                   Toast.makeText(modification.this,"Attendance status modified", Toast.LENGTH_LONG).show();


                                }

                            }


                    }

                        @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
