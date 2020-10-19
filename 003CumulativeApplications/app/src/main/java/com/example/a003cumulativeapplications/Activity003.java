package com.example.a003cumulativeapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;
//import android.support.annotation.Nullable;


public class Activity003 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003);

    }

    public void Back(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if (button_text.equals("List of Apps"))
        {
            Intent back = new Intent(this,MainActivity.class);
            startActivity(back);
            Toast.makeText(this, "Back to Main Menu", Toast.LENGTH_SHORT).show();

        }
    }
}
