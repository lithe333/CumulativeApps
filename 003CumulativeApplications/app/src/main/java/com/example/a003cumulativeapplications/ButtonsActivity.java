package com.example.a003cumulativeapplications;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonsActivity extends AppCompatActivity {

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
        else if (button_text.equals("003 Under Construction"))
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

    public void Choose3(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if (button_text.equals("003A Button Types"))
        {
            Intent back = new Intent(this,Activity003A.class);
            startActivity(back);

        }
        else if (button_text.equals("List of Tests"))
        {
            Intent choose3 = new Intent(this,Activity003.class);
            startActivity(choose3);

        }

    }
}
