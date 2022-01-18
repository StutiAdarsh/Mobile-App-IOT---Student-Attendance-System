package com.example.dell.attendancesystem;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
public class report extends Fragment {
    public final static String EXTRA_MESSAGE18="com.example.dell.attendancesystem.MESSAGE18";
    public final static String EXTRA_MESSAGE19="com.example.dell.attendancesystem.MESSAGE19";
    public final static String EXTRA_MESSAGE20="com.example.dell.attendancesystem.MESSAGE20";
    String[] branch={"cs","is","ec","tc","ee","me","cv"};
    String[] sem={"1","2","3","4","5","6","7","8"};
    String[] sec={"A","B","C","D","E","F","G","H","I","J"};
    Button report;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report,null);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner spinner=(Spinner)view.findViewById(R.id.SP1);
        final Spinner spinner1=(Spinner)view.findViewById(R.id.simple1);
        final Spinner spinner2=(Spinner)view.findViewById(R.id.simple2);
        report=(Button)view.findViewById(R.id.rep);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,branch);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sem);
        ArrayAdapter<String> c=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,sec);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);
        spinner1.setAdapter(b);
        spinner2.setAdapter(c);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l1,l2,l3;
                l1= spinner.getSelectedItem().toString();
                l2=spinner1.getSelectedItem().toString();
                l3=spinner2.getSelectedItem().toString();
                Intent rept=new Intent(getActivity(),generatereport.class);
                rept.putExtra(EXTRA_MESSAGE18,l1);
                rept.putExtra(EXTRA_MESSAGE19,l2);
                rept.putExtra(EXTRA_MESSAGE20,l3);
                startActivity(rept);
            }
        });

    }
}
