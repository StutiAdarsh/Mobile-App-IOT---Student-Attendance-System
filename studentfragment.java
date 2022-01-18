package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentfragment extends Fragment {
    EditText card,usn,name;
    TextView dept1,sem1,sec1;
    Button add,register;
    String[] branch={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseStudent;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_student,null);
        final Spinner spinner=(Spinner)view.findViewById(R.id.SP1);
        final Spinner spinner1=(Spinner)view.findViewById(R.id.simple1);
        final Spinner spinner2=(Spinner)view.findViewById(R.id.simple2);
        card= (EditText) view.findViewById(R.id.card);
        usn= (EditText) view.findViewById(R.id.usn);
        name= (EditText) view.findViewById(R.id.name);
        dept1= (TextView)view.findViewById(R.id.dept);
        sem1=(TextView) view.findViewById(R.id.sem);
        sec1=(TextView) view.findViewById(R.id.sec);

        add=(Button) view.findViewById(R.id.add);
        register=(Button) view.findViewById(R.id.add1);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,branch);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sec);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseStudent=firebaseDatabase.getReference();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String card1=card.getText().toString();
                String usn1=usn.getText().toString();
                String name1=name.getText().toString();
                if(!TextUtils.isEmpty(card1)||!TextUtils.isEmpty(usn1)||!TextUtils.isEmpty(name1)){
                    String facultyQueue=databaseStudent.push().getKey();
                    databaseStudent.child("StudentQueue").child(card1).child("USN").setValue(usn1);
                    databaseStudent.child("StudentQueue").child(card1).child("Name").setValue(name1);
                    Toast.makeText(getActivity(),"Student added",Toast.LENGTH_LONG).show();
                    card.setVisibility(View.GONE);
                    spinner.setVisibility(View.VISIBLE);
                    spinner1.setVisibility(View.VISIBLE);
                    spinner2.setVisibility(View.VISIBLE);
                    register.setVisibility(View.VISIBLE);
                    dept1.setVisibility(View.VISIBLE);
                    sem1.setVisibility(View.VISIBLE);
                    sec1.setVisibility(View.VISIBLE);
                    add.setVisibility(View.GONE);

                }
                else {
                    Toast.makeText(getActivity(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
            }
        });
        view.findViewById(R.id.add1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l1,l2,l3;
                String usn1=usn.getText().toString();
                String name1=name.getText().toString();
                l1= spinner.getSelectedItem().toString();
                l2=spinner1.getSelectedItem().toString();
                l3=spinner2.getSelectedItem().toString();
                databaseStudent.child("Students").child(l1).child(l2).child(l3).child(usn1).setValue(name1);
                Toast.makeText(getActivity(),"Student registered successfully",Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
