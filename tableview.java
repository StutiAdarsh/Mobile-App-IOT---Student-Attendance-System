package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tableview extends AppCompatActivity {
    public final static String EXTRA_MESSAGE2="com.example.dell.attendancesystem.MESSAGE1";
    public final static String EXTRA_MESSAGE3="com.example.dell.attendancesystem.MESSAGE2";
    public final static String EXTRA_MESSAGE4="com.example.dell.attendancesystem.MESSAGE3";
    String[] branch={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    FirebaseDatabase firebaseDatabase;
    String l4;
    DatabaseReference databaseReference;
    Button display1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableview);
        final Spinner spinner=(Spinner) findViewById(R.id.SP1);
        final Spinner spinner1=(Spinner)findViewById(R.id.simple1);
        final Spinner spinner2=(Spinner)findViewById(R.id.simple2);
        display1=findViewById(R.id.display1);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branch);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sec);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        display1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l1,l2,l3;
//                Intent intent=getIntent();
//                String branch=intent.getStringExtra(timetablefragment.EXTRA_MESSAGEsp);
                l1= spinner.getSelectedItem().toString();
                l2=spinner1.getSelectedItem().toString();
                l3=spinner2.getSelectedItem().toString();
                Intent tab=new Intent(tableview.this,display.class);
                tab.putExtra(EXTRA_MESSAGE2,l1);
                tab.putExtra(EXTRA_MESSAGE3,l2);
                tab.putExtra(EXTRA_MESSAGE4,l3);
//                tab.putExtra(branch,l4);
                startActivity(tab);
            }
        });
    }
}
