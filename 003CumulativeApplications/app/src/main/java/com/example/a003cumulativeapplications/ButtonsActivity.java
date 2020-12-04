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
        else if (button_text.equals("004 Calculator"))
        {
            Intent choose = new Intent(this,Activity004.class);
            startActivity(choose);

        }
        else if (button_text.equals("005 Cards"))
        {
            Intent choose = new Intent(this,Activity005.class);
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
            Intent choose3 = new Intent(this,Activity003A.class);
            startActivity(choose3);
        }
        else if (button_text.equals("003B Simple Programming Problems"))
        {
            Intent choose3 = new Intent(this,Activity003B.class);
            startActivity(choose3);
        }
        else if (button_text.equals("003C Template for Tests"))
        {
            Intent choose3 = new Intent(this,Activity003C.class);
            startActivity(choose3);
        }
        else if (button_text.equals("003D Testing Fragments"))
        {
            Intent choose3 = new Intent(this,Activity003D.class);
            startActivity(choose3);
        }
        else if (button_text.equals("List of Tests"))
        {
            Intent choose3 = new Intent(this,Activity003.class);
            startActivity(choose3);
            Toast.makeText(this, "Back to Testing Area", Toast.LENGTH_SHORT).show();

        }

    }

    public void ChooseQ(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if (button_text.equals("Problems - Elementary"))
        {
            Intent chooseQ = new Intent(this,Activity003B1.class);
            startActivity(chooseQ);
        }
        else   if (button_text.equals("Problems - Lists, Strings"))
        {
            Intent chooseQ = new Intent(this,Activity003B2.class);
            startActivity(chooseQ);
        }
        else   if (button_text.equals("Problems - Intermediate"))
        {
            Intent chooseQ = new Intent(this,Activity003B3.class);
            startActivity(chooseQ);
        }
        else   if (button_text.equals("Problems - Advanced"))
        {
            Intent chooseQ = new Intent(this,Activity003B4.class);
            startActivity(chooseQ);
        }
        else   if (button_text.equals("Problems - GUI"))
        {
            Intent chooseQ = new Intent(this,Activity003B5.class);
            startActivity(chooseQ);
        }
        else   if (button_text.equals("Problems - Open Ended"))
        {
            Intent chooseQ = new Intent(this,Activity003B6.class);
            startActivity(chooseQ);
        }
        else if (button_text.equals("List of Questions"))
        {
            Intent chooseQ = new Intent(this,Activity003B.class);
            startActivity(chooseQ);

        }

    }
}
