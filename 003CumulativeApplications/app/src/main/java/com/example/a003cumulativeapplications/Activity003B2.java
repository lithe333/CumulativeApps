package com.example.a003cumulativeapplications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Activity003B2 extends ButtonsActivity {

    private int display = 0;
    private View previous = null;
    private int number = 0;
    private int choice = 0;
    private int max, root;
    private int[] guesses = {};
    private boolean flag_run, flag_reset;

    private ArrayList<String> array_list;
    //private ArrayAdapter<String> adapter;

    private ArrayList<String> array_list2;
    //private ArrayAdapter<String> adapter2;

    private ArrayList<String> array_list3;


    //String itemEnterred = itemET.getText().toString();
    //itemET.setText("");
    //readItem = items.get(position);
    //ArrayList.size();
    //items.remove(editPosition);
    //items.set(editPosition,writeItem);
    //adapter.notifyDataSetChanged();
    //input.setHint("Please enter a list of values separated by \",\"");
    //answer.setText("Hello World");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003b2);

        array_list = new ArrayList<>();
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_list);

        array_list2 = new ArrayList<>();
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_list2);

        array_list3 = new ArrayList<>();

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
        int i;

        String question_text;
        question_text = ((TextView)view).getText().toString();

        if (question_text != "") {

            int question = findQ2(question_text);

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
                } else if ((question == 3)||(question == 9)||(question == 10)||(question == 11)||(question == 12)||(question == 15)||(question == 16)||(question == 18)) {
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
                        input.setHint("Please enter a list of numerical values separated by \",\"");
                        break;
                    case 2:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        break;
                    case 3:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        input2.setHint("Please enter a element to search through the list above");
                        break;
                    case 4:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        break;
                    case 5:
                        input.setHint("Please enter a list of numerical values separated by \",\"");
                        break;
                    case 6:
                        input.setHint("Please enter a string");
                        break;
                    case 7:
                        input.setHint("Please enter a list of numerical values separated by \",\"");
                        break;
                    case 8:
                        input.setHint("Please enter a list of integer values separated by \",\"");
                        break;
                    case 9:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        input2.setHint("Please enter a second list with elements separated by \",\"");
                        break;
                    case 10:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        input2.setHint("Please enter a second list with elements separated by \",\"");
                        break;
                    case 11:
                        input.setHint("Please enter a list of sorted numerical values separated by \",\"");
                        input2.setHint("Please enter a second list of sorted numerical values separated by \",\"");
                        break;
                    case 12:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        input2.setHint("Please enter an integer to rotate the elements of the list above by");
                        break;
                    case 13:
                        String result = "1, 1";
                        double j = 1;
                        double k = 1;
                        double sum = j+k;
                        for (i = 2; i < 100; i++) {
                            sum = j+k;
                            j = k;
                            k = sum;
                            result = result + ", " + cleanValue(Double.toString(sum));
                        }
                        answer_text = "The following is first 100 Fibonacci numbers:\n" + result;
                        answer.setText(answer_text);
                        break;
                    case 14:
                        input.setHint("Please enter an integer");
                        break;
                    case 15:
                        input.setHint("Please enter a list of digits separated by \",\"");
                        input2.setHint("Please enter a second list of digits separated by \",\"");
                        break;
                    case 16:
                        input.setHint("Please enter a list of integers separated by \",\"");
                        input2.setHint("Please enter two integer bases separated by \",\"");
                        break;
                    case 17:
                        input.setHint("Please enter a list with numerical values separated by \",\"");
                        break;
                    case 18:
                        input.setHint("Please enter a sorted list with numerical values separated by \",\"");
                        input2.setHint("Please enter a numerical value to search for");
                        break;
                    case 19:
                        input.setHint("Please enter a list with elements separated by \",\"");
                        break;
                    case 20:
                        input.setHint("Please enter a string for Pig Latin translation\",\"");
                        break;
                }
            }
        }
        previous = view;
    }

    private int findQ2(String question_text) {
        char first = question_text.charAt(0);
        char second = question_text.charAt(1);
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
        return question;
    }

    public void onQ2Send(View view) {
        int i, j, k, size, size2, len;
        double value1, value2;
        int var1, var2, temp, temp2, temp3;
        ArrayList<Integer> int_array_list = new ArrayList<>();
        TextView answer = findViewById(R.id.a3b2_answer);
        TextView input = findViewById(R.id.a3b2_edit_text);
        TextView input2 = findViewById(R.id.a3b2_edit_text2);

        int question = findQ2(((TextView)previous).getText().toString());
        //int question = ((TextView)previous).getText().toString().charAt(0) - '0';
        String input_text = input.getText().toString();
        String input_text2 = input2.getText().toString();
        String answer_text = "";
        String result = "";
        String working = "";
        String result2 = "";
        String result3 = "";

        switch (question) {
            case 1:
                //answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,adapter,"value");
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        result = cleanValue(array_list.get(0));
                        for (i = 1; i < size; i++) {
                            value1 = Double.parseDouble(result);
                            value2 = Double.parseDouble(array_list.get(i));
                            if (value2 > value1) {
                                result = cleanValue(array_list.get(i));
                            }
                        }
                        answer_text = "The largest element of the following list is " + result + ".\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 2:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        result = cleanValue(array_list.get(size-1));
                        for (i = size - 2; i >= 0; i--) {
                            result = result  + ", " + cleanValue(array_list.get(i));
                        }
                        answer_text = "The following is a reversed list and the original:\n" + result + "\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 3:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"string");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 == 1)) {
                            result = " doesn't contain ";
                            for (i = 0; i < size; i++) {
                                if (cleanValue(array_list.get(i)) == cleanValue(input_text2)) {
                                    result = " contains ";
                                }
                            }
                            answer_text = "The following list" + result + "the element " + cleanValue(input_text2) + ":\n" + cleanInput(array_list);
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 4:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        result = cleanValue(array_list.get(0));
                        for (i = 2; i < size; i=i+2) {
                            result = result  + ", " + cleanValue(array_list.get(i));
                        }
                        answer_text = "The following is the odd positioned elements within a list and the complete list:\n" + result + "\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 5:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        value1 = Double.parseDouble(array_list.get(0));
                        for (i = 1; i < size; i++) {
                            value1 = value1 + Double.parseDouble(array_list.get(i));
                        }
                        result = cleanValue(Double.toString(value1));
                        answer_text = "The sum of the values in the following list is " + result + ".\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 6:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"string");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    working = cleanValue(array_list.get(0));
                    len = working.length();
                    if (len > 0) {
                        result = "is a palindrome";
                        for (i = 0; i < len/2; i++) {
                            if (result.charAt(i)!=result.charAt(len-i-1)) {
                                result = "isn't a palindrome";
                            }
                        }
                        answer_text = "The following list string " + result + ":\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 7:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        value1 = Double.parseDouble(array_list.get(0));
                        i = 1;
                        while (i < size) {
                            value1 = value1 + Double.parseDouble(array_list.get(i));
                            i++;
                        }
                        result = cleanValue(Double.toString(value1));
                        answer_text = "The sum of the values in the following list is " + result + ".\n" + cleanInput(array_list) + "\nThis was calculated using a while loop. A for loop was used for the same calculation in question 5. This can also be completed in a recursive function by passing the current iterator value and the maximum size.";
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 8:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"integer");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        for (i = 0; i < size; i++) {
                            var1 = Integer.parseInt(array_list.get(i));
                            for (j = 1; j < 20; j++) {
                                var2 = j*j;
                                if (var1==var2){
                                    if (result == "") {
                                        result = cleanValue(array_list.get(i));
                                    } else {
                                        result = result + ", " + cleanValue(array_list.get(i));
                                    }
                                } else if (var1 < var2) {
                                    j = 20;
                                }
                            }
                        }
                        answer_text = "The following is the perfect squares up to the 20th found in the list and the complete list:\n" + result + "\n" + cleanInput(array_list);
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 9:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"any");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 > 0)) {
                            result = cleanValue(array_list.get(0));
                            for (i = 1; i < size; i++) {
                                result = result + ", " + cleanValue(array_list.get(i));
                            }
                            for (i = 0; i < size2; i++) {
                                result = result + ", " + cleanValue(array_list2.get(i));
                            }
                            answer_text = "The following is the concatenated list as well as the two originals:\n" + result + "\n" + cleanInput(array_list) + "\n" + cleanInput(array_list2);
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 10:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"any");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        result = cleanValue(array_list.get(0)) + ", " + cleanValue(array_list2.get(0));
                        if ((size > 0)&&(size2 > 0)) {
                            for (i = 1; (i < size)&&(i < size2); i++) {
                                result = result + ", " + cleanValue(array_list.get(i)) + ", " + cleanValue(array_list2.get(i));
                            }
                            if (size > size2) {
                                while (i<size) {
                                    result = result + ", " + cleanValue(array_list.get(i));
                                    i++;
                                }
                            } else {
                                while (i<size2) {
                                    result = result + ", " + cleanValue(array_list2.get(i));
                                    i++;
                                }
                            }
                            answer_text = "The following is alternately combined list as well as the two originals:\n" + result + "\n" + cleanInput(array_list) + "\n" + cleanInput(array_list2);
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 11:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"value");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 > 0)) {
                            i = 0;
                            j = 0;
                            value1 = Double.parseDouble(array_list.get(i));
                            value2 = Double.parseDouble(array_list2.get(j));
                            if (value1 < value2) {
                                result = array_list.get(i);
                                i++;
                            } else {
                                result = array_list2.get(j);
                                j++;
                            }
                            while ((i<size)&&(j<size2)) {
                                value1 = Double.parseDouble(array_list.get(i));
                                value2 = Double.parseDouble(array_list2.get(j));
                                if (value1 < value2) {
                                    result = result + ", " + array_list.get(i);
                                    i++;
                                } else {
                                    result = result + ", " + array_list2.get(j);
                                    j++;
                                }
                            }
                            if (i==size) {
                                while (j<size2) {
                                    result = result + ", " + array_list2.get(j);
                                    j++;
                                }
                            } else {
                                while (i<size) {
                                    result = result + ", " + array_list.get(i);
                                    i++;
                                }
                            }
                            answer_text = "The following merges two sorted lists as well as the two originals:\n" + result + "\n" + cleanInput(array_list) + "\n" + cleanInput(array_list2);
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 12:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"integer");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 == 1)) {
                            var1 = Integer.parseInt(array_list2.get(0));
                            while (size < var1) {
                                var1 = var1 - size;
                            }
                            result = cleanValue(array_list.get(var1));
                            for (i = var1 + 1; i < size; i++) {
                                result = result + ", " + array_list.get(i);
                            }
                            for (i = 0; i < var1; i++) {
                                result = result + ", " + array_list.get(i);
                            }
                            answer_text = "The following is a list rotated by " + cleanValue(array_list2.get(0)) + " elements as well as the original:\n" + result + "\n" + cleanInput(array_list);
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 14:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"integer");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size == 1) {
                        len = cleanValue(input_text).length();
                        result = result + cleanValue(input_text).charAt(0);
                        for (i = 1; i < len; i++) {
                            result = result + ", " + cleanValue(input_text).charAt(i);
                        }
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                    answer_text = "The nunber " + cleanValue(input_text) + " has the following digit list:\n" + result;
                    answer.setText(answer_text);
                }
                break;
            case 15:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"digit");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"digit");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 > 0)) {
                            array_list3.clear();
                            //Toast.makeText(this, "array1 " + cleanInput(array_list) +"\narray2 " + cleanInput(array_list2), Toast.LENGTH_SHORT).show();
                            reverseAL(array_list);
                            reverseAL(array_list2);
                            //Toast.makeText(this, "array1 " + cleanInput(array_list) +"\narray2 " + cleanInput(array_list2), Toast.LENGTH_SHORT).show();

                            var1 = Integer.parseInt(array_list.get(0)) + Integer.parseInt(array_list2.get(0));
                            if (var1 > 9) {
                                array_list3.add(Integer.toString(var1-10));
                                var1 = 1;
                            } else {
                                array_list3.add(Integer.toString(var1));
                                var1 = 0;
                            }
                            for (i = 1; (i < size)&&(i < size2); i++) {
                                var1 = var1 + Integer.parseInt(array_list.get(i)) + Integer.parseInt(array_list2.get(i));
                                if (var1 > 9) {
                                    array_list3.add(Integer.toString(var1-10));
                                    var1 = 1;
                                } else {
                                    array_list3.add(Integer.toString(var1));
                                    var1 = 0;
                                }
                            }
                            if (i==size) {
                                while (i<size2) {
                                    var1 = var1 + Integer.parseInt(array_list2.get(i));
                                    if (var1 > 9) {
                                        array_list3.add(Integer.toString(var1-10));
                                        var1 = 1;
                                    } else {
                                        array_list3.add(Integer.toString(var1));
                                        var1 = 0;
                                    }
                                    i++;
                                }
                            } else {
                                while (i<size) {
                                    var1 = var1 + Integer.parseInt(array_list.get(i));
                                    if (var1 > 9) {
                                        array_list3.add(Integer.toString(var1-10));
                                        var1 = 1;
                                    } else {
                                        array_list3.add(Integer.toString(var1));
                                        var1 = 0;
                                    }
                                    i++;
                                }
                            }
                            if (var1 == 1) {
                                array_list3.add("1");
                            }
                            reverseAL(array_list3);
                            result = cleanInput(array_list3);

                            array_list3.clear();
                            var1 = Integer.parseInt(array_list.get(0)) - Integer.parseInt(array_list2.get(0));
                            if (var1 < 0) {
                                array_list3.add(Integer.toString(var1+10));
                                var1 = -1;
                            } else {
                                array_list3.add(Integer.toString(var1));
                                var1 = 0;
                            }
                            for (i = 1; (i < size)&&(i < size2); i++) {
                                var1 = var1 + Integer.parseInt(array_list.get(i)) - Integer.parseInt(array_list2.get(i));
                                if (var1 < 0) {
                                    array_list3.add(Integer.toString(var1+10));
                                    var1 = -1;
                                } else {
                                    array_list3.add(Integer.toString(var1));
                                    var1 = 0;
                                }
                            }
                            if (i < size) {
                                while (i < size) {
                                    var1 = var1 + Integer.parseInt(array_list.get(i));
                                    if (var1 < 0) {
                                        array_list3.add(Integer.toString(var1+10));
                                        var1 = -1;
                                    } else {
                                        array_list3.add(Integer.toString(var1));
                                        var1 = 0;
                                    }
                                    i++;
                                }
                            } else {
                                while (i < size2) {
                                    var1 = var1 - Integer.parseInt(array_list2.get(i));
                                    if (var1 < 0) {
                                        array_list3.add(Integer.toString(var1+10));
                                        var1 = -1;
                                    } else {
                                        array_list3.add(Integer.toString(var1));
                                        var1 = 0;
                                    }
                                    i++;
                                }
                            }
                            int size3;
                            if (var1 == -1) {
                                size3 = array_list3.size();
                                var1 = 10-Integer.parseInt(array_list3.get(0));
                                if (var1 > 9) {
                                    array_list3.set(0,Integer.toString(var1-10));
                                    var1 = 1;
                                } else {
                                    array_list3.set(0,Integer.toString(var1));
                                    var1 = 0;
                                }
                                //array_list3.set(0,Integer.toString(var1));
                                for (i = 1; i < size3; i++) {
                                    var1 = var1 + 9-Integer.parseInt(array_list3.get(i));
                                    if (var1 > 9) {
                                        array_list3.set(i,Integer.toString(var1-10));
                                        var1 = 1;
                                    } else {
                                        array_list3.set(i,Integer.toString(var1));
                                        var1 = 0;
                                    }
                                    //array_list3.set(i,Integer.toString(var1));
                                }
                                result2 = "the negative of ";
                            }
                            reverseAL(array_list3);
                            //Toast.makeText(this, "array3 " + cleanInput(array_list3) + "\n i is " + array_list3.get(0), Toast.LENGTH_SHORT).show();
                            while (Integer.parseInt(array_list3.get(0)) == 0) {
                                array_list3.remove(0);
                            }
                            //Toast.makeText(this, "array3xx " + cleanInput(array_list3) + "\n i is " + array_list3.get(0), Toast.LENGTH_SHORT).show();
                            result2 = result2 + cleanInput(array_list3);

                            array_list3.clear();
                            var1 = 0;
                            var2 = 0;
                            for (i = 0; i < size + size2 - 1; i++) {
                                for (j = 0; (j <= i)&&(j < size2); j++) {
                                    if (((i-j) < size)&&(i >= j)) {
                                        var1 = var1 + (Integer.parseInt(array_list.get(i-j)) * Integer.parseInt(array_list2.get(j)));;
                                    }
                                }
                                while (var1 > 9) {
                                    var1 = var1 - 10;
                                    var2 = var2 + 1;
                                }
                                array_list3.add(Integer.toString(var1));
                                var1 = var2;
                                var2 = 0;
                            }
                            if (var1 > 0) {
                                array_list3.add(Integer.toString(var1));
                            }
                            reverseAL(array_list3);
                            reverseAL(array_list);
                            reverseAL(array_list2);
                            result3 = cleanInput(array_list3);
                            answer_text = "The following are two number in their digit lists and some calculations:\n" + cleanInput(array_list) + "\n" + cleanInput(array_list2) + "\nThis is the sum:" + result + "\nThis is the difference:" + result2 + "\nThis is the product:" + result3;
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 16:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"hex");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"integer");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        //var1 = largestDigit(array_list);
                        var1 = 0;

                        for (i = 0; i < size; i++) {
                            len = array_list.get(i).length();
                            for (j = 0; j < len; j++) {
                                if (array_list.get(i).charAt(j) != '-') {
                                    if ((array_list.get(i).charAt(j)>='a')&&(array_list.get(i).charAt(j)<='z')) {
                                        temp = array_list.get(i).charAt(j) - 'a' + 10;
                                    } else if ((array_list.get(i).charAt(j)>='A')&&(array_list.get(i).charAt(j)<='Z')) {
                                        temp = array_list.get(i).charAt(j) - 'A' + 10;
                                    } else {
                                        temp = Integer.parseInt("" + array_list.get(i).charAt(j));
                                    }
                                    if (var1 < temp) {
                                        var1 = temp;
                                    }
                                }
                            }
                        }

                        var2 = Integer.parseInt(array_list2.get(0));
                        if ((Integer.parseInt(array_list2.get(0)) < 2)||(Integer.parseInt(array_list2.get(1)) < 2)) {
                            var2 = -1;
                        //} else if ((Integer.parseInt(array_list2.get(0)) > 10)||(Integer.parseInt(array_list2.get(1)) > 10)) {
                        } else if ((Integer.parseInt(array_list2.get(0)) > 36)||(Integer.parseInt(array_list2.get(1)) > 36)) {
                            var2 = 37;
                        }
                        if (var2 < 0) {
                            answer.setText("The bases have to be greater than 1");
                        //} else if (var2 > 10) {
                        //    answer.setText("Sorry I haven't programmed it to handle bases larger than 10");
                        } else if (var2 > 36) {
                            answer.setText("Sorry I haven't programmed it to handle bases larger than 36");
                        } else if (var1 >= var2) {
                            answer.setText("The first base can't be smaller than input numbers");
                        } else if ((size > 0)&&(size2 == 2)&&(var1 <= var2)) {
                            array_list3.clear();
                            for (i = 0; i < size; i++) {
                                len = array_list.get(i).length();
                                temp = 0;
                                var1 = 1;
                                var2 = Integer.parseInt(array_list2.get(0));
                                for (j = 0; j < len; j++) {
                                    temp = temp * var2;
                                    if (array_list.get(i).charAt(j) == '-') {
                                        var1 = -1;
                                    } else {
                                        if ((array_list.get(i).charAt(j)>='a')&&(array_list.get(i).charAt(j)<='z')) {
                                            temp = temp + array_list.get(i).charAt(j) - 'a' + 10;
                                        } else if ((array_list.get(i).charAt(j)>='A')&&(array_list.get(i).charAt(j)<='Z')) {
                                            temp = temp + array_list.get(i).charAt(j) - 'A' + 10;
                                        } else {
                                            temp = temp + Integer.parseInt("" + array_list.get(i).charAt(j));
                                        }
                                    }
                                }
                                var2 = Integer.parseInt(array_list2.get(1));
                                if (var2 < 10) {
                                    temp2 = var2;
                                    temp3 = 0;
                                    while (temp > temp2) {
                                        temp2 = temp2 * var2;
                                    }
                                    while (temp > 0) {
                                        temp3 = temp3 + temp / temp2;
                                        temp = temp % temp2;
                                        while (temp < temp2) {
                                            temp2 = temp2 / var2;
                                            temp3 = temp3 * 10;
                                        }
                                    }
                                    temp3 = temp3 / 10;
                                    array_list3.add(Integer.toString(temp3*var1));
                                } else if (var2 == 10) {
                                    array_list3.add(Integer.toString(temp));
                                } else {
                                    temp2 = var2;
                                    working = "";
                                    while (temp > temp2) {
                                        temp2 = temp2 * var2;
                                    }
                                    while (temp > 0) {
                                        temp3 = temp / temp2;
                                        if (temp3 > 9 ) {
                                            working = working + (char) (temp3 +'a'-10);
                                        } else if ((working != "")||(temp3 != 0)){
                                            working = working + Integer.toString(temp3);
                                        }
                                        temp = temp % temp2;
                                        temp2 = temp2 / var2;
                                        if (temp == 0) {
                                            while (temp2 > 0) {
                                                temp2 = temp2 / var2;
                                                working = working + "0";
                                            }
                                        }
                                    }
                                    array_list3.add(working);
                                }
                            }
                            result = cleanInput(array_list3);
                            answer_text = "The following numbers are the input and its base as well as the output and its base:\nInput - " + cleanInput(array_list) + "\nbase - " + cleanValue(array_list2.get(0)) + "\nOutput - " + result + "\nbase - " + cleanValue(array_list2.get(1));
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 17:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size == 1) {
                        answer.setText("Only one entry, there is nothing to sort");
                    } else if (size > 1) {
                        answer_text = "The following is a list of size " + Integer.toString(size) + " which will be sorted in various methods.\n" + cleanInput(array_list);
                        // interations
                        temp = 0;
                        // swaps
                        temp2 = 0;
                        // comparisons
                        temp3 = 0;

                        // Selection Sort - swaps minimum value to the front
                        //Collections.copy(array_list2, array_list);
                        copyArray(array_list2, array_list);
                        for (i = 0; i < size; i++) {
                            value1 = Double.parseDouble(array_list2.get(i));
                            var1 = i;
                            for (j = i+1; j < size; j++) {
                                value2 = Double.parseDouble(array_list2.get(j));
                                if (value2 < value1) {
                                    value1 = value2;
                                    var1 = j;
                                }
                                temp3++;
                            }
                            if (i != var1) {
                                working = array_list2.get(i);
                                array_list2.set(i,array_list2.get(var1));
                                array_list2.set(var1,working);
                                temp2++;
                            }
                            temp++;
                        }
                        answer_text = answer_text + "\n\nSelection Sort\niterations: " + Integer.toString(temp) + "\nswaps: " + Integer.toString(temp2) + "\ncomparisons: " + Integer.toString(temp3) + "\nsorted list: " + cleanInput(array_list2);

                        // Insertion Sort - swaps unsorted value until it is in correct position
                        temp = 0;
                        temp2 = 0;
                        temp3 = 0;
                        //Collections.copy(array_list2, array_list);
                        copyArray(array_list2, array_list);
                        for (i = 1; i < size; i++) {
                            for (j = i; j > 0; j--) {
                                value1 = Double.parseDouble(array_list2.get(j));
                                value2 = Double.parseDouble(array_list2.get(j-1));
                                if (value1 < value2) {
                                    working = array_list2.get(j);
                                    array_list2.set(j,array_list2.get(j-1));
                                    array_list2.set(j-1,working);
                                    temp2++;
                                }
                                temp3++;
                            }
                            temp++;
                        }
                        answer_text = answer_text + "\n\nInsertion Sort\niterations: " + Integer.toString(temp) + "\nswaps: " + Integer.toString(temp2) + "\ncomparisons: " + Integer.toString(temp3) + "\nsorted list: " + cleanInput(array_list2);

                        // Merge Sort - splits to 1's them sorts while merging back together
                        /*temp = 0;
                        temp2 = 0;
                        temp3 = 0;
                        //Collections.copy(array_list2, array_list);
                        copyArray(array_list2, array_list);
                        array_list3.clear();
                        var1 = 1;
                        while (var1<size) {
                            var1 = var1 * 2;
                            for (i = 0; i < size; i = i + var1) {
                                j = 0;
                                k = 0;
                                while ((j + k < var1 - 1)&&((i+k+(var1/2)) < size)) {
                                    value1 = Double.parseDouble(array_list2.get(i+j));
                                    value2 = Double.parseDouble(array_list2.get(i+k+(var1/2)));
                                    if (value1 < value2) {
                                        array_list3.add(array_list2.get(i+j));
                                        j++;
                                    } else {
                                        array_list3.add(array_list2.get(i+k+(var1/2)));
                                        k++;
                                    }
                                    temp2++;
                                    temp3++;
                                    if (j == var1/2) {
                                        while ((j + k < var1 - 1)&&((i+k+(var1/2)) < size)) {
                                            array_list3.add(array_list2.get(i+k+(var1/2)));
                                            k++;
                                            temp2++;
                                        }
                                    } else if ((k == var1/2)||((i+k+(var1/2)) == size)) {
                                        while (j + k < var1 - 1) {
                                            array_list3.add(array_list2.get(i+j));
                                            j++;
                                            temp2++;
                                        }
                                    }
                                }
                            }
                            //Collections.copy(array_list2, array_list3);
                            copyArray(array_list2, array_list3);
                            array_list3.clear();
                            temp++;
                        }*/
                        copyArray(array_list2, array_list);
                        int_array_list.clear();
                        int_array_list.add(0);
                        int_array_list.add(0);
                        int_array_list.add(0);
                        mergeSort(array_list2, int_array_list);
                        temp = int_array_list.get(0);
                        temp2 = int_array_list.get(1);
                        temp3 = int_array_list.get(2);

                        answer_text = answer_text + "\n\nMerge Sort\niterations: " + Integer.toString(temp) + "\nswaps: " + Integer.toString(temp2) + "\ncomparisons: " + Integer.toString(temp3) + "\nsorted list: " + cleanInput(array_list2);

                        // Quicksort - pivot values above and below a point and repeat
                        //temp = 0;
                        //temp2 = 0;
                        //temp3 = 0;
                        //Collections.copy(array_list2, array_list);
                        copyArray(array_list2, array_list);
                        int_array_list.clear();
                        int_array_list.add(0);
                        int_array_list.add(0);
                        int_array_list.add(0);
                        quickSort(array_list2, int_array_list);
                        temp = int_array_list.get(0);
                        temp2 = int_array_list.get(1);
                        temp3 = int_array_list.get(2);
                        answer_text = answer_text + "\n\nQuicksort\niterations: " + Integer.toString(temp) + "\nswaps: " + Integer.toString(temp2) + "\ncomparisons: " + Integer.toString(temp3) + "\nsorted list: " + cleanInput(array_list2);

                        // Stooge sort - sorts the first and the last element, then resursively sort the first, last and first 2/3 of the list (rounded up/floored)
                        //temp = 0;
                        //temp2 = 0;
                        //temp3 = 0;
                        //Collections.copy(array_list2, array_list);
                        copyArray(array_list2, array_list);
                        int_array_list.clear();
                        int_array_list.add(0);
                        int_array_list.add(0);
                        int_array_list.add(0);
                        stoogeSort(array_list2, 0, size - 1, int_array_list);
                        temp = int_array_list.get(0);
                        temp2 = int_array_list.get(1);
                        temp3 = int_array_list.get(2);
                        answer_text = answer_text + "\n\nStooge Sort\niterations: " + Integer.toString(temp) + "\nswaps: " + Integer.toString(temp2) + "\ncomparisons: " + Integer.toString(temp3) + "\nsorted list: " + cleanInput(array_list2);

                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 18:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"value");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    answer_text = A3BInputReader.TextViewReader(this,input_text2,answer_text,array_list2,"value");
                    if (answer_text != "") {
                        answer.setText(answer_text);
                    } else {
                        size = array_list.size();
                        size2 = array_list2.size();
                        if ((size > 0)&&(size2 == 1)) {
                            var1 = 0;
                            var2 = size - 1;
                            value2 = Double.parseDouble(array_list2.get(0));
                            while (var1 != var2) {
                                temp = (var1 + var2)/2;
                                value1 = Double.parseDouble(array_list.get(temp));
                                if (value1 == value2) {
                                    var1 = temp;
                                    var2 = temp;
                                } else if (value1 < value2) {
                                    if (temp == var1) {
                                        var1++;
                                    } else {
                                        var1 = temp;
                                    }
                                }  else if (value1 > value2) {
                                    var2 = temp;
                                }
                            }
                            var2 = var1 + 1;
                            if (var2 == 1) {
                                result = "1st";
                            } else if (var2 == 2) {
                                result = "2nd";
                            } else if (var2 == size) {
                                result = "last";
                            } else {
                                result = Integer.toString(var2) + "th";
                            }
                            value1 = Double.parseDouble(array_list.get(var1));
                            if (value1 == value2) {
                                answer_text = "The value " + cleanValue(array_list2.get(0)) + " was found in the " + result + " position in the following list:\n" + cleanInput(array_list);
                            } else {
                                answer_text = "The value " + cleanValue(array_list2.get(0)) + " was not found in the following list:\n" + cleanInput(array_list) + "\n(assumed the list was sorted)";
                            }
                            answer.setText(answer_text);
                        } else {
                            answer.setText("Sorry, please provide the input again!!");
                        }
                    }
                }
                break;
            case 19:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"any");
                if (answer_text != "") {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        var1 = cleanValue(array_list.get(0)).length();
                        for (i = 1; i < size; i++) {
                            var2 = cleanValue(array_list.get(i)).length();
                            if (var2 > var1) {
                                var1 = var2;
                            }
                        }
                        result = "****";
                        for (i = 0; i < var1; i++) {
                            result = result + "*";
                        }
                        answer_text = result + "\n";
                        for (i = 0; i < size; i++) {
                            answer_text = answer_text + "* " + cleanValue(array_list.get(i));
                            var2 = cleanValue(array_list.get(i)).length();
                            for (j = 0; j < var1; j++) {
                                if (j >= var2) {
                                    answer_text = answer_text + " ";
                                }
                            }
                            answer_text = answer_text + " *\n";
                        }
                        answer_text = answer_text + result;
                        answer.setText(answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                }
                break;
            case 20:
                answer_text = A3BInputReader.TextViewReader(this,input_text,answer_text,array_list,"text");
                if ((answer_text != "")&&(answer_text != "Pig Latin")&&(answer_text != "English")) {
                    answer.setText(answer_text);
                } else {
                    size = array_list.size();
                    if (size > 0) {
                        answer_text = translatePigLatin(array_list, answer_text);
                    } else {
                        answer.setText("Sorry, please provide the input again!!");
                    }
                    answer.setText(answer_text);
                }
                break;
        }
        input.setText("");
        input2.setText("");
    }

    private String translatePigLatin(ArrayList<String> text, String mode) {
        String translation = "";
        int size = text.size();
        int i, len;
        char ch;
        boolean caps = true;
        boolean space = false;
        if (mode == "Pig Latin") {
            for (i = 0; i < size; i++) {
                if (A3BInputReader.isPunc(text.get(i))) {
                    translation = translation + cleanValue(text.get(i)) + " ";
                    caps = true;
                    if (cleanValue(text.get(i)).charAt(0) == ',') {
                        caps = false;
                    }
                    space = false;
                } else {
                    if (space) {
                        translation = translation + " ";
                        space = false;
                    }
                    len = cleanValue(text.get(i)).length();
                    ch = cleanValue(text.get(i)).charAt(len-3);
                    if ((caps)&&(ch>='a')&(ch<='z')) {
                        translation = translation + (char) (ch + 'A' - 'a');
                    } else {
                        translation = translation + ch;
                    }
                    if (len > 3) {
                        ch = cleanValue(text.get(i)).charAt(0);
                        if ((ch>='A')&(ch<='Z')) {
                            ch = (char) (ch - 'A' + 'a');
                        }
                        translation = translation + ch + cleanValue(text.get(i)).substring(1, len - 3);
                    }
                    caps = false;
                    space = true;
                }
            }

        } else if (mode == "English") {
            for (i = 0; i < size; i++) {
                if (A3BInputReader.isPunc(text.get(i))) {
                    translation = translation + cleanValue(text.get(i)) + " ";
                    caps = true;
                    if (cleanValue(text.get(i)).charAt(0) == ',') {
                        caps = false;
                    }
                    space = false;
                } else {
                    if (space) {
                        translation = translation + " ";
                        space = false;
                    }
                    len = cleanValue(text.get(i)).length();
                    if (len > 1) {
                        ch = cleanValue(text.get(i)).charAt(1);
                        if ((caps)&&(ch>='a')&(ch<='z')) {
                            translation = translation + (char) (ch + 'A' - 'a');
                        } else {
                            translation = translation + ch;
                        }
                        if (len > 2) {
                            translation = translation + cleanValue(text.get(i)).substring(2);
                        }
                        ch = cleanValue(text.get(i)).charAt(0);
                        if ((ch>='A')&(ch<='Z')) {
                            ch = (char) (ch - 'A' + 'a');
                        }
                    } else {
                        ch = ch = cleanValue(text.get(i)).charAt(0);
                        if ((caps)&&(ch>='a')&(ch<='z')) {
                            ch = (char) (ch + 'A' - 'a');
                        }
                    }
                    translation = translation + ch + "ay";
                    caps = false;
                    space = true;
                }
            }
        } else {
            translation = "The Pig Latin translation did not work.";
        }
        return translation;
    }

    private void copyArray(ArrayList<String> dest, ArrayList<String> src) {
        dest.clear();
        int size = src.size();
        int i;
        for (i = 0; i < size; i++) {
            dest.add(i,src.get(i));
        }

    }

    private void mergeSort(ArrayList<String> array_list, ArrayList<Integer> counters) {
        int size = array_list.size();
        int split = 1;
        int i, j, k, split2;
        double value1, value2;

        while (split < size) {
            split = split * 2;
        }
        split = split / 2;
        split2 = size - split;

        ArrayList<String> temp_list = new ArrayList<>();
        ArrayList<String> temp_list2 = new ArrayList<>();

        for (i = 0; i < size; i++) {
            if (i < split) {
                temp_list.add(array_list.get(i));
            } else {
                temp_list2.add(array_list.get(i));
            }
        }
        if (split > 1) {
            mergeSort(temp_list, counters);
        }
        if (split2 > 1) {
            mergeSort(temp_list2, counters);
        }

        j = 0;
        k = 0;
        for (i = 0; i < size; i++) {
            value1 = Double.parseDouble(temp_list.get(j));
            value2 = Double.parseDouble(temp_list2.get(k));
            if (value1 < value2) {
                array_list.set(i, temp_list.get(j));
                j++;
            } else {
                array_list.set(i, temp_list2.get(k));
                k++;
            }
            counters.set(2,counters.get(2) + 1);
            counters.set(1,counters.get(1) + 1);
            if (j == split) {
                while (k < split2) {
                    i++;
                    array_list.set(i, temp_list2.get(k));
                    k++;
                    counters.set(1,counters.get(1) + 1);
                }
            } else if (k == split2){
                while (j < split) {
                    i++;
                    array_list.set(i, temp_list.get(j));
                    j++;
                    counters.set(1,counters.get(1) + 1);
                }
            }
        }
        counters.set(0,counters.get(0) + 1);
    }

    private void quickSort(ArrayList<String> array_list, ArrayList<Integer> counters) {
        int size = array_list.size();
        int size2, size3;
        int pivot = size/2;
        double value = Double.parseDouble(array_list.get(pivot));
        ArrayList<String> temp_list = new ArrayList<>();
        ArrayList<String> temp_list2 = new ArrayList<>();
        ArrayList<String> temp_list3 = new ArrayList<>();
        int i;
        for (i = 0; i < size; i++) {
            if (value < Double.parseDouble(array_list.get(i))) {
                temp_list.add(array_list.get(i));
            } else if (value > Double.parseDouble(array_list.get(i))) {
                temp_list2.add(array_list.get(i));
            } else {
                temp_list3.add(array_list.get(i));
            }
            counters.set(2,counters.get(2) + 1);
            counters.set(1,counters.get(1) + 1);
        }
        size2 = temp_list2.size();
        if (size2 > 1) {
            quickSort(temp_list2, counters);
        }
        size3 = temp_list.size();
        if (size3 > 1) {
            quickSort(temp_list, counters);
        }
        size3 = temp_list3.size() + size2;
        for (i = 0; i < size; i++) {
            if (i < size2) {
                array_list.set(i,temp_list2.get(i));
            } else if (i < size3) {
                array_list.set(i,temp_list3.get(i-size2));
            } else {
                array_list.set(i,temp_list.get(i-size3));
            }
        }
        counters.set(0,counters.get(0) + 1);
    }

    private void stoogeSort(ArrayList<String> array_list, int start, int end, ArrayList<Integer> counters) {
        double valueA, valueB;
        String temp;
        int third = (end - start + 2)/3;
        valueA = Double.parseDouble(array_list.get(start));
        valueB = Double.parseDouble(array_list.get(end));
        if (valueA > valueB) {
            temp = array_list.get(start);
            array_list.set(start, array_list.get(end));
            array_list.set(end, temp);
            counters.set(1,counters.get(1) + 1);
        }
        counters.set(2,counters.get(2) + 1);
        if ((end-start) > 1) {
            stoogeSort(array_list, start, end-third, counters);
            stoogeSort(array_list, start+third, end, counters);
            stoogeSort(array_list, start, end-third, counters);
        }
        counters.set(0,counters.get(0) + 1);
    }

    private int largestDigit(ArrayList<String> array_list) {
        int num = 0;
        int size = array_list.size();
        int i, j, len, temp;

        for (i = 0; i < size; i++) {
             len = array_list.get(i).length();
            for (j = 0; j < len; j++) {
                temp = Integer.parseInt("" + array_list.get(i).charAt(j));
                if (num < temp) {
                    num = temp;
                }
            }
        }
        return num;
    }

    private void reverseAL(ArrayList<String> reverse_array) {
        int size = reverse_array.size();
        String temp = "";
        int i;
        if (size > 1) {
            for (i = size/2; i > 0; i--) {
                temp = cleanValue(reverse_array.get(i-1));
                reverse_array.set(i-1,reverse_array.get(size-i));
                reverse_array.set(size-i,temp);
            }
        }
    }

    private boolean isOdd(int num) {
        while (num < 0) {
            num = num + 2;
        }
        while (num > 2) {
            num = num - 2;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    private String cleanValue(String input) {
        String output;

        if (A3BInputReader.isInt(input)) {
            output = Integer.toString(Integer.parseInt(input));
        } else if (A3BInputReader.isValue(input)) {
            //output = Double.toString(Double.parseDouble(input));
            double number = Double.parseDouble(input);
            if (number-(int)number==0){
                output = Integer.toString((int) number);
            } else {
                output = Double.toString(number);
            }
        } else {
            int i,j,k,len;
            len = input.length();
            j = -1;
            k = 0;
            for (i = 0; i < len; i++) {
                if (!Character.isWhitespace(input.charAt(i))) {
                    if (j==-1) {
                        j=i;
                    }
                    k=i;
                }
            }
            k++;
            output = input.substring(j,k);
        }

        return output;
    }

    private String cleanInput(ArrayList<String> array_list) {
        int size = array_list.size();

        if (size == 0) {
            return null;
        }

        String clean_input = cleanValue(array_list.get(0));
        int i;
        for (i = 1; i < size; i++) {
            clean_input = clean_input + ", " + cleanValue(array_list.get(i));
        }
        return clean_input;
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

