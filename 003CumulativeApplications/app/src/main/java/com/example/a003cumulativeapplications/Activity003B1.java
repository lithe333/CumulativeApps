package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

public class Activity003B1 extends ButtonsActivity {

    private int display = 0;
    private View previous = null;
    private int number = 0;
    private int max, root;
    private int[] guesses = {};
    private boolean flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003b1);

    }

    public void onQClick(View view) {
        TextView output = findViewById(R.id.a3b1_output);
        TextView answer = findViewById(R.id.a3b1_answer);
        LinearLayout input_layout = findViewById(R.id.a3b1_input);
        TextView input = findViewById(R.id.a3b1_edit_text);
        Button submit = findViewById(R.id.a3b1_add_btn);
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
                switch (second) {
                    case '.':
                        question = 1;
                        break;
                    case '0':
                        question = 10;
                        break;
                    case '1':
                        question = 11;
                        break;
                }
            } else {
                question = first - '0';
            }

            if (previous != null) {
                ((TextView)previous).setBackgroundColor(Color.TRANSPARENT);
            }

            if (question == display) {
                input_layout.setVisibility(view.GONE);
                output.setText("Please select a question");
                answer.setText("The solution will be printed here");
                display = 0;
            } else {
                ((TextView)view).setBackgroundColor(0xFFFFEAA0);
                if ((first == '1')||(first == '7')||(first == '8')) {
                    input_layout.setVisibility(view.GONE);
                } else {
                    input_layout.setVisibility(view.VISIBLE);
                }
                output.setText("Question " + question);
                display = question;

                switch (display) {
                    case 1:
                        answer.setText("Hello World");
                        break;
                    case 2:
                        answer.setText("Waiting for input");
                        break;
                    case 3:
                        answer.setText("Waiting for input");
                        break;
                    case 4:
                        answer.setText("Waiting for input");
                        break;
                    case 5:
                        answer.setText("Waiting for input");
                        break;
                    case 6:
                        answer.setText("Waiting for input");
                        break;
                    case 7:
                        answer_text = "";
                        hor_bar = " --- --- --- --- --- --- --- --- --- --- --- --- --- ";
                        ver_bar = "|";
                        line = "\n";
                        answer_text = hor_bar;
                        for (i=0; i<13; i++) {
                            answer_text += line + ver_bar;
                            for (j=0; j<13; j++) {
                                if (i==0) {
                                    if (j==0) {
                                        answer_text += " * " + ver_bar;
                                    } else if (j>9) {
                                        answer_text += " " + Integer.toString(j) + ver_bar;
                                    } else {
                                        answer_text += "  " + Integer.toString(j) + ver_bar;
                                    }
                                } else {
                                    if (j==0) {
                                        if (i>9) {
                                            answer_text += " " + Integer.toString(i) + ver_bar;
                                        } else {
                                            answer_text += "  " + Integer.toString(i) + ver_bar;
                                        }
                                    } else if ((i*j)>99) {
                                        answer_text += Integer.toString(i*j) + ver_bar;
                                    } else if ((i*j)>9) {
                                        answer_text += " " + Integer.toString(i*j) + ver_bar;
                                    } else {
                                        answer_text += "  " + Integer.toString(i*j) + ver_bar;
                                    }
                                }
                            }
                            answer_text += line + hor_bar;
                        }
                        answer.setText(answer_text);
                        break;
                    case 8:
                        max = 1000;
                        answer_text = "The following is a list of prime numbers smaller than " + Integer.toString(max) + ":\n2";
                        for (i=3; i<max; i++) {
                            root = (int)Math.sqrt((double)i) + 2;
                            boolean is_prime = true;
                            for (j=2; (is_prime)&&(j<root); j++) {
                                if ((i%j) == 0) {
                                    is_prime = false;
                                }
                            }
                            if (is_prime) {
                                answer_text += ", " + Integer.toString(i);
                            }
                        }
                        answer.setText(answer_text);
                        break;
                    case 9:
                        answer.setText("Waiting for input");
                        max = 10;
                        flag = false;
                        input.setHint("This is a guessing game. Please guess an integer from 0 to " + Integer.toString(max));
                        input.setText("");
                        number = max+1;
                        guesses = new int[number];
                        while (number > max) {
                            number = (int)(Math.random()*(max+1));
                        }
                        break;
                    case 10:
                        Date d = new Date();
                        int year = d.getYear() + 1900;
                        int temp_year = year;
                        answer_text = "The current year is " + year +".\n";

                        if (is_leap(year)) {
                            answer_text += "It is a leap year.\n";
                        } else {
                            answer_text += "It is not a leap year.\n";
                            temp_year = temp_year - (temp_year%4);
                        }
                        answer_text += "\nThe next 20 leap years are:";
                        for (i=0; i<20; i++) {
                            if (is_leap(temp_year+4)) {
                                temp_year = temp_year + 4;
                            } else {
                                temp_year = temp_year + 8;
                            }
                            answer_text += "\n - " + Integer.toString(temp_year);
                        }
                        answer.setText(answer_text);
                        break;
                    case 11:
                        answer_text = "This seems to be using the Leibniz formula for π:\n";
                        sum = 0;
                        for (k=1; k<=1000000; k++) {
                            sum += (-2*((k+1)%2)+1)/(2*k-1);
                        }
                        answer_text += Double.toString(4*sum);
                        answer.setText(answer_text);
                        break;
                }
            }
        }
        previous = view;
        Toast.makeText(this, "test6", Toast.LENGTH_SHORT).show();
    }

    private boolean is_leap(int year) {
        if (year%4 == 0) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public void onQSend(View view) {
        TextView answer = findViewById(R.id.a3b1_answer);
        TextView input = findViewById(R.id.a3b1_edit_text);

        int question = ((TextView)previous).getText().toString().charAt(0) - '0';
        String input_text = input.getText().toString();

        switch (question) {
            case 2:
                answer.setText("Waiting for input");
                break;
            case 3:
                answer.setText("Waiting for input");
                break;
            case 4:
                answer.setText("Waiting for input");
                break;
            case 5:
                answer.setText("Waiting for input");
                break;
            case 6:
                answer.setText("Waiting for input");
                break;
            case 9:
                if (flag) {
                    answer.setText("A new secret number has been chosen.");
                    max = 10;
                    flag = false;
                    input.setHint("This is a guessing game. Please guess an integer from 0 to " + Integer.toString(max));
                    input.setText("");
                    number = max+1;
                    guesses = new int[number];
                    while (number > max) {
                        number = (int)(Math.random()*(max+1));
                    }
                } else {
                    if (input_text.isEmpty()) {
                        answer.setText("Empty? I am still waiting for input");
                    } else if (isInt(input_text)) {
                        int guess = Integer.parseInt(input_text);
                        if ((guess > max)||(guess < 0)) {
                            answer.setText("Please enter a value from 0 to "+ Integer.toString(max));
                        } else {
                            if (guess == number) {
                                answer.setText("Well done! The secret number was " + Integer.toString(guess) +"\n\n Click the button to play again.");
                                flag = true;
                            } else if (guesses[guess]==1) {
                                answer.setText("You have already guessed " + Integer.toString(guess) + ". Please guess again");
                            } else {
                                guesses[guess]=1;
                                answer.setText(Integer.toString(guess) + " was not the number. Please guess again");
                            }
                        }
                    } else {
                        answer.setText("Please enter an integer value");
                    }
                }
                input.setText("");
                break;
        }
    }

    static boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }
}