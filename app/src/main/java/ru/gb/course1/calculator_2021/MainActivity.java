package ru.gb.course1.calculator_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    public void zero_btn(View view){

    }
    public void one_btn(View view){

    }
    public void two_btn(View view){

    }
    public void three_btn(View view){

    }
    public void four_btn(View view){

    }
    public void five_btn(View view){

    }
    public void six_btn(View view){

    }
    public void seven_btn(View view){

    }
    public void eith_btn(View view){

    }
    public void eleven_btn(View view){

    }
    public void nine_btn(View view){

    }
    public void clear_btn(View view){

    }
    public void exponent_btn(View view){

    }
    public void parentheses_btn(View view){

    }
    public void divide_btn(View view){

    }
    public void multiply_btn(View view){

    }
    public void add_btn(View view){

    }
    public void subtract_btn(View view){

    }
    public void plusMinus_btn(View view){

    }
    public void point_btn(View view){

    }
    public void equals_btn(View view){

    }

    public void backspace_btn(View view){

    }

}