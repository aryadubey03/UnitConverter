package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Time extends AppCompatActivity {
    Spinner time_options1,time_options2;
    protected Button button;
    protected TextView textView;
    protected EditText editText;
    protected Spinner timeOptions1;
    protected Spinner timeOptions2;
    protected String selectedtime;
    protected String selectedtime2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        button = findViewById(R.id.button2);
        editText=findViewById(R.id.editText4);
        textView=findViewById(R.id.textView);
        timeOptions1=(Spinner) findViewById(R.id.time_options1);
        timeOptions2=(Spinner) findViewById(R.id.time_options2);
        timeOptions1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedtime=adapterView.getItemAtPosition(i).toString();
                switch(selectedtime){
                    case "Hours":
                        timeOptions2.setAdapter(new ArrayAdapter<String>(Time.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Hours)));
                        break;
                    case "Minutes":
                        timeOptions2.setAdapter(new ArrayAdapter<String>(Time.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Minutes)));
                        break;
                    case "Seconds":
                        timeOptions2.setAdapter(new ArrayAdapter<String>(Time.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Seconds)));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        timeOptions2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedtime2=adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void calculate(View view){
        String s=editText.getText().toString();
        int input = Integer.parseInt(s);
        double output;
        if(selectedtime.equals("Hours") && selectedtime2.equals("Minutes")){
            output=input*60;
            textView.setText("" + output);
        }
        else if(selectedtime.equals("Hours") && selectedtime2.equals("Seconds")){
            output=input*60*60;
            textView.setText("" + output);
        }
        else if(selectedtime.equals("Minutes") && selectedtime2.equals("Hours")){
            output=input/60.0;
            textView.setText("" + output);
        }
        else if(selectedtime.equals("Minutes") && selectedtime2.equals("Seconds")){
            output=input/60.0;
            textView.setText("" + output);
        }
        else if(selectedtime.equals("Seconds") && selectedtime2.equals("Hours")){
            output=input/3600.0;
            textView.setText("" + output);
        }
        else{
            output=input/60.0;
            textView.setText("" + output);
        }



    }
}