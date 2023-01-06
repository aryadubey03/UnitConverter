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

public class Temperature extends AppCompatActivity {

    Spinner temp_options1,temp_options2;
    private Button button;
    private TextView textView;
    private EditText editText;
    private Spinner tempOptions1;
    private Spinner tempOptions2;
    private String selectedtemp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        button = findViewById(R.id.button2);
        editText=findViewById(R.id.editText4);
        textView=findViewById(R.id.textView);
        tempOptions1=(Spinner) findViewById(R.id.temp_options1);
        tempOptions2=(Spinner) findViewById(R.id.temp_options2);
        tempOptions1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedtemp=adapterView.getItemAtPosition(i).toString();
                switch(selectedtemp){
                    case "Celsius":
                        tempOptions2.setAdapter(new ArrayAdapter<String>(Temperature.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Foption)));
                        break;
                    case "Fahrenheit":
                        tempOptions2.setAdapter(new ArrayAdapter<String>(Temperature.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Coption)));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tempOptions2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if(selectedtemp.equals("Celsius")){
            output=(input*1.8)+32;
            textView.setText("" + output);
        }
        else{
            output=(input-32)*0.555;
            textView.setText("" + output);
        }



    }
}