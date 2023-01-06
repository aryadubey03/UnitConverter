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

public class Weight extends AppCompatActivity {
    Spinner weight_options1,weight_options2;
    protected Button button;
    protected TextView textView;
    protected EditText editText;
    protected Spinner weightOptions1;
    protected Spinner weightOptions2;
    protected String selectedweight;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        button = findViewById(R.id.button2);
        editText=findViewById(R.id.editText4);
        textView=findViewById(R.id.textView);
        weightOptions1=(Spinner) findViewById(R.id.weight_options1);
        weightOptions2=(Spinner) findViewById(R.id.weight_options2);
        weightOptions1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedweight=adapterView.getItemAtPosition(i).toString();
                switch(selectedweight){
                    case "Kilograms":
                        weightOptions2.setAdapter(new ArrayAdapter<String>(Weight.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.goption)));
                        break;
                    case "Grams":
                        weightOptions2.setAdapter(new ArrayAdapter<String>(Weight.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.KgOption)));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        weightOptions2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

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
        if(selectedweight.equals("Kilograms")){
            output=input*1000;
            textView.setText("" + output);
        }
        else{
            output=input*0.001;
            textView.setText("" + output);
        }



    }
}