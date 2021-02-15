package com.example.a003cumulativeapplications;

import android.content.Context;

import java.util.ArrayList;

public class A3BInputReader {

    //public static String TextViewReader(Context context, String input_text, String answer_text, ArrayList<String> array_list, ArrayAdapter array_adaptor, String inputType) {
    public static String TextViewReader(Context context, String input_text, String answer_text, ArrayList<String> array_list, String inputType) {
        boolean value_found = false;
        boolean hex_all = true;
        boolean double_all = true;
        boolean int_all = true;
        boolean is_pig = true;

        if (input_text.isEmpty()) {
            answer_text = "Empty? I am still waiting for your input";
        } else {
            //fillingArray(context, input_text, array_list, array_adaptor);
            if (inputType == "text") {
                textArray(context, input_text, array_list);
            } else {
                fillingArray(context, input_text, array_list);
            }

            int size = array_list.size();
            //Toast.makeText(context, "Size " + Integer.toString(size), Toast.LENGTH_SHORT).show();

            if (size == 0) {
                answer_text = "Sorry, please provide the input again";
            } else {

                int i;
                int int_len = 1;
                int length;
                for (i = 0; i < size; i++) {
                    if (isInt(array_list.get(i))) {
                        value_found = true;
                        length = array_list.get(i).length();
                        if (array_list.get(i).charAt(0)=='-') {
                            length--;
                        }
                        if (length > int_len) {
                            int_len = length;
                        }
                    } else if (isValue(array_list.get(i))) {
                        value_found = true;
                        int_all = false;
                    } else if (isAlphaNum(array_list.get(i))) {
                        //value_found = true;
                        int_all = false;
                        double_all = false;
                        length = array_list.get(i).length();
                        if ((length < 3)||((array_list.get(i).charAt(length-1) != 'y')&&(array_list.get(i).charAt(length-1) != 'Y'))||((array_list.get(i).charAt(length-2) != 'a')&&(array_list.get(i).charAt(length-2) != 'A'))) {
                            is_pig = false;
                        }
                    } else {
                        int_all = false;
                        double_all = false;
                        hex_all = false;
                        length = array_list.get(i).length();
                        if (!isPunc(array_list.get(i))) {
                            if ((length < 3)||((array_list.get(i).charAt(length-1) != 'y')&&(array_list.get(i).charAt(length-1) != 'Y'))||((array_list.get(i).charAt(length-2) != 'a')&&(array_list.get(i).charAt(length-2) != 'A'))) {
                                is_pig = false;
                            }
                        }
                    }
                }

                if ((inputType == "text")&&(value_found)) {
                    answer_text = "There are numerical values in your input. Please try again";
                } else if (inputType == "text") {
                    if (is_pig) {
                        answer_text = "Pig Latin";
                    } else {
                        answer_text = "English";
                    }
                } else if ((inputType == "hex")&&(!hex_all)) {
                    answer_text = "Please only use alpha numeric characters";
                } else if (((inputType == "value")||(inputType == "integer")||(inputType == "digit"))&&(!double_all)) {
                    answer_text = "Numbers only please. Something went wrong";
                } else if (((inputType == "integer")||(inputType == "digit"))&&(!int_all)) {
                    answer_text = "Please only enter integers";
                } else if ((inputType == "digit")&&(int_len>1)) {
                    answer_text = "Please only use single digits (0-9)";
                } else if ((inputType == "string")&&(size>1)) {
                    answer_text = "Please enter one string and avoid using \",\"";
                }
            }
        }
        return answer_text;
    }

    //public static void fillingArray(Context context, String input, ArrayList<String> array_list, ArrayAdapter array_adaptor) {
    public static void fillingArray(Context context, String input, ArrayList<String> array_list) {
        //ArrayList<String> output = new ArrayList<>();
        array_list.clear();
        //array_list = new ArrayList<>();
        //array_adaptor.notifyDataSetChanged();

        int length = input.length();
        String output = "";

        for (int i = 0; i<length; i++) {
            if (input.charAt(i) == ',') {
                if (output != "") {
                    //array_adaptor.add(output);
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    //Toast.makeText(context, "output " + output, Toast.LENGTH_SHORT).show();
                    output = "";
                }
            } else {
                String temp = Character.toString((input.charAt(i)));
                output = output + temp;
            }
        }
        if (output != "") {
            //array_adaptor.add(output);
            if (isNotEmpty(output)) {
                array_list.add(output);
            }
            //Toast.makeText(context, "output " + output, Toast.LENGTH_SHORT).show();
        }
    }

    public static void textArray(Context context, String input, ArrayList<String> array_list) {
        array_list.clear();

        int length = input.length();
        int counter = 0;
        String output = "";

        for (int i = 0; i<length; i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                if (output != "") {
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    output = "";
                }
            } else if (input.charAt(i) == ','){
                if (output != "") {
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    output = "";
                }
                array_list.add(",");
            } else if (input.charAt(i) == '.'){
                if (output != "") {
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    output = "";
                }
                array_list.add(".");
            } else if (input.charAt(i) == '!'){
                if (output != "") {
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    output = "";
                }
                array_list.add("!");
            } else if (input.charAt(i) == '?'){
                if (output != "") {
                    if (isNotEmpty(output)) {
                        array_list.add(output);
                    }
                    output = "";
                }
                array_list.add("?");
            } else {
                String temp = Character.toString((input.charAt(i)));
                output = output + temp;
            }
        }
        if (output != "") {
            if (isNotEmpty(output)) {
                array_list.add(output);
            }
        }
    }

    public static boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean isValue(String s) {
        try {
            double k = Double.parseDouble(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean isAlphaNum(String s) {
        int i, len;
        len = s.length();
        for (i = 0; i < len; i++) {
            if ((i == 0)&&(s.charAt(i) == '-')) {
            } else if ((!isInt(""+s.charAt(i)))&&(!Character.isLetter(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String s) {
        boolean is_not_empty = false;
        int len = s.length();
        int i;
        for (i = 0; i < len; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                is_not_empty = true;
            }
        }
        return is_not_empty;
    }

    public static boolean isPunc(String s) {
        boolean is_punc = false;
        if (s == ","){
            is_punc = true;
        } else if (s == "."){
            is_punc = true;
        } else if (s == "!"){
            is_punc = true;
        } else if (s == "?"){
            is_punc = true;
        }
        return is_punc;
    }
}

//sorting
//https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//https://developer.android.com/reference/android/widget/ArrayAdapter