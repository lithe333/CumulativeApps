package com.example.a003cumulativeapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

    }

    public void Ganesh(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if(button_text.equals("001 Magic Eightball"))
        {
            Intent ganesh = new Intent(this,Activity001.class);
            startActivity(ganesh);
        }
        else if (button_text.equals("002 To Do List"))
        {
            Intent mass = new Intent(this,Activity002.class);
            startActivity(mass);

        }
        else if (button_text.equals("003 Metaverse"))
        {
            Intent mass = new Intent(this,Activity003.class);
            startActivity(mass);

        }
    }
}