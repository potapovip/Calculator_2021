package ru.gb.course1.calculator_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(view -> {
            if (getString(R.string.display).equals(display.getText().toString())) {
                display.setText("");
            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        pasteText();
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
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
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();
        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().charAt(i) == '(') {
                openPar += 1;
            }
            if (display.getText().toString().charAt(i) == ')') {
                closePar += 1;
            }
        }
        if (openPar == closePar || display.getText().toString().charAt(textLen - 1) == '(') {
            updateText("(");
        } else if (closePar < openPar && display.getText().toString().charAt(textLen - 1) != '(') {
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
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
        updateText("-");
    }

    public void point_btn(View view) {
        int cursorPos = display.getSelectionStart();
        int decimalInit = 0;
        int operatInit = 0;
        int textLen = display.getText().length();
        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().charAt(i) == '.') {
                decimalInit += 1;
            }
            if ((display.getText().toString().charAt(i) == '÷') || (display.getText().toString().charAt(i) == '×')|| (display.getText().toString().charAt(i) == '+')|| (display.getText().toString().charAt(i) == '-')|| (display.getText().toString().charAt(i) == '^')) {
                operatInit += 1;
            }
        }
        if (decimalInit <= operatInit && display.getText().toString().charAt(textLen - 1) != '.')  {
            updateText(".");
        }
        else return;
        display.setSelection(cursorPos + 1);
    }

    public void equals_btn(View view) {
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression expression = new Expression(userExp);

        String result = String.valueOf(expression.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
//    private void showField() {
//        calcText.setText(memory.entryField.toString());
//    }

    private void pasteText() {
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.endsWith(action) && type.equals("text/*")) {
//            buttonOptions.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            display.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
//            showField();
        }
    }

    public void backspace_btn(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

}