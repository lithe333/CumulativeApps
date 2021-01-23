package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class Activity003B3 extends ButtonsActivity {

    private int display = 0;
    private View previous = null;
    private int number = 0;
    private int choice = 0;
    private int max, root;
    private int[] guesses = {};
    private boolean flag_run, flag_reset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003b3);

    }

    public void onQ3Click(View view) {
        TextView output = findViewById(R.id.a3b3_output);
        TextView answer = findViewById(R.id.a3b3_answer);
        LinearLayout input_layout = findViewById(R.id.a3b3_input);
        LinearLayout input_layout2 = findViewById(R.id.a3b3_input2);
        TextView input = findViewById(R.id.a3b3_edit_text);
        TextView input2 = findViewById(R.id.a3b3_edit_text2);
        Button submit = findViewById(R.id.a3b3_send_btn);
        String answer_text, hor_bar, line, ver_bar;
        int i, j;
        double k, sum;

        String question_text;
        question_text = ((TextView)view).getText().toString();
        char first, second;

        if (question_text != "") {
            first = question_text.charAt(0);
            second = question_text.charAt(1);

            int question = 0;

            if (first == '1') {
                if (second == '.') {
                    question = 1;
                } else {
                    question = second - '0' + 10;
                }
            } else {
                question = first - '0';
            }

            if (previous != null) {
                ((TextView)previous).setBackgroundColor(Color.TRANSPARENT);
            }

            if (question == display) {
                input_layout.setVisibility(View.GONE);
                output.setText("Please select a question");
                answer.setText("The solution will be printed here");
                display = 0;
            } else {
                ((TextView)view).setBackgroundColor(0xFFFFBF8B);
                if (question == 1) {
                    input_layout.setVisibility(View.GONE);
                } else if ((question == 2)||(question == 6)||(question == 7)){
                    input_layout.setVisibility(View.VISIBLE);
                } else {
                    //graphical things? fragment?
                }
                output.setText("Question " + question);
                display = question;

                answer.setText("Waiting for input");
                input.setText("");

                switch (display) {
                    case 1:
                        answer.setText("Hello World");
                        break;
                    case 2:
                        input.setHint("Please enter the duration of a year as a decimal \"1.2\" or a partial fraction \"1+(2/3)\"");
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                }
            }
        }
        previous = view;
    }

    public void onQ3Send(View view) {
        int i, result;
        TextView answer = findViewById(R.id.a3b3_answer);
        TextView input = findViewById(R.id.a3b3_edit_text);
        TextView input2 = findViewById(R.id.a3b3_edit_text2);

        int question = ((TextView)previous).getText().toString().charAt(0) - '0';
        String input_text = input.getText().toString();

        switch (question) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
        }
        input.setText("");
    }
}