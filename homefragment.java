package com.example.dell.attendancesystem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class homefragment extends Fragment implements AdapterView.OnItemSelectedListener{
    public final static String EXTRA_MESSAGE1="com.example.dell.attendancesystem.MESSAGE";
    public final static String EXTRA_MESSAGE6="com.example.dell.attendancesystem.MESSAGE6";
    public final static String EXTRA_MESSAGE7="com.example.dell.attendancesystem.MESSAGE7";
    public final static String EXTRA_MESSAGE8="com.example.dell.attendancesystem.MESSAGE8";
    public final static String EXTRA_MESSAGE9="com.example.dell.attendancesystem.MESSAGE9";
    public final static String EXTRA_MESSAGE10="com.example.dell.attendancesystem.MESSAGE10";
    public final static String EXTRA_MESSAGE45="com.example.dell.attendancesystem.MESSAGE45";
    public final static String EXTRA_MESSAGE46="com.example.dell.attendancesystem.MESSAGE46";
    public final static String EXTRA_MESSAGE47="com.example.dell.attendancesystem.MESSAGE47";


    String[] dept={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    String[] year={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
    String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    TextView dept1,sem1,sec1,selected,year1,month1,day1;
    DatePickerDialog.OnDateSetListener mDateSetListener;

    Button  usn,date,view1,view2;
    EditText usnentry,subcode,dt;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String roll;
    String [] data;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,null);
        return view;
        //return inflater.inflate(R.layout.fragment_home,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usn = (Button) view.findViewById(R.id.usn);
        date = (Button) view.findViewById(R.id.date);
       view1 = (Button) view.findViewById(R.id.view1);
        view2 = (Button) view.findViewById(R.id.view2);
        data=new String[100];
        final Spinner spinner=(Spinner) view.findViewById(R.id.SP);
        final Spinner spinner1=(Spinner)view.findViewById(R.id.simple);
        final Spinner spinner2=(Spinner)view.findViewById(R.id.simple1);
        final Spinner spinner3=(Spinner) view.findViewById(R.id.simple2);
        final Spinner spinner4=(Spinner)view.findViewById(R.id.simple3);
        final Spinner spinner5=(Spinner)view.findViewById(R.id.simple4);
        dept1=(TextView)view.findViewById(R.id.dept);
       // selected=(TextView)view.findViewById(R.id.selected);
        sem1=(TextView)view.findViewById(R.id.sem);
        sec1=(TextView)view.findViewById(R.id.sec);
        subcode=(EditText)view.findViewById(R.id.subject);
        year1=(TextView)view.findViewById(R.id.year);
        month1=(TextView)view.findViewById(R.id.month);
        day1=(TextView)view.findViewById(R.id.day);


        //cal=(CalendarView)view.findViewById(R.id.cal);
        usnentry= (EditText) view.findViewById(R.id.usnentry);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,dept);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sec);
        ArrayAdapter<String> d=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,year);
        ArrayAdapter<String> e=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,month);
        ArrayAdapter<String> f=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,day);
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
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        view.findViewById(R.id.date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                date.setVisibility(View.GONE);
                usn.setVisibility(View.GONE);
                dept1.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                sem1.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.VISIBLE);
                sec1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
              //  view1.setVisibility(View.VISIBLE);
                subcode.setVisibility(View.VISIBLE);
                year1.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                month1.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                day1.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);

                //  selected.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);



//                view1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                                Calendar cal=Calendar.getInstance();
//                        int year=cal.get(Calendar.YEAR);
//                        int month=cal.get(Calendar.MONTH);
//                        int day=cal.get(Calendar.DAY_OF_MONTH);
//                        DatePickerDialog dialog=new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
//                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                        dialog.show();
//                    }
//                });
//                mDateSetListener=new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                        String d,m,y;
//                        y=String.valueOf(year);
//                        d=String.valueOf(day);
//                        month=month+1;
//                        m=String.valueOf(month);
//                        String date=y+"-"+m+"-"+d;
//                        selected.setText(date);
//                    }
//                };


            }
        });
        view.findViewById(R.id.usn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usnentry.setVisibility(View.VISIBLE);
//                view2.setVisibility(View.VISIBLE);
                date.setVisibility(View.GONE);
                view1.setVisibility(View.VISIBLE);
                usn.setVisibility(View.GONE);
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        databaseReference.addValueEventListener(new ValueEventListener() {
                            int i=0,counter=0;
                            String usn1=usnentry.getText().toString();
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                for(DataSnapshot postSnapshot:dataSnapshot.child("StudentDetails").getChildren()) {
                                    roll = postSnapshot.getKey();
                                    data[counter] = roll;
                                    counter++;

                                    if(usn1.equalsIgnoreCase(data[i]))
                                    {
                                        Toast.makeText(getActivity(),"Verified",Toast.LENGTH_SHORT).show();
                                        Intent next=new Intent(getActivity(),usnwise.class);
                                        next.putExtra(EXTRA_MESSAGE1,usn1);
                                        startActivity(next);
                                        break ;
                                    }

                                    i++;
                                }

                                if(!usn1.equalsIgnoreCase(data[i])){
                                    Toast.makeText(getActivity(),"Not Verified",Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
//                        Intent attn=new Intent(getActivity(),usnwise.class);
//                        startActivity(attn);
                    }
                });

            }
        });
        view.findViewById(R.id.view2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String l1,l2,l3,l4,l5,l6,l7;
                l1= spinner.getSelectedItem().toString();
                l2=spinner1.getSelectedItem().toString();
                l3=spinner2.getSelectedItem().toString();
              // l4=selected.getText().toString();
                l5=spinner3.getSelectedItem().toString();
                l6=spinner4.getSelectedItem().toString();
                l7=spinner5.getSelectedItem().toString();

                Intent tab=new Intent(getActivity(),studentpresent.class);
                tab.putExtra(EXTRA_MESSAGE9,subcode.getText().toString());
                tab.putExtra(EXTRA_MESSAGE6,l1);
                tab.putExtra(EXTRA_MESSAGE7,l2);
                tab.putExtra(EXTRA_MESSAGE8,l3);
              //   tab.putExtra(EXTRA_MESSAGE10,l4);
                tab.putExtra(EXTRA_MESSAGE45,l5);
                tab.putExtra(EXTRA_MESSAGE46,l6);
                tab.putExtra(EXTRA_MESSAGE47,l7);
                startActivity(tab);

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}










