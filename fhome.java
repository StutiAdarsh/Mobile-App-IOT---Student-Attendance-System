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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fhome extends AppCompatActivity  {
    public final static String EXTRA_MESSAGE11="com.example.dell.attendancesystem.MESSAGE11";
    public final static String EXTRA_MESSAGE12="com.example.dell.attendancesystem.MESSAGE12";
    public final static String EXTRA_MESSAGE13="com.example.dell.attendancesystem.MESSAGE13";
    public final static String EXTRA_MESSAGE14="com.example.dell.attendancesystem.MESSAGE14";
    public final static String EXTRA_MESSAGE15="com.example.dell.attendancesystem.MESSAGE15";
    public final static String EXTRA_MESSAGE16="com.example.dell.attendancesystem.MESSAGE16";
    public final static String EXTRA_MESSAGE17="com.example.dell.attendancesystem.MESSAGE17";
    View view;
    String[] dept={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    String[] year={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
    String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    TextView dept1,sem1,sec1,year1,month1,day1;
    EditText sub1code;
    Button enter,abcd,log;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String roll;
    String [] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fhome);
        sub1code=findViewById(R.id.subject);
        data=new String[100];
         final Spinner spinner=(Spinner) findViewById(R.id.SP);
         final Spinner spinner1=(Spinner)findViewById(R.id.simple);
        final Spinner spinner2=(Spinner)findViewById(R.id.simple1);
     final Spinner spinner3=(Spinner) findViewById(R.id.simple2);
        final Spinner spinner4=(Spinner)findViewById(R.id.simple3);
      final Spinner spinner5=(Spinner)findViewById(R.id.simple4);
        enter=findViewById(R.id.ss);
       abcd=findViewById(R.id.ss1);
        log=findViewById(R.id.lo);
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





        findViewById(R.id.ss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String l1,l2,l3,l4,l5,l6;

        l1= spinner.getSelectedItem().toString();
        l2=spinner1.getSelectedItem().toString();
        l3=spinner2.getSelectedItem().toString();
        l4= spinner3.getSelectedItem().toString();
        l5=spinner4.getSelectedItem().toString();
        l6=spinner5.getSelectedItem().toString();

        Intent res=new Intent(fhome.this,datewiseusn.class);
        res.putExtra(EXTRA_MESSAGE11,l1);
        res.putExtra(EXTRA_MESSAGE12,l2);
        res.putExtra(EXTRA_MESSAGE13,l3);
        res.putExtra(EXTRA_MESSAGE14,sub1code.getText().toString());
        res.putExtra(EXTRA_MESSAGE15,l4);
        res.putExtra(EXTRA_MESSAGE16,l5);
        res.putExtra(EXTRA_MESSAGE17,l6);
        startActivity(res);
            }
        });

        findViewById(R.id.ss1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent efg=new Intent(fhome.this,modification.class);
                startActivity(efg);
            }
        });

        findViewById(R.id.lo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hij=new Intent(fhome.this,registration.class);
                startActivity(hij);
            }
        });

    }



}
