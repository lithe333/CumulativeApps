package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

public class Activity003B1 extends ButtonsActivity {

    private int display = 0;
    private View previous = null;
    private int number = 0;
    private int choice = 0;
    private int max, root;
    private int[] guesses = {};
    private boolean flag_run;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003b1);

    }

    public void onQ1Click(View view) {
        TextView output = findViewById(R.id.a3b1_output);
        TextView answer = findViewById(R.id.a3b1_answer);
        LinearLayout input_layout = findViewById(R.id.a3b1_input);
        TextView input = findViewById(R.id.a3b1_edit_text);
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
                ((TextView)view).setBackgroundColor(0xFFFFEAA0);
                if ((first == '1')||(first == '7')||(first == '8')) {
                    input_layout.setVisibility(View.GONE);
                } else {
                    input_layout.setVisibility(View.VISIBLE);
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
                        input.setHint("Please provide your name");
                        break;
                    case 3:
                        input.setHint("Please provide your name");
                        break;
                    case 4:
                        input.setHint("Please provide an integer n to find the sum from 1 to n.");
                        break;
                    case 5:
                        input.setHint("Please provide an integer n to find the sum from 1 to n for values that are multiples of 3 and 5.");
                        break;
                    case 6:
                        flag_run = false;
                        input.setHint("Please provide an integer n to find the sum or product from 1 to n.");
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
                        flag_run = true;
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

    public void onQ1Send(View view) {
        int i, result;
        TextView answer = findViewById(R.id.a3b1_answer);
        TextView input = findViewById(R.id.a3b1_edit_text);

        int question = ((TextView)previous).getText().toString().charAt(0) - '0';
        String input_text = input.getText().toString();

        switch (question) {
            case 2:
                if (input_text.isEmpty()) {
                    answer.setText("Empty? I am still waiting for your name");
                } else if (A3BInputReader.isInt(input_text)) {
                    choice = Integer.parseInt(input_text);
                    answer.setText("Your name is a number? Really?\nHi " + Integer.toString(choice) + "\nIf that was a mistake, please give me the correct name.");
                } else {
                    answer.setText("Hi " + input_text + "!\nLet me know if your name changes.");
                }
                break;
            case 3:
                if (input_text.isEmpty()) {
                    answer.setText("Empty? I am still waiting for your name");
                } else if (A3BInputReader.isInt(input_text)) {
                    choice = Integer.parseInt(input_text);
                    answer.setText("Your name is a number? Really?\nHi " + Integer.toString(choice) + "\nIf that was a mistake, please give me the correct name.");
                } else if ((input_text.equals("Alice"))||(input_text.equals("alice"))||(input_text.equals("Bob"))||(input_text.equals("bob"))) {
                    answer.setText("Hi " + input_text + "!\nLet me know if your name changes.");
                } else {
                    answer.setText("Okay, Hi!\nWhat was your name again?");
                }
                break;
            case 4:
                if (input_text.isEmpty()) {
                    answer.setText("Empty? I am still waiting for that number");
                } else if (A3BInputReader.isInt(input_text)) {
                    choice = Integer.parseInt(input_text);
                    if (choice <= 0) {
                        answer.setText("Please enter a value greater than 1");
                    } else {
                        result = (choice*(choice+1))/2;
                        answer.setText("The sum from 1 to " + Integer.toString(choice) + " will be: " + Integer.toString(result) + "\nPlease provide a new value for n.");
                    }
                } else {
                    answer.setText("Please enter an integer value");
                }
                break;
            case 5:
                if (input_text.isEmpty()) {
                    answer.setText("Empty? I am still waiting for that number");
                } else if (A3BInputReader.isInt(input_text)) {
                    choice = Integer.parseInt(input_text);
                    if (choice <= 2) {
                        answer.setText("Please enter a value greater than 3");
                    } else {
                        result = 0;
                        for (i=2; i<choice; i++) {
                            if (((i+1)%3==0)||((i+1)%5==0)) {
                                result += (i+1);
                            }
                        }
                        answer.setText("The sum from 1 to " + Integer.toString(choice) + " for values that are multiples of 3 and 5 will be: " + Integer.toString(result) + "\nPlease provide a new value for n.");
                    }
                } else {
                    answer.setText("Please enter an integer value");
                }
                break;
            case 6:
                if (!flag_run) {
                    if (input_text.isEmpty()) {
                        answer.setText("Empty? I am still waiting for that number");
                    } else if (A3BInputReader.isInt(input_text)) {
                        choice = Integer.parseInt(input_text);
                        if (choice <= 0) {
                            answer.setText("Please enter a value greater than 1");
                        } else {
                            if (choice == 1) {
                                answer.setText("The product or sum when n is 1 will be: 1\nPlease provide a new value for n.");
                            } else {
                                answer.setText("You have chosen n as " + Integer.toString(choice) + ".\nNow, please choose either (P)roduct or (S)um.");
                                flag_run = true;
                                //flag_reset = false;
                            }
                        }
                    } else {
                        answer.setText("Please enter an integer value");
                    }
                } else {
                    if (input_text.isEmpty()) {
                        answer.setText("Empty? Did you want the (P)roduct or (S)um of numbers from 1 to " + Integer.toString(choice) + "?");
                    } else {
                        if ((input_text.equals("Product"))||(input_text.equals("product"))||(input_text.equals("P"))||(input_text.equals("p"))) {
                            result = 1;
                            for (i=1; i<choice; i++) {
                                result *= (i+1);
                            }
                            answer.setText("The product from 1 to " + Integer.toString(choice) + " will be: " + Integer.toString(result) + "\nPlease provide a new value for n.");
                            flag_run = false;
                        } else if ((input_text.equals("Sum"))||(input_text.equals("sum"))||(input_text.equals("S"))||(input_text.equals("s"))) {
                            result = (choice*(choice+1))/2;
                            answer.setText("The sum from 1 to " + Integer.toString(choice) + " will be: " + Integer.toString(result) + "\nPlease provide a new value for n.");
                            flag_run = false;
                        } else {
                            answer.setText("Sorry I did not understand. Please no funny business.\nIs your choice (P)roduct or (S)um?");
                        }
                    }
                }
                break;
            case 9:
                if (flag_run) {
                    if (input_text.isEmpty()) {
                        answer.setText("Empty? I am still waiting for that number");
                    } else if (A3BInputReader.isInt(input_text)) {
                        int guess = Integer.parseInt(input_text);
                        if ((guess > max)||(guess < 0)) {
                            answer.setText("Please enter a value from 0 to "+ Integer.toString(max));
                        } else {
                            if (guess == number) {
                                answer.setText("Well done! The secret number was " + Integer.toString(guess) +"\n\n Click the button to play again.");
                                flag_run = false;
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
                } else {
                    answer.setText("A new secret number has been chosen.");
                    max = 10;
                    flag_run = true;
                    input.setHint("This is a guessing game. Please guess an integer from 0 to " + Integer.toString(max));
                    number = max+1;
                    guesses = new int[number];
                    while (number > max) {
                        number = (int)(Math.random()*(max+1));
                    }
                }
                break;
        }
        input.setText("");
    }

}