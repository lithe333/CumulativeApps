package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class Activity003B6 extends ButtonsActivity {

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
        setContentView(R.layout.activity003b6);

    }

    public void onQ6Click(View view) {
        TextView output = findViewById(R.id.a3b6_output);
        TextView answer = findViewById(R.id.a3b6_answer);
        LinearLayout input_layout = findViewById(R.id.a3b6_input);
        LinearLayout input_layout2 = findViewById(R.id.a3b6_input2);
        TextView input = findViewById(R.id.a3b6_edit_text);
        TextView input2 = findViewById(R.id.a3b6_edit_text2);
        Button submit = findViewById(R.id.a3b6_send_btn);
        String answer_text, hor_bar, line, ver_bar;
        int i, j;
        double k, sum;

        String question_text;
        question_text = ((TextView)view).getText().toString();
        char first;

        if (question_text != "") {
            first = question_text.charAt(0);

            int question = first - '0';

            if (previous != null) {
                ((TextView)previous).setBackgroundColor(Color.TRANSPARENT);
            }

            if (question == display) {
                input_layout.setVisibility(View.GONE);
                output.setText("Please select a question");
                answer.setText("The solution will be printed here");
                display = 0;
            } else {
                ((TextView)view).setBackgroundColor(0xFFFF7E61);
                if (question == 5) {
                    input_layout.setVisibility(View.GONE);
                } else if (question == 4) {
                    input_layout.setVisibility(View.VISIBLE);
                    input2.setVisibility(View.VISIBLE);
                } else {
                    //graphical things? fragment?
                }
                output.setText("Question " + question);
                display = question;

                answer.setText("Waiting for input");
                input.setText("");

                switch (display) {
                    case 1:
                        input.setHint("Please enter a string in each space");
                        break;
                    case 2:
                        answer.setText("Hello World");
                        break;
                    case 3:
                        break;
                }
            }
        }
        previous = view;
    }

    public void onQ6Send(View view) {
        int i, result;
        TextView answer = findViewById(R.id.a3b4_answer);
        TextView input = findViewById(R.id.a3b4_edit_text);
        TextView input2 = findViewById(R.id.a3b4_edit_text2);

        int question = ((TextView)previous).getText().toString().charAt(0) - '0';
        String input_text = input.getText().toString();

        switch (question) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        input.setText("");
    }
}