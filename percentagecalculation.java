package com.example.dell.attendancesystem;


import android.graphics.LightingColorFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class percentagecalculation extends Fragment {
    EditText usn;
    TextView s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    Button submit;
    String data,data1,data2,data3;
    String [] values,values1,j;
    TableLayout tb1;
    int [] l;

    View view;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseStudent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_percentagecalculation,null);
       usn=view.findViewById(R.id.uu);
       // code=view.findViewById(R.id.code);
        s1=view.findViewById(R.id.s1);
        s2=view.findViewById(R.id.s2);
        s3=view.findViewById(R.id.s3);
        s4=view.findViewById(R.id.s4);
        s5=view.findViewById(R.id.s5);
        s6=view.findViewById(R.id.s6);
        s7=view.findViewById(R.id.s7);
        s8=view.findViewById(R.id.s8);
        s9=view.findViewById(R.id.s9);
        s10=view.findViewById(R.id.s10);
        final TableLayout tb1=(TableLayout)view.findViewById(R.id.tl);
        final TableRow tr=(TableRow)view.findViewById(R.id.tr1);
        final TableRow tr1=(TableRow)view.findViewById(R.id.tr2);
        final TableRow tr2=(TableRow)view.findViewById(R.id.tr3);
        final TableRow tr3=(TableRow)view.findViewById(R.id.tr4);
        final TableRow tr4=(TableRow)view.findViewById(R.id.tr5);
        final TableRow tr5=(TableRow)view.findViewById(R.id.tr6);

       j= new String[100];
       l=new int[100];
        values=new String[100];
        values1=new String[100];
        submit=view.findViewById(R.id.atdpercent);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseStudent=firebaseDatabase.getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              usn.setVisibility(view.GONE);
               // code.setVisibility(view.GONE);
                submit.setVisibility(view.GONE);
                s1.setVisibility(view.VISIBLE);
                s2.setVisibility(view.VISIBLE);
                s3.setVisibility(view.VISIBLE);
                s4.setVisibility(view.VISIBLE);
                s5.setVisibility(view.VISIBLE);
                s6.setVisibility(view.VISIBLE);
                s7.setVisibility(view.VISIBLE);
                s8.setVisibility(view.VISIBLE);
                s9.setVisibility(view.VISIBLE);
                s10.setVisibility(view.VISIBLE);
              tb1.setVisibility(view.VISIBLE);
                tr.setVisibility(view.VISIBLE);
                tr1.setVisibility(view.VISIBLE);
                tr2.setVisibility(view.VISIBLE);
                tr3.setVisibility(view.VISIBLE);
                tr4.setVisibility(view.VISIBLE);
                tr5.setVisibility(view.VISIBLE);

                data1=usn.getText().toString();
                databaseStudent.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      int counter=0,i,counter1=0,k;
                      String a="75";

                       // loop:
                        for(DataSnapshot postSnapshot:dataSnapshot.child("StudentDetails").child(data1).child("Average").getChildren()){
                            data=postSnapshot.getKey();
                            data3=postSnapshot.getValue().toString();
                            values[counter]=data;
                            values1[counter1]=data3;
                            counter++;
                            counter1++;


//                            if(data2.equals(values[counter])){
//                                break loop;
//                            }
                        }
//
//                        for(i=0;i<=10;i++){
////                          if(values1[i]<=a){}
//                            l[i]=Integer.valueOf(values1[i]);
//                            Toast.makeText(getActivity(),l[i],Toast.LENGTH_LONG).show();
//                        }

//                            if(l[0]<75){s2.setText(values1[0]);
//                                s2.setBackgroundColor(getResources().getColor(R.color.colorAccent));}
//                        for(k=0;k<=counter;k++) {
//                        s1.setText(values[0]);
//                            if(j[0]<=75) {
//                                s2.setText(values1[0]);
//                                s2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                            }
//                            else {
//                                s2.setText(values1[0]);
//                                s2.setBackgroundColor(getResources().getColor(R.color.green));
//
//                            }
                            s1.setText(values[0]);
                           s2.setText(values1[0]);
                            s3.setText(values[1]);
                            s4.setText(values1[1]);
                            s5.setText(values[2]);
                            s6.setText(values1[2]);
                            s7.setText(values[3]);
                            s8.setText(values1[3]);
                            s9.setText(values[4]);
                            s10.setText(values1[4]);
//                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
      return  view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
