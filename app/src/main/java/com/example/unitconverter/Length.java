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

public class Length extends AppCompatActivity {
    Spinner length_options1,length_options2;
    protected Button button;
    protected TextView textView;
    protected EditText editText;
    protected Spinner lengthOptions1;
    protected Spinner lengthOptions2;
    protected String selectedlen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        button = findViewById(R.id.button2);
        editText=findViewById(R.id.editText4);
        textView=findViewById(R.id.textView);
        lengthOptions1=(Spinner) findViewById(R.id.length_options1);
        lengthOptions2=(Spinner) findViewById(R.id.length_options2);
        lengthOptions1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedlen=adapterView.getItemAtPosition(i).toString();
                switch(selectedlen){
                    case "Centimeters":
                        lengthOptions2.setAdapter(new ArrayAdapter<String>(Length.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.CMOption)));
                        break;
                    case "Meters":
                        lengthOptions2.setAdapter(new ArrayAdapter<String>(Length.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.mption)));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lengthOptions2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if(selectedlen.equals("Centimeters")){
            output=input*0.01;
            textView.setText("" + output);
        }
        else{
            output=input*100;
            textView.setText("" + output);
        }



    }
}