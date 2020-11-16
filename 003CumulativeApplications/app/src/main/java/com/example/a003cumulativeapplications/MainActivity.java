package com.example.a003cumulativeapplications;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends ButtonsActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

    }
}