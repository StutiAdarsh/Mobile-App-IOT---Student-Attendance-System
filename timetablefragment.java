package com.example.dell.attendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class timetablefragment extends Fragment {

    String[] branch={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    String[] day={"Mon","Tue","Wed","Thu","Fri","Sat"};
    String[] slot={"07:00:00","08:00:00","09:00:00","10:00:00","11:00:00","12:00:00","01:00:00","02:00:00","03:00:00","04:00:00","05:00:00"};
    EditText sub;
    String dat[];
    String store;
    Button add,dis,view3;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_timetablefragment,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner spinner=(Spinner) view.findViewById(R.id.SP);
        final Spinner spinner1=(Spinner)view.findViewById(R.id.simple);
        final Spinner spinner2=(Spinner)view.findViewById(R.id.simple1);
        final Spinner spinner3=(Spinner)view.findViewById(R.id.simple2);
        final Spinner spinner4=(Spinner)view.findViewById(R.id.simple3);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,branch);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sec);
        ArrayAdapter<String> d=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,day);
        ArrayAdapter<String> e=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,slot);

        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        d.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);
        spinner3.setAdapter(d);
        spinner4.setAdapter(e);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (adapterView.getItemAtPosition(i).toString().equals("--SELECT--")) {
//                }
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        dat=new String[100];
        sub=view.findViewById(R.id.subcode);
        add= view.findViewById(R.id.add);
        dis= view.findViewById(R.id.view);
        view3= view.findViewById(R.id.view3);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subj=sub.getText().toString();
                String t,t1,t2,t3,t4;

                t= spinner.getSelectedItem().toString();
                t1=spinner1.getSelectedItem().toString();
                t2=spinner2.getSelectedItem().toString();
                t3=spinner3.getSelectedItem().toString();
                t4=spinner4.getSelectedItem().toString();
                databaseReference.child("Timetable").child(t).child(t1).child(t2).child(t3).child(t4).setValue(subj);
                Toast.makeText(getActivity(),subj,Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(),"Time table added",Toast.LENGTH_LONG).show();
            }
        });
        view.findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tab=new Intent(getActivity(),tableview.class);
                startActivity(tab);
            }
        });
        view.findViewById(R.id.view3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String t5,t6,t7,t8,t9;
               final String subj1=sub.getText().toString();
                t5= spinner.getSelectedItem().toString();
                t6=spinner1.getSelectedItem().toString();
                t7=spinner2.getSelectedItem().toString();
                t8=spinner3.getSelectedItem().toString();
                t9=spinner4.getSelectedItem().toString();

                databaseReference.addValueEventListener(new ValueEventListener() {
                   int countr=0,i;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot2:dataSnapshot.child("Timetable").child(t5).child(t6).child(t7).child(t8).getChildren()) {
                            store = postSnapshot2.getKey();
                            dat[countr] = store;
                            countr++;
                        }
                        for(i=0;i<=countr;i++){
                            if(t9.equals(dat[i])){
                                databaseReference.child("Timetable").child(t5).child(t6).child(t7).child(t8).child(t9).setValue(subj1);
                                Toast.makeText(getActivity(),"Timetable modified",Toast.LENGTH_SHORT).show();

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

