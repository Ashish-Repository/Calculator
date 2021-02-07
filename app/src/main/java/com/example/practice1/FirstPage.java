package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstPage extends AppCompatActivity {

    TextView text_screen;
    String first_input = "",second_input = "",operator = "";
    double res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        text_screen = findViewById(R.id.display);
    }

    public void ac(View view) {
        text_screen.setText("");
        first_input = "";
        second_input = "";
        operator = "";
    }

    public void del(View view) {
        String s = text_screen.getText().toString();
        text_screen.setText(s != "" ? s.substring(0, s.length() - 1) : "");
    }

    // Operator Buttons

    public void divide(View view) {
        solve("/");
    }

    public void multiplication(View view) {
        solve("*");
    }

    public void percentage(View view) {
        solve("%");
    }

    public void subtract(View view) {
        solve("-");
    }

    public void add(View view) {
        solve("+");
    }

    public void solve(String op) {
        if (operator != "" && second_input != "") {
            solution();
            first_input = String.valueOf(res);
            second_input = "";
            text_screen.setText(String.valueOf(res).concat(op));
        } else {
            text_screen.setText(first_input.concat(op));
        }
        operator = op;
    }

    public void equal(View view) {
        if (operator != "" && second_input != "") {
            solution();
            text_screen.setText(String.valueOf(res));
        }
    }

    private void solution() {
        double a = Double.parseDouble(first_input);
        double b = Double.parseDouble(second_input);
        switch (operator) {
            case "/":
                res = a / b;
                break;
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "%":
                res = a % b;
                break;
            default:
                text_screen.setText(null);
        }
    }

    // Number Buttons

    public void seven(View view) {
        operate("7");
    }

    public void eight(View view) {
        operate("8");
    }

    public void nine(View view) {
        operate("9");
    }

    public void four(View view) {
        operate("4");
    }

    public void five(View view) {
        operate("5");
    }

    public void six(View view) {
        operate("6");
    }

    public void one(View view) {
        operate("1");
    }

    public void two(View view) {
        operate("2");
    }

    public void three(View view) {
        operate("3");
    }

    public void d_zero(View view) {
        operate("00");
    }

    public void zero(View view) {
        operate("0");
    }

    public void decimal(View view) {
        String s = text_screen.getText().toString();
        if(operator != "" && !second_input.contains(".")) {
            second_input = second_input.concat(".");
            text_screen.setText(s.concat("."));
        }
        else if(!first_input.contains(".")) {
            first_input = first_input.concat(".");
            text_screen.setText(s.concat("."));
        }
    }

    public void operate(String val) {
        if(operator != "") {
            String s = text_screen.getText().toString();
            second_input = second_input.concat(val);
            text_screen.setText(s.concat(val));
        }
        else {
            first_input = first_input.concat(val);
            text_screen.setText(first_input);
        }
    }
}