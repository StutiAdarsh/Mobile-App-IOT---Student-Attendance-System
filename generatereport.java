package com.example.dell.attendancesystem;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class generatereport extends AppCompatActivity {
     TextView usn2,usn3,usn4,usn5,usn6,usn7,a73,a74,a75,a76,a77,a78,a79,a80,a81,a82,a83,a84,a85,a86,a87,a88,a89,a90,a91,a92,a93,a94,a95,a96,a61,a62,a63,a64,a65,a66,a67,a68,a69,a70,a71,a72,a1,a2,a3,a4,a5,a6,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40,a41,a42,a43,a44,a45,a46,a47,a48,a49,a50,a51,a52,a53,a54;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseStudent;
    String [] data,data1,data2,data3,data4;
    String usn,subs,subs1,subs2,subs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatereport);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseStudent=firebaseDatabase.getReference();
        data=new String[100];
        data1=new String[100];
        data2=new String[100];
        data3=new String[100];
        data4=new String[100];
        usn2=findViewById(R.id.usn2);
        usn3=findViewById(R.id.usn3);
        usn4=findViewById(R.id.usn4);
        usn5=findViewById(R.id.usn5);
        usn6=findViewById(R.id.usn6);
        usn7=findViewById(R.id.usn7);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        a4=findViewById(R.id.a4);
        a5=findViewById(R.id.a5);
        a6=findViewById(R.id.a6);
        a19=findViewById(R.id.a19);
        a20=findViewById(R.id.a20);
        a21=findViewById(R.id.a21);
        a22=findViewById(R.id.a22);
        a23=findViewById(R.id.a23);
        a24=findViewById(R.id.a24);
        a25=findViewById(R.id.a25);
        a26=findViewById(R.id.a26);
        a27=findViewById(R.id.a27);
        a28=findViewById(R.id.a28);
        a29=findViewById(R.id.a29);
        a30=findViewById(R.id.a30);
        a31=findViewById(R.id.a31);
        a32=findViewById(R.id.a32);
        a33=findViewById(R.id.a33);
        a34=findViewById(R.id.a34);
        a35=findViewById(R.id.a35);
        a36=findViewById(R.id.a36);
        a37=findViewById(R.id.a37);
        a38=findViewById(R.id.a38);
        a39=findViewById(R.id.a39);
        a40=findViewById(R.id.a40);
        a41=findViewById(R.id.a41);
        a42=findViewById(R.id.a42);
        a43=findViewById(R.id.a43);
        a44=findViewById(R.id.a44);
        a45=findViewById(R.id.a45);
        a46=findViewById(R.id.a46);
        a47=findViewById(R.id.a47);
        a48=findViewById(R.id.a48);
        a49=findViewById(R.id.a49);
        a50=findViewById(R.id.a50);
        a51=findViewById(R.id.a51);
        a52=findViewById(R.id.a52);
        a53=findViewById(R.id.a53);
        a54=findViewById(R.id.a54);
        a61=findViewById(R.id.a61);
        a62=findViewById(R.id.a62);
        a63=findViewById(R.id.a63);
        a64=findViewById(R.id.a64);
        a65=findViewById(R.id.a65);
        a66=findViewById(R.id.a66);
        a67=findViewById(R.id.a67);
        a68=findViewById(R.id.a68);
        a69=findViewById(R.id.a69);
        a70=findViewById(R.id.a70);
        a71=findViewById(R.id.a71);
        a72=findViewById(R.id.a72);
        a73=findViewById(R.id.a73);
        a74=findViewById(R.id.a74);
        a75=findViewById(R.id.a75);
        a76=findViewById(R.id.a76);
        a77=findViewById(R.id.a77);
        a78=findViewById(R.id.a78);
        a79=findViewById(R.id.a79);
        a80=findViewById(R.id.a80);
        a81=findViewById(R.id.a81);
        a82=findViewById(R.id.a82);
        a83=findViewById(R.id.a83);
        a84=findViewById(R.id.a84);
        a85=findViewById(R.id.a85);
        a86=findViewById(R.id.a86);
        a87=findViewById(R.id.a87);
        a88=findViewById(R.id.a88);
        a89=findViewById(R.id.a89);
        a90=findViewById(R.id.a90);
        a91=findViewById(R.id.a91);
        a92=findViewById(R.id.a92);
        a93=findViewById(R.id.a93);
        a94=findViewById(R.id.a94);
        a95=findViewById(R.id.a95);
        a96=findViewById(R.id.a96);
        databaseStudent.addValueEventListener(new ValueEventListener() {
            int counter=0,counter1=0,counter2=0,counter3=0,i=0,counter4=0;
            Intent intent=getIntent();
            String branch=intent.getStringExtra(report.EXTRA_MESSAGE18);
            String sem=intent.getStringExtra(report.EXTRA_MESSAGE19);
            String sec=intent.getStringExtra(report.EXTRA_MESSAGE20);
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.child("Students").child(branch).child(sem).child(sec).getChildren())
                {
                    usn=postSnapshot.getKey();
                    data[counter]=usn;
                    counter++;
                    usn2.setText(data[0]);
                    usn3.setText(data[1]);
                    usn4.setText(data[2]);
                    usn5.setText(data[3]);
                    usn6.setText(data[4]);
                    usn7.setText(data[5]);
                }
                for(DataSnapshot postSnapshot3:dataSnapshot.child("Timetable").child(branch).child(sem).child(sec).child("total_class").getChildren())
                {
                    subs2=postSnapshot3.getValue().toString();
                    subs3=postSnapshot3.getKey();
                    data3[counter3]=subs2;
                    data4[counter4]=subs3;
                    counter3++;
                    counter4++;
                    a1.setText(data4[0]);
                    a2.setText(data4[1]);
                    a3.setText(data4[2]);
                    a4.setText(data4[3]);
                    a5.setText(data4[4]);
                    a6.setText(data4[5]);
                    a20.setText(data3[0]);
                    a22.setText(data3[1]);
                    a24.setText(data3[2]);
                    a26.setText(data3[3]);
                    a28.setText(data3[4]);
                    a30.setText(data3[5]);
                    a32.setText(data3[0]);
                    a34.setText(data3[1]);
                    a36.setText(data3[2]);
                    a38.setText(data3[3]);
                    a40.setText(data3[4]);
                    a42.setText(data3[5]);
                    a44.setText(data3[0]);
                    a46.setText(data3[1]);
                    a48.setText(data3[2]);
                    a50.setText(data3[3]);
                    a52.setText(data3[4]);
                    a54.setText(data3[5]);
                    a62.setText(data3[0]);
                    a64.setText(data3[1]);
                    a66.setText(data3[2]);
                    a68.setText(data3[3]);
                    a70.setText(data3[4]);
                    a72.setText(data3[5]);
                    a74.setText(data3[0]);
                    a76.setText(data3[1]);
                    a78.setText(data3[2]);
                    a80.setText(data3[3]);
                    a82.setText(data3[4]);
                    a84.setText(data3[5]);
                    a86.setText(data3[0]);
                    a88.setText(data3[1]);
                    a90.setText(data3[2]);
                    a92.setText(data3[3]);
                    a94.setText(data3[4]);
                    a96.setText(data3[5]);

                }

                for(i=0;i<counter;i++)
                {
                    for(DataSnapshot postSnapshot1:dataSnapshot.child("StudentDetails").child(data[i]).child("Attendance").getChildren()) {
                        subs = postSnapshot1.getKey();
                        subs1 = postSnapshot1.getValue().toString();
                        data1[counter1] = subs;
                        data2[counter2] = subs1;
                        counter1++;
                        counter2++;
                        a19.setText(data2[0]);
                        a21.setText(data2[1]);
                        a23.setText(data2[2]);
                        a25.setText(data2[3]);
                        a27.setText(data2[4]);
                        a29.setText(data2[5]);
                        a31.setText(data2[6]);
                        a33.setText(data2[7]);
                        a35.setText(data2[8]);
                        a37.setText(data2[9]);
                        a39.setText(data2[10]);
                        a41.setText(data2[11]);
                        a43.setText(data2[12]);
                        a45.setText(data2[13]);
                        a47.setText(data2[14]);
                        a49.setText(data2[15]);
                        a51.setText(data2[16]);
                        a53.setText(data2[17]);
                        a61.setText(data2[18]);
                        a63.setText(data2[19]);
                        a65.setText(data2[20]);
                        a67.setText(data2[21]);
                        a69.setText(data2[22]);
                        a71.setText(data2[23]);
                        a73.setText(data2[24]);
                        a75.setText(data2[25]);
                        a77.setText(data2[26]);
                        a79.setText(data2[27]);
                        a81.setText(data2[28]);
                        a83.setText(data2[29]);
                        a85.setText(data2[30]);
                        a87.setText(data2[31]);
                        a89.setText(data2[32]);
                        a91.setText(data2[33]);
                        a93.setText(data2[34]);
                        a95.setText(data2[23]);



                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
