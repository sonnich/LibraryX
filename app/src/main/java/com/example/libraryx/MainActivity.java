package com.example.libraryx;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] valuesDisplayed= getPickerValues(10);
        numberPicker = findViewById(R.id.numberPicker);
        setupNumberPicker(numberPicker, valuesDisplayed);



    }


    public String[] getPickerValues(int i){
        String[] values = new String[i];

        for (int j = 0; j < i; j++) {

            int num = j*5;
            values[j] = Integer.toString(num);
        }
        return values;
    }

    public void setupNumberPicker(NumberPicker numberPicker, String[] values){


        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(values.length-1);
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setDisplayedValues(values);
        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", 1);
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });

    }
}