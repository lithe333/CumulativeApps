package com.example.a003cumulativeapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

public class Activity003D extends ButtonsActivity {

    private static final String FRAGMENT_TAG = "JAVA_FRAGMENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity003d);
    }

    public boolean fragment_flag = false;

    public void add(View view) {

        if (fragment_flag == false) {
            A3DFragment2 javaFragment = new A3DFragment2();
                getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.java_fragment, javaFragment, FRAGMENT_TAG)
                .commit();
                fragment_flag = true;
            Toast.makeText(this, "Added (via Java)", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Already there..", Toast.LENGTH_SHORT).show();
        }
    }

    public void remove(View view) {

        Fragment fragment = getSupportFragmentManager()
                .findFragmentByTag(FRAGMENT_TAG);

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
            fragment_flag = false;
            Toast.makeText(this, "Removed (via Java)", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nothing to remove..", Toast.LENGTH_SHORT).show();
        }
    }
}
