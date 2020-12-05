package com.example.a003cumulativeapplications;

import android.content.Context;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A4Memory {

    // the list is stored in this file (for future runs of the app as well)
    public static final String FILENAME = "memory.dat";

    // data will be written to the file, then file is closed
    public static void writeDouble(double number, Context context){

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeDouble(number);
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // data will be read from the file. If file is not found, display empty array.
    public static double readDouble(Context context) {

        double number = 0;

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            DataInputStream dis = new DataInputStream(fis);
            number = dis.readDouble();
        } catch (FileNotFoundException e) {
            number = 0;
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return number;

    }

}
