package com.example.unitconverter;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Currency extends AppCompatActivity {
    Spinner currency_options1,currency_options2;
    private Button button;
    private TextView textView;
    private EditText editText;
    private Spinner currencyOptions1;
    private Spinner currencyOptions2;
    private String selectedCurr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        button = findViewById(R.id.button2);
        editText=findViewById(R.id.editText4);
        textView=findViewById(R.id.textView);
        currencyOptions1=(Spinner) findViewById(R.id.currency_options1);
        currencyOptions2=(Spinner) findViewById(R.id.currency_options2);
        currencyOptions1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCurr=adapterView.getItemAtPosition(i).toString();
                switch(selectedCurr){
                    case "Rupees":
                        currencyOptions2.setAdapter(new ArrayAdapter<String>(Currency.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.DOption)));
                        break;
                    case "Dollars":
                        currencyOptions2.setAdapter(new ArrayAdapter<String>(Currency.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.RsOption)));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        currencyOptions2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if(selectedCurr.equals("Rupees")){
           output=input*0.012;
            textView.setText("" + output);
        }
        else{
            output=input*82.70;
            textView.setText("" + output);
        }



    }
}