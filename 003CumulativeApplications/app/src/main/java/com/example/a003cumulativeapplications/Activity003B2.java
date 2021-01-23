package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class Activity003B2 extends ButtonsActivity {

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
        setContentView(R.layout.activity003b2);

    }

    public void onQ2Click(View view) {
        TextView output = findViewById(R.id.a3b2_output);
        TextView answer = findViewById(R.id.a3b2_answer);
        LinearLayout input_layout = findViewById(R.id.a3b2_input);
        LinearLayout input_layout2 = findViewById(R.id.a3b2_input2);
        TextView input = findViewById(R.id.a3b2_edit_text);
        TextView input2 = findViewById(R.id.a3b2_edit_text2);
        Button submit = findViewById(R.id.a3b2_send_btn);
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
            } else if (first == '2') {
                if (second == '.') {
                    question = 2;
                } else {
                    question = 20;
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
                ((TextView)view).setBackgroundColor(0xFFFFD495);
                if (question == 13) {
                    input_layout.setVisibility(View.GONE);
                } else if ((question == 3)||(question == 9)||(question == 10)||(question == 11)||(question == 12)||(question == 15)||(question == 16)) {
                    input_layout.setVisibility(View.VISIBLE);
                    input2.setVisibility(View.VISIBLE);
                } else {
                    input_layout.setVisibility(View.VISIBLE);
                    input2.setVisibility(View.GONE);
                }
                output.setText("Question " + question);
                display = question;

                answer.setText("Waiting for input");
                input.setText("");

                switch (display) {
                    case 1:
                        input.setHint("Please enter a list of values separated by \",\"");
                        break;
                    case 2:
                        answer.setText("Hello World");
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
                    case 16:
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                }
            }
        }
        previous = view;
    }

    public void onQ2Send(View view) {
        int i, result;
        TextView answer = findViewById(R.id.a3b2_answer);
        TextView input = findViewById(R.id.a3b2_edit_text);
        TextView input2 = findViewById(R.id.a3b2_edit_text2);

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
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
        }
        input.setText("");
    }

    private int[] readValues(TextView entry) {
        return null;
    }

    private String[] readText(TextView entry) {
        return null;
    }

    class CharArrayToString
    {
        public void main(String args[])
        {
            // Method 1: Using String object
            char[] ch = {'g', 'o', 'o', 'd', ' ', 'm', 'o', 'r', 'n', 'i', 'n', 'g'};
            String str = new String(ch);
            System.out.println(str);

            // Method 2: Using valueOf method
            String str2 = String.valueOf(ch);
            System.out.println(str2);
        }
    }

    public class GameCharacter {
        private String name;
        private String type;
        private int health;


        public GameCharacter(String newName, String newType, int newCurHealth){
            name = newName;
            type = newType;
            health = newCurHealth;
        }

        public String changeHealth (int change){
            // Adding positive number will increase health.
            // Adding negative number will decrease health.
            health += change;
            if (health > 0){
                return "Your character now has " + health + " health.";
            } else {
                return "Your character is dead.";
            }
        }

        public  void main(String[] args){
            GameCharacter Mario = new GameCharacter ("Mario", "Hero", 100);
            GameCharacter Luigi = new GameCharacter ("Luigi", "Sidekick", 100);
            GameCharacter Bowser = new GameCharacter ("Bowser", "Villain", 100);
        }
    }
}

