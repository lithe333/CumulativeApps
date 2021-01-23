package com.example.a003cumulativeapplications;

import android.widget.TextView;

public class A3BInputReader {

    public String TextViewReader (TextView input) {
        String input_text = input.getText().toString();
        String answer_text;
        int choice;
        if (input_text.isEmpty()) {
            answer_text = "Empty? I am still waiting for your name";
        } else if (isInt(input_text)) {
            choice = Integer.parseInt(input_text);
            answer_text = "Your name is a number? Really?\nHi " + Integer.toString(choice) + "\nIf that was a mistake, please give me the correct name.";
        } else {
            answer_text = "Hi " + input_text + "!\nLet me know if your name changes.";
        }
        return answer_text;
    }

    public static boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch(NumberFormatException er) {
            return false;
        }
    }
}
