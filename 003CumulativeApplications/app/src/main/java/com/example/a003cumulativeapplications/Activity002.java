package com.example.a003cumulativeapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import android.support.annotation.Nullable;

public class Activity002 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    // Initialising the variables
    private EditText itemET;
    private Button btn;
    private ListView itemsList;

    // variables for reading and writings into the list
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    // associate the variables when opening the app
    // reading the data will store the list from previous run
    // video mentioned that adapter is to help read/write from arrays
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity002);

        itemET = findViewById(R.id.a2_item_edit_text);
        btn = findViewById(R.id.a2_add_btn);
        itemsList = findViewById((R.id.a2_items_list));

        items = A2FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);
    }

    // when button is clicked, we add an item to list via adaptor and FileHelper
    // adaptor adds another any string to the list
    // FileHelper updates the file
    // after storing the entry we also clear the textbox
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.a2_add_btn:
                String itemEnterred = itemET.getText().toString();
                adapter.add(itemEnterred);
                itemET.setText("");
                A2FileHelper.writeData(items, this);
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // when list item is clicked, we remove the item
    // but it didn't update file so we need to use FileHelper.writedata again.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        A2FileHelper.writeData(items,this);
        Toast.makeText(this, "Item Removed", Toast.LENGTH_SHORT).show();
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