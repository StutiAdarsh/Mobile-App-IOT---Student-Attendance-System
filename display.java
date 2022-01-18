package com.example.dell.attendancesystem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class display extends AppCompatActivity {
    public final static String EXTRA_MESSAGE27="com.example.dell.attendancesystem.MESSAGE27";


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String data,data1,data2,data3,data4,data5;
    String [] values,values1,values2,values3,values4,values5;
    TextView p1,p2,p3,p4,p5,p6,p7,p50,p51,p52,p53,p8,p9,p10,mon,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76,p77;
    String t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        values=new String[100];
        values1=new String[100];
        values2=new String[100];
        values3=new String[100];
        values4=new String[100];
        values5=new String[100];
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);
        p3=findViewById(R.id.p3);
        p4=findViewById(R.id.p4);
        p5=findViewById(R.id.p5);
        p6=findViewById(R.id.p6);
        p7=findViewById(R.id.p7);
        p8=findViewById(R.id.p8);
        p9=findViewById(R.id.p9);
        p10=findViewById(R.id.p10);
        p11=findViewById(R.id.p11);
        p12=findViewById(R.id.p12);
        p13=findViewById(R.id.p13);
        p14=findViewById(R.id.p14);
        p15=findViewById(R.id.p15);
        p16=findViewById(R.id.p16);
        p17=findViewById(R.id.p17);
        p18=findViewById(R.id.p18);
        p19=findViewById(R.id.p19);
        p20=findViewById(R.id.p20);
        p21=findViewById(R.id.p21);
        p22=findViewById(R.id.p22);
        p23=findViewById(R.id.p23);
        p24=findViewById(R.id.p24);
        p25=findViewById(R.id.p25);
        p26=findViewById(R.id.p26);
        p27=findViewById(R.id.p27);
        p28=findViewById(R.id.p28);
        p29=findViewById(R.id.p29);
        p30=findViewById(R.id.p30);
        p31=findViewById(R.id.p31);
        p32=findViewById(R.id.p32);
        p33=findViewById(R.id.p33);
        p34=findViewById(R.id.p34);
        p35=findViewById(R.id.p35);
        p36=findViewById(R.id.p36);
        p37=findViewById(R.id.p37);
        p38=findViewById(R.id.p38);
        p39=findViewById(R.id.p39);
        p40=findViewById(R.id.p40);
        p41=findViewById(R.id.p41);
        p42=findViewById(R.id.p42);
        p43=findViewById(R.id.p43);
        p44=findViewById(R.id.p44);
        p45=findViewById(R.id.p45);
        p46=findViewById(R.id.p46);
        p47=findViewById(R.id.p47);
        p48=findViewById(R.id.p48);
        p49=findViewById(R.id.p49);
        p50=findViewById(R.id.p50);
        p51=findViewById(R.id.p51);
        p52=findViewById(R.id.p52);
        p53=findViewById(R.id.p53);
        p54=findViewById(R.id.p54);
        p55=findViewById(R.id.p55);
        p56=findViewById(R.id.p56);
        p57=findViewById(R.id.p57);
        p58=findViewById(R.id.p58);
        p59=findViewById(R.id.p59);
        p60=findViewById(R.id.p60);
        p61=findViewById(R.id.p61);
        p62=findViewById(R.id.p62);
        p63=findViewById(R.id.p63);
        p64=findViewById(R.id.p64);
        p65=findViewById(R.id.p65);
        p66=findViewById(R.id.p66);
        p67=findViewById(R.id.p67);
        p68=findViewById(R.id.p68);
        p69=findViewById(R.id.p69);
        p70=findViewById(R.id.p70);
        p71=findViewById(R.id.p71);
        p72=findViewById(R.id.p72);
        p73=findViewById(R.id.p73);
        p74=findViewById(R.id.p74);
        p75=findViewById(R.id.p75);
        p76=findViewById(R.id.p76);
        p77=findViewById(R.id.p77);
        t1=p1.getText().toString();
        t2=p2.getText().toString();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {

            int counter=0,counter1=0,counter2=0,counter3=0,counter4=0,counter5=0;
            Intent intent=getIntent();
            String branch1=intent.getStringExtra(tableview.EXTRA_MESSAGE2);
            String sem=intent.getStringExtra(tableview.EXTRA_MESSAGE3);
            String sec=intent.getStringExtra(tableview.EXTRA_MESSAGE4);


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Mon").getChildren()) {
                    data = postSnapshot.getValue().toString();
                    values[counter] = data;
                    counter++;
                    p8.setText(values[0]);
                    p9.setText(values[1]);
                    p10.setText(values[2]);
                    p11.setText(values[3]);
                    p12.setText(values[4]);
                    p13.setText(values[5]);
                    p14.setText(values[6]);
                    p54.setText(values[7]);
                    p55.setText(values[8]);
                    p56.setText(values[9]);
                    p57.setText(values[10]);}
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Tue").getChildren()){
                    data1 = postSnapshot.getValue().toString();
                    values1[counter1] = data1;
                    counter1++;
                    p15.setText(values1[0]);
                    p16.setText(values1[1]);
                    p17.setText(values1[2]);
                    p18.setText(values1[3]);
                    p19.setText(values1[4]);
                    p20.setText(values1[5]);
                    p21.setText(values1[6]);
                    p58.setText(values1[7]);
                    p59.setText(values1[8]);
                    p60.setText(values1[9]);
                    p61.setText(values1[10]);}
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Wed").getChildren()){
                    data2= postSnapshot.getValue().toString();
                    values2[counter2] = data2;
                    counter2++;
                    p22.setText(values2[0]);
                    p23.setText(values2[1]);
                    p24.setText(values2[2]);
                    p25.setText(values2[3]);
                    p26.setText(values2[4]);
                    p27.setText(values2[5]);
                    p28.setText(values2[6]);
                    p62.setText(values2[7]);
                    p63.setText(values2[8]);
                    p64.setText(values2[9]);
                    p65.setText(values2[10]);}
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Thu").getChildren()){
                    data3= postSnapshot.getValue().toString();
                    values3[counter3] = data3;
                    counter3++;
                    p29.setText(values3[0]);
                    p30.setText(values3[1]);
                    p31.setText(values3[2]);
                    p32.setText(values3[3]);
                    p33.setText(values3[4]);
                    p34.setText(values3[5]);
                    p35.setText(values3[6]);
                    p66.setText(values3[7]);
                    p67.setText(values3[8]);
                    p68.setText(values3[9]);
                    p69.setText(values3[10]);}
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Fri").getChildren()){
                    data4 = postSnapshot.getValue().toString();
                    values4[counter4] = data4;
                    counter4++;
                    p36.setText(values4[0]);
                    p37.setText(values4[1]);
                    p38.setText(values4[2]);
                    p39.setText(values4[3]);
                    p40.setText(values4[4]);
                    p41.setText(values4[5]);
                    p42.setText(values4[6]);
                    p70.setText(values4[7]);
                    p71.setText(values4[8]);
                    p72.setText(values4[9]);
                    p73.setText(values4[10]);}
                for(DataSnapshot postSnapshot:dataSnapshot.child("Timetable").child(branch1).child(sem).child(sec).child("Sat").getChildren()) {
                    data5= postSnapshot.getValue().toString();
                    values5[counter5] = data5;
                    counter5++;
                    p43.setText(values5[0]);
                    p44.setText(values5[1]);
                    p45.setText(values5[2]);
                    p46.setText(values5[3]);
                    p47.setText(values5[4]);
                    p48.setText(values5[5]);
                    p49.setText(values5[6]);
                    p74.setText(values5[7]);
                    p75.setText(values5[8]);
                    p76.setText(values5[9]);
                    p77.setText(values5[10]);
                }




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
