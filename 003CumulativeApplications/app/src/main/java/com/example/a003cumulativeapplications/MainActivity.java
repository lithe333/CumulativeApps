package com.example.a003cumulativeapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

    }

    public void Choose(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if(button_text.equals("001 Magic Eightball"))
        {
            Intent choose = new Intent(this,Activity001.class);
            startActivity(choose);
        }
        else if (button_text.equals("002 To Do List"))
        {
            Intent choose = new Intent(this,Activity002.class);
            startActivity(choose);

        }
        else if (button_text.equals("003 Metaverse"))
        {
            Intent choose = new Intent(this,Activity003.class);
            startActivity(choose);

        }
        else if (button_text.equals("List of Apps"))
        {
            Intent choose = new Intent(this,MainActivity.class);
            startActivity(choose);
            Toast.makeText(this, "Uhh.. you are already Here!", Toast.LENGTH_SHORT).show();

        }
    }
}