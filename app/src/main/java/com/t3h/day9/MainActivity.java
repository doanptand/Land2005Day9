package com.t3h.day9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] color = new String[]{"Red", "Blue",
            "Green", "Yellow", "Orange", "Pink", "Gray", "White"};
    private ListView lvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvColor = findViewById(R.id.lv_color);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, color);
        lvColor.setAdapter(adapter);
    }
}