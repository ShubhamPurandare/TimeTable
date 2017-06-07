package com.example.root.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TimeTableSetup extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String selection[] = {"","","","","",""};
    Spinner spinner_branch,spinner_year,spinner_sem,spinner_subject,spinner_staff,spinner_division;
    ArrayAdapter<String> adapter_branch;
    ArrayAdapter<String> adapter_year;
    ArrayAdapter<String> adapter_sem;
    ArrayAdapter<String> adapter_division;
    ArrayAdapter<String> adapter_subject;
    ArrayAdapter<String> adapter_staff;
    final String branch[]={"Select Branch","B1","B2","B3","B4"};
    final String year[]={"Select Year","FE","SE","TE","BE"};
    final String sem[]={"Select Sem","S1","S2"};
    final String division[]={"Select Division","D1","D2","D3","D4"};
    final String subject[]={"Select Subject","Sub1","Sub2","Sub3","Sub4"};
    final String staff[]={"Select Staff","A","B","C","D"};
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_setup);

        spinner_branch = (Spinner)findViewById(R.id.spinner_branch_id);
        spinner_sem = (Spinner)findViewById(R.id.spinner_sem_id);
        spinner_staff = (Spinner)findViewById(R.id.spinner_staff_id);
        spinner_subject = (Spinner)findViewById(R.id.spinner_subject_id);
        spinner_year = (Spinner)findViewById(R.id.spinner_year_id);
        spinner_division = (Spinner)findViewById(R.id.spinner_division_id);

        adapter_branch = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,branch);
        adapter_branch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_branch.setAdapter(adapter_branch);
        spinner_branch.setOnItemSelectedListener(this);

        adapter_division = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,division);
        adapter_division.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_division.setAdapter(adapter_division);
        spinner_division.setOnItemSelectedListener(this);

        adapter_sem = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,sem);
        adapter_sem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sem.setAdapter(adapter_sem);
        spinner_sem.setOnItemSelectedListener(this);

        adapter_staff = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,staff);
        adapter_staff.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_staff.setAdapter(adapter_staff);
        spinner_staff.setOnItemSelectedListener(this);

        adapter_year = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,year);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(adapter_year);
        spinner_year.setOnItemSelectedListener(this);

        adapter_subject = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,subject);
        adapter_subject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_subject.setAdapter(adapter_subject);
        spinner_subject.setOnItemSelectedListener(this);

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selection[0]=spinner_branch.getSelectedItem().toString();
        selection[1]=spinner_year.getSelectedItem().toString();
        selection[2]=spinner_sem.getSelectedItem().toString();
        selection[3]=spinner_division.getSelectedItem().toString();
        selection[4]=spinner_staff.getSelectedItem().toString();
        selection[5]=spinner_subject.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void finalize(View view) {
        table = (TableLayout) findViewById(R.id.time_table_table);

        String time,day;
        for(int i=1;i<6;i++)
        {
            TableRow table_row_object =(TableRow)table.getChildAt(i);
            for(int j=1;j<table_row_object.getChildCount();j++)
            {
                Toast.makeText(this,"Hi1",Toast.LENGTH_LONG).show();



                CheckBox checkbox = (CheckBox)table_row_object.getChildAt(j);
                if(checkbox.isChecked())
                {
                    day = convertI(i);
                    time = convertJ(j);
                    Toast.makeText(this,day,Toast.LENGTH_LONG).show();
                }

            }
        }
        //String data = Arrays.toString(selection);
        //Toast.makeText(this,data, Toast.LENGTH_LONG).show();
    }

    private String convertJ(int j) {
        switch(j) {
            case 1:
                return "TimeSlot1";
            case 2:
                return "TimeSlot2";
            case 3:
                return "TimeSlot3";
            case 4:
                return "TimeSlot4";
            case 5:
                return "TimeSlot5";
            case 6:
                return "TimeSlot6";
            case 7:
                return "TimeSlot7";
            case 8:
                return "TimeSlot8";
            default:
                return "Error";

        }
    }

    private String convertI(int i) {
        switch(i)
        {
            case 1:
                return "Monday";
            case 2:
                return "Tueday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Error";
        }
    }
}
