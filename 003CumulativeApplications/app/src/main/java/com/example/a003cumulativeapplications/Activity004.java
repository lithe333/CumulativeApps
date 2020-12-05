package com.example.a003cumulativeapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;
//import android.support.annotation.Nullable;


public class Activity004 extends ButtonsActivity {

    private String number = "";
    private String nullNum = "0";
    private String symbol = "";
    private double num1 = 0;
    private double num2 = 0;
    private double num3 = 0;
    private boolean decFlag = false;
    private boolean memFlag = false;
    private boolean nullFlag = true;

    private TextView displayTV;
    private TextView memoryTV;
    private Button keyPad11, keyPad12, keyPad13, keyPad14, keyPad21, keyPad22, keyPad23, keyPad24,
            keyPad31, keyPad32, keyPad33, keyPad34, keyPad41, keyPad42, keyPad43, keyPad44,
            keyPad51, keyPad52, keyPad53, keyPad54, keyPad61, keyPad62, keyPad63, keyPad64;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity004);
        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        num3 = A4Memory.readDouble(this);
        if (num3 != 0) {
            memoryTV.setText(Double.toString(num3));
            memFlag = true;
        } else {
            memoryTV.setText("0");
        }
    }

    public boolean mode_simple = true;

    public void Mode(View view) {

        LinearLayout linearLayout1 = findViewById(R.id.a4_row1);
        LinearLayout linearLayout2 = findViewById(R.id.a4_row2);
        Button ModeButton = findViewById(R.id.a4_mode_btn);
        memoryTV = findViewById(R.id.a4_memory);

        if (mode_simple) {
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
            memoryTV.setVisibility(View.VISIBLE);
            mode_simple = false;
            ModeButton.setText("Standard");
        }
        else {
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
            memoryTV.setVisibility(View.INVISIBLE);
            mode_simple = true;
            ModeButton.setText("Simple");
        }
    }

    public void Mem(View view) {
        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        if (!nullFlag) {
            nullNum = number;
            number = "";
            decFlag = false;
            nullFlag = true;
        }

        switch(view.getId()) {
            case R.id.a4_btn11:
                num3 = 0;
                memFlag = false;
                A4Memory.writeDouble(num3, this);
                break;
            case R.id.a4_btn12:
                if (memFlag) {
                    num3 = A4Memory.readDouble(this);
                } else {
                    num3 = 0;
                }
                displayTV.setText(Double.toString(num3));
                nullNum = Double.toString(num3);
                break;
            case R.id.a4_btn13:
                if (memFlag) {
                    num3 = A4Memory.readDouble(this) + Double.parseDouble(nullNum);
                } else {
                    num3 = Double.parseDouble(nullNum);
                    memFlag = true;
                }
                break;
            case R.id.a4_btn14:
                if (memFlag) {
                    num3 = A4Memory.readDouble(this) - Double.parseDouble(nullNum);
                } else {
                    num3 = -Double.parseDouble(nullNum);
                    memFlag = true;
                }
                break;
        }

        if (memFlag) {
            A4Memory.writeDouble(num3, this);
            number = Double.toString(num3);
        } else {
            A4Memory.writeDouble(0, this);
            number = "0";
        }
        memoryTV.setText(number);
        number = "";

    }

    public void Calc(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        if (nullFlag) {
            number = nullNum;
            nullFlag = false;

            switch(view.getId()){
                case R.id.a4_btn34:
                    if (symbol == "*") {
                        nullFlag = true;
                    }
                    break;
                case R.id.a4_btn44:
                    if (symbol == "/") {
                        nullFlag = true;
                    }
                    break;
                case R.id.a4_btn54:
                    if (symbol == "-") {
                        nullFlag = true;
                    }
                    break;
                case R.id.a4_btn64:
                    if (symbol == "+") {
                        nullFlag = true;
                    }
                    break;
            }

            if (nullFlag) {
                nullFlag = false;
            } else {
                symbol = "";
            }

        }

        if (symbol != null) {
            num2 = Double.parseDouble(number);
            switch (symbol) {
                case "*":
                    number = Double.toString(num1*num2);
                    break;
                case "/":
                    number = Double.toString(num1/num2);
                    break;
                case "-":
                    number = Double.toString(num1-num2);
                    break;
                case "+":
                    number = Double.toString(num1+num2);
                    break;
            }
            symbol = "";
            num1 = 0;
            num2 = 0;
        }

        switch(view.getId()){
            case R.id.a4_btn34:
                symbol = "*";
                num1 = Double.parseDouble(number);
                break;
            case R.id.a4_btn44:
                symbol = "/";
                num1 = Double.parseDouble(number);
                break;
            case R.id.a4_btn54:
                symbol = "-";
                num1 = Double.parseDouble(number);
                break;
            case R.id.a4_btn63:
                break;
            case R.id.a4_btn64:
                symbol = "+";
                num1 = Double.parseDouble(number);
                break;
        }

        nullNum = number;
        number = "";
        decFlag = false;
        nullFlag = true;
        displayTV.setText(nullNum);

    }

    public void Std(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        if (nullFlag) {
            number = nullNum;
        }

        switch(view.getId()) {
            case R.id.a4_btn21:
                nullNum = Double.toString(1/Double.parseDouble(number));
                break;
            case R.id.a4_btn22:
                nullNum = Double.toString(Math.pow(Double.parseDouble(number),2));
                break;
            case R.id.a4_btn23:
                nullNum = Double.toString(Math.sqrt(Double.parseDouble(number)));
                break;
        }

        number = "";
        decFlag = false;
        nullFlag = true;
        displayTV.setText(nullNum);

    }

    public void Num(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        nullFlag = false;

        switch(view.getId()) {
            case R.id.a4_btn24:
                if (!decFlag) {
                    if (nullFlag) {
                        number = "0.";
                    } else if (number == "") {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                    decFlag = true;
                }
                break;
            case R.id.a4_btn31:
                number = number + "7";
                break;
            case R.id.a4_btn32:
                number = number + "8";
                break;
            case R.id.a4_btn33:
                number = number + "9";
                break;
            case R.id.a4_btn41:
                number = number + "4";
                break;
            case R.id.a4_btn42:
                number = number + "5";
                break;
            case R.id.a4_btn43:
                number = number + "6";
                break;
            case R.id.a4_btn51:
                number = number + "1";
                break;
            case R.id.a4_btn52:
                number = number + "2";
                break;
            case R.id.a4_btn53:
                number = number + "3";
                break;
            case R.id.a4_btn61:
                number = "";
                nullNum = "0";
                symbol = "";
                num1 = 0;
                num2 = 0;
                decFlag = false;
                nullFlag = true;
                break;
            case R.id.a4_btn62:
                if (number != "") {
                    number = number + "0";
                } else {
                    nullNum = "0";
                    nullFlag = true;
                }
                break;
        }

        if (nullFlag) {
            displayTV.setText(nullNum);
        } else {
            displayTV.setText(number);
        }


    }

}
