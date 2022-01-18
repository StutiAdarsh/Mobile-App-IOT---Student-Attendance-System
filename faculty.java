package com.example.dell.attendancesystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class faculty extends AppCompatActivity implements View.OnClickListener {

    private EditText emailField,passwordField;
    private Button check,login;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String data;
    String [] time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);
        emailField = (EditText) findViewById(R.id.emailField);
        check=(Button) findViewById(R.id.check);
        passwordField = (EditText) findViewById(R.id.passwordField);
        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        time=new String[100];
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    int i=0,counter=0;
                    String email=emailField.getText().toString();
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        breakloop:
                        for(DataSnapshot postSnapshot:dataSnapshot.child("facultyDetails").getChildren()) {
                            data = postSnapshot.getValue().toString();
                            time[counter] = data;
                            counter++;

                         //   for()
                        if(email.equalsIgnoreCase(time[i]))
                            {
                                Toast.makeText(faculty.this,"Verified",Toast.LENGTH_SHORT).show();
                                check.setVisibility(View.GONE);
                                passwordField.setVisibility(View.VISIBLE);
                                login.setVisibility(View.VISIBLE);

                                break breakloop;
                            }

                            i++;

                        }
                            if(!email.equalsIgnoreCase(time[i]))
                                Toast.makeText(faculty.this,"Not Verified",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
                );


            }
        });}

        private void registerUser(){
            String email=emailField.getText().toString().trim();
            String password=passwordField.getText().toString().trim();
            if (TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
                Toast.makeText(faculty.this,"Fields are empty",Toast.LENGTH_LONG).show();
                return;
            }
            progressDialog.setMessage("Registering User....");
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(faculty.this,"Registered successfully",Toast.LENGTH_LONG).show();
                        Intent fachome=new Intent(faculty.this,fhome.class);
                        startActivity(fachome);
                    }
                    else if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(faculty.this,"Registered user login",Toast.LENGTH_LONG).show();
                        Intent fachome=new Intent(faculty.this,fhome.class);
                        startActivity(fachome);
                    }
                    else {
                        Toast.makeText(faculty.this,"Could not register.Please try again",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    @Override
    public void onClick(View view) {
        registerUser();
    }
}



