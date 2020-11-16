package com.example.a003cumulativeapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class Activity003A extends ButtonsActivity implements View.OnClickListener {

    private TextView tv1, tv2, tv3, tv4;
    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003a);

        btn1 = findViewById(R.id.a3a_btn1);
        btn2 = findViewById(R.id.a3a_btn2);
        btn3 = findViewById(R.id.a3a_btn3);
        btn4 = findViewById(R.id.a3a_btn4);

        tv1 = findViewById(R.id.a3a_tv1);
        tv2 = findViewById(R.id.a3a_tv2);
        tv3 = findViewById(R.id.a3a_tv3);
        tv4 = findViewById(R.id.a3a_tv4);

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv2.setText("Inside the OnCreate - OnClickListener");
            }
        });

        btn3.setOnClickListener((View.OnClickListener) this);

        btn4.setOnClickListener(this);
    }

    public void Click3a(View view) {
        tv1.setText("From XML - onClick");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a3a_btn3:
                tv3.setText("From SWTICH - OnClickListener, this, casting, getId");
                break;
            case R.id.a3a_btn4:
                tv4.setText("From SWITCH - OnClickListener, this, getId");
                break;
        }
    }
}
