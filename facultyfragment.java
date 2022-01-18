package com.example.dell.attendancesystem;

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

public class facultyfragment extends Fragment {
    String[] branch1={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    EditText name,subj;
    EditText emailField;
    Button loginbtn1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseFaculty;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_faculty,null);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner spinner=(Spinner)view. findViewById(R.id.SP);
        final Spinner spinner1=(Spinner)view.findViewById(R.id.simple);
        final Spinner spinner2=(Spinner)view.findViewById(R.id.simple1);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,branch1);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sec);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);
        name= (EditText) view.findViewById(R.id.name);
        subj=(EditText)view.findViewById(R.id.subcode);
        emailField=(EditText) view.findViewById(R.id.emailField);
        loginbtn1=(Button) view.findViewById(R.id.loginbtn);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseFaculty=firebaseDatabase.getReference();
        loginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t,t1,t2;
                String subcode1=subj.getText().toString();
                String fname=name.getText().toString();
                String email=emailField.getText().toString();
                t=spinner.getSelectedItem().toString();
                t1=spinner1.getSelectedItem().toString();
                t2=spinner2.getSelectedItem().toString();

                if(!TextUtils.isEmpty(fname)||!TextUtils.isEmpty(email)||!TextUtils.isEmpty(subcode1)){
                    String facultyQueue=databaseFaculty.push().getKey();
                    String facultyDetails=databaseFaculty.push().getKey();
                    databaseFaculty.child("facultyQueue").child(t).child(t1).child(t2).child(subcode1).child(fname).setValue(email);
                    databaseFaculty.child("facultyDetails").child(fname).setValue(email);
                    Toast.makeText(getActivity(),"Faculty added",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
