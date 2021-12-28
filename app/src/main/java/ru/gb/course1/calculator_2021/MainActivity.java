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
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }

            }
        });
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void zero_btn(View view) {
        updateText("0");
    }

    public void one_btn(View view) {
        updateText("1");
    }

    public void two_btn(View view) {
        updateText("2");
    }

    public void three_btn(View view) {
        updateText("3");
    }

    public void four_btn(View view) {
        updateText("4");
    }

    public void five_btn(View view) {
        updateText("5");
    }

    public void six_btn(View view) {
        updateText("6");
    }

    public void seven_btn(View view) {
        updateText("7");
    }

    public void eight_btn(View view) {
        updateText("8");
    }


    public void nine_btn(View view) {
        updateText("9");
    }

    public void clear_btn(View view) {
        display.setText("");
    }

    public void exponent_btn(View view) {
        updateText("^");
    }

    public void parentheses_btn(View view) {
        updateText("");
    }

    public void divide_btn(View view) {
        updateText("÷");
    }

    public void multiply_btn(View view) {
        updateText("×");
    }

    public void add_btn(View view) {
        updateText("+");
    }

    public void subtract_btn(View view) {
        updateText("-");
    }

    public void plusMinus_btn(View view) {
        updateText("+/-");
    }

    public void point_btn(View view) {
        updateText(".");
    }

    public void equals_btn(View view) {
        updateText("");
    }

    public void backspace_btn(View view) {
        updateText("");
    }

}