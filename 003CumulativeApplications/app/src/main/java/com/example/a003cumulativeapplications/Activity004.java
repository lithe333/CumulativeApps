package com.example.a003cumulativeapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
//import android.support.annotation.Nullable;


public class Activity004 extends ButtonsActivity {

    private boolean mode_simple = true;
    private boolean mode_standard = false;

    private String number = "";
    private String decNum = "0";
    private String nullNum = "0";
    private String symbol = "";
    private String symbol2 = "";
    private String symbol3 = "";
    private String working = "0";
    private double num1 = 0;
    private double num2 = 0;
    private double num3 = 0;
    private double num4 = 0;
    private int decimals = 9;
    private boolean decFlag = false;
    private boolean errFlag = false;
    private boolean memFlag = false;
    private boolean nullFlag = true;
    private boolean rptFlag = false;
    private boolean roundFlag = false;
    private boolean stdFlag = false;
    private boolean switchFlag = true;


    private TextView displayTV, memoryTV, decimalsTV, tempTV;
    //private Button keyPad11, keyPad12, keyPad13, keyPad14, keyPad21, keyPad22, keyPad23, keyPad24,
    //        keyPad31, keyPad32, keyPad33, keyPad34, keyPad41, keyPad42, keyPad43, keyPad44,
    //        keyPad51, keyPad52, keyPad53, keyPad54, keyPad61, keyPad62, keyPad63, keyPad64;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity004);
        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        num3 = A4Memory.readDouble(this);
        if (num3 != 0) {
            DisplayDec(ToStringDec(num3),"memory");
            //memoryTV.setText(ToStringDec(num3));
            memFlag = true;
        } else {
            memoryTV.setText("0");
        }
    }

    public String ToStringDec(double number) {
        return ToStringDec(number,false);
    }

    public String ToStringDec(double number, boolean methodFlag) {
        if (roundFlag||methodFlag) {
            if (decimals == 0) {
                return Integer.toString((int) number);
            }
            DecimalFormat numberFormat = new DecimalFormat("#.#####");
            switch (decimals) {
                case 1:
                    numberFormat = new DecimalFormat("#.#");
                    break;
                case 2:
                    numberFormat = new DecimalFormat("#.##");
                    break;
                case 3:
                    numberFormat = new DecimalFormat("#.###");
                    break;
                case 4:
                    numberFormat = new DecimalFormat("#.####");
                    break;
                case 5:
                    break;
                case 6:
                    numberFormat = new DecimalFormat("#.######");
                    break;
                case 7:
                    numberFormat = new DecimalFormat("#.#######");
                    break;
                case 8:
                    numberFormat = new DecimalFormat("#.########");
                    break;
                case 9:
                    numberFormat = new DecimalFormat("#.#########");
                    break;
            }
            return numberFormat.format(number);
        } else {
            return Double.toString(number);
        }
    }

    public void DisplayDec(String display, String selectTV) {
        if (selectTV == "temp") {
            tempTV = findViewById(R.id.a4_temp);
            tempTV.setText(display);
        } else {
            double displayNum = Double.parseDouble(display);
            if (selectTV == "display") {
                displayTV = findViewById(R.id.a4_display);
                displayTV.setText(ToStringDec(displayNum,true));
            } else if (selectTV == "memory") {
                memoryTV = findViewById(R.id.a4_memory);
                memoryTV.setText(ToStringDec(displayNum,true));
            }
        }
    }

    public void Mode(View view) {

        LinearLayout linearLayout1 = findViewById(R.id.a4_row1);
        LinearLayout linearLayout2 = findViewById(R.id.a4_row2);
        LinearLayout linearLayout3 = findViewById(R.id.a4_adv1);
        LinearLayout linearLayout4 = findViewById(R.id.a4_adv2);
        Button ModeButton = findViewById(R.id.a4_mode_btn);
        memoryTV = findViewById(R.id.a4_memory);

        if (mode_simple) {
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
            memoryTV.setVisibility(View.VISIBLE);
            mode_simple = false;
            mode_standard = true;
            ModeButton.setText("Standard");
        } else if (mode_standard) {
            linearLayout3.setVisibility(View.VISIBLE);
            linearLayout4.setVisibility(View.VISIBLE);
            mode_standard = false;
            ModeButton.setText("Advanced");
        } else {
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
            linearLayout3.setVisibility(View.GONE);
            linearLayout4.setVisibility(View.GONE);
            memoryTV.setVisibility(View.INVISIBLE);
            mode_simple = true;
            ModeButton.setText("Simple");
        }
    }

    public void Dec(View view) {

        decimalsTV = findViewById(R.id.a4_decimals);
        Button DecButton = findViewById(R.id.a4_dec_btn);

        switch(view.getId()) {
            case R.id.a4_dec_btn:
                String button_text;
                button_text = ((Button) view).getText().toString();
                if (button_text == "Rounding") {
                    DecButton.setText("Decimals");
                    roundFlag = false;
                    decimals = 9;
                } else {
                    DecButton.setText("Rounding");
                    roundFlag = true;
                    decimals = 2;
                }
                break;
            case R.id.a4_dec_left:
                if (decimals > 0) {
                    decimals = decimals - 1;
                }
                break;
            case R.id.a4_dec_right:
                if (decimals < 9) {
                    decimals = decimals + 1;
                }
                break;
        }
        decimalsTV.setText(Integer.toString(decimals));
        if (num3 != 0) {
            DisplayDec(ToStringDec(num3),"memory");
            //memoryTV.setText(ToStringDec(num3));
            memFlag = true;
        } else {
            memoryTV.setText("0");
        }
        if (nullFlag) {
            DisplayDec(nullNum,"display");
            //displayTV.setText(nullNum);
        } else {
            DisplayDec(number,"display");
            //displayTV.setText(number);
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
                DisplayDec(ToStringDec(num3),"display");
                //displayTV.setText(ToStringDec(num3));
                nullNum = ToStringDec(num3);
                stdFlag = true;
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
            number = ToStringDec(num3);
        } else {
            A4Memory.writeDouble(0, this);
            number = "0";
        }
        DisplayDec(number,"memory");
        //memoryTV.setText(number);
        number = "";
        DisplayDec("memory", "temp");
    }

    public void Calc(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        if (nullFlag) {
            number = nullNum;
            if (symbol == "/") {
                if (number == "0") {
                    errFlag = true;
                }
            }

            switch(view.getId()){
                case R.id.a4_btn34:
                    symbol2 = "*";
                    break;
                case R.id.a4_btn44:
                    symbol2 = "/";
                    break;
                case R.id.a4_btn54:
                    symbol2 = "-";
                    break;
                case R.id.a4_btn63:
                    symbol2 = "=";
                    break;
                case R.id.a4_btn64:
                    symbol2 = "+";
            }

            if (symbol2 != "=") {
                if (symbol == symbol2) {
                    symbol3 = symbol2;
                    if (!rptFlag) {
                        rptFlag = true;
                        num4 = Double.parseDouble(number);
                    }
                } else {
                    symbol3 = "";
                    rptFlag = false;
                    switchFlag = true;
                    num4 = 0;
                }
            }
        } else {
            if (symbol != "=") {
                symbol3 = symbol;
            }
        }

        if (symbol != "") {
            if (nullFlag) {
                nullFlag = false;
                if (stdFlag) {
                    symbol3 = symbol;
                }
            } else {
                symbol3 = symbol;
            }
            num2 = Double.parseDouble(number);
            if (symbol3 != "") {
                switchFlag = false;
            }

            if (symbol3 == "/") {
                if (rptFlag) {
                    if (num4==0) {
                        errFlag = true;
                    }
                } else {
                    if (num2==0) {
                        errFlag = true;
                    }
                }
            }

            switch (symbol3) {
                case "*":
                    if (rptFlag) {
                        number = ToStringDec(num2*num4);
                    } else {
                        number = ToStringDec(num1*num2);
                    }
                    break;
                case "/":
                    if (rptFlag) {
                        number = ToStringDec(num2/num4);
                    } else {
                        number = ToStringDec(num1/num2);
                    }
                    break;
                case "-":
                    if (rptFlag) {
                        number = ToStringDec(num2-num4);
                    } else {
                        number = ToStringDec(num1-num2);
                    }
                    break;
                case "+":
                    if (rptFlag) {
                        number = ToStringDec(num2+num4);
                    } else {
                        number = ToStringDec(num1+num2);
                    }
                    break;
            }

            if (rptFlag) {
                working = ToStringDec(num2) + " " + symbol3 + symbol3 + " " + ToStringDec(num4) + " " + "=" + " " ;
            } else if (switchFlag) {
                switchFlag = false;
                working = number + " " + symbol3 + " ";
            } else if (symbol3 != "=") {
                working = ToStringDec(num1) + " " + symbol3 + " " + ToStringDec(num2) + " " + "=" + " " ;
            } else {
                switchFlag = true;
            }

        }

        switch(view.getId()){
            case R.id.a4_btn34:
                symbol = "*";
                break;
            case R.id.a4_btn44:
                symbol = "/";
                break;
            case R.id.a4_btn54:
                symbol = "-";
                break;
            case R.id.a4_btn63:
                symbol = "=";
                break;
            case R.id.a4_btn64:
                symbol = "+";
                break;
        }
        num1 = Double.parseDouble(number);

        if (symbol3 == "") {
            switchFlag = true;
        }

        if (!rptFlag) {
            symbol3 = "";
        }

        if (switchFlag) {
            working = number + " " + symbol + " ";
        }

        switchFlag = true;

        if (errFlag) {
            nullNum = "NaN";
            DisplayDec("error","temp");
        } else {
            nullNum = number;
            DisplayDec(working,"temp");
        }
        number = "";
        decFlag = false;
        nullFlag = true;
        DisplayDec(nullNum,"display");
        //displayTV.setText(nullNum);
    }

    public void Std(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);
        stdFlag = true;

        if (nullFlag) {
            number = nullNum;
        }
        rptFlag = false;

        switch(view.getId()) {
            case R.id.a4_btn21:
                if (number == "0") {
                    errFlag = true;
                    nullNum = "NaN";
                    DisplayDec("error","temp");
                } else {
                    nullNum = ToStringDec(1/Double.parseDouble(number));
                }
                break;
            case R.id.a4_btn22:
                nullNum = ToStringDec(Math.pow(Double.parseDouble(number),2));
                break;
            case R.id.a4_btn23:
                nullNum = ToStringDec(Math.sqrt(Double.parseDouble(number)));
                break;
        }

        number = "";
        decFlag = false;
        nullFlag = true;
        switchFlag = true;
        DisplayDec(nullNum,"display");
        //displayTV.setText(nullNum);

    }

    public void Num(View view) {

        displayTV = findViewById(R.id.a4_display);
        memoryTV = findViewById(R.id.a4_memory);

        nullFlag = false;

        switch(view.getId()) {
            case R.id.a4_btn24:
                if (!decFlag) {
                    if (number == "") {
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
                symbol2 = "";
                symbol3 = "";
                working = "0";
                DisplayDec(working,"temp");
                num1 = 0;
                num2 = 0;
                num4 = 0;
                decFlag = false;
                errFlag = false;
                nullFlag = true;
                rptFlag = false;
                stdFlag = false;
                switchFlag = true;
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
            DisplayDec(nullNum,"display");
            //displayTV.setText(nullNum);
        } else {
            DisplayDec(number,"display");
            //displayTV.setText(number);
        }

    }

}
